package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.PodatkiOBonitetnihOcenah;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8195 (Podatki o bonitetnih ocenah)
 * Generated - do not edit manually.
 */
public class PodatkiOBonitetnihOcenah_8195_Mapper implements PropertyMapper<PodatkiOBonitetnihOcenah> {

    @Override
    public PodatkiOBonitetnihOcenah fromList(List<PCharacteristicVAO> characteristics) {
        PodatkiOBonitetnihOcenah result = new PodatkiOBonitetnihOcenah();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8193:
                    result.setBonitetnaOcenanesifrirana(pch.getPch_desc());
                    break;
                case 8194:
                    result.setDatumBonitetneOcene(pch.getPch_date());
                    break;
                case 8196:
                    result.setBonitetnaAgencija(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(PodatkiOBonitetnihOcenah obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getBonitetnaOcenanesifrirana() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8193);
            pch.setPch_desc(obj.getBonitetnaOcenanesifrirana());
            result.add(pch);
        }
        if (obj.getDatumBonitetneOcene() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8194);
            pch.setPch_date(obj.getDatumBonitetneOcene());
            result.add(pch);
        }
        if (obj.getBonitetnaAgencija() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8196);
            pch.setPch_number(obj.getBonitetnaAgencija());
            result.add(pch);
        }

        return result;
    }

    @Override
    public void updateList(PodatkiOBonitetnihOcenah obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 8193, obj.getBonitetnaOcenanesifrirana(), "desc");
        updateOrAdd(characteristics, 8194, obj.getDatumBonitetneOcene(), "date");
        updateOrAdd(characteristics, 8196, obj.getBonitetnaAgencija(), "number");
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
    public Class<PodatkiOBonitetnihOcenah> getPropertyClass() {
        return PodatkiOBonitetnihOcenah.class;
    }
}