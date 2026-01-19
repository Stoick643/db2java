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
    public void updateList(PosebniEmailNaslov obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 7840, obj.getZaporednaStevilkaLastnosti(), "number");
        updateOrAdd(characteristics, 8317, obj.getTipPosebnegaEmailNaslova(), "number");
        updateOrAdd(characteristics, 8318, obj.getEmailNaslov(), "desc");
        updateOrAdd(characteristics, 8575, obj.getTpcharspecialemailverified(), "number");
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
    public Class<PosebniEmailNaslov> getPropertyClass() {
        return PosebniEmailNaslov.class;
    }
}