package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.OpravljenPoglobljenPregled;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8371 (Opravljen poglobljen pregled)
 * Generated - do not edit manually.
 */
public class OpravljenPoglobljenPregled_8371_Mapper implements PropertyMapper<OpravljenPoglobljenPregled> {

    @Override
    public OpravljenPoglobljenPregled fromList(List<PCharacteristicVAO> characteristics) {
        OpravljenPoglobljenPregled result = new OpravljenPoglobljenPregled();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8372:
                    result.setOpravljenPoglobljenPregled(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(OpravljenPoglobljenPregled obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getOpravljenPoglobljenPregled() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8372);
            pch.setPch_number(obj.getOpravljenPoglobljenPregled());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<OpravljenPoglobljenPregled> getPropertyClass() {
        return OpravljenPoglobljenPregled.class;
    }
}