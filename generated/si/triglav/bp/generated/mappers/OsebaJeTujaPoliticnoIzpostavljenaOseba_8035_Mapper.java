package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.OsebaJeTujaPoliticnoIzpostavljenaOseba;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8035 (Oseba je tuja politicno izpostavljena oseba)
 * Generated - do not edit manually.
 */
public class OsebaJeTujaPoliticnoIzpostavljenaOseba_8035_Mapper implements PropertyMapper<OsebaJeTujaPoliticnoIzpostavljenaOseba> {

    @Override
    public OsebaJeTujaPoliticnoIzpostavljenaOseba fromList(List<PCharacteristicVAO> characteristics) {
        OsebaJeTujaPoliticnoIzpostavljenaOseba result = new OsebaJeTujaPoliticnoIzpostavljenaOseba();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8036:
                    result.setOsebaJeTujaPoliticnoIzpostavljenaOseba(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(OsebaJeTujaPoliticnoIzpostavljenaOseba obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getOsebaJeTujaPoliticnoIzpostavljenaOseba() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8036);
            pch.setPch_number(obj.getOsebaJeTujaPoliticnoIzpostavljenaOseba());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<OsebaJeTujaPoliticnoIzpostavljenaOseba> getPropertyClass() {
        return OsebaJeTujaPoliticnoIzpostavljenaOseba.class;
    }
}