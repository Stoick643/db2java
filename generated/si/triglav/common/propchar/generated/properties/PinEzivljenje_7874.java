package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=7874 (Pin - e-življenje)
 * Generated - do not edit manually.
 */
public class PinEzivljenje_7874 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private String pinEzivljenje;  // 7873 desc

    public String getPinEzivljenje() {
        return pinEzivljenje;
    }

    public void setPinEzivljenje(String pinEzivljenje) {
        this.pinEzivljenje = pinEzivljenje;
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
            case 7873: return this.getPinEzivljenje();
            default: return null;
        }
    }

}