package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.KontaktKontaktniCenterList;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=9182 (Kontakt  kontaktni center list)
 * Generated - do not edit manually.
 */
public class KontaktKontaktniCenterList_9182_Mapper implements PropertyMapper<KontaktKontaktniCenterList> {

    @Override
    public KontaktKontaktniCenterList fromList(List<PCharacteristicVAO> characteristics) {
        KontaktKontaktniCenterList result = new KontaktKontaktniCenterList();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 9181:
                    result.setKontaktniCenterTelefon(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(KontaktKontaktniCenterList obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getKontaktniCenterTelefon() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(9181);
            pch.setPch_desc(obj.getKontaktniCenterTelefon());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<KontaktKontaktniCenterList> getPropertyClass() {
        return KontaktKontaktniCenterList.class;
    }
}