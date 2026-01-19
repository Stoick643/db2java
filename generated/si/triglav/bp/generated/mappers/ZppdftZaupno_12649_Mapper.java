package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.ZppdftZaupno;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=12649 (ZPPDFT zaupno)
 * Generated - do not edit manually.
 */
public class ZppdftZaupno_12649_Mapper implements PropertyMapper<ZppdftZaupno> {

    @Override
    public ZppdftZaupno fromList(List<PCharacteristicVAO> characteristics) {
        ZppdftZaupno result = new ZppdftZaupno();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 12650:
                    result.setZppdftZaupnoVnos(pch.getPch_number());
                    break;
                case 12651:
                    result.setZppdftZaupnoOpis(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(ZppdftZaupno obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getZppdftZaupnoVnos() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12650);
            pch.setPch_number(obj.getZppdftZaupnoVnos());
            result.add(pch);
        }
        if (obj.getZppdftZaupnoOpis() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12651);
            pch.setPch_desc(obj.getZppdftZaupnoOpis());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<ZppdftZaupno> getPropertyClass() {
        return ZppdftZaupno.class;
    }
}