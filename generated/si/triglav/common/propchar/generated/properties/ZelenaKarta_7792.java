package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=7792 (Zelena karta)
 * Generated - do not edit manually.
 */
public class ZelenaKarta_7792 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private String kodaZeleneKarte;  // 7845 desc

    public String getKodaZeleneKarte() {
        return kodaZeleneKarte;
    }

    public void setKodaZeleneKarte(String kodaZeleneKarte) {
        this.kodaZeleneKarte = kodaZeleneKarte;
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
            case 7845: return this.getKodaZeleneKarte();
            default: return null;
        }
    }

}