package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.AmeriskaZveznaDrzava;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=9244 (Ameriška zvezna država)
 * Generated - do not edit manually.
 */
public class AmeriskaZveznaDrzava_9244_Mapper implements PropertyMapper<AmeriskaZveznaDrzava> {

    @Override
    public AmeriskaZveznaDrzava fromList(List<PCharacteristicVAO> characteristics) {
        AmeriskaZveznaDrzava result = new AmeriskaZveznaDrzava();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 9245:
                    result.setAmeriskaZveznaDrzava(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(AmeriskaZveznaDrzava obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getAmeriskaZveznaDrzava() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(9245);
            pch.setPch_number(obj.getAmeriskaZveznaDrzava());
            result.add(pch);
        }

        return result;
    }

    @Override
    public void updateList(AmeriskaZveznaDrzava obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 9245, obj.getAmeriskaZveznaDrzava(), "number");
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
    public Class<AmeriskaZveznaDrzava> getPropertyClass() {
        return AmeriskaZveznaDrzava.class;
    }
}