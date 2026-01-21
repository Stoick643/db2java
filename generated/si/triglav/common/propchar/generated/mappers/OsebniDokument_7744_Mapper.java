package si.triglav.common.propchar.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.common.propchar.properties.OsebniDokument;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=7744 (Osebni dokument)
 * Generated - do not edit manually.
 */
public class OsebniDokument_7744_Mapper implements PropertyMapper<OsebniDokument> {

    @Override
    public OsebniDokument fromList(List<PCharacteristicVAO> characteristics) {
        OsebniDokument result = new OsebniDokument();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 7805:
                    result.setStevilkaDokumenta(pch.getPch_desc());
                    break;
                case 7806:
                    result.setVrstaDokumenta(pch.getPch_number());
                    break;
                case 7807:
                    result.setDatumIzdaje(pch.getPch_date());
                    break;
                case 7808:
                    result.setKonecVeljavnosti(pch.getPch_date());
                    break;
                case 8018:
                    result.setOrganIzdaje(pch.getPch_desc());
                    break;
                case 8355:
                    result.setVzrokNeizvedeneOsebneIdentifikacije_number(pch.getPch_number());
                    result.setVzrokNeizvedeneOsebneIdentifikacije_desc(pch.getPch_desc());
                    break;
                case 8963:
                    result.setDrzavaIzdajeOsebnegaDokumenta(pch.getPch_number());
                    break;
                case 9111:
                    result.setKonecVeljavnostiPermanentno(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(OsebniDokument obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getStevilkaDokumenta() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7805);
            pch.setPch_desc(obj.getStevilkaDokumenta());
            result.add(pch);
        }
        if (obj.getVrstaDokumenta() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7806);
            pch.setPch_number(obj.getVrstaDokumenta());
            result.add(pch);
        }
        if (obj.getDatumIzdaje() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7807);
            pch.setPch_date(obj.getDatumIzdaje());
            result.add(pch);
        }
        if (obj.getKonecVeljavnosti() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7808);
            pch.setPch_date(obj.getKonecVeljavnosti());
            result.add(pch);
        }
        if (obj.getOrganIzdaje() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8018);
            pch.setPch_desc(obj.getOrganIzdaje());
            result.add(pch);
        }
        if (obj.getVzrokNeizvedeneOsebneIdentifikacije_number() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8355);
            pch.setPch_number(obj.getVzrokNeizvedeneOsebneIdentifikacije_number());
            result.add(pch);
        }
        if (obj.getVzrokNeizvedeneOsebneIdentifikacije_desc() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8355);
            pch.setPch_desc(obj.getVzrokNeizvedeneOsebneIdentifikacije_desc());
            result.add(pch);
        }
        if (obj.getDrzavaIzdajeOsebnegaDokumenta() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8963);
            pch.setPch_number(obj.getDrzavaIzdajeOsebnegaDokumenta());
            result.add(pch);
        }
        if (obj.getKonecVeljavnostiPermanentno() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(9111);
            pch.setPch_number(obj.getKonecVeljavnostiPermanentno());
            result.add(pch);
        }

        return result;
    }

    @Override
    public void updateList(OsebniDokument obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 7805, obj.getStevilkaDokumenta(), "desc");
        updateOrAdd(characteristics, 7806, obj.getVrstaDokumenta(), "number");
        updateOrAdd(characteristics, 7807, obj.getDatumIzdaje(), "date");
        updateOrAdd(characteristics, 7808, obj.getKonecVeljavnosti(), "date");
        updateOrAdd(characteristics, 8018, obj.getOrganIzdaje(), "desc");
        updateOrAdd(characteristics, 8355, obj.getVzrokNeizvedeneOsebneIdentifikacije_number(), "number");
        updateOrAdd(characteristics, 8355, obj.getVzrokNeizvedeneOsebneIdentifikacije_desc(), "desc");
        updateOrAdd(characteristics, 8963, obj.getDrzavaIzdajeOsebnegaDokumenta(), "number");
        updateOrAdd(characteristics, 9111, obj.getKonecVeljavnostiPermanentno(), "number");
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
    public Class<OsebniDokument> getPropertyClass() {
        return OsebniDokument.class;
    }
}