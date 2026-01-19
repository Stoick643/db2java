package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.IdentifikacijskaKodaEuid;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=13682 (Identifikacijska koda EUID)
 * Generated - do not edit manually.
 */
public class IdentifikacijskaKodaEuid_13682_Mapper implements PropertyMapper<IdentifikacijskaKodaEuid> {

    @Override
    public IdentifikacijskaKodaEuid fromList(List<PCharacteristicVAO> characteristics) {
        IdentifikacijskaKodaEuid result = new IdentifikacijskaKodaEuid();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 13683:
                    result.setIdentifikacijskaKodaEuid(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(IdentifikacijskaKodaEuid obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getIdentifikacijskaKodaEuid() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(13683);
            pch.setPch_desc(obj.getIdentifikacijskaKodaEuid());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<IdentifikacijskaKodaEuid> getPropertyClass() {
        return IdentifikacijskaKodaEuid.class;
    }
}