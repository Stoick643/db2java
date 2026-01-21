package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=7743 (Kontakt - spletni naslov)
 * Generated - do not edit manually.
 */
public class KontaktSpletniNaslov_7743 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private String spletniNaslov;  // 7804 desc

    public String getSpletniNaslov() {
        return spletniNaslov;
    }

    public void setSpletniNaslov(String spletniNaslov) {
        this.spletniNaslov = spletniNaslov;
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
            case 7804: return this.getSpletniNaslov();
            default: return null;
        }
    }

}