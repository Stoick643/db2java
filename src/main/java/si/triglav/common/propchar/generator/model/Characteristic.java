package si.triglav.common.propchar.generator.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a tp_character with one or more fields.
 */
public class Characteristic {

    private final int tpCharacter;
    private final String name;
    private final List<CharacteristicField> fields;
    private boolean isBoolean;
    private Integer booleanTrueVal;
    private Integer booleanFalseVal;

    public Characteristic(int tpCharacter, String name) {
        this.tpCharacter = tpCharacter;
        this.name = name;
        this.fields = new ArrayList<>();
        this.isBoolean = false;
    }

    public int getTpCharacter() {
        return tpCharacter;
    }

    public String getName() {
        return name;
    }

    public List<CharacteristicField> getFields() {
        return fields;
    }

    public void addField(CharacteristicField field) {
        this.fields.add(field);
    }

    public boolean isBoolean() {
        return isBoolean;
    }

    public void setBoolean(boolean isBoolean) {
        this.isBoolean = isBoolean;
    }

    public Integer getBooleanTrueVal() {
        return booleanTrueVal;
    }

    public void setBooleanTrueVal(Integer booleanTrueVal) {
        this.booleanTrueVal = booleanTrueVal;
    }

    public Integer getBooleanFalseVal() {
        return booleanFalseVal;
    }

    public void setBooleanFalseVal(Integer booleanFalseVal) {
        this.booleanFalseVal = booleanFalseVal;
    }
}
