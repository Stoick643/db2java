package si.triglav.common.propchar.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.common.propchar.properties.PartnerJePlacnikNaZbirnemRacunuDneviPosiljanja;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8918 (Partner je placnik na zbirnem racunu - dnevi pošiljanja)
 * Generated - do not edit manually.
 */
public class PartnerJePlacnikNaZbirnemRacunuDneviPosiljanja_8918_Mapper implements PropertyMapper<PartnerJePlacnikNaZbirnemRacunuDneviPosiljanja> {

    @Override
    public PartnerJePlacnikNaZbirnemRacunuDneviPosiljanja fromList(List<PCharacteristicVAO> characteristics) {
        PartnerJePlacnikNaZbirnemRacunuDneviPosiljanja result = new PartnerJePlacnikNaZbirnemRacunuDneviPosiljanja();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8917:
                    result.setDanZaPosiljanjeZbirniRacun(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(PartnerJePlacnikNaZbirnemRacunuDneviPosiljanja obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getDanZaPosiljanjeZbirniRacun() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8917);
            pch.setPch_desc(obj.getDanZaPosiljanjeZbirniRacun());
            result.add(pch);
        }

        return result;
    }

    @Override
    public void updateList(PartnerJePlacnikNaZbirnemRacunuDneviPosiljanja obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 8917, obj.getDanZaPosiljanjeZbirniRacun(), "desc");
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
    public Class<PartnerJePlacnikNaZbirnemRacunuDneviPosiljanja> getPropertyClass() {
        return PartnerJePlacnikNaZbirnemRacunuDneviPosiljanja.class;
    }
}