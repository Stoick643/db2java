package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=7767 (lastnost vracilo fakture)
 * Generated - do not edit manually.
 */
public class LastnostVraciloFakture_7767 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer vrednostLastnostiVracilaFakture_number;  // 7768 number
    private String vrednostLastnostiVracilaFakture_desc;  // 7768 desc

    public Integer getVrednostLastnostiVracilaFakture_number() {
        return vrednostLastnostiVracilaFakture_number;
    }

    public void setVrednostLastnostiVracilaFakture_number(Integer vrednostLastnostiVracilaFakture_number) {
        this.vrednostLastnostiVracilaFakture_number = vrednostLastnostiVracilaFakture_number;
    }

    public String getVrednostLastnostiVracilaFakture_desc() {
        return vrednostLastnostiVracilaFakture_desc;
    }

    public void setVrednostLastnostiVracilaFakture_desc(String vrednostLastnostiVracilaFakture_desc) {
        this.vrednostLastnostiVracilaFakture_desc = vrednostLastnostiVracilaFakture_desc;
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
            case 7768: return this.getVrednostLastnostiVracilaFakture_number();
            default: return null;
        }
    }

}