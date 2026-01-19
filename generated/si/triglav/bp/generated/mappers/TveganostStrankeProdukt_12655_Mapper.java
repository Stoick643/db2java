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
    public Class<TveganostStrankeProdukt> getPropertyClass() {
        return TveganostStrankeProdukt.class;
    }
}