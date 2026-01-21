package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=8371 (Opravljen poglobljen pregled)
 * Generated - do not edit manually.
 */
public class OpravljenPoglobljenPregled_8371 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer opravljenPoglobljenPregled;  // 8372 number

    public Integer getOpravljenPoglobljenPregled() {
        return opravljenPoglobljenPregled;
    }

    public void setOpravljenPoglobljenPregled(Integer opravljenPoglobljenPregled) {
        this.opravljenPoglobljenPregled = opravljenPoglobljenPregled;
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
            case 8372: return this.getOpravljenPoglobljenPregled();
            default: return null;
        }
    }

}