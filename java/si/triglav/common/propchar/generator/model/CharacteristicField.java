package si.triglav.common.propchar.generator.model;

/**
 * Represents a single field for a characteristic (may have multiple if multi-column).
 */
public class CharacteristicField {

    private final String fieldName;
    private final String javaType;
    private final String columnType; // 'number', 'value', 'date', 'desc', 'boolean'

    public CharacteristicField(String fieldName, String javaType, String columnType) {
        this.fieldName = fieldName;
        this.javaType = javaType;
        this.columnType = columnType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getJavaType() {
        return javaType;
    }

    public String getColumnType() {
        return columnType;
    }
}
