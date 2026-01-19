package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.Tppropertytpdpartnerdata;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=13345 (TP_PROPERTY_TPD_PARTNER_DATA)
 * Generated - do not edit manually.
 */
public class Tppropertytpdpartnerdata_13345_Mapper implements PropertyMapper<Tppropertytpdpartnerdata> {

    @Override
    public Tppropertytpdpartnerdata fromList(List<PCharacteristicVAO> characteristics) {
        Tppropertytpdpartnerdata result = new Tppropertytpdpartnerdata();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 13346:
                    result.setTpcharpartnervalidtpdinsurance(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(Tppropertytpdpartnerdata obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getTpcharpartnervalidtpdinsurance() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(13346);
            pch.setPch_number(obj.getTpcharpartnervalidtpdinsurance());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<Tppropertytpdpartnerdata> getPropertyClass() {
        return Tppropertytpdpartnerdata.class;
    }
}