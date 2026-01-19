package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.IdentifikacijskaStevilkaZaDdv;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=7867 (Identifikacijska številka za DDV)
 * Generated - do not edit manually.
 */
public class IdentifikacijskaStevilkaZaDdv_7867_Mapper implements PropertyMapper<IdentifikacijskaStevilkaZaDdv> {

    @Override
    public IdentifikacijskaStevilkaZaDdv fromList(List<PCharacteristicVAO> characteristics) {
        IdentifikacijskaStevilkaZaDdv result = new IdentifikacijskaStevilkaZaDdv();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 7868:
                    result.setIdentifikacijskaStevilkaZaDdv(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(IdentifikacijskaStevilkaZaDdv obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getIdentifikacijskaStevilkaZaDdv() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7868);
            pch.setPch_desc(obj.getIdentifikacijskaStevilkaZaDdv());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<IdentifikacijskaStevilkaZaDdv> getPropertyClass() {
        return IdentifikacijskaStevilkaZaDdv.class;
    }
}