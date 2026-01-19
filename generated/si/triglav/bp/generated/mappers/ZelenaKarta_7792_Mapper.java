package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.ZelenaKarta;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=7792 (Zelena karta)
 * Generated - do not edit manually.
 */
public class ZelenaKarta_7792_Mapper implements PropertyMapper<ZelenaKarta> {

    @Override
    public ZelenaKarta fromList(List<PCharacteristicVAO> characteristics) {
        ZelenaKarta result = new ZelenaKarta();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 7845:
                    result.setKodaZeleneKarte(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(ZelenaKarta obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getKodaZeleneKarte() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7845);
            pch.setPch_desc(obj.getKodaZeleneKarte());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<ZelenaKarta> getPropertyClass() {
        return ZelenaKarta.class;
    }
}