package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.Swift;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=7798 (Swift)
 * Generated - do not edit manually.
 */
public class Swift_7798_Mapper implements PropertyMapper<Swift> {

    @Override
    public Swift fromList(List<PCharacteristicVAO> characteristics) {
        Swift result = new Swift();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 7799:
                    result.setSwiftKoda(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(Swift obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getSwiftKoda() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7799);
            pch.setPch_desc(obj.getSwiftKoda());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<Swift> getPropertyClass() {
        return Swift.class;
    }
}