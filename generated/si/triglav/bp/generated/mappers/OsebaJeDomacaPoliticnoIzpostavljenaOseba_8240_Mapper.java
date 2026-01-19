package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.OsebaJeDomacaPoliticnoIzpostavljenaOseba;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8240 (Oseba je domaca politicno izpostavljena oseba)
 * Generated - do not edit manually.
 */
public class OsebaJeDomacaPoliticnoIzpostavljenaOseba_8240_Mapper implements PropertyMapper<OsebaJeDomacaPoliticnoIzpostavljenaOseba> {

    @Override
    public OsebaJeDomacaPoliticnoIzpostavljenaOseba fromList(List<PCharacteristicVAO> characteristics) {
        OsebaJeDomacaPoliticnoIzpostavljenaOseba result = new OsebaJeDomacaPoliticnoIzpostavljenaOseba();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8047:
                    result.setIzpolnjenVprasalnikZaTujePoliticnoIzpostavljeneOsebe(pch.getPch_number());
                    break;
                case 8241:
                    result.setOsebaJeDomacaPoliticnoIzpostavljenaOseba(pch.getPch_number());
                    break;
                case 8363:
                    result.setVzrokZaIzpolnitevVprasalnika(pch.getPch_desc());
                    break;
                case 8364:
                    result.setPodrocjeOzIzpolnitveVprasalnika(pch.getPch_number());
                    break;
                case 8593:
                    result.setFinishdatepoliticperson(pch.getPch_date());
                    break;
                case 8630:
                    result.setTpnonresponeyesno(pch.getPch_number());
                    break;
                case 8631:
                    result.setTpnonresfammemyesno(pch.getPch_number());
                    break;
                case 8632:
                    result.setTpnonrescoworkyesno(pch.getPch_number());
                    break;
                case 9112:
                    result.setTppiocommentfunc(pch.getPch_desc());
                    break;
                case 9113:
                    result.setTppiocommentproperty(pch.getPch_desc());
                    break;
                case 9190:
                    result.setFinishdatepoliticpersonfunction(pch.getPch_date());
                    break;
                case 9191:
                    result.setTpcharnonresponecomment(pch.getPch_desc());
                    break;
                case 9192:
                    result.setTpcharnonresfammemcomment(pch.getPch_desc());
                    break;
                case 9193:
                    result.setTpcharnonrescoworkcomment(pch.getPch_desc());
                    break;
                case 9194:
                    result.setTpcharpioevent(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(OsebaJeDomacaPoliticnoIzpostavljenaOseba obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getIzpolnjenVprasalnikZaTujePoliticnoIzpostavljeneOsebe() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8047);
            pch.setPch_number(obj.getIzpolnjenVprasalnikZaTujePoliticnoIzpostavljeneOsebe());
            result.add(pch);
        }
        if (obj.getOsebaJeDomacaPoliticnoIzpostavljenaOseba() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8241);
            pch.setPch_number(obj.getOsebaJeDomacaPoliticnoIzpostavljenaOseba());
            result.add(pch);
        }
        if (obj.getVzrokZaIzpolnitevVprasalnika() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8363);
            pch.setPch_desc(obj.getVzrokZaIzpolnitevVprasalnika());
            result.add(pch);
        }
        if (obj.getPodrocjeOzIzpolnitveVprasalnika() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8364);
            pch.setPch_number(obj.getPodrocjeOzIzpolnitveVprasalnika());
            result.add(pch);
        }
        if (obj.getFinishdatepoliticperson() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8593);
            pch.setPch_date(obj.getFinishdatepoliticperson());
            result.add(pch);
        }
        if (obj.getTpnonresponeyesno() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8630);
            pch.setPch_number(obj.getTpnonresponeyesno());
            result.add(pch);
        }
        if (obj.getTpnonresfammemyesno() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8631);
            pch.setPch_number(obj.getTpnonresfammemyesno());
            result.add(pch);
        }
        if (obj.getTpnonrescoworkyesno() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8632);
            pch.setPch_number(obj.getTpnonrescoworkyesno());
            result.add(pch);
        }
        if (obj.getTppiocommentfunc() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(9112);
            pch.setPch_desc(obj.getTppiocommentfunc());
            result.add(pch);
        }
        if (obj.getTppiocommentproperty() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(9113);
            pch.setPch_desc(obj.getTppiocommentproperty());
            result.add(pch);
        }
        if (obj.getFinishdatepoliticpersonfunction() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(9190);
            pch.setPch_date(obj.getFinishdatepoliticpersonfunction());
            result.add(pch);
        }
        if (obj.getTpcharnonresponecomment() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(9191);
            pch.setPch_desc(obj.getTpcharnonresponecomment());
            result.add(pch);
        }
        if (obj.getTpcharnonresfammemcomment() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(9192);
            pch.setPch_desc(obj.getTpcharnonresfammemcomment());
            result.add(pch);
        }
        if (obj.getTpcharnonrescoworkcomment() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(9193);
            pch.setPch_desc(obj.getTpcharnonrescoworkcomment());
            result.add(pch);
        }
        if (obj.getTpcharpioevent() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(9194);
            pch.setPch_number(obj.getTpcharpioevent());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<OsebaJeDomacaPoliticnoIzpostavljenaOseba> getPropertyClass() {
        return OsebaJeDomacaPoliticnoIzpostavljenaOseba.class;
    }
}