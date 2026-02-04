package si.triglav.common.propchar.generator

/**
 * Data models for the property generator.
 */

/** Represents a single field for a characteristic (may have multiple if multi-column). */
data class CharacteristicField(
    val fieldName: String,
    val javaType: String,
    val columnType: String  // 'number', 'value', 'date', 'desc', 'boolean'
)

/** Represents a tp_character with one or more fields. */
data class Characteristic(
    val tpCharacter: Int,
    val name: String,
    val fields: MutableList<CharacteristicField> = mutableListOf(),
    var isBoolean: Boolean = false,
    var booleanTrueVal: Int? = null,
    var booleanFalseVal: Int? = null
)

/** Represents a tp_property with its characteristics. */
data class Property(
    val tpProperty: Int,
    val name: String,
    val className: String,
    val characteristics: MutableList<Characteristic> = mutableListOf()
)

/** Boolean mapping from pbooleans.csv */
data class BooleanMapping(
    val tpCharacter: Int,
    val trueVal: Int,
    val falseVal: Int
)
