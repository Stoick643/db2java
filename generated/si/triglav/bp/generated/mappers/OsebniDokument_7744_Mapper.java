package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.OsebniDokument;
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
    public Class<OsebniDokument> getPropertyClass() {
        return OsebniDokument.class;
    }
}