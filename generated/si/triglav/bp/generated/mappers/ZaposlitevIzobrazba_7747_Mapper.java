package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.ZaposlitevIzobrazba;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=7747 (Zaposlitev - izobrazba)
 * Generated - do not edit manually.
 */
public class ZaposlitevIzobrazba_7747_Mapper implements PropertyMapper<ZaposlitevIzobrazba> {

    @Override
    public ZaposlitevIzobrazba fromList(List<PCharacteristicVAO> characteristics) {
        ZaposlitevIzobrazba result = new ZaposlitevIzobrazba();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 7811:
                    result.setStopnjaIzobrazbe(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(ZaposlitevIzobrazba obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getStopnjaIzobrazbe() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7811);
            pch.setPch_number(obj.getStopnjaIzobrazbe());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<ZaposlitevIzobrazba> getPropertyClass() {
        return ZaposlitevIzobrazba.class;
    }
}