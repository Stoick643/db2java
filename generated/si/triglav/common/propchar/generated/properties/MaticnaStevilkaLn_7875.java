package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=7875 (Maticna številka - LN)
 * Generated - do not edit manually.
 */
public class MaticnaStevilkaLn_7875 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private String maticnaStevilkaLn;  // 7876 desc

    public String getMaticnaStevilkaLn() {
        return maticnaStevilkaLn;
    }

    public void setMaticnaStevilkaLn(String maticnaStevilkaLn) {
        this.maticnaStevilkaLn = maticnaStevilkaLn;
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
            case 7876: return this.getMaticnaStevilkaLn();
            default: return null;
        }
    }

}