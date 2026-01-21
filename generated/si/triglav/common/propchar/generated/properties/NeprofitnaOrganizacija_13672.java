package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=13672 (Neprofitna organizacija)
 * Generated - do not edit manually.
 */
public class NeprofitnaOrganizacija_13672 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer neprofitnaOrganizacija;  // 13673 number

    public Integer getNeprofitnaOrganizacija() {
        return neprofitnaOrganizacija;
    }

    public void setNeprofitnaOrganizacija(Integer neprofitnaOrganizacija) {
        this.neprofitnaOrganizacija = neprofitnaOrganizacija;
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
            case 13673: return this.getNeprofitnaOrganizacija();
            default: return null;
        }
    }

}