package si.triglav.common.propchar.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.common.propchar.properties.TipVloge;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=7793 (TIP VLOGE)
 * Generated - do not edit manually.
 */
public class TipVloge_7793_Mapper implements PropertyMapper<TipVloge> {

    @Override
    public TipVloge fromList(List<PCharacteristicVAO> characteristics) {
        TipVloge result = new TipVloge();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 7794:
                    result.setTipVloge(pch.getPch_number());
                    break;
                case 7797:
                    result.setTipVlogeOpis(pch.getPch_desc());
                    break;
                case 13668:
                    result.setTipVlogeDodatek(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(TipVloge obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getTipVloge() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7794);
            pch.setPch_number(obj.getTipVloge());
            result.add(pch);
        }
        if (obj.getTipVlogeOpis() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7797);
            pch.setPch_desc(obj.getTipVlogeOpis());
            result.add(pch);
        }
        if (obj.getTipVlogeDodatek() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(13668);
            pch.setPch_desc(obj.getTipVlogeDodatek());
            result.add(pch);
        }

        return result;
    }

    @Override
    public void updateList(TipVloge obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 7794, obj.getTipVloge(), "number");
        updateOrAdd(characteristics, 7797, obj.getTipVlogeOpis(), "desc");
        updateOrAdd(characteristics, 13668, obj.getTipVlogeDodatek(), "desc");
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
    public Class<TipVloge> getPropertyClass() {
        return TipVloge.class;
    }
}