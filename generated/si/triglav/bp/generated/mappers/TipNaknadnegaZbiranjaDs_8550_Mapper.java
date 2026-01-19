package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.TipNaknadnegaZbiranjaDs;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8550 (Tip naknadnega zbiranja DŠ)
 * Generated - do not edit manually.
 */
public class TipNaknadnegaZbiranjaDs_8550_Mapper implements PropertyMapper<TipNaknadnegaZbiranjaDs> {

    @Override
    public TipNaknadnegaZbiranjaDs fromList(List<PCharacteristicVAO> characteristics) {
        TipNaknadnegaZbiranjaDs result = new TipNaknadnegaZbiranjaDs();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8551:
                    result.setTipNaknadnegaZbiranjaDs_number(pch.getPch_number());
                    result.setTipNaknadnegaZbiranjaDs_desc(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(TipNaknadnegaZbiranjaDs obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getTipNaknadnegaZbiranjaDs_number() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8551);
            pch.setPch_number(obj.getTipNaknadnegaZbiranjaDs_number());
            result.add(pch);
        }
        if (obj.getTipNaknadnegaZbiranjaDs_desc() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8551);
            pch.setPch_desc(obj.getTipNaknadnegaZbiranjaDs_desc());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<TipNaknadnegaZbiranjaDs> getPropertyClass() {
        return TipNaknadnegaZbiranjaDs.class;
    }
}