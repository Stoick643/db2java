package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.PinEzivljenje;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=7874 (Pin - e-življenje)
 * Generated - do not edit manually.
 */
public class PinEzivljenje_7874_Mapper implements PropertyMapper<PinEzivljenje> {

    @Override
    public PinEzivljenje fromList(List<PCharacteristicVAO> characteristics) {
        PinEzivljenje result = new PinEzivljenje();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 7873:
                    result.setPinEzivljenje(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(PinEzivljenje obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getPinEzivljenje() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7873);
            pch.setPch_desc(obj.getPinEzivljenje());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<PinEzivljenje> getPropertyClass() {
        return PinEzivljenje.class;
    }
}