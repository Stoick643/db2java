package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.FinancnaInstitucija;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8158 (Financna inštitucija)
 * Generated - do not edit manually.
 */
public class FinancnaInstitucija_8158_Mapper implements PropertyMapper<FinancnaInstitucija> {

    @Override
    public FinancnaInstitucija fromList(List<PCharacteristicVAO> characteristics) {
        FinancnaInstitucija result = new FinancnaInstitucija();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8159:
                    result.setFinancnaInstitucija(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(FinancnaInstitucija obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getFinancnaInstitucija() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8159);
            pch.setPch_number(obj.getFinancnaInstitucija());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<FinancnaInstitucija> getPropertyClass() {
        return FinancnaInstitucija.class;
    }
}