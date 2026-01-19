package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.PodatkiOSoglasjuZaUporaboOsebnihPodatkovZaTestiranjeAplikacij;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=14295 (Podatki o soglasju za uporabo osebnih podatkov za testiranje aplikacij)
 * Generated - do not edit manually.
 */
public class PodatkiOSoglasjuZaUporaboOsebnihPodatkovZaTestiranjeAplikacij_14295_Mapper implements PropertyMapper<PodatkiOSoglasjuZaUporaboOsebnihPodatkovZaTestiranjeAplikacij> {

    @Override
    public PodatkiOSoglasjuZaUporaboOsebnihPodatkovZaTestiranjeAplikacij fromList(List<PCharacteristicVAO> characteristics) {
        PodatkiOSoglasjuZaUporaboOsebnihPodatkovZaTestiranjeAplikacij result = new PodatkiOSoglasjuZaUporaboOsebnihPodatkovZaTestiranjeAplikacij();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 14294:
                    result.setPartnerImaPodanoSoglasjeZaUporaboOsebnihPodatkovPriTestiranju(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(PodatkiOSoglasjuZaUporaboOsebnihPodatkovZaTestiranjeAplikacij obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getPartnerImaPodanoSoglasjeZaUporaboOsebnihPodatkovPriTestiranju() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(14294);
            pch.setPch_number(obj.getPartnerImaPodanoSoglasjeZaUporaboOsebnihPodatkovPriTestiranju());
            result.add(pch);
        }

        return result;
    }

    @Override
    public void updateList(PodatkiOSoglasjuZaUporaboOsebnihPodatkovZaTestiranjeAplikacij obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 14294, obj.getPartnerImaPodanoSoglasjeZaUporaboOsebnihPodatkovPriTestiranju(), "number");
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
    public Class<PodatkiOSoglasjuZaUporaboOsebnihPodatkovZaTestiranjeAplikacij> getPropertyClass() {
        return PodatkiOSoglasjuZaUporaboOsebnihPodatkovZaTestiranjeAplikacij.class;
    }
}