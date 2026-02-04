package si.triglav.common.propchar.generator

import java.io.File
import java.nio.charset.Charset

/**
 * CSV parsing utilities.
 */
object CsvParser {

    /** Load boolean characteristic mappings from CSV.
     *  Returns: Map of tpCharacter -> BooleanMapping
     */
    fun loadBooleanMappings(filepath: String): Map<Int, BooleanMapping> {
        val file = File(filepath)
        if (!file.exists()) return emptyMap()

        return file.readLines()
            .drop(1) // Skip header
            .mapNotNull { line ->
                val parts = line.split(",")
                if (parts.size >= 3) {
                    try {
                        val tpChar = parts[0].trim().toInt()
                        val trueVal = parts[1].trim().toInt()
                        val falseVal = parts[2].trim().toInt()
                        tpChar to BooleanMapping(tpChar, trueVal, falseVal)
                    } catch (e: NumberFormatException) {
                        null
                    }
                } else null
            }
            .toMap()
    }

    /**
     * Parse prochar.csv with count columns.
     * Format: TP_PROPERTY;SIF_OPIS;TP_CHARACTER;SIF_OPIS;CNT_NUMBER;CNT_VALUE;CNT_DATE;CNT_DESC
     */
    fun parseProcharCsv(
        filepath: String,
        booleanMappings: Map<Int, BooleanMapping> = emptyMap()
    ): Map<Int, Property> {
        val properties = mutableMapOf<Int, Property>()
        val charset = Charset.forName("windows-1250")

        File(filepath).bufferedReader(charset).useLines { lines ->
            lines.drop(1).forEach { line -> // Skip header
                try {
                    val parts = line.split(";")
                    if (parts.size < 8) return@forEach

                    val tpProperty = parts[0].toInt()
                    val propName = parts[1]
                    val tpCharacter = parts[2].toInt()
                    val charName = parts[3]
                    val cntNumber = parts[4].toIntOrNull() ?: 0
                    val cntValue = parts[5].toIntOrNull() ?: 0
                    val cntDate = parts[6].toIntOrNull() ?: 0
                    val cntDesc = parts[7].toIntOrNull() ?: 0

                    // Determine which columns are active (above threshold)
                    val activeColumns = mutableListOf<Pair<String, Int>>()
                    if (cntNumber > GeneratorConfig.THRESHOLD) activeColumns.add("number" to cntNumber)
                    if (cntValue > GeneratorConfig.THRESHOLD) activeColumns.add("value" to cntValue)
                    if (cntDate > GeneratorConfig.THRESHOLD) activeColumns.add("date" to cntDate)
                    if (cntDesc > GeneratorConfig.THRESHOLD) activeColumns.add("desc" to cntDesc)

                    // Skip if no active columns
                    if (activeColumns.isEmpty()) return@forEach

                    // Create property if not exists
                    if (tpProperty !in properties) {
                        val className = SlovenianNameConverter.toClassName(propName)
                        properties[tpProperty] = Property(
                            tpProperty = tpProperty,
                            name = propName,
                            className = "${className}_$tpProperty"
                        )
                    }

                    // Create characteristic with fields
                    val baseFieldName = SlovenianNameConverter.toFieldName(charName)
                    val isMultiColumn = activeColumns.size > 1

                    val char = Characteristic(tpCharacter = tpCharacter, name = charName)

                    // Check if this is a boolean characteristic
                    val boolMapping = booleanMappings[tpCharacter]
                    if (boolMapping != null) {
                        char.isBoolean = true
                        char.booleanTrueVal = boolMapping.trueVal
                        char.booleanFalseVal = boolMapping.falseVal
                        // Override field type to Boolean (single field)
                        char.fields.add(CharacteristicField(
                            fieldName = baseFieldName,
                            javaType = "Boolean",
                            columnType = "boolean"
                        ))
                    } else {
                        for ((colType, _) in activeColumns) {
                            val fieldName = if (isMultiColumn) "${baseFieldName}_$colType" else baseFieldName
                            char.fields.add(CharacteristicField(
                                fieldName = fieldName,
                                javaType = GeneratorConfig.TYPE_MAP[colType]!!,
                                columnType = colType
                            ))
                        }
                    }

                    properties[tpProperty]!!.characteristics.add(char)

                } catch (e: Exception) {
                    println("Warning: skipping row: ${e.message}")
                }
            }
        }

        return properties
    }
}
