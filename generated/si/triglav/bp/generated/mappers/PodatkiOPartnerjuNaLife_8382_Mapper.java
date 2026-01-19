package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.PodatkiOPartnerjuNaLife;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8382 (Podatki o partnerju na LIFE)
 * Generated - do not edit manually.
 */
public class PodatkiOPartnerjuNaLife_8382_Mapper implements PropertyMapper<PodatkiOPartnerjuNaLife> {

    @Override
    public PodatkiOPartnerjuNaLife fromList(List<PCharacteristicVAO> characteristics) {
        PodatkiOPartnerjuNaLife result = new PodatkiOPartnerjuNaLife();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8383:
                    result.setPartnerImaSklenjenoVeljavnoOsebnoZavarovanje(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(PodatkiOPartnerjuNaLife obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getPartnerImaSklenjenoVeljavnoOsebnoZavarovanje() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8383);
            pch.setPch_number(obj.getPartnerImaSklenjenoVeljavnoOsebnoZavarovanje());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<PodatkiOPartnerjuNaLife> getPropertyClass() {
        return PodatkiOPartnerjuNaLife.class;
    }
}