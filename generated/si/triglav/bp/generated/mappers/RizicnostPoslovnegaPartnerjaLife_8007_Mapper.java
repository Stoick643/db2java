package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.RizicnostPoslovnegaPartnerjaLife;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8007 (Rizicnost poslovnega partnerja - LIFE)
 * Generated - do not edit manually.
 */
public class RizicnostPoslovnegaPartnerjaLife_8007_Mapper implements PropertyMapper<RizicnostPoslovnegaPartnerjaLife> {

    @Override
    public RizicnostPoslovnegaPartnerjaLife fromList(List<PCharacteristicVAO> characteristics) {
        RizicnostPoslovnegaPartnerjaLife result = new RizicnostPoslovnegaPartnerjaLife();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8008:
                    result.setRizicnostPoslovnegaPartnerjaLife(pch.getPch_number());
                    break;
                case 12841:
                    result.setStrankaJePio(pch.getPch_number());
                    break;
                case 12842:
                    result.setStrankaImaPovezaneOsebe(pch.getPch_number());
                    break;
                case 12843:
                    result.setDrzavljanstvo(pch.getPch_number());
                    break;
                case 12844:
                    result.setDrzavaStalnegaPrebivanja(pch.getPch_number());
                    break;
                case 12845:
                    result.setDrzavaZacasnegaPrebivanja(pch.getPch_number());
                    break;
                case 12846:
                    result.setRezidentstvoRs(pch.getPch_number());
                    break;
                case 12847:
                    result.setSklenjeniProdukti(pch.getPch_number());
                    break;
                case 12848:
                    result.setTransakcijeInStanjaNaNalozbenemRacunu(pch.getPch_number());
                    break;
                case 12849:
                    result.setNaciniIzvedbeTransakcije(pch.getPch_number());
                    break;
                case 12854:
                    result.setDrzavaSedeza(pch.getPch_number());
                    break;
                case 12855:
                    result.setJavnaUpravaInJavnaPodjetja(pch.getPch_number());
                    break;
                case 12856:
                    result.setDrzavaIzvoraVplacila(pch.getPch_number());
                    break;
                case 12857:
                    result.setDrzavaIzplacila(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(RizicnostPoslovnegaPartnerjaLife obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getRizicnostPoslovnegaPartnerjaLife() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8008);
            pch.setPch_number(obj.getRizicnostPoslovnegaPartnerjaLife());
            result.add(pch);
        }
        if (obj.getStrankaJePio() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12841);
            pch.setPch_number(obj.getStrankaJePio());
            result.add(pch);
        }
        if (obj.getStrankaImaPovezaneOsebe() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12842);
            pch.setPch_number(obj.getStrankaImaPovezaneOsebe());
            result.add(pch);
        }
        if (obj.getDrzavljanstvo() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12843);
            pch.setPch_number(obj.getDrzavljanstvo());
            result.add(pch);
        }
        if (obj.getDrzavaStalnegaPrebivanja() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12844);
            pch.setPch_number(obj.getDrzavaStalnegaPrebivanja());
            result.add(pch);
        }
        if (obj.getDrzavaZacasnegaPrebivanja() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12845);
            pch.setPch_number(obj.getDrzavaZacasnegaPrebivanja());
            result.add(pch);
        }
        if (obj.getRezidentstvoRs() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12846);
            pch.setPch_number(obj.getRezidentstvoRs());
            result.add(pch);
        }
        if (obj.getSklenjeniProdukti() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12847);
            pch.setPch_number(obj.getSklenjeniProdukti());
            result.add(pch);
        }
        if (obj.getTransakcijeInStanjaNaNalozbenemRacunu() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12848);
            pch.setPch_number(obj.getTransakcijeInStanjaNaNalozbenemRacunu());
            result.add(pch);
        }
        if (obj.getNaciniIzvedbeTransakcije() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12849);
            pch.setPch_number(obj.getNaciniIzvedbeTransakcije());
            result.add(pch);
        }
        if (obj.getDrzavaSedeza() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12854);
            pch.setPch_number(obj.getDrzavaSedeza());
            result.add(pch);
        }
        if (obj.getJavnaUpravaInJavnaPodjetja() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12855);
            pch.setPch_number(obj.getJavnaUpravaInJavnaPodjetja());
            result.add(pch);
        }
        if (obj.getDrzavaIzvoraVplacila() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12856);
            pch.setPch_number(obj.getDrzavaIzvoraVplacila());
            result.add(pch);
        }
        if (obj.getDrzavaIzplacila() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12857);
            pch.setPch_number(obj.getDrzavaIzplacila());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<RizicnostPoslovnegaPartnerjaLife> getPropertyClass() {
        return RizicnostPoslovnegaPartnerjaLife.class;
    }
}