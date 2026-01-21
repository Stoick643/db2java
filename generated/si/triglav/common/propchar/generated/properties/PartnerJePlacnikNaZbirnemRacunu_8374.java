package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=8374 (Partner je placnik na zbirnem racunu)
 * Generated - do not edit manually.
 */
public class PartnerJePlacnikNaZbirnemRacunu_8374 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer partnerJePlacnikNaZbirnemRacunu;  // 8375 number
    private String elektronskiNaslovZaPrejemZbirnegaRacuna;  // 8376 desc
    private Integer valutaZbirnegaRacuna;  // 8394 number

    public Integer getPartnerJePlacnikNaZbirnemRacunu() {
        return partnerJePlacnikNaZbirnemRacunu;
    }

    public void setPartnerJePlacnikNaZbirnemRacunu(Integer partnerJePlacnikNaZbirnemRacunu) {
        this.partnerJePlacnikNaZbirnemRacunu = partnerJePlacnikNaZbirnemRacunu;
    }

    public String getElektronskiNaslovZaPrejemZbirnegaRacuna() {
        return elektronskiNaslovZaPrejemZbirnegaRacuna;
    }

    public void setElektronskiNaslovZaPrejemZbirnegaRacuna(String elektronskiNaslovZaPrejemZbirnegaRacuna) {
        this.elektronskiNaslovZaPrejemZbirnegaRacuna = elektronskiNaslovZaPrejemZbirnegaRacuna;
    }

    public Integer getValutaZbirnegaRacuna() {
        return valutaZbirnegaRacuna;
    }

    public void setValutaZbirnegaRacuna(Integer valutaZbirnegaRacuna) {
        this.valutaZbirnegaRacuna = valutaZbirnegaRacuna;
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
            case 8375: return this.getPartnerJePlacnikNaZbirnemRacunu();
            case 8376: return this.getElektronskiNaslovZaPrejemZbirnegaRacuna();
            case 8394: return this.getValutaZbirnegaRacuna();
            default: return null;
        }
    }

}