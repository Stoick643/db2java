package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=7774 (Kontakt - kontaktna oseba)
 * Generated - do not edit manually.
 */
public class KontaktKontaktnaOseba_7774 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private String kontaktnaOseba;  // 7824 desc

    public String getKontaktnaOseba() {
        return kontaktnaOseba;
    }

    public void setKontaktnaOseba(String kontaktnaOseba) {
        this.kontaktnaOseba = kontaktnaOseba;
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
            case 7824: return this.getKontaktnaOseba();
            default: return null;
        }
    }

}