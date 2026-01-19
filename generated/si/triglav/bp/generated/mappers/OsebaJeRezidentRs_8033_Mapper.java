package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.OsebaJeRezidentRs;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8033 (Oseba je rezident RS)
 * Generated - do not edit manually.
 */
public class OsebaJeRezidentRs_8033_Mapper implements PropertyMapper<OsebaJeRezidentRs> {

    @Override
    public OsebaJeRezidentRs fromList(List<PCharacteristicVAO> characteristics) {
        OsebaJeRezidentRs result = new OsebaJeRezidentRs();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8034:
                    result.setOsebaJeRezidentRs(pch.getPch_number());
                    break;
                case 8046:
                    result.setDrzavaRezidenstva(pch.getPch_number());
                    break;
                case 8047:
                    result.setIzpolnjenVprasalnikZaTujePoliticnoIzpostavljeneOsebe(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(OsebaJeRezidentRs obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getOsebaJeRezidentRs() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8034);
            pch.setPch_number(obj.getOsebaJeRezidentRs());
            result.add(pch);
        }
        if (obj.getDrzavaRezidenstva() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8046);
            pch.setPch_number(obj.getDrzavaRezidenstva());
            result.add(pch);
        }
        if (obj.getIzpolnjenVprasalnikZaTujePoliticnoIzpostavljeneOsebe() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8047);
            pch.setPch_number(obj.getIzpolnjenVprasalnikZaTujePoliticnoIzpostavljeneOsebe());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<OsebaJeRezidentRs> getPropertyClass() {
        return OsebaJeRezidentRs.class;
    }
}