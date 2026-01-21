package si.triglav.common.propchar.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.common.propchar.properties.Tppropertydefsubjectstatus;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=13329 (TP_PROPERTY_DEF_SUBJECT_STATUS)
 * Generated - do not edit manually.
 */
public class Tppropertydefsubjectstatus_13329_Mapper implements PropertyMapper<Tppropertydefsubjectstatus> {

    @Override
    public Tppropertydefsubjectstatus fromList(List<PCharacteristicVAO> characteristics) {
        Tppropertydefsubjectstatus result = new Tppropertydefsubjectstatus();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 13330:
                    result.setTpchardefsubjstatorigcountry(pch.getPch_number());
                    break;
                case 13339:
                    result.setTpchardefsubjstatnofininstanfs11(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(Tppropertydefsubjectstatus obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getTpchardefsubjstatorigcountry() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(13330);
            pch.setPch_number(obj.getTpchardefsubjstatorigcountry());
            result.add(pch);
        }
        if (obj.getTpchardefsubjstatnofininstanfs11() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(13339);
            pch.setPch_desc(obj.getTpchardefsubjstatnofininstanfs11());
            result.add(pch);
        }

        return result;
    }

    @Override
    public void updateList(Tppropertydefsubjectstatus obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 13330, obj.getTpchardefsubjstatorigcountry(), "number");
        updateOrAdd(characteristics, 13339, obj.getTpchardefsubjstatnofininstanfs11(), "desc");
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
    public Class<Tppropertydefsubjectstatus> getPropertyClass() {
        return Tppropertydefsubjectstatus.class;
    }
}