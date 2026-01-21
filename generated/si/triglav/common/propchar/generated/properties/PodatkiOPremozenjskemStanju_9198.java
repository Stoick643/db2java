package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=9198 (Podatki o premoženjskem stanju)
 * Generated - do not edit manually.
 */
public class PodatkiOPremozenjskemStanju_9198 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private String drugo;  // 8284 desc
    private String imetnikBancnegaRacunaPriBanki;  // 13066 desc
    private String lastnikAliSolastnikNepremAliDrugegaPremozenjaVRsAliTujini;  // 13067 desc
    private String vlagateljVVzajemneSkladePriUpravljalcuSkladov;  // 13069 desc
    private String drugoPremozenje;  // 13070 desc

    public String getDrugo() {
        return drugo;
    }

    public void setDrugo(String drugo) {
        this.drugo = drugo;
    }

    public String getImetnikBancnegaRacunaPriBanki() {
        return imetnikBancnegaRacunaPriBanki;
    }

    public void setImetnikBancnegaRacunaPriBanki(String imetnikBancnegaRacunaPriBanki) {
        this.imetnikBancnegaRacunaPriBanki = imetnikBancnegaRacunaPriBanki;
    }

    public String getLastnikAliSolastnikNepremAliDrugegaPremozenjaVRsAliTujini() {
        return lastnikAliSolastnikNepremAliDrugegaPremozenjaVRsAliTujini;
    }

    public void setLastnikAliSolastnikNepremAliDrugegaPremozenjaVRsAliTujini(String lastnikAliSolastnikNepremAliDrugegaPremozenjaVRsAliTujini) {
        this.lastnikAliSolastnikNepremAliDrugegaPremozenjaVRsAliTujini = lastnikAliSolastnikNepremAliDrugegaPremozenjaVRsAliTujini;
    }

    public String getVlagateljVVzajemneSkladePriUpravljalcuSkladov() {
        return vlagateljVVzajemneSkladePriUpravljalcuSkladov;
    }

    public void setVlagateljVVzajemneSkladePriUpravljalcuSkladov(String vlagateljVVzajemneSkladePriUpravljalcuSkladov) {
        this.vlagateljVVzajemneSkladePriUpravljalcuSkladov = vlagateljVVzajemneSkladePriUpravljalcuSkladov;
    }

    public String getDrugoPremozenje() {
        return drugoPremozenje;
    }

    public void setDrugoPremozenje(String drugoPremozenje) {
        this.drugoPremozenje = drugoPremozenje;
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
            case 8284: return this.getDrugo();
            case 13066: return this.getImetnikBancnegaRacunaPriBanki();
            case 13067: return this.getLastnikAliSolastnikNepremAliDrugegaPremozenjaVRsAliTujini();
            case 13069: return this.getVlagateljVVzajemneSkladePriUpravljalcuSkladov();
            case 13070: return this.getDrugoPremozenje();
            default: return null;
        }
    }

}