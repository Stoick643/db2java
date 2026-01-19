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
    public Class<ItriglavInEkomuniciranje> getPropertyClass() {
        return ItriglavInEkomuniciranje.class;
    }
}