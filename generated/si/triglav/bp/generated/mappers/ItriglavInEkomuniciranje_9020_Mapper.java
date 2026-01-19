package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.ItriglavInEkomuniciranje;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=9020 (iTriglav in E-komuniciranje)
 * Generated - do not edit manually.
 */
public class ItriglavInEkomuniciranje_9020_Mapper implements PropertyMapper<ItriglavInEkomuniciranje> {

    @Override
    public ItriglavInEkomuniciranje fromList(List<PCharacteristicVAO> characteristics) {
        ItriglavInEkomuniciranje result = new ItriglavInEkomuniciranje();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 9021:
                    result.setStrankaJeUporabnikItriglav(pch.getPch_number());
                    break;
                case 9022:
                    result.setEkomuniciranje(pch.getPch_number());
                    break;
                case 9023:
                    result.setEnaslovZaItriglavInEkomuniciranje(pch.getPch_desc());
                    break;
                case 9026:
                    result.setTelefonskaStevilkaZaItriglav(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(ItriglavInEkomuniciranje obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getStrankaJeUporabnikItriglav() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(9021);
            pch.setPch_number(obj.getStrankaJeUporabnikItriglav());
            result.add(pch);
        }
        if (obj.getEkomuniciranje() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(9022);
            pch.setPch_number(obj.getEkomuniciranje());
            result.add(pch);
        }
        if (obj.getEnaslovZaItriglavInEkomuniciranje() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(9023);
            pch.setPch_desc(obj.getEnaslovZaItriglavInEkomuniciranje());
            result.add(pch);
        }
        if (obj.getTelefonskaStevilkaZaItriglav() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(9026);
            pch.setPch_desc(obj.getTelefonskaStevilkaZaItriglav());
            result.add(pch);
        }

        return result;
    }

    @Override
    public void updateList(ItriglavInEkomuniciranje obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 9021, obj.getStrankaJeUporabnikItriglav(), "number");
        updateOrAdd(characteristics, 9022, obj.getEkomuniciranje(), "number");
        updateOrAdd(characteristics, 9023, obj.getEnaslovZaItriglavInEkomuniciranje(), "desc");
        updateOrAdd(characteristics, 9026, obj.getTelefonskaStevilkaZaItriglav(), "desc");
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
    public Class<ItriglavInEkomuniciranje> getPropertyClass() {
        return ItriglavInEkomuniciranje.class;
    }
}