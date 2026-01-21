package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=9244 (Ameriška zvezna država)
 * Generated - do not edit manually.
 */
public class AmeriskaZveznaDrzava_9244 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer ameriskaZveznaDrzava;  // 9245 number

    public Integer getAmeriskaZveznaDrzava() {
        return ameriskaZveznaDrzava;
    }

    public void setAmeriskaZveznaDrzava(Integer ameriskaZveznaDrzava) {
        this.ameriskaZveznaDrzava = ameriskaZveznaDrzava;
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
            case 9245: return this.getAmeriskaZveznaDrzava();
            default: return null;
        }
    }

}