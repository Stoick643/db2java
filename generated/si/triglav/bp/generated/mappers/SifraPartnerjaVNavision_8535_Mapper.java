package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.SifraPartnerjaVNavision;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8535 (Šifra partnerja v Navision)
 * Generated - do not edit manually.
 */
public class SifraPartnerjaVNavision_8535_Mapper implements PropertyMapper<SifraPartnerjaVNavision> {

    @Override
    public SifraPartnerjaVNavision fromList(List<PCharacteristicVAO> characteristics) {
        SifraPartnerjaVNavision result = new SifraPartnerjaVNavision();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8536:
                    result.setSifraPartnerjaVNavision(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(SifraPartnerjaVNavision obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getSifraPartnerjaVNavision() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8536);
            pch.setPch_desc(obj.getSifraPartnerjaVNavision());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<SifraPartnerjaVNavision> getPropertyClass() {
        return SifraPartnerjaVNavision.class;
    }
}