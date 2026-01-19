package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.ZaposlitevStatus;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=7745 (Zaposlitev - status)
 * Generated - do not edit manually.
 */
public class ZaposlitevStatus_7745_Mapper implements PropertyMapper<ZaposlitevStatus> {

    @Override
    public ZaposlitevStatus fromList(List<PCharacteristicVAO> characteristics) {
        ZaposlitevStatus result = new ZaposlitevStatus();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 7809:
                    result.setStatusZaposlitve(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(ZaposlitevStatus obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getStatusZaposlitve() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7809);
            pch.setPch_number(obj.getStatusZaposlitve());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<ZaposlitevStatus> getPropertyClass() {
        return ZaposlitevStatus.class;
    }
}