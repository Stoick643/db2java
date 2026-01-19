package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.EkomuniciranjeAnalitika;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=9183 (E-komuniciranje - Analitika)
 * Generated - do not edit manually.
 */
public class EkomuniciranjeAnalitika_9183_Mapper implements PropertyMapper<EkomuniciranjeAnalitika> {

    @Override
    public EkomuniciranjeAnalitika fromList(List<PCharacteristicVAO> characteristics) {
        EkomuniciranjeAnalitika result = new EkomuniciranjeAnalitika();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 9184:
                    result.setEkomuniciranjeEmail(pch.getPch_desc());
                    break;
                case 9185:
                    result.setEkomuniciranjeOpomba(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(EkomuniciranjeAnalitika obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getEkomuniciranjeEmail() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(9184);
            pch.setPch_desc(obj.getEkomuniciranjeEmail());
            result.add(pch);
        }
        if (obj.getEkomuniciranjeOpomba() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(9185);
            pch.setPch_desc(obj.getEkomuniciranjeOpomba());
            result.add(pch);
        }

        return result;
    }

    @Override
    public void updateList(EkomuniciranjeAnalitika obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 9184, obj.getEkomuniciranjeEmail(), "desc");
        updateOrAdd(characteristics, 9185, obj.getEkomuniciranjeOpomba(), "desc");
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
    public Class<EkomuniciranjeAnalitika> getPropertyClass() {
        return EkomuniciranjeAnalitika.class;
    }
}