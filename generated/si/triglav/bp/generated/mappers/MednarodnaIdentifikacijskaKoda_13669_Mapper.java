package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.MednarodnaIdentifikacijskaKoda;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=13669 (Mednarodna identifikacijska koda)
 * Generated - do not edit manually.
 */
public class MednarodnaIdentifikacijskaKoda_13669_Mapper implements PropertyMapper<MednarodnaIdentifikacijskaKoda> {

    @Override
    public MednarodnaIdentifikacijskaKoda fromList(List<PCharacteristicVAO> characteristics) {
        MednarodnaIdentifikacijskaKoda result = new MednarodnaIdentifikacijskaKoda();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 13670:
                    result.setMednarodnaIdentifikacijskaKoda(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(MednarodnaIdentifikacijskaKoda obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getMednarodnaIdentifikacijskaKoda() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(13670);
            pch.setPch_desc(obj.getMednarodnaIdentifikacijskaKoda());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<MednarodnaIdentifikacijskaKoda> getPropertyClass() {
        return MednarodnaIdentifikacijskaKoda.class;
    }
}