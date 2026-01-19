package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.Eracun;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8275 (eRacun)
 * Generated - do not edit manually.
 */
public class Eracun_8275_Mapper implements PropertyMapper<Eracun> {

    @Override
    public Eracun fromList(List<PCharacteristicVAO> characteristics) {
        Eracun result = new Eracun();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8276:
                    result.setStrankaZeliPrejematiEracun(pch.getPch_number());
                    break;
                case 8277:
                    result.setVrstaKanalaZaPrejemanjeEracuna(pch.getPch_number());
                    break;
                case 8278:
                    result.setElektronskiNaslovZaEracun(pch.getPch_desc());
                    break;
                case 8286:
                    result.setBancniRacunZaEracun(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(Eracun obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getStrankaZeliPrejematiEracun() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8276);
            pch.setPch_number(obj.getStrankaZeliPrejematiEracun());
            result.add(pch);
        }
        if (obj.getVrstaKanalaZaPrejemanjeEracuna() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8277);
            pch.setPch_number(obj.getVrstaKanalaZaPrejemanjeEracuna());
            result.add(pch);
        }
        if (obj.getElektronskiNaslovZaEracun() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8278);
            pch.setPch_desc(obj.getElektronskiNaslovZaEracun());
            result.add(pch);
        }
        if (obj.getBancniRacunZaEracun() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8286);
            pch.setPch_desc(obj.getBancniRacunZaEracun());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<Eracun> getPropertyClass() {
        return Eracun.class;
    }
}