package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.KontaktSpletniNaslov;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=7743 (Kontakt - spletni naslov)
 * Generated - do not edit manually.
 */
public class KontaktSpletniNaslov_7743_Mapper implements PropertyMapper<KontaktSpletniNaslov> {

    @Override
    public KontaktSpletniNaslov fromList(List<PCharacteristicVAO> characteristics) {
        KontaktSpletniNaslov result = new KontaktSpletniNaslov();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 7804:
                    result.setSpletniNaslov(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(KontaktSpletniNaslov obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getSpletniNaslov() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7804);
            pch.setPch_desc(obj.getSpletniNaslov());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<KontaktSpletniNaslov> getPropertyClass() {
        return KontaktSpletniNaslov.class;
    }
}