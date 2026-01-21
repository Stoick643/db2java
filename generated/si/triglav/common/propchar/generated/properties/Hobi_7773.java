package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=7773 (Hobi)
 * Generated - do not edit manually.
 */
public class Hobi_7773 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer tipHobija;  // 7822 number

    public Integer getTipHobija() {
        return tipHobija;
    }

    public void setTipHobija(Integer tipHobija) {
        this.tipHobija = tipHobija;
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
            case 7822: return this.getTipHobija();
            default: return null;
        }
    }

}