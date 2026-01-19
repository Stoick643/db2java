package si.triglav.bp.generated.properties;

import si.triglav.bp.properties.BaseProperties;
import si.triglav.common.SimpleDate;

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

}