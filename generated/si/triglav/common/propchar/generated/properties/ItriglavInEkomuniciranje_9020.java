package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=9020 (iTriglav in E-komuniciranje)
 * Generated - do not edit manually.
 */
public class ItriglavInEkomuniciranje_9020 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer strankaJeUporabnikItriglav;  // 9021 number
    private Integer ekomuniciranje;  // 9022 number
    private String enaslovZaItriglavInEkomuniciranje;  // 9023 desc
    private String telefonskaStevilkaZaItriglav;  // 9026 desc

    public Integer getStrankaJeUporabnikItriglav() {
        return strankaJeUporabnikItriglav;
    }

    public void setStrankaJeUporabnikItriglav(Integer strankaJeUporabnikItriglav) {
        this.strankaJeUporabnikItriglav = strankaJeUporabnikItriglav;
    }

    public Integer getEkomuniciranje() {
        return ekomuniciranje;
    }

    public void setEkomuniciranje(Integer ekomuniciranje) {
        this.ekomuniciranje = ekomuniciranje;
    }

    public String getEnaslovZaItriglavInEkomuniciranje() {
        return enaslovZaItriglavInEkomuniciranje;
    }

    public void setEnaslovZaItriglavInEkomuniciranje(String enaslovZaItriglavInEkomuniciranje) {
        this.enaslovZaItriglavInEkomuniciranje = enaslovZaItriglavInEkomuniciranje;
    }

    public String getTelefonskaStevilkaZaItriglav() {
        return telefonskaStevilkaZaItriglav;
    }

    public void setTelefonskaStevilkaZaItriglav(String telefonskaStevilkaZaItriglav) {
        this.telefonskaStevilkaZaItriglav = telefonskaStevilkaZaItriglav;
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
            case 9021: return this.getStrankaJeUporabnikItriglav();
            case 9022: return this.getEkomuniciranje();
            case 9023: return this.getEnaslovZaItriglavInEkomuniciranje();
            case 9026: return this.getTelefonskaStevilkaZaItriglav();
            default: return null;
        }
    }

}