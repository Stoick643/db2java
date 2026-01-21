package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=7871 (Privatna šifra zavarovanca)
 * Generated - do not edit manually.
 */
public class PrivatnaSifraZavarovanca_7871 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private String privatnaSifraZavarovanca;  // 7872 desc

    public String getPrivatnaSifraZavarovanca() {
        return privatnaSifraZavarovanca;
    }

    public void setPrivatnaSifraZavarovanca(String privatnaSifraZavarovanca) {
        this.privatnaSifraZavarovanca = privatnaSifraZavarovanca;
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
            case 7872: return this.getPrivatnaSifraZavarovanca();
            default: return null;
        }
    }

}