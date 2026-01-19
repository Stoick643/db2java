package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.VzrokNastankaTveganostiLife;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8962 (Vzrok nastanka tveganosti - LIFE)
 * Generated - do not edit manually.
 */
public class VzrokNastankaTveganostiLife_8962_Mapper implements PropertyMapper<VzrokNastankaTveganostiLife> {

    @Override
    public VzrokNastankaTveganostiLife fromList(List<PCharacteristicVAO> characteristics) {
        VzrokNastankaTveganostiLife result = new VzrokNastankaTveganostiLife();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8961:
                    result.setVzrokNastankaTveganostiLife(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(VzrokNastankaTveganostiLife obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getVzrokNastankaTveganostiLife() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8961);
            pch.setPch_number(obj.getVzrokNastankaTveganostiLife());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<VzrokNastankaTveganostiLife> getPropertyClass() {
        return VzrokNastankaTveganostiLife.class;
    }
}