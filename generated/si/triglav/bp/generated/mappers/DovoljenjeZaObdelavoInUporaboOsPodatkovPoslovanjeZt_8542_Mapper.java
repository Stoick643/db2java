package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.DovoljenjeZaObdelavoInUporaboOsPodatkovPoslovanjeZt;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8542 (Dovoljenje za obdelavo in uporabo os. podatkov - poslovanje ZT)
 * Generated - do not edit manually.
 */
public class DovoljenjeZaObdelavoInUporaboOsPodatkovPoslovanjeZt_8542_Mapper implements PropertyMapper<DovoljenjeZaObdelavoInUporaboOsPodatkovPoslovanjeZt> {

    @Override
    public DovoljenjeZaObdelavoInUporaboOsPodatkovPoslovanjeZt fromList(List<PCharacteristicVAO> characteristics) {
        DovoljenjeZaObdelavoInUporaboOsPodatkovPoslovanjeZt result = new DovoljenjeZaObdelavoInUporaboOsPodatkovPoslovanjeZt();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8543:
                    result.setDovoljenjeZaObdelavoInUporaboOsPodatkovPoslovanjeZt(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(DovoljenjeZaObdelavoInUporaboOsPodatkovPoslovanjeZt obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getDovoljenjeZaObdelavoInUporaboOsPodatkovPoslovanjeZt() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8543);
            pch.setPch_number(obj.getDovoljenjeZaObdelavoInUporaboOsPodatkovPoslovanjeZt());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<DovoljenjeZaObdelavoInUporaboOsPodatkovPoslovanjeZt> getPropertyClass() {
        return DovoljenjeZaObdelavoInUporaboOsPodatkovPoslovanjeZt.class;
    }
}