package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=13329 (TP_PROPERTY_DEF_SUBJECT_STATUS)
 * Generated - do not edit manually.
 */
public class Tppropertydefsubjectstatus_13329 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer tpchardefsubjstatorigcountry;  // 13330 number
    private String tpchardefsubjstatnofininstanfs11;  // 13339 desc

    public Integer getTpchardefsubjstatorigcountry() {
        return tpchardefsubjstatorigcountry;
    }

    public void setTpchardefsubjstatorigcountry(Integer tpchardefsubjstatorigcountry) {
        this.tpchardefsubjstatorigcountry = tpchardefsubjstatorigcountry;
    }

    public String getTpchardefsubjstatnofininstanfs11() {
        return tpchardefsubjstatnofininstanfs11;
    }

    public void setTpchardefsubjstatnofininstanfs11(String tpchardefsubjstatnofininstanfs11) {
        this.tpchardefsubjstatnofininstanfs11 = tpchardefsubjstatnofininstanfs11;
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
            case 13330: return this.getTpchardefsubjstatorigcountry();
            case 13339: return this.getTpchardefsubjstatnofininstanfs11();
            default: return null;
        }
    }

}