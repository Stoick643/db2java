package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.TveganostStrankeTpdTransakcijeInStanje;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=12732 (Tveganost stranke TPD - TRANSAKCIJE in STANJE)
 * Generated - do not edit manually.
 */
public class TveganostStrankeTpdTransakcijeInStanje_12732_Mapper implements PropertyMapper<TveganostStrankeTpdTransakcijeInStanje> {

    @Override
    public TveganostStrankeTpdTransakcijeInStanje fromList(List<PCharacteristicVAO> characteristics) {
        TveganostStrankeTpdTransakcijeInStanje result = new TveganostStrankeTpdTransakcijeInStanje();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 12733:
                    result.setTveganostStrankeTpdTransakcijeInStanje(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(TveganostStrankeTpdTransakcijeInStanje obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getTveganostStrankeTpdTransakcijeInStanje() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12733);
            pch.setPch_number(obj.getTveganostStrankeTpdTransakcijeInStanje());
            result.add(pch);
        }

        return result;
    }

    @Override
    public void updateList(TveganostStrankeTpdTransakcijeInStanje obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 12733, obj.getTveganostStrankeTpdTransakcijeInStanje(), "number");
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
    public Class<TveganostStrankeTpdTransakcijeInStanje> getPropertyClass() {
        return TveganostStrankeTpdTransakcijeInStanje.class;
    }
}