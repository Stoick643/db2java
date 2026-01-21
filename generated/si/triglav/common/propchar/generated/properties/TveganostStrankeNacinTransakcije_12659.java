package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=12659 (Tveganost stranke - NACIN TRANSAKCIJE)
 * Generated - do not edit manually.
 */
public class TveganostStrankeNacinTransakcije_12659 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer tveganostStrankeNacinTransakcije;  // 12660 number

    public Integer getTveganostStrankeNacinTransakcije() {
        return tveganostStrankeNacinTransakcije;
    }

    public void setTveganostStrankeNacinTransakcije(Integer tveganostStrankeNacinTransakcije) {
        this.tveganostStrankeNacinTransakcije = tveganostStrankeNacinTransakcije;
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
            case 12660: return this.getTveganostStrankeNacinTransakcije();
            default: return null;
        }
    }

}