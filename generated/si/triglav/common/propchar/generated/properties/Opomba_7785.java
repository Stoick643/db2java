package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=7785 (Opomba)
 * Generated - do not edit manually.
 */
public class Opomba_7785 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private String opisOpombe;  // 7832 desc

    public String getOpisOpombe() {
        return opisOpombe;
    }

    public void setOpisOpombe(String opisOpombe) {
        this.opisOpombe = opisOpombe;
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
            case 7832: return this.getOpisOpombe();
            default: return null;
        }
    }

}