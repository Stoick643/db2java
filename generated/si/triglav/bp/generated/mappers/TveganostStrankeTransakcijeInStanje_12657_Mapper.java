package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.TveganostStrankeTransakcijeInStanje;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=12657 (Tveganost stranke - TRANSAKCIJE in STANJE)
 * Generated - do not edit manually.
 */
public class TveganostStrankeTransakcijeInStanje_12657_Mapper implements PropertyMapper<TveganostStrankeTransakcijeInStanje> {

    @Override
    public TveganostStrankeTransakcijeInStanje fromList(List<PCharacteristicVAO> characteristics) {
        TveganostStrankeTransakcijeInStanje result = new TveganostStrankeTransakcijeInStanje();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 12658:
                    result.setTveganostStrankeTransakcijeInStanje(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(TveganostStrankeTransakcijeInStanje obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getTveganostStrankeTransakcijeInStanje() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12658);
            pch.setPch_number(obj.getTveganostStrankeTransakcijeInStanje());
            result.add(pch);
        }

        return result;
    }

    @Override
    public void updateList(TveganostStrankeTransakcijeInStanje obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 12658, obj.getTveganostStrankeTransakcijeInStanje(), "number");
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
    public Class<TveganostStrankeTransakcijeInStanje> getPropertyClass() {
        return TveganostStrankeTransakcijeInStanje.class;
    }
}