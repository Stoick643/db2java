package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.DatumZdravstvenegaPregleda;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8019 (Datum zdravstvenega pregleda)
 * Generated - do not edit manually.
 */
public class DatumZdravstvenegaPregleda_8019_Mapper implements PropertyMapper<DatumZdravstvenegaPregleda> {

    @Override
    public DatumZdravstvenegaPregleda fromList(List<PCharacteristicVAO> characteristics) {
        DatumZdravstvenegaPregleda result = new DatumZdravstvenegaPregleda();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8029:
                    result.setDatumPredvidenegaPregleda(pch.getPch_date());
                    break;
                case 8030:
                    result.setDatumOpravljenegaPregleda(pch.getPch_date());
                    break;
                case 8038:
                    result.setPeriodaPregleda(pch.getPch_number());
                    break;
                case 8044:
                    result.setDatumVabilaNaPregled(pch.getPch_date());
                    break;
                case 8045:
                    result.setDatumOpomina(pch.getPch_date());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(DatumZdravstvenegaPregleda obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getDatumPredvidenegaPregleda() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8029);
            pch.setPch_date(obj.getDatumPredvidenegaPregleda());
            result.add(pch);
        }
        if (obj.getDatumOpravljenegaPregleda() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8030);
            pch.setPch_date(obj.getDatumOpravljenegaPregleda());
            result.add(pch);
        }
        if (obj.getPeriodaPregleda() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8038);
            pch.setPch_number(obj.getPeriodaPregleda());
            result.add(pch);
        }
        if (obj.getDatumVabilaNaPregled() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8044);
            pch.setPch_date(obj.getDatumVabilaNaPregled());
            result.add(pch);
        }
        if (obj.getDatumOpomina() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8045);
            pch.setPch_date(obj.getDatumOpomina());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<DatumZdravstvenegaPregleda> getPropertyClass() {
        return DatumZdravstvenegaPregleda.class;
    }
}