package si.triglav.bp.generated.properties;

import si.triglav.bp.properties.BaseProperties;
import si.triglav.common.SimpleDate;

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

}