package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.TveganostStrankeNacinTransakcije;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=12659 (Tveganost stranke - NACIN TRANSAKCIJE)
 * Generated - do not edit manually.
 */
public class TveganostStrankeNacinTransakcije_12659_Mapper implements PropertyMapper<TveganostStrankeNacinTransakcije> {

    @Override
    public TveganostStrankeNacinTransakcije fromList(List<PCharacteristicVAO> characteristics) {
        TveganostStrankeNacinTransakcije result = new TveganostStrankeNacinTransakcije();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 12660:
                    result.setTveganostStrankeNacinTransakcije(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(TveganostStrankeNacinTransakcije obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getTveganostStrankeNacinTransakcije() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12660);
            pch.setPch_number(obj.getTveganostStrankeNacinTransakcije());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<TveganostStrankeNacinTransakcije> getPropertyClass() {
        return TveganostStrankeNacinTransakcije.class;
    }
}