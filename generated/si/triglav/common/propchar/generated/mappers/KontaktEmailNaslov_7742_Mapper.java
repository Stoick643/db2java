package si.triglav.common.propchar.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.common.propchar.properties.KontaktEmailNaslov;
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
    public void updateList(KontaktEmailNaslov obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 7803, obj.getEmailNaslov(), "desc");
        updateOrAdd(characteristics, 7840, obj.getZaporednaStevilkaLastnosti(), "number");
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
    public Class<KontaktEmailNaslov> getPropertyClass() {
        return KontaktEmailNaslov.class;
    }
}