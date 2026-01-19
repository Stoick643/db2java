package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.VelikostPodjetja;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8520 (Velikost podjetja)
 * Generated - do not edit manually.
 */
public class VelikostPodjetja_8520_Mapper implements PropertyMapper<VelikostPodjetja> {

    @Override
    public VelikostPodjetja fromList(List<PCharacteristicVAO> characteristics) {
        VelikostPodjetja result = new VelikostPodjetja();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8521:
                    result.setVelikostPodjetja(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(VelikostPodjetja obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getVelikostPodjetja() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8521);
            pch.setPch_number(obj.getVelikostPodjetja());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<VelikostPodjetja> getPropertyClass() {
        return VelikostPodjetja.class;
    }
}