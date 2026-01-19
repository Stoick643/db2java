package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.PartnerJePlacnikNaZbirnemRacunuDneviPosiljanja;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8918 (Partner je placnik na zbirnem racunu - dnevi pošiljanja)
 * Generated - do not edit manually.
 */
public class PartnerJePlacnikNaZbirnemRacunuDneviPosiljanja_8918_Mapper implements PropertyMapper<PartnerJePlacnikNaZbirnemRacunuDneviPosiljanja> {

    @Override
    public PartnerJePlacnikNaZbirnemRacunuDneviPosiljanja fromList(List<PCharacteristicVAO> characteristics) {
        PartnerJePlacnikNaZbirnemRacunuDneviPosiljanja result = new PartnerJePlacnikNaZbirnemRacunuDneviPosiljanja();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8917:
                    result.setDanZaPosiljanjeZbirniRacun(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(PartnerJePlacnikNaZbirnemRacunuDneviPosiljanja obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getDanZaPosiljanjeZbirniRacun() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8917);
            pch.setPch_desc(obj.getDanZaPosiljanjeZbirniRacun());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<PartnerJePlacnikNaZbirnemRacunuDneviPosiljanja> getPropertyClass() {
        return PartnerJePlacnikNaZbirnemRacunuDneviPosiljanja.class;
    }
}