package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=12649 (ZPPDFT zaupno)
 * Generated - do not edit manually.
 */
public class ZppdftZaupno_12649 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer zppdftZaupnoVnos;  // 12650 number
    private String zppdftZaupnoOpis;  // 12651 desc

    public Integer getZppdftZaupnoVnos() {
        return zppdftZaupnoVnos;
    }

    public void setZppdftZaupnoVnos(Integer zppdftZaupnoVnos) {
        this.zppdftZaupnoVnos = zppdftZaupnoVnos;
    }

    public String getZppdftZaupnoOpis() {
        return zppdftZaupnoOpis;
    }

    public void setZppdftZaupnoOpis(String zppdftZaupnoOpis) {
        this.zppdftZaupnoOpis = zppdftZaupnoOpis;
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
            case 12650: return this.getZppdftZaupnoVnos();
            case 12651: return this.getZppdftZaupnoOpis();
            default: return null;
        }
    }

}