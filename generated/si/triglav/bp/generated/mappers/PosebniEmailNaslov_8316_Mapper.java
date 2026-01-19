package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.PosebniEmailNaslov;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8316 (Posebni email naslov)
 * Generated - do not edit manually.
 */
public class PosebniEmailNaslov_8316_Mapper implements PropertyMapper<PosebniEmailNaslov> {

    @Override
    public PosebniEmailNaslov fromList(List<PCharacteristicVAO> characteristics) {
        PosebniEmailNaslov result = new PosebniEmailNaslov();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 7840:
                    result.setZaporednaStevilkaLastnosti(pch.getPch_number());
                    break;
                case 8317:
                    result.setTipPosebnegaEmailNaslova(pch.getPch_number());
                    break;
                case 8318:
                    result.setEmailNaslov(pch.getPch_desc());
                    break;
                case 8575:
                    result.setTpcharspecialemailverified(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(PosebniEmailNaslov obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getZaporednaStevilkaLastnosti() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7840);
            pch.setPch_number(obj.getZaporednaStevilkaLastnosti());
            result.add(pch);
        }
        if (obj.getTipPosebnegaEmailNaslova() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8317);
            pch.setPch_number(obj.getTipPosebnegaEmailNaslova());
            result.add(pch);
        }
        if (obj.getEmailNaslov() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8318);
            pch.setPch_desc(obj.getEmailNaslov());
            result.add(pch);
        }
        if (obj.getTpcharspecialemailverified() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8575);
            pch.setPch_number(obj.getTpcharspecialemailverified());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<PosebniEmailNaslov> getPropertyClass() {
        return PosebniEmailNaslov.class;
    }
}