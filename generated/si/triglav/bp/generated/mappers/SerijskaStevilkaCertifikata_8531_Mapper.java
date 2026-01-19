package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.SerijskaStevilkaCertifikata;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8531 (Serijska številka certifikata)
 * Generated - do not edit manually.
 */
public class SerijskaStevilkaCertifikata_8531_Mapper implements PropertyMapper<SerijskaStevilkaCertifikata> {

    @Override
    public SerijskaStevilkaCertifikata fromList(List<PCharacteristicVAO> characteristics) {
        SerijskaStevilkaCertifikata result = new SerijskaStevilkaCertifikata();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8532:
                    result.setSerijskaStevilkaCertifikata(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(SerijskaStevilkaCertifikata obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getSerijskaStevilkaCertifikata() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8532);
            pch.setPch_desc(obj.getSerijskaStevilkaCertifikata());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<SerijskaStevilkaCertifikata> getPropertyClass() {
        return SerijskaStevilkaCertifikata.class;
    }
}