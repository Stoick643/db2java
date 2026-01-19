package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.KontaktKontaktniCenter;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=9180 (Kontakt - kontaktni center)
 * Generated - do not edit manually.
 */
public class KontaktKontaktniCenter_9180_Mapper implements PropertyMapper<KontaktKontaktniCenter> {

    @Override
    public KontaktKontaktniCenter fromList(List<PCharacteristicVAO> characteristics) {
        KontaktKontaktniCenter result = new KontaktKontaktniCenter();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 9119:
                    result.setKontaktniCenter(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(KontaktKontaktniCenter obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getKontaktniCenter() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(9119);
            pch.setPch_number(obj.getKontaktniCenter());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<KontaktKontaktniCenter> getPropertyClass() {
        return KontaktKontaktniCenter.class;
    }
}