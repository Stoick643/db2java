package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=8071 (Privatna šifra zavarovanca - transportna zavarovanja)
 * Generated - do not edit manually.
 */
public class PrivatnaSifraZavarovancaTransportnaZavarovanja_8071 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private String privatnaSifraZavarovancaTransportnaZavarovanja;  // 8072 desc

    public String getPrivatnaSifraZavarovancaTransportnaZavarovanja() {
        return privatnaSifraZavarovancaTransportnaZavarovanja;
    }

    public void setPrivatnaSifraZavarovancaTransportnaZavarovanja(String privatnaSifraZavarovancaTransportnaZavarovanja) {
        this.privatnaSifraZavarovancaTransportnaZavarovanja = privatnaSifraZavarovancaTransportnaZavarovanja;
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
            case 8072: return this.getPrivatnaSifraZavarovancaTransportnaZavarovanja();
            default: return null;
        }
    }

}