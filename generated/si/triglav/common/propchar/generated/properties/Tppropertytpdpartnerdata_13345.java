package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=13345 (TP_PROPERTY_TPD_PARTNER_DATA)
 * Generated - do not edit manually.
 */
public class Tppropertytpdpartnerdata_13345 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer tpcharpartnervalidtpdinsurance;  // 13346 number

    public Integer getTpcharpartnervalidtpdinsurance() {
        return tpcharpartnervalidtpdinsurance;
    }

    public void setTpcharpartnervalidtpdinsurance(Integer tpcharpartnervalidtpdinsurance) {
        this.tpcharpartnervalidtpdinsurance = tpcharpartnervalidtpdinsurance;
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
            case 13346: return this.getTpcharpartnervalidtpdinsurance();
            default: return null;
        }
    }

}