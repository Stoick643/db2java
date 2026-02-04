package si.triglav.common.propchar.generator.model;

/**
 * Represents boolean value mapping for a characteristic.
 */
public class BooleanMapping {

    private final int tpCharacter;
    private final int trueValue;
    private final int falseValue;

    public BooleanMapping(int tpCharacter, int trueValue, int falseValue) {
        this.tpCharacter = tpCharacter;
        this.trueValue = trueValue;
        this.falseValue = falseValue;
    }

    public int getTpCharacter() {
        return tpCharacter;
    }

    public int getTrueValue() {
        return trueValue;
    }

    public int getFalseValue() {
        return falseValue;
    }
}
