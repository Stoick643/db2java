package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=8299 (Podatki o rojstvu)
 * Generated - do not edit manually.
 */
public class PodatkiORojstvu_8299 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private String krajRojstva;  // 8267 desc
    private Integer drzavaRojstva;  // 8309 number

    public String getKrajRojstva() {
        return krajRojstva;
    }

    public void setKrajRojstva(String krajRojstva) {
        this.krajRojstva = krajRojstva;
    }

    public Integer getDrzavaRojstva() {
        return drzavaRojstva;
    }

    public void setDrzavaRojstva(Integer drzavaRojstva) {
        this.drzavaRojstva = drzavaRojstva;
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
            case 8267: return this.getKrajRojstva();
            case 8309: return this.getDrzavaRojstva();
            default: return null;
        }
    }

}