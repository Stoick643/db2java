package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=8542 (Dovoljenje za obdelavo in uporabo os. podatkov - poslovanje ZT)
 * Generated - do not edit manually.
 */
public class DovoljenjeZaObdelavoInUporaboOsPodatkovPoslovanjeZt_8542 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer dovoljenjeZaObdelavoInUporaboOsPodatkovPoslovanjeZt;  // 8543 number

    public Integer getDovoljenjeZaObdelavoInUporaboOsPodatkovPoslovanjeZt() {
        return dovoljenjeZaObdelavoInUporaboOsPodatkovPoslovanjeZt;
    }

    public void setDovoljenjeZaObdelavoInUporaboOsPodatkovPoslovanjeZt(Integer dovoljenjeZaObdelavoInUporaboOsPodatkovPoslovanjeZt) {
        this.dovoljenjeZaObdelavoInUporaboOsPodatkovPoslovanjeZt = dovoljenjeZaObdelavoInUporaboOsPodatkovPoslovanjeZt;
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
            case 8543: return this.getDovoljenjeZaObdelavoInUporaboOsPodatkovPoslovanjeZt();
            default: return null;
        }
    }

}