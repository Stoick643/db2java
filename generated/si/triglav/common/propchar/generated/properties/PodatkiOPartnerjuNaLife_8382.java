package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=8382 (Podatki o partnerju na LIFE)
 * Generated - do not edit manually.
 */
public class PodatkiOPartnerjuNaLife_8382 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer partnerImaSklenjenoVeljavnoOsebnoZavarovanje;  // 8383 number

    public Integer getPartnerImaSklenjenoVeljavnoOsebnoZavarovanje() {
        return partnerImaSklenjenoVeljavnoOsebnoZavarovanje;
    }

    public void setPartnerImaSklenjenoVeljavnoOsebnoZavarovanje(Integer partnerImaSklenjenoVeljavnoOsebnoZavarovanje) {
        this.partnerImaSklenjenoVeljavnoOsebnoZavarovanje = partnerImaSklenjenoVeljavnoOsebnoZavarovanje;
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
            case 8383: return this.getPartnerImaSklenjenoVeljavnoOsebnoZavarovanje();
            default: return null;
        }
    }

}