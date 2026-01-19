package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.ZaposlitevDelovnoMesto;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=7746 (Zaposlitev - delovno mesto)
 * Generated - do not edit manually.
 */
public class ZaposlitevDelovnoMesto_7746_Mapper implements PropertyMapper<ZaposlitevDelovnoMesto> {

    @Override
    public ZaposlitevDelovnoMesto fromList(List<PCharacteristicVAO> characteristics) {
        ZaposlitevDelovnoMesto result = new ZaposlitevDelovnoMesto();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 7810:
                    result.setDelovnoMesto(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(ZaposlitevDelovnoMesto obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getDelovnoMesto() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7810);
            pch.setPch_desc(obj.getDelovnoMesto());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<ZaposlitevDelovnoMesto> getPropertyClass() {
        return ZaposlitevDelovnoMesto.class;
    }
}