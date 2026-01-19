package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.NeprofitnaOrganizacija;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=13672 (Neprofitna organizacija)
 * Generated - do not edit manually.
 */
public class NeprofitnaOrganizacija_13672_Mapper implements PropertyMapper<NeprofitnaOrganizacija> {

    @Override
    public NeprofitnaOrganizacija fromList(List<PCharacteristicVAO> characteristics) {
        NeprofitnaOrganizacija result = new NeprofitnaOrganizacija();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 13673:
                    result.setNeprofitnaOrganizacija(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(NeprofitnaOrganizacija obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getNeprofitnaOrganizacija() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(13673);
            pch.setPch_number(obj.getNeprofitnaOrganizacija());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<NeprofitnaOrganizacija> getPropertyClass() {
        return NeprofitnaOrganizacija.class;
    }
}