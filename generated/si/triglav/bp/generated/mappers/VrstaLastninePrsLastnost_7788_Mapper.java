package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.VrstaLastninePrsLastnost;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=7788 (Vrsta lastnine (PRS) - Lastnost)
 * Generated - do not edit manually.
 */
public class VrstaLastninePrsLastnost_7788_Mapper implements PropertyMapper<VrstaLastninePrsLastnost> {

    @Override
    public VrstaLastninePrsLastnost fromList(List<PCharacteristicVAO> characteristics) {
        VrstaLastninePrsLastnost result = new VrstaLastninePrsLastnost();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 7839:
                    result.setVrstaLastninePrsKarakteristika(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(VrstaLastninePrsLastnost obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getVrstaLastninePrsKarakteristika() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7839);
            pch.setPch_number(obj.getVrstaLastninePrsKarakteristika());
            result.add(pch);
        }

        return result;
    }

    @Override
    public void updateList(VrstaLastninePrsLastnost obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 7839, obj.getVrstaLastninePrsKarakteristika(), "number");
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
    public Class<VrstaLastninePrsLastnost> getPropertyClass() {
        return VrstaLastninePrsLastnost.class;
    }
}