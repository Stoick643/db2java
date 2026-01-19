package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.ZaposlitevStatusFatca;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=9188 (Zaposlitev - status FATCA)
 * Generated - do not edit manually.
 */
public class ZaposlitevStatusFatca_9188_Mapper implements PropertyMapper<ZaposlitevStatusFatca> {

    @Override
    public ZaposlitevStatusFatca fromList(List<PCharacteristicVAO> characteristics) {
        ZaposlitevStatusFatca result = new ZaposlitevStatusFatca();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 9189:
                    result.setStatusZaposlitveFatca(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(ZaposlitevStatusFatca obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getStatusZaposlitveFatca() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(9189);
            pch.setPch_number(obj.getStatusZaposlitveFatca());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<ZaposlitevStatusFatca> getPropertyClass() {
        return ZaposlitevStatusFatca.class;
    }
}