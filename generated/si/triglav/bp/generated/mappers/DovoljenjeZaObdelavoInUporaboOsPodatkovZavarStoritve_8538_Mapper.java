package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.DovoljenjeZaObdelavoInUporaboOsPodatkovZavarStoritve;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8538 (Dovoljenje za obdelavo in uporabo os. podatkov - zavar. storitve)
 * Generated - do not edit manually.
 */
public class DovoljenjeZaObdelavoInUporaboOsPodatkovZavarStoritve_8538_Mapper implements PropertyMapper<DovoljenjeZaObdelavoInUporaboOsPodatkovZavarStoritve> {

    @Override
    public DovoljenjeZaObdelavoInUporaboOsPodatkovZavarStoritve fromList(List<PCharacteristicVAO> characteristics) {
        DovoljenjeZaObdelavoInUporaboOsPodatkovZavarStoritve result = new DovoljenjeZaObdelavoInUporaboOsPodatkovZavarStoritve();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8539:
                    result.setDovoljenjeZaObdelavoInUporaboOsPodatkovZavarStoritve(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(DovoljenjeZaObdelavoInUporaboOsPodatkovZavarStoritve obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getDovoljenjeZaObdelavoInUporaboOsPodatkovZavarStoritve() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8539);
            pch.setPch_number(obj.getDovoljenjeZaObdelavoInUporaboOsPodatkovZavarStoritve());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<DovoljenjeZaObdelavoInUporaboOsPodatkovZavarStoritve> getPropertyClass() {
        return DovoljenjeZaObdelavoInUporaboOsPodatkovZavarStoritve.class;
    }
}