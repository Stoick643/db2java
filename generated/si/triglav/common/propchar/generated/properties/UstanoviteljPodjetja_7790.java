package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=7790 (Ustanovitelj podjetja)
 * Generated - do not edit manually.
 */
public class UstanoviteljPodjetja_7790 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private String imeOsebe;  // 7842 desc
    private String priimekOsebe;  // 7843 desc

    public String getImeOsebe() {
        return imeOsebe;
    }

    public void setImeOsebe(String imeOsebe) {
        this.imeOsebe = imeOsebe;
    }

    public String getPriimekOsebe() {
        return priimekOsebe;
    }

    public void setPriimekOsebe(String priimekOsebe) {
        this.priimekOsebe = priimekOsebe;
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
            case 7842: return this.getImeOsebe();
            case 7843: return this.getPriimekOsebe();
            default: return null;
        }
    }

}