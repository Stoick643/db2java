package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=8540 (Dovoljenje za obdelavo in uporabo os. podatkov - trženje)
 * Generated - do not edit manually.
 */
public class DovoljenjeZaObdelavoInUporaboOsPodatkovTrzenje_8540 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer dovoljenjeZaObdelavoInUporaboOsPodatkovTrzenje;  // 8541 number

    public Integer getDovoljenjeZaObdelavoInUporaboOsPodatkovTrzenje() {
        return dovoljenjeZaObdelavoInUporaboOsPodatkovTrzenje;
    }

    public void setDovoljenjeZaObdelavoInUporaboOsPodatkovTrzenje(Integer dovoljenjeZaObdelavoInUporaboOsPodatkovTrzenje) {
        this.dovoljenjeZaObdelavoInUporaboOsPodatkovTrzenje = dovoljenjeZaObdelavoInUporaboOsPodatkovTrzenje;
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
            case 8541: return this.getDovoljenjeZaObdelavoInUporaboOsPodatkovTrzenje();
            default: return null;
        }
    }

}