package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.DovoljenjeZaObdelavoInUporaboOsPodatkovTrzenje;
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
    public Class<DovoljenjeZaObdelavoInUporaboOsPodatkovTrzenje> getPropertyClass() {
        return DovoljenjeZaObdelavoInUporaboOsPodatkovTrzenje.class;
    }
}