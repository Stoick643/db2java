package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=8296 (Vir dohodka)
 * Generated - do not edit manually.
 */
public class VirDohodka_8296 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer poslanoSStraniInkaso;  // 8057 number
    private Integer poslanoSStraniTarifacija;  // 8058 number
    private String drugo;  // 8284 desc
    private Integer tipViraDohodka;  // 8297 number
    private String dodatniOpisViraDohodka;  // 8298 desc
    private Integer cashoriginyesno;  // 8605 number
    private Integer tpcharcashoriginpioyes;  // 9196 number
    private Integer tpcharcashoriginpaymentover15k;  // 9197 number

    public Integer getPoslanoSStraniInkaso() {
        return poslanoSStraniInkaso;
    }

    public void setPoslanoSStraniInkaso(Integer poslanoSStraniInkaso) {
        this.poslanoSStraniInkaso = poslanoSStraniInkaso;
    }

    public Integer getPoslanoSStraniTarifacija() {
        return poslanoSStraniTarifacija;
    }

    public void setPoslanoSStraniTarifacija(Integer poslanoSStraniTarifacija) {
        this.poslanoSStraniTarifacija = poslanoSStraniTarifacija;
    }

    public String getDrugo() {
        return drugo;
    }

    public void setDrugo(String drugo) {
        this.drugo = drugo;
    }

    public Integer getTipViraDohodka() {
        return tipViraDohodka;
    }

    public void setTipViraDohodka(Integer tipViraDohodka) {
        this.tipViraDohodka = tipViraDohodka;
    }

    public String getDodatniOpisViraDohodka() {
        return dodatniOpisViraDohodka;
    }

    public void setDodatniOpisViraDohodka(String dodatniOpisViraDohodka) {
        this.dodatniOpisViraDohodka = dodatniOpisViraDohodka;
    }

    public Integer getCashoriginyesno() {
        return cashoriginyesno;
    }

    public void setCashoriginyesno(Integer cashoriginyesno) {
        this.cashoriginyesno = cashoriginyesno;
    }

    public Integer getTpcharcashoriginpioyes() {
        return tpcharcashoriginpioyes;
    }

    public void setTpcharcashoriginpioyes(Integer tpcharcashoriginpioyes) {
        this.tpcharcashoriginpioyes = tpcharcashoriginpioyes;
    }

    public Integer getTpcharcashoriginpaymentover15k() {
        return tpcharcashoriginpaymentover15k;
    }

    public void setTpcharcashoriginpaymentover15k(Integer tpcharcashoriginpaymentover15k) {
        this.tpcharcashoriginpaymentover15k = tpcharcashoriginpaymentover15k;
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
            case 8057: return this.getPoslanoSStraniInkaso();
            case 8058: return this.getPoslanoSStraniTarifacija();
            case 8284: return this.getDrugo();
            case 8297: return this.getTipViraDohodka();
            case 8298: return this.getDodatniOpisViraDohodka();
            case 8605: return this.getCashoriginyesno();
            case 9196: return this.getTpcharcashoriginpioyes();
            case 9197: return this.getTpcharcashoriginpaymentover15k();
            default: return null;
        }
    }

}