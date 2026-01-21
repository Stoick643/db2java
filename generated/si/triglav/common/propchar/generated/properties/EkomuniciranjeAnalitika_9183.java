package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=9183 (E-komuniciranje - Analitika)
 * Generated - do not edit manually.
 */
public class EkomuniciranjeAnalitika_9183 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private String ekomuniciranjeEmail;  // 9184 desc
    private String ekomuniciranjeOpomba;  // 9185 desc

    public String getEkomuniciranjeEmail() {
        return ekomuniciranjeEmail;
    }

    public void setEkomuniciranjeEmail(String ekomuniciranjeEmail) {
        this.ekomuniciranjeEmail = ekomuniciranjeEmail;
    }

    public String getEkomuniciranjeOpomba() {
        return ekomuniciranjeOpomba;
    }

    public void setEkomuniciranjeOpomba(String ekomuniciranjeOpomba) {
        this.ekomuniciranjeOpomba = ekomuniciranjeOpomba;
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
            case 9184: return this.getEkomuniciranjeEmail();
            case 9185: return this.getEkomuniciranjeOpomba();
            default: return null;
        }
    }

}