package si.triglav.common.propchar.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.common.propchar.properties.ZppdftZaupno;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=12649 (ZPPDFT zaupno)
 * Generated - do not edit manually.
 */
public class ZppdftZaupno_12649_Mapper implements PropertyMapper<ZppdftZaupno> {

    @Override
    public ZppdftZaupno fromList(List<PCharacteristicVAO> characteristics) {
        ZppdftZaupno result = new ZppdftZaupno();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 12650:
                    result.setZppdftZaupnoVnos(pch.getPch_number());
                    break;
                case 12651:
                    result.setZppdftZaupnoOpis(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(ZppdftZaupno obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getZppdftZaupnoVnos() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12650);
            pch.setPch_number(obj.getZppdftZaupnoVnos());
            result.add(pch);
        }
        if (obj.getZppdftZaupnoOpis() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12651);
            pch.setPch_desc(obj.getZppdftZaupnoOpis());
            result.add(pch);
        }

        return result;
    }

    @Override
    public void updateList(ZppdftZaupno obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 12650, obj.getZppdftZaupnoVnos(), "number");
        updateOrAdd(characteristics, 12651, obj.getZppdftZaupnoOpis(), "desc");
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
    public Class<ZppdftZaupno> getPropertyClass() {
        return ZppdftZaupno.class;
    }
}