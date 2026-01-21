package si.triglav.common.propchar.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.common.propchar.properties.DovoljenjeZaObdelavoInUporaboOsPodatkovTrzenje;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8540 (Dovoljenje za obdelavo in uporabo os. podatkov - trženje)
 * Generated - do not edit manually.
 */
public class DovoljenjeZaObdelavoInUporaboOsPodatkovTrzenje_8540_Mapper implements PropertyMapper<DovoljenjeZaObdelavoInUporaboOsPodatkovTrzenje> {

    @Override
    public DovoljenjeZaObdelavoInUporaboOsPodatkovTrzenje fromList(List<PCharacteristicVAO> characteristics) {
        DovoljenjeZaObdelavoInUporaboOsPodatkovTrzenje result = new DovoljenjeZaObdelavoInUporaboOsPodatkovTrzenje();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8541:
                    result.setDovoljenjeZaObdelavoInUporaboOsPodatkovTrzenje(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(DovoljenjeZaObdelavoInUporaboOsPodatkovTrzenje obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getDovoljenjeZaObdelavoInUporaboOsPodatkovTrzenje() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8541);
            pch.setPch_number(obj.getDovoljenjeZaObdelavoInUporaboOsPodatkovTrzenje());
            result.add(pch);
        }

        return result;
    }

    @Override
    public void updateList(DovoljenjeZaObdelavoInUporaboOsPodatkovTrzenje obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 8541, obj.getDovoljenjeZaObdelavoInUporaboOsPodatkovTrzenje(), "number");
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
    public Class<DovoljenjeZaObdelavoInUporaboOsPodatkovTrzenje> getPropertyClass() {
        return DovoljenjeZaObdelavoInUporaboOsPodatkovTrzenje.class;
    }
}