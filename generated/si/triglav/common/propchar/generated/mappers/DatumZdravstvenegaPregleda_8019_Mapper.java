package si.triglav.common.propchar.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.common.propchar.properties.DatumZdravstvenegaPregleda;
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
    public void updateList(DatumZdravstvenegaPregleda obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 8029, obj.getDatumPredvidenegaPregleda(), "date");
        updateOrAdd(characteristics, 8030, obj.getDatumOpravljenegaPregleda(), "date");
        updateOrAdd(characteristics, 8038, obj.getPeriodaPregleda(), "number");
        updateOrAdd(characteristics, 8044, obj.getDatumVabilaNaPregled(), "date");
        updateOrAdd(characteristics, 8045, obj.getDatumOpomina(), "date");
    }

    private PCharacteristicVAO findByTpCharacter(List<PCharacteristicVAO> list, int tpChar) {
        for (PCharacteristicVAO pch : list) {
            if (pch.getTp_character() != null && pch.getTp_character() == tpChar) {
                return pch;
            }
        }
        return null;
    }

    private void updateOrAdd(List<PCharacteristicVAO> list, int tpChar, Object value, String type) {
        if (value == null) return;
        PCharacteristicVAO existing = findByTpCharacter(list, tpChar);
        if (existing != null) {
            setValue(existing, value, type);
        } else {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setTp_character(tpChar);
            setValue(pch, value, type);
            list.add(pch);
        }
    }

    private void setValue(PCharacteristicVAO pch, Object value, String type) {
        switch (type) {
            case "desc": pch.setPch_desc((String) value); break;
            case "number": pch.setPch_number((Integer) value); break;
            case "date": pch.setPch_date((SimpleDate) value); break;
            case "value": pch.setPch_value((BigDecimal) value); break;
        }
    }

    @Override
    public Class<DatumZdravstvenegaPregleda> getPropertyClass() {
        return DatumZdravstvenegaPregleda.class;
    }
}