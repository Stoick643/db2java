package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=9182 (Kontakt  kontaktni center list)
 * Generated - do not edit manually.
 */
public class KontaktKontaktniCenterList_9182 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private String kontaktniCenterTelefon;  // 9181 desc

    public String getKontaktniCenterTelefon() {
        return kontaktniCenterTelefon;
    }

    public void setKontaktniCenterTelefon(String kontaktniCenterTelefon) {
        this.kontaktniCenterTelefon = kontaktniCenterTelefon;
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
            case 9181: return this.getKontaktniCenterTelefon();
            default: return null;
        }
    }

}