package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=8035 (Oseba je tuja politicno izpostavljena oseba)
 * Generated - do not edit manually.
 */
public class OsebaJeTujaPoliticnoIzpostavljenaOseba_8035 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer osebaJeTujaPoliticnoIzpostavljenaOseba;  // 8036 number

    public Integer getOsebaJeTujaPoliticnoIzpostavljenaOseba() {
        return osebaJeTujaPoliticnoIzpostavljenaOseba;
    }

    public void setOsebaJeTujaPoliticnoIzpostavljenaOseba(Integer osebaJeTujaPoliticnoIzpostavljenaOseba) {
        this.osebaJeTujaPoliticnoIzpostavljenaOseba = osebaJeTujaPoliticnoIzpostavljenaOseba;
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
            case 8036: return this.getOsebaJeTujaPoliticnoIzpostavljenaOseba();
            default: return null;
        }
    }

}