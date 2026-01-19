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
    public Class<PodatkiOBonitetnihOcenah> getPropertyClass() {
        return PodatkiOBonitetnihOcenah.class;
    }
}