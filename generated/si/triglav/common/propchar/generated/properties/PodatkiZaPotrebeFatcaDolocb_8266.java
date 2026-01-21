package si.triglav.common.propchar.generated.properties;

import si.triglav.common.SimpleDate;
import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=8266 (Podatki za potrebe FATCA dolocb)
 * Generated - do not edit manually.
 */
public class PodatkiZaPotrebeFatcaDolocb_8266 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer drzava;  // 8268 number
    private Integer rezidentZdaZaDavcneNamene;  // 8269 number
    private String sifraTinssn;  // 8270 desc
    private Integer izpolnjenVprasalnikW8Benbene;  // 8272 number
    private Integer izpolnjenVprasalnikW9;  // 8273 number
    private Integer fatcaStatus;  // 8274 number
    private Integer osebaImaPozitivenFatcaStatus;  // 8313 number
    private Integer fatcayesno;  // 8574 number
    private String tpcharfatcassn;  // 9195 desc
    private SimpleDate tpcharfatcanotesentdate;  // 12670 date
    private SimpleDate tpcharfatcanotereceiveddate;  // 12671 date

    public Integer getDrzava() {
        return drzava;
    }

    public void setDrzava(Integer drzava) {
        this.drzava = drzava;
    }

    public Integer getRezidentZdaZaDavcneNamene() {
        return rezidentZdaZaDavcneNamene;
    }

    public void setRezidentZdaZaDavcneNamene(Integer rezidentZdaZaDavcneNamene) {
        this.rezidentZdaZaDavcneNamene = rezidentZdaZaDavcneNamene;
    }

    public String getSifraTinssn() {
        return sifraTinssn;
    }

    public void setSifraTinssn(String sifraTinssn) {
        this.sifraTinssn = sifraTinssn;
    }

    public Integer getIzpolnjenVprasalnikW8Benbene() {
        return izpolnjenVprasalnikW8Benbene;
    }

    public void setIzpolnjenVprasalnikW8Benbene(Integer izpolnjenVprasalnikW8Benbene) {
        this.izpolnjenVprasalnikW8Benbene = izpolnjenVprasalnikW8Benbene;
    }

    public Integer getIzpolnjenVprasalnikW9() {
        return izpolnjenVprasalnikW9;
    }

    public void setIzpolnjenVprasalnikW9(Integer izpolnjenVprasalnikW9) {
        this.izpolnjenVprasalnikW9 = izpolnjenVprasalnikW9;
    }

    public Integer getFatcaStatus() {
        return fatcaStatus;
    }

    public void setFatcaStatus(Integer fatcaStatus) {
        this.fatcaStatus = fatcaStatus;
    }

    public Integer getOsebaImaPozitivenFatcaStatus() {
        return osebaImaPozitivenFatcaStatus;
    }

    public void setOsebaImaPozitivenFatcaStatus(Integer osebaImaPozitivenFatcaStatus) {
        this.osebaImaPozitivenFatcaStatus = osebaImaPozitivenFatcaStatus;
    }

    public Integer getFatcayesno() {
        return fatcayesno;
    }

    public void setFatcayesno(Integer fatcayesno) {
        this.fatcayesno = fatcayesno;
    }

    public String getTpcharfatcassn() {
        return tpcharfatcassn;
    }

    public void setTpcharfatcassn(String tpcharfatcassn) {
        this.tpcharfatcassn = tpcharfatcassn;
    }

    public SimpleDate getTpcharfatcanotesentdate() {
        return tpcharfatcanotesentdate;
    }

    public void setTpcharfatcanotesentdate(SimpleDate tpcharfatcanotesentdate) {
        this.tpcharfatcanotesentdate = tpcharfatcanotesentdate;
    }

    public SimpleDate getTpcharfatcanotereceiveddate() {
        return tpcharfatcanotereceiveddate;
    }

    public void setTpcharfatcanotereceiveddate(SimpleDate tpcharfatcanotereceiveddate) {
        this.tpcharfatcanotereceiveddate = tpcharfatcanotereceiveddate;
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
            case 8268: return this.getDrzava();
            case 8269: return this.getRezidentZdaZaDavcneNamene();
            case 8270: return this.getSifraTinssn();
            case 8272: return this.getIzpolnjenVprasalnikW8Benbene();
            case 8273: return this.getIzpolnjenVprasalnikW9();
            case 8274: return this.getFatcaStatus();
            case 8313: return this.getOsebaImaPozitivenFatcaStatus();
            case 8574: return this.getFatcayesno();
            case 9195: return this.getTpcharfatcassn();
            case 12670: return this.getTpcharfatcanotesentdate();
            case 12671: return this.getTpcharfatcanotereceiveddate();
            default: return null;
        }
    }

}