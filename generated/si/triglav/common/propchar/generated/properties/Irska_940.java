package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=940 (IRSKA)
 * Generated - do not edit manually.
 */
public class Irska_940 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private String signingIdentifier;  // 9013 desc
    private String phone;  // 9017 desc

    public String getSigningIdentifier() {
        return signingIdentifier;
    }

    public void setSigningIdentifier(String signingIdentifier) {
        this.signingIdentifier = signingIdentifier;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
            case 9013: return this.getSigningIdentifier();
            case 9017: return this.getPhone();
            default: return null;
        }
    }

}