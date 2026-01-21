package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=7747 (Zaposlitev - izobrazba)
 * Generated - do not edit manually.
 */
public class ZaposlitevIzobrazba_7747 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer stopnjaIzobrazbe;  // 7811 number

    public Integer getStopnjaIzobrazbe() {
        return stopnjaIzobrazbe;
    }

    public void setStopnjaIzobrazbe(Integer stopnjaIzobrazbe) {
        this.stopnjaIzobrazbe = stopnjaIzobrazbe;
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
            case 7811: return this.getStopnjaIzobrazbe();
            default: return null;
        }
    }

}