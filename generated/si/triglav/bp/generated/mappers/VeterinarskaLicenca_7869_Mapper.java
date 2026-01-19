package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.VeterinarskaLicenca;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=7869 (Veterinarska licenca)
 * Generated - do not edit manually.
 */
public class VeterinarskaLicenca_7869_Mapper implements PropertyMapper<VeterinarskaLicenca> {

    @Override
    public VeterinarskaLicenca fromList(List<PCharacteristicVAO> characteristics) {
        VeterinarskaLicenca result = new VeterinarskaLicenca();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 7870:
                    result.setVeterinarskaLicenca(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(VeterinarskaLicenca obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getVeterinarskaLicenca() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7870);
            pch.setPch_desc(obj.getVeterinarskaLicenca());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<VeterinarskaLicenca> getPropertyClass() {
        return VeterinarskaLicenca.class;
    }
}