package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=8550 (Tip naknadnega zbiranja DŠ)
 * Generated - do not edit manually.
 */
public class TipNaknadnegaZbiranjaDs_8550 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer tipNaknadnegaZbiranjaDs_number;  // 8551 number
    private String tipNaknadnegaZbiranjaDs_desc;  // 8551 desc

    public Integer getTipNaknadnegaZbiranjaDs_number() {
        return tipNaknadnegaZbiranjaDs_number;
    }

    public void setTipNaknadnegaZbiranjaDs_number(Integer tipNaknadnegaZbiranjaDs_number) {
        this.tipNaknadnegaZbiranjaDs_number = tipNaknadnegaZbiranjaDs_number;
    }

    public String getTipNaknadnegaZbiranjaDs_desc() {
        return tipNaknadnegaZbiranjaDs_desc;
    }

    public void setTipNaknadnegaZbiranjaDs_desc(String tipNaknadnegaZbiranjaDs_desc) {
        this.tipNaknadnegaZbiranjaDs_desc = tipNaknadnegaZbiranjaDs_desc;
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
            case 8551: return this.getTipNaknadnegaZbiranjaDs_number();
            default: return null;
        }
    }

}