package si.triglav.common.propchar.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.common.propchar.properties.UstanoviteljPodjetja;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=7790 (Ustanovitelj podjetja)
 * Generated - do not edit manually.
 */
public class UstanoviteljPodjetja_7790_Mapper implements PropertyMapper<UstanoviteljPodjetja> {

    @Override
    public UstanoviteljPodjetja fromList(List<PCharacteristicVAO> characteristics) {
        UstanoviteljPodjetja result = new UstanoviteljPodjetja();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 7842:
                    result.setImeOsebe(pch.getPch_desc());
                    break;
                case 7843:
                    result.setPriimekOsebe(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(UstanoviteljPodjetja obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getImeOsebe() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7842);
            pch.setPch_desc(obj.getImeOsebe());
            result.add(pch);
        }
        if (obj.getPriimekOsebe() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7843);
            pch.setPch_desc(obj.getPriimekOsebe());
            result.add(pch);
        }

        return result;
    }

    @Override
    public void updateList(UstanoviteljPodjetja obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 7842, obj.getImeOsebe(), "desc");
        updateOrAdd(characteristics, 7843, obj.getPriimekOsebe(), "desc");
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
    public Class<UstanoviteljPodjetja> getPropertyClass() {
        return UstanoviteljPodjetja.class;
    }
}