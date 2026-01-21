package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=8033 (Oseba je rezident RS)
 * Generated - do not edit manually.
 */
public class OsebaJeRezidentRs_8033 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer osebaJeRezidentRs;  // 8034 number
    private Integer drzavaRezidenstva;  // 8046 number
    private Integer izpolnjenVprasalnikZaTujePoliticnoIzpostavljeneOsebe;  // 8047 number

    public Integer getOsebaJeRezidentRs() {
        return osebaJeRezidentRs;
    }

    public void setOsebaJeRezidentRs(Integer osebaJeRezidentRs) {
        this.osebaJeRezidentRs = osebaJeRezidentRs;
    }

    public Integer getDrzavaRezidenstva() {
        return drzavaRezidenstva;
    }

    public void setDrzavaRezidenstva(Integer drzavaRezidenstva) {
        this.drzavaRezidenstva = drzavaRezidenstva;
    }

    public Integer getIzpolnjenVprasalnikZaTujePoliticnoIzpostavljeneOsebe() {
        return izpolnjenVprasalnikZaTujePoliticnoIzpostavljeneOsebe;
    }

    public void setIzpolnjenVprasalnikZaTujePoliticnoIzpostavljeneOsebe(Integer izpolnjenVprasalnikZaTujePoliticnoIzpostavljeneOsebe) {
        this.izpolnjenVprasalnikZaTujePoliticnoIzpostavljeneOsebe = izpolnjenVprasalnikZaTujePoliticnoIzpostavljeneOsebe;
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
            case 8034: return this.getOsebaJeRezidentRs();
            case 8046: return this.getDrzavaRezidenstva();
            case 8047: return this.getIzpolnjenVprasalnikZaTujePoliticnoIzpostavljeneOsebe();
            default: return null;
        }
    }

}