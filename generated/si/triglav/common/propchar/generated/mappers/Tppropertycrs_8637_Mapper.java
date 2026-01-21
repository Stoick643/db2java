package si.triglav.common.propchar.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.common.propchar.properties.Tppropertycrs;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8637 (TP_PROPERTY_CRS)
 * Generated - do not edit manually.
 */
public class Tppropertycrs_8637_Mapper implements PropertyMapper<Tppropertycrs> {

    @Override
    public Tppropertycrs fromList(List<PCharacteristicVAO> characteristics) {
        Tppropertycrs result = new Tppropertycrs();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8636:
                    result.setTpcharcrsyesno(pch.getPch_number());
                    break;
                case 12665:
                    result.setTpcharcrsnotesentdate(pch.getPch_date());
                    break;
                case 12666:
                    result.setTpcharcrsreceivedconfirmationdate(pch.getPch_date());
                    break;
                case 12667:
                    result.setTpcharcrsvalidbegindate(pch.getPch_date());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(Tppropertycrs obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getTpcharcrsyesno() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8636);
            pch.setPch_number(obj.getTpcharcrsyesno());
            result.add(pch);
        }
        if (obj.getTpcharcrsnotesentdate() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12665);
            pch.setPch_date(obj.getTpcharcrsnotesentdate());
            result.add(pch);
        }
        if (obj.getTpcharcrsreceivedconfirmationdate() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12666);
            pch.setPch_date(obj.getTpcharcrsreceivedconfirmationdate());
            result.add(pch);
        }
        if (obj.getTpcharcrsvalidbegindate() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12667);
            pch.setPch_date(obj.getTpcharcrsvalidbegindate());
            result.add(pch);
        }

        return result;
    }

    @Override
    public void updateList(Tppropertycrs obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 8636, obj.getTpcharcrsyesno(), "number");
        updateOrAdd(characteristics, 12665, obj.getTpcharcrsnotesentdate(), "date");
        updateOrAdd(characteristics, 12666, obj.getTpcharcrsreceivedconfirmationdate(), "date");
        updateOrAdd(characteristics, 12667, obj.getTpcharcrsvalidbegindate(), "date");
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
    public Class<Tppropertycrs> getPropertyClass() {
        return Tppropertycrs.class;
    }
}