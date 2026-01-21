package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=12734 (Tveganost stranke TPD - NACIN TRANSAKCIJE)
 * Generated - do not edit manually.
 */
public class TveganostStrankeTpdNacinTransakcije_12734 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer tveganostStrankeTpdNacinTransakcije;  // 12735 number

    public Integer getTveganostStrankeTpdNacinTransakcije() {
        return tveganostStrankeTpdNacinTransakcije;
    }

    public void setTveganostStrankeTpdNacinTransakcije(Integer tveganostStrankeTpdNacinTransakcije) {
        this.tveganostStrankeTpdNacinTransakcije = tveganostStrankeTpdNacinTransakcije;
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
            case 12735: return this.getTveganostStrankeTpdNacinTransakcije();
            default: return null;
        }
    }

}