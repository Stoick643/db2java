package si.triglav.common.propchar.generated.properties;

import si.triglav.common.SimpleDate;
import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=8240 (Oseba je domaca politicno izpostavljena oseba)
 * Generated - do not edit manually.
 */
public class OsebaJeDomacaPoliticnoIzpostavljenaOseba_8240 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer izpolnjenVprasalnikZaTujePoliticnoIzpostavljeneOsebe;  // 8047 number
    private Integer osebaJeDomacaPoliticnoIzpostavljenaOseba;  // 8241 number
    private String vzrokZaIzpolnitevVprasalnika;  // 8363 desc
    private Integer podrocjeOzIzpolnitveVprasalnika;  // 8364 number
    private SimpleDate finishdatepoliticperson;  // 8593 date
    private Integer tpnonresponeyesno;  // 8630 number
    private Integer tpnonresfammemyesno;  // 8631 number
    private Integer tpnonrescoworkyesno;  // 8632 number
    private String tppiocommentfunc;  // 9112 desc
    private String tppiocommentproperty;  // 9113 desc
    private SimpleDate finishdatepoliticpersonfunction;  // 9190 date
    private String tpcharnonresponecomment;  // 9191 desc
    private String tpcharnonresfammemcomment;  // 9192 desc
    private String tpcharnonrescoworkcomment;  // 9193 desc
    private Integer tpcharpioevent;  // 9194 number

    public Integer getIzpolnjenVprasalnikZaTujePoliticnoIzpostavljeneOsebe() {
        return izpolnjenVprasalnikZaTujePoliticnoIzpostavljeneOsebe;
    }

    public void setIzpolnjenVprasalnikZaTujePoliticnoIzpostavljeneOsebe(Integer izpolnjenVprasalnikZaTujePoliticnoIzpostavljeneOsebe) {
        this.izpolnjenVprasalnikZaTujePoliticnoIzpostavljeneOsebe = izpolnjenVprasalnikZaTujePoliticnoIzpostavljeneOsebe;
    }

    public Integer getOsebaJeDomacaPoliticnoIzpostavljenaOseba() {
        return osebaJeDomacaPoliticnoIzpostavljenaOseba;
    }

    public void setOsebaJeDomacaPoliticnoIzpostavljenaOseba(Integer osebaJeDomacaPoliticnoIzpostavljenaOseba) {
        this.osebaJeDomacaPoliticnoIzpostavljenaOseba = osebaJeDomacaPoliticnoIzpostavljenaOseba;
    }

    public String getVzrokZaIzpolnitevVprasalnika() {
        return vzrokZaIzpolnitevVprasalnika;
    }

    public void setVzrokZaIzpolnitevVprasalnika(String vzrokZaIzpolnitevVprasalnika) {
        this.vzrokZaIzpolnitevVprasalnika = vzrokZaIzpolnitevVprasalnika;
    }

    public Integer getPodrocjeOzIzpolnitveVprasalnika() {
        return podrocjeOzIzpolnitveVprasalnika;
    }

    public void setPodrocjeOzIzpolnitveVprasalnika(Integer podrocjeOzIzpolnitveVprasalnika) {
        this.podrocjeOzIzpolnitveVprasalnika = podrocjeOzIzpolnitveVprasalnika;
    }

    public SimpleDate getFinishdatepoliticperson() {
        return finishdatepoliticperson;
    }

    public void setFinishdatepoliticperson(SimpleDate finishdatepoliticperson) {
        this.finishdatepoliticperson = finishdatepoliticperson;
    }

    public Integer getTpnonresponeyesno() {
        return tpnonresponeyesno;
    }

    public void setTpnonresponeyesno(Integer tpnonresponeyesno) {
        this.tpnonresponeyesno = tpnonresponeyesno;
    }

    public Integer getTpnonresfammemyesno() {
        return tpnonresfammemyesno;
    }

    public void setTpnonresfammemyesno(Integer tpnonresfammemyesno) {
        this.tpnonresfammemyesno = tpnonresfammemyesno;
    }

    public Integer getTpnonrescoworkyesno() {
        return tpnonrescoworkyesno;
    }

    public void setTpnonrescoworkyesno(Integer tpnonrescoworkyesno) {
        this.tpnonrescoworkyesno = tpnonrescoworkyesno;
    }

    public String getTppiocommentfunc() {
        return tppiocommentfunc;
    }

    public void setTppiocommentfunc(String tppiocommentfunc) {
        this.tppiocommentfunc = tppiocommentfunc;
    }

    public String getTppiocommentproperty() {
        return tppiocommentproperty;
    }

    public void setTppiocommentproperty(String tppiocommentproperty) {
        this.tppiocommentproperty = tppiocommentproperty;
    }

    public SimpleDate getFinishdatepoliticpersonfunction() {
        return finishdatepoliticpersonfunction;
    }

    public void setFinishdatepoliticpersonfunction(SimpleDate finishdatepoliticpersonfunction) {
        this.finishdatepoliticpersonfunction = finishdatepoliticpersonfunction;
    }

    public String getTpcharnonresponecomment() {
        return tpcharnonresponecomment;
    }

    public void setTpcharnonresponecomment(String tpcharnonresponecomment) {
        this.tpcharnonresponecomment = tpcharnonresponecomment;
    }

    public String getTpcharnonresfammemcomment() {
        return tpcharnonresfammemcomment;
    }

    public void setTpcharnonresfammemcomment(String tpcharnonresfammemcomment) {
        this.tpcharnonresfammemcomment = tpcharnonresfammemcomment;
    }

    public String getTpcharnonrescoworkcomment() {
        return tpcharnonrescoworkcomment;
    }

    public void setTpcharnonrescoworkcomment(String tpcharnonrescoworkcomment) {
        this.tpcharnonrescoworkcomment = tpcharnonrescoworkcomment;
    }

    public Integer getTpcharpioevent() {
        return tpcharpioevent;
    }

    public void setTpcharpioevent(Integer tpcharpioevent) {
        this.tpcharpioevent = tpcharpioevent;
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
            case 8047: return this.getIzpolnjenVprasalnikZaTujePoliticnoIzpostavljeneOsebe();
            case 8241: return this.getOsebaJeDomacaPoliticnoIzpostavljenaOseba();
            case 8363: return this.getVzrokZaIzpolnitevVprasalnika();
            case 8364: return this.getPodrocjeOzIzpolnitveVprasalnika();
            case 8593: return this.getFinishdatepoliticperson();
            case 8630: return this.getTpnonresponeyesno();
            case 8631: return this.getTpnonresfammemyesno();
            case 8632: return this.getTpnonrescoworkyesno();
            case 9112: return this.getTppiocommentfunc();
            case 9113: return this.getTppiocommentproperty();
            case 9190: return this.getFinishdatepoliticpersonfunction();
            case 9191: return this.getTpcharnonresponecomment();
            case 9192: return this.getTpcharnonresfammemcomment();
            case 9193: return this.getTpcharnonrescoworkcomment();
            case 9194: return this.getTpcharpioevent();
            default: return null;
        }
    }

}