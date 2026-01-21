package si.triglav.common.propchar.generated.properties;

import si.triglav.common.SimpleDate;
import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=8019 (Datum zdravstvenega pregleda)
 * Generated - do not edit manually.
 */
public class DatumZdravstvenegaPregleda_8019 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private SimpleDate datumPredvidenegaPregleda;  // 8029 date
    private SimpleDate datumOpravljenegaPregleda;  // 8030 date
    private Integer periodaPregleda;  // 8038 number
    private SimpleDate datumVabilaNaPregled;  // 8044 date
    private SimpleDate datumOpomina;  // 8045 date

    public SimpleDate getDatumPredvidenegaPregleda() {
        return datumPredvidenegaPregleda;
    }

    public void setDatumPredvidenegaPregleda(SimpleDate datumPredvidenegaPregleda) {
        this.datumPredvidenegaPregleda = datumPredvidenegaPregleda;
    }

    public SimpleDate getDatumOpravljenegaPregleda() {
        return datumOpravljenegaPregleda;
    }

    public void setDatumOpravljenegaPregleda(SimpleDate datumOpravljenegaPregleda) {
        this.datumOpravljenegaPregleda = datumOpravljenegaPregleda;
    }

    public Integer getPeriodaPregleda() {
        return periodaPregleda;
    }

    public void setPeriodaPregleda(Integer periodaPregleda) {
        this.periodaPregleda = periodaPregleda;
    }

    public SimpleDate getDatumVabilaNaPregled() {
        return datumVabilaNaPregled;
    }

    public void setDatumVabilaNaPregled(SimpleDate datumVabilaNaPregled) {
        this.datumVabilaNaPregled = datumVabilaNaPregled;
    }

    public SimpleDate getDatumOpomina() {
        return datumOpomina;
    }

    public void setDatumOpomina(SimpleDate datumOpomina) {
        this.datumOpomina = datumOpomina;
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
            case 8029: return this.getDatumPredvidenegaPregleda();
            case 8030: return this.getDatumOpravljenegaPregleda();
            case 8038: return this.getPeriodaPregleda();
            case 8044: return this.getDatumVabilaNaPregled();
            case 8045: return this.getDatumOpomina();
            default: return null;
        }
    }

}