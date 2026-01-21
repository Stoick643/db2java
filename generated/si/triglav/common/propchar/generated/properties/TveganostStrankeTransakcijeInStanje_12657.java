package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=12657 (Tveganost stranke - TRANSAKCIJE in STANJE)
 * Generated - do not edit manually.
 */
public class TveganostStrankeTransakcijeInStanje_12657 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer tveganostStrankeTransakcijeInStanje;  // 12658 number

    public Integer getTveganostStrankeTransakcijeInStanje() {
        return tveganostStrankeTransakcijeInStanje;
    }

    public void setTveganostStrankeTransakcijeInStanje(Integer tveganostStrankeTransakcijeInStanje) {
        this.tveganostStrankeTransakcijeInStanje = tveganostStrankeTransakcijeInStanje;
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
            case 12658: return this.getTveganostStrankeTransakcijeInStanje();
            default: return null;
        }
    }

}