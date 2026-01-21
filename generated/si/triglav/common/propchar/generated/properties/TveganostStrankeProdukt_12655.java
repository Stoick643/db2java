package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=12655 (Tveganost stranke - PRODUKT)
 * Generated - do not edit manually.
 */
public class TveganostStrankeProdukt_12655 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer tveganostStrankeProdukt;  // 12656 number

    public Integer getTveganostStrankeProdukt() {
        return tveganostStrankeProdukt;
    }

    public void setTveganostStrankeProdukt(Integer tveganostStrankeProdukt) {
        this.tveganostStrankeProdukt = tveganostStrankeProdukt;
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
            case 12656: return this.getTveganostStrankeProdukt();
            default: return null;
        }
    }

}