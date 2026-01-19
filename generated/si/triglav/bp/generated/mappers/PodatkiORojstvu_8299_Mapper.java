package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.PodatkiORojstvu;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8299 (Podatki o rojstvu)
 * Generated - do not edit manually.
 */
public class PodatkiORojstvu_8299_Mapper implements PropertyMapper<PodatkiORojstvu> {

    @Override
    public PodatkiORojstvu fromList(List<PCharacteristicVAO> characteristics) {
        PodatkiORojstvu result = new PodatkiORojstvu();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8267:
                    result.setKrajRojstva(pch.getPch_desc());
                    break;
                case 8309:
                    result.setDrzavaRojstva(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(PodatkiORojstvu obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getKrajRojstva() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8267);
            pch.setPch_desc(obj.getKrajRojstva());
            result.add(pch);
        }
        if (obj.getDrzavaRojstva() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8309);
            pch.setPch_number(obj.getDrzavaRojstva());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<PodatkiORojstvu> getPropertyClass() {
        return PodatkiORojstvu.class;
    }
}