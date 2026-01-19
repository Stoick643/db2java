package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.PodatkiZaPotrebeFatcaDolocb;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8266 (Podatki za potrebe FATCA dolocb)
 * Generated - do not edit manually.
 */
public class PodatkiZaPotrebeFatcaDolocb_8266_Mapper implements PropertyMapper<PodatkiZaPotrebeFatcaDolocb> {

    @Override
    public PodatkiZaPotrebeFatcaDolocb fromList(List<PCharacteristicVAO> characteristics) {
        PodatkiZaPotrebeFatcaDolocb result = new PodatkiZaPotrebeFatcaDolocb();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8268:
                    result.setDrzava(pch.getPch_number());
                    break;
                case 8269:
                    result.setRezidentZdaZaDavcneNamene(pch.getPch_number());
                    break;
                case 8270:
                    result.setSifraTinssn(pch.getPch_desc());
                    break;
                case 8272:
                    result.setIzpolnjenVprasalnikW8Benbene(pch.getPch_number());
                    break;
                case 8273:
                    result.setIzpolnjenVprasalnikW9(pch.getPch_number());
                    break;
                case 8274:
                    result.setFatcaStatus(pch.getPch_number());
                    break;
                case 8313:
                    result.setOsebaImaPozitivenFatcaStatus(pch.getPch_number());
                    break;
                case 8574:
                    result.setFatcayesno(pch.getPch_number());
                    break;
                case 9195:
                    result.setTpcharfatcassn(pch.getPch_desc());
                    break;
                case 12670:
                    result.setTpcharfatcanotesentdate(pch.getPch_date());
                    break;
                case 12671:
                    result.setTpcharfatcanotereceiveddate(pch.getPch_date());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(PodatkiZaPotrebeFatcaDolocb obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getDrzava() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8268);
            pch.setPch_number(obj.getDrzava());
            result.add(pch);
        }
        if (obj.getRezidentZdaZaDavcneNamene() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8269);
            pch.setPch_number(obj.getRezidentZdaZaDavcneNamene());
            result.add(pch);
        }
        if (obj.getSifraTinssn() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8270);
            pch.setPch_desc(obj.getSifraTinssn());
            result.add(pch);
        }
        if (obj.getIzpolnjenVprasalnikW8Benbene() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8272);
            pch.setPch_number(obj.getIzpolnjenVprasalnikW8Benbene());
            result.add(pch);
        }
        if (obj.getIzpolnjenVprasalnikW9() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8273);
            pch.setPch_number(obj.getIzpolnjenVprasalnikW9());
            result.add(pch);
        }
        if (obj.getFatcaStatus() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8274);
            pch.setPch_number(obj.getFatcaStatus());
            result.add(pch);
        }
        if (obj.getOsebaImaPozitivenFatcaStatus() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8313);
            pch.setPch_number(obj.getOsebaImaPozitivenFatcaStatus());
            result.add(pch);
        }
        if (obj.getFatcayesno() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8574);
            pch.setPch_number(obj.getFatcayesno());
            result.add(pch);
        }
        if (obj.getTpcharfatcassn() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(9195);
            pch.setPch_desc(obj.getTpcharfatcassn());
            result.add(pch);
        }
        if (obj.getTpcharfatcanotesentdate() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12670);
            pch.setPch_date(obj.getTpcharfatcanotesentdate());
            result.add(pch);
        }
        if (obj.getTpcharfatcanotereceiveddate() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12671);
            pch.setPch_date(obj.getTpcharfatcanotereceiveddate());
            result.add(pch);
        }

        return result;
    }

    @Override
    public void updateList(PodatkiZaPotrebeFatcaDolocb obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 8268, obj.getDrzava(), "number");
        updateOrAdd(characteristics, 8269, obj.getRezidentZdaZaDavcneNamene(), "number");
        updateOrAdd(characteristics, 8270, obj.getSifraTinssn(), "desc");
        updateOrAdd(characteristics, 8272, obj.getIzpolnjenVprasalnikW8Benbene(), "number");
        updateOrAdd(characteristics, 8273, obj.getIzpolnjenVprasalnikW9(), "number");
        updateOrAdd(characteristics, 8274, obj.getFatcaStatus(), "number");
        updateOrAdd(characteristics, 8313, obj.getOsebaImaPozitivenFatcaStatus(), "number");
        updateOrAdd(characteristics, 8574, obj.getFatcayesno(), "number");
        updateOrAdd(characteristics, 9195, obj.getTpcharfatcassn(), "desc");
        updateOrAdd(characteristics, 12670, obj.getTpcharfatcanotesentdate(), "date");
        updateOrAdd(characteristics, 12671, obj.getTpcharfatcanotereceiveddate(), "date");
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
    public Class<PodatkiZaPotrebeFatcaDolocb> getPropertyClass() {
        return PodatkiZaPotrebeFatcaDolocb.class;
    }
}