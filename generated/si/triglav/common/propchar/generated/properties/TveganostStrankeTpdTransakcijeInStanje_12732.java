package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=12732 (Tveganost stranke TPD - TRANSAKCIJE in STANJE)
 * Generated - do not edit manually.
 */
public class TveganostStrankeTpdTransakcijeInStanje_12732 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer tveganostStrankeTpdTransakcijeInStanje;  // 12733 number

    public Integer getTveganostStrankeTpdTransakcijeInStanje() {
        return tveganostStrankeTpdTransakcijeInStanje;
    }

    public void setTveganostStrankeTpdTransakcijeInStanje(Integer tveganostStrankeTpdTransakcijeInStanje) {
        this.tveganostStrankeTpdTransakcijeInStanje = tveganostStrankeTpdTransakcijeInStanje;
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
            case 12733: return this.getTveganostStrankeTpdTransakcijeInStanje();
            default: return null;
        }
    }

}