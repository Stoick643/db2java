package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=12730 (Tveganost stranke TPD - PRODUKT)
 * Generated - do not edit manually.
 */
public class TveganostStrankeTpdProdukt_12730 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer tveganostStrankeTpdProdukt;  // 12731 number

    public Integer getTveganostStrankeTpdProdukt() {
        return tveganostStrankeTpdProdukt;
    }

    public void setTveganostStrankeTpdProdukt(Integer tveganostStrankeTpdProdukt) {
        this.tveganostStrankeTpdProdukt = tveganostStrankeTpdProdukt;
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
            case 12731: return this.getTveganostStrankeTpdProdukt();
            default: return null;
        }
    }

}