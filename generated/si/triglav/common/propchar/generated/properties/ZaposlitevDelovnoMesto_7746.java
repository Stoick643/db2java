package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=7746 (Zaposlitev - delovno mesto)
 * Generated - do not edit manually.
 */
public class ZaposlitevDelovnoMesto_7746 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private String delovnoMesto;  // 7810 desc

    public String getDelovnoMesto() {
        return delovnoMesto;
    }

    public void setDelovnoMesto(String delovnoMesto) {
        this.delovnoMesto = delovnoMesto;
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
            case 7810: return this.getDelovnoMesto();
            default: return null;
        }
    }

}