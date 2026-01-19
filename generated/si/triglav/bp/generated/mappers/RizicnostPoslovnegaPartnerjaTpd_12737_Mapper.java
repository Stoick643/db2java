package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.RizicnostPoslovnegaPartnerjaTpd;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=12737 (Rizicnost poslovnega partnerja - TPD)
 * Generated - do not edit manually.
 */
public class RizicnostPoslovnegaPartnerjaTpd_12737_Mapper implements PropertyMapper<RizicnostPoslovnegaPartnerjaTpd> {

    @Override
    public RizicnostPoslovnegaPartnerjaTpd fromList(List<PCharacteristicVAO> characteristics) {
        RizicnostPoslovnegaPartnerjaTpd result = new RizicnostPoslovnegaPartnerjaTpd();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 12736:
                    result.setRizicnostPoslovnegaPartnerjaTpd(pch.getPch_number());
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
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(RizicnostPoslovnegaPartnerjaTpd obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getRizicnostPoslovnegaPartnerjaTpd() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12736);
            pch.setPch_number(obj.getRizicnostPoslovnegaPartnerjaTpd());
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

        return result;
    }

    @Override
    public void updateList(RizicnostPoslovnegaPartnerjaTpd obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 12736, obj.getRizicnostPoslovnegaPartnerjaTpd(), "number");
        updateOrAdd(characteristics, 12841, obj.getStrankaJePio(), "number");
        updateOrAdd(characteristics, 12842, obj.getStrankaImaPovezaneOsebe(), "number");
        updateOrAdd(characteristics, 12843, obj.getDrzavljanstvo(), "number");
        updateOrAdd(characteristics, 12844, obj.getDrzavaStalnegaPrebivanja(), "number");
        updateOrAdd(characteristics, 12845, obj.getDrzavaZacasnegaPrebivanja(), "number");
        updateOrAdd(characteristics, 12846, obj.getRezidentstvoRs(), "number");
        updateOrAdd(characteristics, 12847, obj.getSklenjeniProdukti(), "number");
        updateOrAdd(characteristics, 12848, obj.getTransakcijeInStanjaNaNalozbenemRacunu(), "number");
        updateOrAdd(characteristics, 12849, obj.getNaciniIzvedbeTransakcije(), "number");
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
    public Class<RizicnostPoslovnegaPartnerjaTpd> getPropertyClass() {
        return RizicnostPoslovnegaPartnerjaTpd.class;
    }
}