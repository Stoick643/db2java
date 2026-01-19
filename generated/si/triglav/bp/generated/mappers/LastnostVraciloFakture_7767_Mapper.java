package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.LastnostVraciloFakture;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=7767 (lastnost vracilo fakture)
 * Generated - do not edit manually.
 */
public class LastnostVraciloFakture_7767_Mapper implements PropertyMapper<LastnostVraciloFakture> {

    @Override
    public LastnostVraciloFakture fromList(List<PCharacteristicVAO> characteristics) {
        LastnostVraciloFakture result = new LastnostVraciloFakture();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 7768:
                    result.setVrednostLastnostiVracilaFakture_number(pch.getPch_number());
                    result.setVrednostLastnostiVracilaFakture_desc(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(LastnostVraciloFakture obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getVrednostLastnostiVracilaFakture_number() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7768);
            pch.setPch_number(obj.getVrednostLastnostiVracilaFakture_number());
            result.add(pch);
        }
        if (obj.getVrednostLastnostiVracilaFakture_desc() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7768);
            pch.setPch_desc(obj.getVrednostLastnostiVracilaFakture_desc());
            result.add(pch);
        }

        return result;
    }

    @Override
    public void updateList(LastnostVraciloFakture obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 7768, obj.getVrednostLastnostiVracilaFakture_number(), "number");
        updateOrAdd(characteristics, 7768, obj.getVrednostLastnostiVracilaFakture_desc(), "desc");
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
    public Class<LastnostVraciloFakture> getPropertyClass() {
        return LastnostVraciloFakture.class;
    }
}