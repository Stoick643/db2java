package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=13669 (Mednarodna identifikacijska koda)
 * Generated - do not edit manually.
 */
public class MednarodnaIdentifikacijskaKoda_13669 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private String mednarodnaIdentifikacijskaKoda;  // 13670 desc

    public String getMednarodnaIdentifikacijskaKoda() {
        return mednarodnaIdentifikacijskaKoda;
    }

    public void setMednarodnaIdentifikacijskaKoda(String mednarodnaIdentifikacijskaKoda) {
        this.mednarodnaIdentifikacijskaKoda = mednarodnaIdentifikacijskaKoda;
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
            case 13670: return this.getMednarodnaIdentifikacijskaKoda();
            default: return null;
        }
    }

}