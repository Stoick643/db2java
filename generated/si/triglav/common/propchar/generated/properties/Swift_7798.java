package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=7798 (Swift)
 * Generated - do not edit manually.
 */
public class Swift_7798 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private String swiftKoda;  // 7799 desc

    public String getSwiftKoda() {
        return swiftKoda;
    }

    public void setSwiftKoda(String swiftKoda) {
        this.swiftKoda = swiftKoda;
    }

    /**
     * Bridge method for accessing characteristics by tp_character ID.
     *
     * <p><b>Use sparingly:</b> This method is provided for backward compatibility
     * and legacy code migration. Prefer using typed getters directly
     * (e.g., getStevilkaDokumenta() instead of getCharValue(7805)).</p>
     *
     * @param tpCharacter The characteristic type ID
     * @return The characteristic value, or null if not found
     */
    public Object getCharValue(Integer tpCharacter) {
        switch (tpCharacter) {
            case 7799: return this.getSwiftKoda();
            default: return null;
        }
    }

}