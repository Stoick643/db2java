package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=12737 (Rizicnost poslovnega partnerja - TPD)
 * Generated - do not edit manually.
 */
public class RizicnostPoslovnegaPartnerjaTpd_12737 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer rizicnostPoslovnegaPartnerjaTpd;  // 12736 number
    private Integer strankaJePio;  // 12841 number
    private Integer strankaImaPovezaneOsebe;  // 12842 number
    private Integer drzavljanstvo;  // 12843 number
    private Integer drzavaStalnegaPrebivanja;  // 12844 number
    private Integer drzavaZacasnegaPrebivanja;  // 12845 number
    private Integer rezidentstvoRs;  // 12846 number
    private Integer sklenjeniProdukti;  // 12847 number
    private Integer transakcijeInStanjaNaNalozbenemRacunu;  // 12848 number
    private Integer naciniIzvedbeTransakcije;  // 12849 number

    public Integer getRizicnostPoslovnegaPartnerjaTpd() {
        return rizicnostPoslovnegaPartnerjaTpd;
    }

    public void setRizicnostPoslovnegaPartnerjaTpd(Integer rizicnostPoslovnegaPartnerjaTpd) {
        this.rizicnostPoslovnegaPartnerjaTpd = rizicnostPoslovnegaPartnerjaTpd;
    }

    public Integer getStrankaJePio() {
        return strankaJePio;
    }

    public void setStrankaJePio(Integer strankaJePio) {
        this.strankaJePio = strankaJePio;
    }

    public Integer getStrankaImaPovezaneOsebe() {
        return strankaImaPovezaneOsebe;
    }

    public void setStrankaImaPovezaneOsebe(Integer strankaImaPovezaneOsebe) {
        this.strankaImaPovezaneOsebe = strankaImaPovezaneOsebe;
    }

    public Integer getDrzavljanstvo() {
        return drzavljanstvo;
    }

    public void setDrzavljanstvo(Integer drzavljanstvo) {
        this.drzavljanstvo = drzavljanstvo;
    }

    public Integer getDrzavaStalnegaPrebivanja() {
        return drzavaStalnegaPrebivanja;
    }

    public void setDrzavaStalnegaPrebivanja(Integer drzavaStalnegaPrebivanja) {
        this.drzavaStalnegaPrebivanja = drzavaStalnegaPrebivanja;
    }

    public Integer getDrzavaZacasnegaPrebivanja() {
        return drzavaZacasnegaPrebivanja;
    }

    public void setDrzavaZacasnegaPrebivanja(Integer drzavaZacasnegaPrebivanja) {
        this.drzavaZacasnegaPrebivanja = drzavaZacasnegaPrebivanja;
    }

    public Integer getRezidentstvoRs() {
        return rezidentstvoRs;
    }

    public void setRezidentstvoRs(Integer rezidentstvoRs) {
        this.rezidentstvoRs = rezidentstvoRs;
    }

    public Integer getSklenjeniProdukti() {
        return sklenjeniProdukti;
    }

    public void setSklenjeniProdukti(Integer sklenjeniProdukti) {
        this.sklenjeniProdukti = sklenjeniProdukti;
    }

    public Integer getTransakcijeInStanjaNaNalozbenemRacunu() {
        return transakcijeInStanjaNaNalozbenemRacunu;
    }

    public void setTransakcijeInStanjaNaNalozbenemRacunu(Integer transakcijeInStanjaNaNalozbenemRacunu) {
        this.transakcijeInStanjaNaNalozbenemRacunu = transakcijeInStanjaNaNalozbenemRacunu;
    }

    public Integer getNaciniIzvedbeTransakcije() {
        return naciniIzvedbeTransakcije;
    }

    public void setNaciniIzvedbeTransakcije(Integer naciniIzvedbeTransakcije) {
        this.naciniIzvedbeTransakcije = naciniIzvedbeTransakcije;
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
            case 12736: return this.getRizicnostPoslovnegaPartnerjaTpd();
            case 12841: return this.getStrankaJePio();
            case 12842: return this.getStrankaImaPovezaneOsebe();
            case 12843: return this.getDrzavljanstvo();
            case 12844: return this.getDrzavaStalnegaPrebivanja();
            case 12845: return this.getDrzavaZacasnegaPrebivanja();
            case 12846: return this.getRezidentstvoRs();
            case 12847: return this.getSklenjeniProdukti();
            case 12848: return this.getTransakcijeInStanjaNaNalozbenemRacunu();
            case 12849: return this.getNaciniIzvedbeTransakcije();
            default: return null;
        }
    }

}