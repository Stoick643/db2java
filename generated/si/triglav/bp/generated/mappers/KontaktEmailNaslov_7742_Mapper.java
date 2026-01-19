package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.KontaktEmailNaslov;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=7742 (Kontakt - email naslov)
 * Generated - do not edit manually.
 */
public class KontaktEmailNaslov_7742_Mapper implements PropertyMapper<KontaktEmailNaslov> {

    @Override
    public KontaktEmailNaslov fromList(List<PCharacteristicVAO> characteristics) {
        KontaktEmailNaslov result = new KontaktEmailNaslov();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 7803:
                    result.setEmailNaslov(pch.getPch_desc());
                    break;
                case 7840:
                    result.setZaporednaStevilkaLastnosti(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(KontaktEmailNaslov obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getEmailNaslov() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7803);
            pch.setPch_desc(obj.getEmailNaslov());
            result.add(pch);
        }
        if (obj.getZaporednaStevilkaLastnosti() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7840);
            pch.setPch_number(obj.getZaporednaStevilkaLastnosti());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<KontaktEmailNaslov> getPropertyClass() {
        return KontaktEmailNaslov.class;
    }
}