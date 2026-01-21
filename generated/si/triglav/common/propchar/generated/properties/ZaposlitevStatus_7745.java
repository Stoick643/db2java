package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=7745 (Zaposlitev - status)
 * Generated - do not edit manually.
 */
public class ZaposlitevStatus_7745 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer statusZaposlitve;  // 7809 number

    public Integer getStatusZaposlitve() {
        return statusZaposlitve;
    }

    public void setStatusZaposlitve(Integer statusZaposlitve) {
        this.statusZaposlitve = statusZaposlitve;
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
            case 7809: return this.getStatusZaposlitve();
            default: return null;
        }
    }

}