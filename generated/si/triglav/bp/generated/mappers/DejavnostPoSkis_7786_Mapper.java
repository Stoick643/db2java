package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.DejavnostPoSkis;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=7786 (Dejavnost po SKIS)
 * Generated - do not edit manually.
 */
public class DejavnostPoSkis_7786_Mapper implements PropertyMapper<DejavnostPoSkis> {

    @Override
    public DejavnostPoSkis fromList(List<PCharacteristicVAO> characteristics) {
        DejavnostPoSkis result = new DejavnostPoSkis();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 7846:
                    result.setDejavnostPoSkisKarakteristika(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(DejavnostPoSkis obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getDejavnostPoSkisKarakteristika() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7846);
            pch.setPch_desc(obj.getDejavnostPoSkisKarakteristika());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<DejavnostPoSkis> getPropertyClass() {
        return DejavnostPoSkis.class;
    }
}