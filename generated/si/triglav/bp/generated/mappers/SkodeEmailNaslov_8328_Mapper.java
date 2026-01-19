package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.SkodeEmailNaslov;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8328 (Škode - email naslov)
 * Generated - do not edit manually.
 */
public class SkodeEmailNaslov_8328_Mapper implements PropertyMapper<SkodeEmailNaslov> {

    @Override
    public SkodeEmailNaslov fromList(List<PCharacteristicVAO> characteristics) {
        SkodeEmailNaslov result = new SkodeEmailNaslov();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8329:
                    result.setSkodeEmailNaslov(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(SkodeEmailNaslov obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getSkodeEmailNaslov() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8329);
            pch.setPch_desc(obj.getSkodeEmailNaslov());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<SkodeEmailNaslov> getPropertyClass() {
        return SkodeEmailNaslov.class;
    }
}