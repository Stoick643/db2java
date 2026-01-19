package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.PodatkiOPremozenjskemStanju;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=9198 (Podatki o premoženjskem stanju)
 * Generated - do not edit manually.
 */
public class PodatkiOPremozenjskemStanju_9198_Mapper implements PropertyMapper<PodatkiOPremozenjskemStanju> {

    @Override
    public PodatkiOPremozenjskemStanju fromList(List<PCharacteristicVAO> characteristics) {
        PodatkiOPremozenjskemStanju result = new PodatkiOPremozenjskemStanju();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8284:
                    result.setDrugo(pch.getPch_desc());
                    break;
                case 13066:
                    result.setImetnikBancnegaRacunaPriBanki(pch.getPch_desc());
                    break;
                case 13067:
                    result.setLastnikAliSolastnikNepremAliDrugegaPremozenjaVRsAliTujini(pch.getPch_desc());
                    break;
                case 13069:
                    result.setVlagateljVVzajemneSkladePriUpravljalcuSkladov(pch.getPch_desc());
                    break;
                case 13070:
                    result.setDrugoPremozenje(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(PodatkiOPremozenjskemStanju obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getDrugo() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8284);
            pch.setPch_desc(obj.getDrugo());
            result.add(pch);
        }
        if (obj.getImetnikBancnegaRacunaPriBanki() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(13066);
            pch.setPch_desc(obj.getImetnikBancnegaRacunaPriBanki());
            result.add(pch);
        }
        if (obj.getLastnikAliSolastnikNepremAliDrugegaPremozenjaVRsAliTujini() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(13067);
            pch.setPch_desc(obj.getLastnikAliSolastnikNepremAliDrugegaPremozenjaVRsAliTujini());
            result.add(pch);
        }
        if (obj.getVlagateljVVzajemneSkladePriUpravljalcuSkladov() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(13069);
            pch.setPch_desc(obj.getVlagateljVVzajemneSkladePriUpravljalcuSkladov());
            result.add(pch);
        }
        if (obj.getDrugoPremozenje() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(13070);
            pch.setPch_desc(obj.getDrugoPremozenje());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<PodatkiOPremozenjskemStanju> getPropertyClass() {
        return PodatkiOPremozenjskemStanju.class;
    }
}