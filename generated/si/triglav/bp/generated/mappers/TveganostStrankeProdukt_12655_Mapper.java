package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.TveganostStrankeProdukt;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=12655 (Tveganost stranke - PRODUKT)
 * Generated - do not edit manually.
 */
public class TveganostStrankeProdukt_12655_Mapper implements PropertyMapper<TveganostStrankeProdukt> {

    @Override
    public TveganostStrankeProdukt fromList(List<PCharacteristicVAO> characteristics) {
        TveganostStrankeProdukt result = new TveganostStrankeProdukt();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 12656:
                    result.setTveganostStrankeProdukt(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(TveganostStrankeProdukt obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getTveganostStrankeProdukt() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12656);
            pch.setPch_number(obj.getTveganostStrankeProdukt());
            result.add(pch);
        }

        return result;
    }

    @Override
    public void updateList(TveganostStrankeProdukt obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 12656, obj.getTveganostStrankeProdukt(), "number");
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
    public Class<TveganostStrankeProdukt> getPropertyClass() {
        return TveganostStrankeProdukt.class;
    }
}