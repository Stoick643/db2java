package si.triglav.common.propchar.generator

/**
 * Configuration constants for the property generator.
 */
object GeneratorConfig {
    /** Ignore counts <= this value as data errors */
    const val THRESHOLD = 5

    /** Type mappings from column type to Java type */
    val TYPE_MAP = mapOf(
        "number" to "Integer",
        "value" to "BigDecimal",
        "date" to "SimpleDate",
        "desc" to "String"
    )

    /** Getter method names for PCharacteristicVAO */
    val GETTER_MAP = mapOf(
        "number" to "getPch_number()",
        "value" to "getPch_value()",
        "date" to "getPch_date()",
        "desc" to "getPch_desc()"
    )

    /** Setter method names for PCharacteristicVAO */
    val SETTER_MAP = mapOf(
        "number" to "setPch_number",
        "value" to "setPch_value",
        "date" to "setPch_date",
        "desc" to "setPch_desc"
    )
}
