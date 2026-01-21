package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=8275 (eRacun)
 * Generated - do not edit manually.
 */
public class Eracun_8275 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer strankaZeliPrejematiEracun;  // 8276 number
    private Integer vrstaKanalaZaPrejemanjeEracuna;  // 8277 number
    private String elektronskiNaslovZaEracun;  // 8278 desc
    private String bancniRacunZaEracun;  // 8286 desc

    public Integer getStrankaZeliPrejematiEracun() {
        return strankaZeliPrejematiEracun;
    }

    public void setStrankaZeliPrejematiEracun(Integer strankaZeliPrejematiEracun) {
        this.strankaZeliPrejematiEracun = strankaZeliPrejematiEracun;
    }

    public Integer getVrstaKanalaZaPrejemanjeEracuna() {
        return vrstaKanalaZaPrejemanjeEracuna;
    }

    public void setVrstaKanalaZaPrejemanjeEracuna(Integer vrstaKanalaZaPrejemanjeEracuna) {
        this.vrstaKanalaZaPrejemanjeEracuna = vrstaKanalaZaPrejemanjeEracuna;
    }

    public String getElektronskiNaslovZaEracun() {
        return elektronskiNaslovZaEracun;
    }

    public void setElektronskiNaslovZaEracun(String elektronskiNaslovZaEracun) {
        this.elektronskiNaslovZaEracun = elektronskiNaslovZaEracun;
    }

    public String getBancniRacunZaEracun() {
        return bancniRacunZaEracun;
    }

    public void setBancniRacunZaEracun(String bancniRacunZaEracun) {
        this.bancniRacunZaEracun = bancniRacunZaEracun;
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
            case 8276: return this.getStrankaZeliPrejematiEracun();
            case 8277: return this.getVrstaKanalaZaPrejemanjeEracuna();
            case 8278: return this.getElektronskiNaslovZaEracun();
            case 8286: return this.getBancniRacunZaEracun();
            default: return null;
        }
    }

}