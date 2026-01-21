package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=7793 (TIP VLOGE)
 * Generated - do not edit manually.
 */
public class TipVloge_7793 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer tipVloge;  // 7794 number
    private String tipVlogeOpis;  // 7797 desc
    private String tipVlogeDodatek;  // 13668 desc

    public Integer getTipVloge() {
        return tipVloge;
    }

    public void setTipVloge(Integer tipVloge) {
        this.tipVloge = tipVloge;
    }

    public String getTipVlogeOpis() {
        return tipVlogeOpis;
    }

    public void setTipVlogeOpis(String tipVlogeOpis) {
        this.tipVlogeOpis = tipVlogeOpis;
    }

    public String getTipVlogeDodatek() {
        return tipVlogeDodatek;
    }

    public void setTipVlogeDodatek(String tipVlogeDodatek) {
        this.tipVlogeDodatek = tipVlogeDodatek;
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
            case 7794: return this.getTipVloge();
            case 7797: return this.getTipVlogeOpis();
            case 13668: return this.getTipVlogeDodatek();
            default: return null;
        }
    }

}