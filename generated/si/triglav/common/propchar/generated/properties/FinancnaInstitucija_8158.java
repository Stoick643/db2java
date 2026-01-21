package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=8158 (Financna inštitucija)
 * Generated - do not edit manually.
 */
public class FinancnaInstitucija_8158 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer financnaInstitucija;  // 8159 number

    public Integer getFinancnaInstitucija() {
        return financnaInstitucija;
    }

    public void setFinancnaInstitucija(Integer financnaInstitucija) {
        this.financnaInstitucija = financnaInstitucija;
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
            case 8159: return this.getFinancnaInstitucija();
            default: return null;
        }
    }

}