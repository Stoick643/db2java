package si.triglav.common.propchar.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.common.propchar.properties.OsebaJeTujaPoliticnoIzpostavljenaOseba;
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
    public void updateList(OsebaJeTujaPoliticnoIzpostavljenaOseba obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 8036, obj.getOsebaJeTujaPoliticnoIzpostavljenaOseba(), "number");
    }

    private PCharacteristicVAO findByTpCharacter(List<PCharacteristicVAO> list, int tpChar) {
        for (PCharacteristicVAO pch : list) {
            if (pch.getTp_character() != null && pch.getTp_character() == tpChar) {
                return pch;
            }
        }
        return null;
    }

    private void updateOrAdd(List<PCharacteristicVAO> list, int tpChar, Object value, String type) {
        if (value == null) return;
        PCharacteristicVAO existing = findByTpCharacter(list, tpChar);
        if (existing != null) {
            setValue(existing, value, type);
        } else {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setTp_character(tpChar);
            setValue(pch, value, type);
            list.add(pch);
        }
    }

    private void setValue(PCharacteristicVAO pch, Object value, String type) {
        switch (type) {
            case "desc": pch.setPch_desc((String) value); break;
            case "number": pch.setPch_number((Integer) value); break;
            case "date": pch.setPch_date((SimpleDate) value); break;
            case "value": pch.setPch_value((BigDecimal) value); break;
        }
    }

    @Override
    public Class<OsebaJeTujaPoliticnoIzpostavljenaOseba> getPropertyClass() {
        return OsebaJeTujaPoliticnoIzpostavljenaOseba.class;
    }
}