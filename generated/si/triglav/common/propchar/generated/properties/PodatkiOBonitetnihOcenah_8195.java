package si.triglav.common.propchar.generated.properties;

import si.triglav.common.SimpleDate;
import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=8195 (Podatki o bonitetnih ocenah)
 * Generated - do not edit manually.
 */
public class PodatkiOBonitetnihOcenah_8195 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private String bonitetnaOcenanesifrirana;  // 8193 desc
    private SimpleDate datumBonitetneOcene;  // 8194 date
    private Integer bonitetnaAgencija;  // 8196 number

    public String getBonitetnaOcenanesifrirana() {
        return bonitetnaOcenanesifrirana;
    }

    public void setBonitetnaOcenanesifrirana(String bonitetnaOcenanesifrirana) {
        this.bonitetnaOcenanesifrirana = bonitetnaOcenanesifrirana;
    }

    public SimpleDate getDatumBonitetneOcene() {
        return datumBonitetneOcene;
    }

    public void setDatumBonitetneOcene(SimpleDate datumBonitetneOcene) {
        this.datumBonitetneOcene = datumBonitetneOcene;
    }

    public Integer getBonitetnaAgencija() {
        return bonitetnaAgencija;
    }

    public void setBonitetnaAgencija(Integer bonitetnaAgencija) {
        this.bonitetnaAgencija = bonitetnaAgencija;
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
            case 8193: return this.getBonitetnaOcenanesifrirana();
            case 8194: return this.getDatumBonitetneOcene();
            case 8196: return this.getBonitetnaAgencija();
            default: return null;
        }
    }

}