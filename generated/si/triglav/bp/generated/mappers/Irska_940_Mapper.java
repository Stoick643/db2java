package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.Irska;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=940 (IRSKA)
 * Generated - do not edit manually.
 */
public class Irska_940_Mapper implements PropertyMapper<Irska> {

    @Override
    public Irska fromList(List<PCharacteristicVAO> characteristics) {
        Irska result = new Irska();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 9013:
                    result.setSigningIdentifier(pch.getPch_desc());
                    break;
                case 9017:
                    result.setPhone(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(Irska obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getSigningIdentifier() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(9013);
            pch.setPch_desc(obj.getSigningIdentifier());
            result.add(pch);
        }
        if (obj.getPhone() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(9017);
            pch.setPch_desc(obj.getPhone());
            result.add(pch);
        }

        return result;
    }

    @Override
    public void updateList(Irska obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 9013, obj.getSigningIdentifier(), "desc");
        updateOrAdd(characteristics, 9017, obj.getPhone(), "desc");
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
    public Class<Irska> getPropertyClass() {
        return Irska.class;
    }
}