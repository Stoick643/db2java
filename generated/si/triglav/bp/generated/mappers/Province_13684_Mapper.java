package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.Province;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=13684 (Province)
 * Generated - do not edit manually.
 */
public class Province_13684_Mapper implements PropertyMapper<Province> {

    @Override
    public Province fromList(List<PCharacteristicVAO> characteristics) {
        Province result = new Province();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 13685:
                    result.setProvince(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(Province obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getProvince() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(13685);
            pch.setPch_number(obj.getProvince());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<Province> getPropertyClass() {
        return Province.class;
    }
}