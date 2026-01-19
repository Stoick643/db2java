package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.EkomuniciranjeAnalitika;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=9183 (E-komuniciranje - Analitika)
 * Generated - do not edit manually.
 */
public class EkomuniciranjeAnalitika_9183_Mapper implements PropertyMapper<EkomuniciranjeAnalitika> {

    @Override
    public EkomuniciranjeAnalitika fromList(List<PCharacteristicVAO> characteristics) {
        EkomuniciranjeAnalitika result = new EkomuniciranjeAnalitika();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 9184:
                    result.setEkomuniciranjeEmail(pch.getPch_desc());
                    break;
                case 9185:
                    result.setEkomuniciranjeOpomba(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(EkomuniciranjeAnalitika obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getEkomuniciranjeEmail() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(9184);
            pch.setPch_desc(obj.getEkomuniciranjeEmail());
            result.add(pch);
        }
        if (obj.getEkomuniciranjeOpomba() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(9185);
            pch.setPch_desc(obj.getEkomuniciranjeOpomba());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<EkomuniciranjeAnalitika> getPropertyClass() {
        return EkomuniciranjeAnalitika.class;
    }
}