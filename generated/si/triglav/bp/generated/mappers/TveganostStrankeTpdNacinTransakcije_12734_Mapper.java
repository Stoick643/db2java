package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.TveganostStrankeTpdNacinTransakcije;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=12734 (Tveganost stranke TPD - NACIN TRANSAKCIJE)
 * Generated - do not edit manually.
 */
public class TveganostStrankeTpdNacinTransakcije_12734_Mapper implements PropertyMapper<TveganostStrankeTpdNacinTransakcije> {

    @Override
    public TveganostStrankeTpdNacinTransakcije fromList(List<PCharacteristicVAO> characteristics) {
        TveganostStrankeTpdNacinTransakcije result = new TveganostStrankeTpdNacinTransakcije();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 12735:
                    result.setTveganostStrankeTpdNacinTransakcije(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(TveganostStrankeTpdNacinTransakcije obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getTveganostStrankeTpdNacinTransakcije() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12735);
            pch.setPch_number(obj.getTveganostStrankeTpdNacinTransakcije());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<TveganostStrankeTpdNacinTransakcije> getPropertyClass() {
        return TveganostStrankeTpdNacinTransakcije.class;
    }
}