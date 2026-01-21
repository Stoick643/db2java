package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=7869 (Veterinarska licenca)
 * Generated - do not edit manually.
 */
public class VeterinarskaLicenca_7869 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private String veterinarskaLicenca;  // 7870 desc

    public String getVeterinarskaLicenca() {
        return veterinarskaLicenca;
    }

    public void setVeterinarskaLicenca(String veterinarskaLicenca) {
        this.veterinarskaLicenca = veterinarskaLicenca;
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
            case 7870: return this.getVeterinarskaLicenca();
            default: return null;
        }
    }

}