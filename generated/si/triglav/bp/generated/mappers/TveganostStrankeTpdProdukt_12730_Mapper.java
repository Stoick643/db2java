package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.TveganostStrankeTpdProdukt;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=12730 (Tveganost stranke TPD - PRODUKT)
 * Generated - do not edit manually.
 */
public class TveganostStrankeTpdProdukt_12730_Mapper implements PropertyMapper<TveganostStrankeTpdProdukt> {

    @Override
    public TveganostStrankeTpdProdukt fromList(List<PCharacteristicVAO> characteristics) {
        TveganostStrankeTpdProdukt result = new TveganostStrankeTpdProdukt();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 12731:
                    result.setTveganostStrankeTpdProdukt(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(TveganostStrankeTpdProdukt obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getTveganostStrankeTpdProdukt() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12731);
            pch.setPch_number(obj.getTveganostStrankeTpdProdukt());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<TveganostStrankeTpdProdukt> getPropertyClass() {
        return TveganostStrankeTpdProdukt.class;
    }
}