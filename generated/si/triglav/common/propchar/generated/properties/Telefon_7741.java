package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=7741 (Telefon)
 * Generated - do not edit manually.
 */
public class Telefon_7741 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private String telefon;  // 7741 desc
    private String telefonskaStevilka;  // 7800 desc
    private String omreznaSkupina;  // 7801 desc
    private Integer vrstaTelefona_number;  // 7802 number
    private String vrstaTelefona_desc;  // 7802 desc
    private Integer zaporednaStevilkaLastnosti;  // 7840 number

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getTelefonskaStevilka() {
        return telefonskaStevilka;
    }

    public void setTelefonskaStevilka(String telefonskaStevilka) {
        this.telefonskaStevilka = telefonskaStevilka;
    }

    public String getOmreznaSkupina() {
        return omreznaSkupina;
    }

    public void setOmreznaSkupina(String omreznaSkupina) {
        this.omreznaSkupina = omreznaSkupina;
    }

    public Integer getVrstaTelefona_number() {
        return vrstaTelefona_number;
    }

    public void setVrstaTelefona_number(Integer vrstaTelefona_number) {
        this.vrstaTelefona_number = vrstaTelefona_number;
    }

    public String getVrstaTelefona_desc() {
        return vrstaTelefona_desc;
    }

    public void setVrstaTelefona_desc(String vrstaTelefona_desc) {
        this.vrstaTelefona_desc = vrstaTelefona_desc;
    }

    public Integer getZaporednaStevilkaLastnosti() {
        return zaporednaStevilkaLastnosti;
    }

    public void setZaporednaStevilkaLastnosti(Integer zaporednaStevilkaLastnosti) {
        this.zaporednaStevilkaLastnosti = zaporednaStevilkaLastnosti;
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
            case 7741: return this.getTelefon();
            case 7800: return this.getTelefonskaStevilka();
            case 7801: return this.getOmreznaSkupina();
            case 7802: return this.getVrstaTelefona_number();
            case 7840: return this.getZaporednaStevilkaLastnosti();
            default: return null;
        }
    }

}