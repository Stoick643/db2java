package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.TveganostStrankeDrzavaIzvoraVplacila;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=14290 (Tveganost stranke - Država izvora vplacila)
 * Generated - do not edit manually.
 */
public class TveganostStrankeDrzavaIzvoraVplacila_14290_Mapper implements PropertyMapper<TveganostStrankeDrzavaIzvoraVplacila> {

    @Override
    public TveganostStrankeDrzavaIzvoraVplacila fromList(List<PCharacteristicVAO> characteristics) {
        TveganostStrankeDrzavaIzvoraVplacila result = new TveganostStrankeDrzavaIzvoraVplacila();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 14291:
                    result.setTveganostStrankeDrzavaIzvoraVplacila(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(TveganostStrankeDrzavaIzvoraVplacila obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getTveganostStrankeDrzavaIzvoraVplacila() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(14291);
            pch.setPch_number(obj.getTveganostStrankeDrzavaIzvoraVplacila());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<TveganostStrankeDrzavaIzvoraVplacila> getPropertyClass() {
        return TveganostStrankeDrzavaIzvoraVplacila.class;
    }
}