package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=8531 (Serijska številka certifikata)
 * Generated - do not edit manually.
 */
public class SerijskaStevilkaCertifikata_8531 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private String serijskaStevilkaCertifikata;  // 8532 desc

    public String getSerijskaStevilkaCertifikata() {
        return serijskaStevilkaCertifikata;
    }

    public void setSerijskaStevilkaCertifikata(String serijskaStevilkaCertifikata) {
        this.serijskaStevilkaCertifikata = serijskaStevilkaCertifikata;
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
            case 8532: return this.getSerijskaStevilkaCertifikata();
            default: return null;
        }
    }

}