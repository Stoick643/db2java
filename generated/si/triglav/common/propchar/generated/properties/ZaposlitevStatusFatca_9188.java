package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=9188 (Zaposlitev - status FATCA)
 * Generated - do not edit manually.
 */
public class ZaposlitevStatusFatca_9188 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer statusZaposlitveFatca;  // 9189 number

    public Integer getStatusZaposlitveFatca() {
        return statusZaposlitveFatca;
    }

    public void setStatusZaposlitveFatca(Integer statusZaposlitveFatca) {
        this.statusZaposlitveFatca = statusZaposlitveFatca;
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
            case 9189: return this.getStatusZaposlitveFatca();
            default: return null;
        }
    }

}