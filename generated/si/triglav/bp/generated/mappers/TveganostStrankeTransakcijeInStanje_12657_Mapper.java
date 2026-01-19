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
    public Class<TveganostStrankeTransakcijeInStanje> getPropertyClass() {
        return TveganostStrankeTransakcijeInStanje.class;
    }
}