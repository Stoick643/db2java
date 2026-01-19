package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.MaticnaStevilkaLn;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=7875 (Maticna številka - LN)
 * Generated - do not edit manually.
 */
public class MaticnaStevilkaLn_7875_Mapper implements PropertyMapper<MaticnaStevilkaLn> {

    @Override
    public MaticnaStevilkaLn fromList(List<PCharacteristicVAO> characteristics) {
        MaticnaStevilkaLn result = new MaticnaStevilkaLn();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 7876:
                    result.setMaticnaStevilkaLn(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(MaticnaStevilkaLn obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getMaticnaStevilkaLn() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7876);
            pch.setPch_desc(obj.getMaticnaStevilkaLn());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<MaticnaStevilkaLn> getPropertyClass() {
        return MaticnaStevilkaLn.class;
    }
}