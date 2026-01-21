package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=7867 (Identifikacijska številka za DDV)
 * Generated - do not edit manually.
 */
public class IdentifikacijskaStevilkaZaDdv_7867 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private String identifikacijskaStevilkaZaDdv;  // 7868 desc

    public String getIdentifikacijskaStevilkaZaDdv() {
        return identifikacijskaStevilkaZaDdv;
    }

    public void setIdentifikacijskaStevilkaZaDdv(String identifikacijskaStevilkaZaDdv) {
        this.identifikacijskaStevilkaZaDdv = identifikacijskaStevilkaZaDdv;
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
            case 7868: return this.getIdentifikacijskaStevilkaZaDdv();
            default: return null;
        }
    }

}