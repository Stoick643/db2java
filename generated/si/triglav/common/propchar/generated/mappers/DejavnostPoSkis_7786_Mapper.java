package si.triglav.common.propchar.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.common.propchar.properties.DejavnostPoSkis;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=7786 (Dejavnost po SKIS)
 * Generated - do not edit manually.
 */
public class DejavnostPoSkis_7786_Mapper implements PropertyMapper<DejavnostPoSkis> {

    @Override
    public DejavnostPoSkis fromList(List<PCharacteristicVAO> characteristics) {
        DejavnostPoSkis result = new DejavnostPoSkis();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 7846:
                    result.setDejavnostPoSkisKarakteristika(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(DejavnostPoSkis obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getDejavnostPoSkisKarakteristika() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7846);
            pch.setPch_desc(obj.getDejavnostPoSkisKarakteristika());
            result.add(pch);
        }

        return result;
    }

    @Override
    public void updateList(DejavnostPoSkis obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 7846, obj.getDejavnostPoSkisKarakteristika(), "desc");
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
    public Class<DejavnostPoSkis> getPropertyClass() {
        return DejavnostPoSkis.class;
    }
}