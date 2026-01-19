package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.TveganostStrankeDrzavaIzplacila;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=14292 (Tveganost stranke - Država izplacila)
 * Generated - do not edit manually.
 */
public class TveganostStrankeDrzavaIzplacila_14292_Mapper implements PropertyMapper<TveganostStrankeDrzavaIzplacila> {

    @Override
    public TveganostStrankeDrzavaIzplacila fromList(List<PCharacteristicVAO> characteristics) {
        TveganostStrankeDrzavaIzplacila result = new TveganostStrankeDrzavaIzplacila();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 14293:
                    result.setTveganostStrankeDrzavaIzplacila(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(TveganostStrankeDrzavaIzplacila obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getTveganostStrankeDrzavaIzplacila() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(14293);
            pch.setPch_number(obj.getTveganostStrankeDrzavaIzplacila());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<TveganostStrankeDrzavaIzplacila> getPropertyClass() {
        return TveganostStrankeDrzavaIzplacila.class;
    }
}