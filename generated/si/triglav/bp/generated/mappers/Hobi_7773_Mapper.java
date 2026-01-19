package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.Hobi;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=7773 (Hobi)
 * Generated - do not edit manually.
 */
public class Hobi_7773_Mapper implements PropertyMapper<Hobi> {

    @Override
    public Hobi fromList(List<PCharacteristicVAO> characteristics) {
        Hobi result = new Hobi();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 7822:
                    result.setTipHobija(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(Hobi obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getTipHobija() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7822);
            pch.setPch_number(obj.getTipHobija());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<Hobi> getPropertyClass() {
        return Hobi.class;
    }
}