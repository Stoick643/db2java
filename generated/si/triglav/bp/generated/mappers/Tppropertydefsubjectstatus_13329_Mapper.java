package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.Tppropertydefsubjectstatus;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=13329 (TP_PROPERTY_DEF_SUBJECT_STATUS)
 * Generated - do not edit manually.
 */
public class Tppropertydefsubjectstatus_13329_Mapper implements PropertyMapper<Tppropertydefsubjectstatus> {

    @Override
    public Tppropertydefsubjectstatus fromList(List<PCharacteristicVAO> characteristics) {
        Tppropertydefsubjectstatus result = new Tppropertydefsubjectstatus();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 13330:
                    result.setTpchardefsubjstatorigcountry(pch.getPch_number());
                    break;
                case 13339:
                    result.setTpchardefsubjstatnofininstanfs11(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(Tppropertydefsubjectstatus obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getTpchardefsubjstatorigcountry() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(13330);
            pch.setPch_number(obj.getTpchardefsubjstatorigcountry());
            result.add(pch);
        }
        if (obj.getTpchardefsubjstatnofininstanfs11() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(13339);
            pch.setPch_desc(obj.getTpchardefsubjstatnofininstanfs11());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<Tppropertydefsubjectstatus> getPropertyClass() {
        return Tppropertydefsubjectstatus.class;
    }
}