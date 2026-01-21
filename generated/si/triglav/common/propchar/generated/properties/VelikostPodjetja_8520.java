package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=8520 (Velikost podjetja)
 * Generated - do not edit manually.
 */
public class VelikostPodjetja_8520 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer velikostPodjetja;  // 8521 number

    public Integer getVelikostPodjetja() {
        return velikostPodjetja;
    }

    public void setVelikostPodjetja(Integer velikostPodjetja) {
        this.velikostPodjetja = velikostPodjetja;
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
            case 8521: return this.getVelikostPodjetja();
            default: return null;
        }
    }

}