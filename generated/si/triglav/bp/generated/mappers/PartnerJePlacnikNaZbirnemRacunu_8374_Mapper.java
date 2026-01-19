package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.PartnerJePlacnikNaZbirnemRacunu;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8374 (Partner je placnik na zbirnem racunu)
 * Generated - do not edit manually.
 */
public class PartnerJePlacnikNaZbirnemRacunu_8374_Mapper implements PropertyMapper<PartnerJePlacnikNaZbirnemRacunu> {

    @Override
    public PartnerJePlacnikNaZbirnemRacunu fromList(List<PCharacteristicVAO> characteristics) {
        PartnerJePlacnikNaZbirnemRacunu result = new PartnerJePlacnikNaZbirnemRacunu();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8375:
                    result.setPartnerJePlacnikNaZbirnemRacunu(pch.getPch_number());
                    break;
                case 8376:
                    result.setElektronskiNaslovZaPrejemZbirnegaRacuna(pch.getPch_desc());
                    break;
                case 8394:
                    result.setValutaZbirnegaRacuna(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(PartnerJePlacnikNaZbirnemRacunu obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getPartnerJePlacnikNaZbirnemRacunu() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8375);
            pch.setPch_number(obj.getPartnerJePlacnikNaZbirnemRacunu());
            result.add(pch);
        }
        if (obj.getElektronskiNaslovZaPrejemZbirnegaRacuna() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8376);
            pch.setPch_desc(obj.getElektronskiNaslovZaPrejemZbirnegaRacuna());
            result.add(pch);
        }
        if (obj.getValutaZbirnegaRacuna() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8394);
            pch.setPch_number(obj.getValutaZbirnegaRacuna());
            result.add(pch);
        }

        return result;
    }

    @Override
    public void updateList(PartnerJePlacnikNaZbirnemRacunu obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 8375, obj.getPartnerJePlacnikNaZbirnemRacunu(), "number");
        updateOrAdd(characteristics, 8376, obj.getElektronskiNaslovZaPrejemZbirnegaRacuna(), "desc");
        updateOrAdd(characteristics, 8394, obj.getValutaZbirnegaRacuna(), "number");
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
    public Class<PartnerJePlacnikNaZbirnemRacunu> getPropertyClass() {
        return PartnerJePlacnikNaZbirnemRacunu.class;
    }
}