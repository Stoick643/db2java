package si.triglav.common.propchar.generated.properties;

import si.triglav.common.SimpleDate;
import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=7744 (Osebni dokument)
 * Generated - do not edit manually.
 */
public class OsebniDokument_7744 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private String stevilkaDokumenta;  // 7805 desc
    private Integer vrstaDokumenta;  // 7806 number
    private SimpleDate datumIzdaje;  // 7807 date
    private SimpleDate konecVeljavnosti;  // 7808 date
    private String organIzdaje;  // 8018 desc
    private Integer vzrokNeizvedeneOsebneIdentifikacije_number;  // 8355 number
    private String vzrokNeizvedeneOsebneIdentifikacije_desc;  // 8355 desc
    private Integer drzavaIzdajeOsebnegaDokumenta;  // 8963 number
    private Integer konecVeljavnostiPermanentno;  // 9111 number

    public String getStevilkaDokumenta() {
        return stevilkaDokumenta;
    }

    public void setStevilkaDokumenta(String stevilkaDokumenta) {
        this.stevilkaDokumenta = stevilkaDokumenta;
    }

    public Integer getVrstaDokumenta() {
        return vrstaDokumenta;
    }

    public void setVrstaDokumenta(Integer vrstaDokumenta) {
        this.vrstaDokumenta = vrstaDokumenta;
    }

    public SimpleDate getDatumIzdaje() {
        return datumIzdaje;
    }

    public void setDatumIzdaje(SimpleDate datumIzdaje) {
        this.datumIzdaje = datumIzdaje;
    }

    public SimpleDate getKonecVeljavnosti() {
        return konecVeljavnosti;
    }

    public void setKonecVeljavnosti(SimpleDate konecVeljavnosti) {
        this.konecVeljavnosti = konecVeljavnosti;
    }

    public String getOrganIzdaje() {
        return organIzdaje;
    }

    public void setOrganIzdaje(String organIzdaje) {
        this.organIzdaje = organIzdaje;
    }

    public Integer getVzrokNeizvedeneOsebneIdentifikacije_number() {
        return vzrokNeizvedeneOsebneIdentifikacije_number;
    }

    public void setVzrokNeizvedeneOsebneIdentifikacije_number(Integer vzrokNeizvedeneOsebneIdentifikacije_number) {
        this.vzrokNeizvedeneOsebneIdentifikacije_number = vzrokNeizvedeneOsebneIdentifikacije_number;
    }

    public String getVzrokNeizvedeneOsebneIdentifikacije_desc() {
        return vzrokNeizvedeneOsebneIdentifikacije_desc;
    }

    public void setVzrokNeizvedeneOsebneIdentifikacije_desc(String vzrokNeizvedeneOsebneIdentifikacije_desc) {
        this.vzrokNeizvedeneOsebneIdentifikacije_desc = vzrokNeizvedeneOsebneIdentifikacije_desc;
    }

    public Integer getDrzavaIzdajeOsebnegaDokumenta() {
        return drzavaIzdajeOsebnegaDokumenta;
    }

    public void setDrzavaIzdajeOsebnegaDokumenta(Integer drzavaIzdajeOsebnegaDokumenta) {
        this.drzavaIzdajeOsebnegaDokumenta = drzavaIzdajeOsebnegaDokumenta;
    }

    public Integer getKonecVeljavnostiPermanentno() {
        return konecVeljavnostiPermanentno;
    }

    public void setKonecVeljavnostiPermanentno(Integer konecVeljavnostiPermanentno) {
        this.konecVeljavnostiPermanentno = konecVeljavnostiPermanentno;
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
            case 7805: return this.getStevilkaDokumenta();
            case 7806: return this.getVrstaDokumenta();
            case 7807: return this.getDatumIzdaje();
            case 7808: return this.getKonecVeljavnosti();
            case 8018: return this.getOrganIzdaje();
            case 8355: return this.getVzrokNeizvedeneOsebneIdentifikacije_number();
            case 8963: return this.getDrzavaIzdajeOsebnegaDokumenta();
            case 9111: return this.getKonecVeljavnostiPermanentno();
            default: return null;
        }
    }

}