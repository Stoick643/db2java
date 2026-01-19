package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.LastnostVraciloFakture;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=7767 (lastnost vracilo fakture)
 * Generated - do not edit manually.
 */
public class LastnostVraciloFakture_7767_Mapper implements PropertyMapper<LastnostVraciloFakture> {

    @Override
    public LastnostVraciloFakture fromList(List<PCharacteristicVAO> characteristics) {
        LastnostVraciloFakture result = new LastnostVraciloFakture();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 7768:
                    result.setVrednostLastnostiVracilaFakture_number(pch.getPch_number());
                    result.setVrednostLastnostiVracilaFakture_desc(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(LastnostVraciloFakture obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getVrednostLastnostiVracilaFakture_number() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7768);
            pch.setPch_number(obj.getVrednostLastnostiVracilaFakture_number());
            result.add(pch);
        }
        if (obj.getVrednostLastnostiVracilaFakture_desc() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7768);
            pch.setPch_desc(obj.getVrednostLastnostiVracilaFakture_desc());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<LastnostVraciloFakture> getPropertyClass() {
        return LastnostVraciloFakture.class;
    }
}