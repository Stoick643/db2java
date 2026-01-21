package si.triglav.common.propchar.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.common.propchar.properties.VeterinarskaLicenca;
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
    public void updateList(VeterinarskaLicenca obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 7870, obj.getVeterinarskaLicenca(), "desc");
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
    public Class<VeterinarskaLicenca> getPropertyClass() {
        return VeterinarskaLicenca.class;
    }
}