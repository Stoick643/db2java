package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.VrstaLastninePrsLastnost;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=7788 (Vrsta lastnine (PRS) - Lastnost)
 * Generated - do not edit manually.
 */
public class VrstaLastninePrsLastnost_7788_Mapper implements PropertyMapper<VrstaLastninePrsLastnost> {

    @Override
    public VrstaLastninePrsLastnost fromList(List<PCharacteristicVAO> characteristics) {
        VrstaLastninePrsLastnost result = new VrstaLastninePrsLastnost();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 7839:
                    result.setVrstaLastninePrsKarakteristika(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(VrstaLastninePrsLastnost obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getVrstaLastninePrsKarakteristika() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7839);
            pch.setPch_number(obj.getVrstaLastninePrsKarakteristika());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<VrstaLastninePrsLastnost> getPropertyClass() {
        return VrstaLastninePrsLastnost.class;
    }
}