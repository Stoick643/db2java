package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.UstanoviteljPodjetja;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=7790 (Ustanovitelj podjetja)
 * Generated - do not edit manually.
 */
public class UstanoviteljPodjetja_7790_Mapper implements PropertyMapper<UstanoviteljPodjetja> {

    @Override
    public UstanoviteljPodjetja fromList(List<PCharacteristicVAO> characteristics) {
        UstanoviteljPodjetja result = new UstanoviteljPodjetja();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 7842:
                    result.setImeOsebe(pch.getPch_desc());
                    break;
                case 7843:
                    result.setPriimekOsebe(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(UstanoviteljPodjetja obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getImeOsebe() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7842);
            pch.setPch_desc(obj.getImeOsebe());
            result.add(pch);
        }
        if (obj.getPriimekOsebe() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7843);
            pch.setPch_desc(obj.getPriimekOsebe());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<UstanoviteljPodjetja> getPropertyClass() {
        return UstanoviteljPodjetja.class;
    }
}