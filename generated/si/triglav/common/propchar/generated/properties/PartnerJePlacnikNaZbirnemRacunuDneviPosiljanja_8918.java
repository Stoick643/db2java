package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=8918 (Partner je placnik na zbirnem racunu - dnevi pošiljanja)
 * Generated - do not edit manually.
 */
public class PartnerJePlacnikNaZbirnemRacunuDneviPosiljanja_8918 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private String danZaPosiljanjeZbirniRacun;  // 8917 desc

    public String getDanZaPosiljanjeZbirniRacun() {
        return danZaPosiljanjeZbirniRacun;
    }

    public void setDanZaPosiljanjeZbirniRacun(String danZaPosiljanjeZbirniRacun) {
        this.danZaPosiljanjeZbirniRacun = danZaPosiljanjeZbirniRacun;
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
            case 8917: return this.getDanZaPosiljanjeZbirniRacun();
            default: return null;
        }
    }

}