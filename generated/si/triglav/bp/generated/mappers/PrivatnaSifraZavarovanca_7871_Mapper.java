package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.PrivatnaSifraZavarovanca;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=7871 (Privatna šifra zavarovanca)
 * Generated - do not edit manually.
 */
public class PrivatnaSifraZavarovanca_7871_Mapper implements PropertyMapper<PrivatnaSifraZavarovanca> {

    @Override
    public PrivatnaSifraZavarovanca fromList(List<PCharacteristicVAO> characteristics) {
        PrivatnaSifraZavarovanca result = new PrivatnaSifraZavarovanca();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 7872:
                    result.setPrivatnaSifraZavarovanca(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(PrivatnaSifraZavarovanca obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getPrivatnaSifraZavarovanca() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7872);
            pch.setPch_desc(obj.getPrivatnaSifraZavarovanca());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<PrivatnaSifraZavarovanca> getPropertyClass() {
        return PrivatnaSifraZavarovanca.class;
    }
}