package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.Opomba;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=7785 (Opomba)
 * Generated - do not edit manually.
 */
public class Opomba_7785_Mapper implements PropertyMapper<Opomba> {

    @Override
    public Opomba fromList(List<PCharacteristicVAO> characteristics) {
        Opomba result = new Opomba();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 7832:
                    result.setOpisOpombe(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(Opomba obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getOpisOpombe() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7832);
            pch.setPch_desc(obj.getOpisOpombe());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<Opomba> getPropertyClass() {
        return Opomba.class;
    }
}