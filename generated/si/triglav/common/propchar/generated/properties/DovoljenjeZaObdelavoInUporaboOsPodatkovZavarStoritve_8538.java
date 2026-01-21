package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=8538 (Dovoljenje za obdelavo in uporabo os. podatkov - zavar. storitve)
 * Generated - do not edit manually.
 */
public class DovoljenjeZaObdelavoInUporaboOsPodatkovZavarStoritve_8538 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer dovoljenjeZaObdelavoInUporaboOsPodatkovZavarStoritve;  // 8539 number

    public Integer getDovoljenjeZaObdelavoInUporaboOsPodatkovZavarStoritve() {
        return dovoljenjeZaObdelavoInUporaboOsPodatkovZavarStoritve;
    }

    public void setDovoljenjeZaObdelavoInUporaboOsPodatkovZavarStoritve(Integer dovoljenjeZaObdelavoInUporaboOsPodatkovZavarStoritve) {
        this.dovoljenjeZaObdelavoInUporaboOsPodatkovZavarStoritve = dovoljenjeZaObdelavoInUporaboOsPodatkovZavarStoritve;
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
            case 8539: return this.getDovoljenjeZaObdelavoInUporaboOsPodatkovZavarStoritve();
            default: return null;
        }
    }

}