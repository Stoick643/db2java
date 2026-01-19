package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.Tppropertynationality;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8639 (TP_PROPERTY_NATIONALITY)
 * Generated - do not edit manually.
 */
public class Tppropertynationality_8639_Mapper implements PropertyMapper<Tppropertynationality> {

    @Override
    public Tppropertynationality fromList(List<PCharacteristicVAO> characteristics) {
        Tppropertynationality result = new Tppropertynationality();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8638:
                    result.setTpcharnationality(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(Tppropertynationality obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getTpcharnationality() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8638);
            pch.setPch_number(obj.getTpcharnationality());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<Tppropertynationality> getPropertyClass() {
        return Tppropertynationality.class;
    }
}