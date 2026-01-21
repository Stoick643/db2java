package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=8639 (TP_PROPERTY_NATIONALITY)
 * Generated - do not edit manually.
 */
public class Tppropertynationality_8639 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer tpcharnationality;  // 8638 number

    public Integer getTpcharnationality() {
        return tpcharnationality;
    }

    public void setTpcharnationality(Integer tpcharnationality) {
        this.tpcharnationality = tpcharnationality;
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
            case 8638: return this.getTpcharnationality();
            default: return null;
        }
    }

}