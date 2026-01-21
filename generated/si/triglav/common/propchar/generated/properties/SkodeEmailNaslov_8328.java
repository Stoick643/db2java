package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=8328 (Škode - email naslov)
 * Generated - do not edit manually.
 */
public class SkodeEmailNaslov_8328 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private String skodeEmailNaslov;  // 8329 desc

    public String getSkodeEmailNaslov() {
        return skodeEmailNaslov;
    }

    public void setSkodeEmailNaslov(String skodeEmailNaslov) {
        this.skodeEmailNaslov = skodeEmailNaslov;
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
            case 8329: return this.getSkodeEmailNaslov();
            default: return null;
        }
    }

}