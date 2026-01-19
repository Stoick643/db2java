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
    public Class<PodatkiOSoglasjuZaUporaboOsebnihPodatkovZaTestiranjeAplikacij> getPropertyClass() {
        return PodatkiOSoglasjuZaUporaboOsebnihPodatkovZaTestiranjeAplikacij.class;
    }
}