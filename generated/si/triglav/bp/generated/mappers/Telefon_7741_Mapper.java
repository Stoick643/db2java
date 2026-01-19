package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.Telefon;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=7741 (Telefon)
 * Generated - do not edit manually.
 */
public class Telefon_7741_Mapper implements PropertyMapper<Telefon> {

    @Override
    public Telefon fromList(List<PCharacteristicVAO> characteristics) {
        Telefon result = new Telefon();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 7741:
                    result.setTelefon(pch.getPch_desc());
                    break;
                case 7800:
                    result.setTelefonskaStevilka(pch.getPch_desc());
                    break;
                case 7801:
                    result.setOmreznaSkupina(pch.getPch_desc());
                    break;
                case 7802:
                    result.setVrstaTelefona_number(pch.getPch_number());
                    result.setVrstaTelefona_desc(pch.getPch_desc());
                    break;
                case 7840:
                    result.setZaporednaStevilkaLastnosti(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(Telefon obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getTelefon() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7741);
            pch.setPch_desc(obj.getTelefon());
            result.add(pch);
        }
        if (obj.getTelefonskaStevilka() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7800);
            pch.setPch_desc(obj.getTelefonskaStevilka());
            result.add(pch);
        }
        if (obj.getOmreznaSkupina() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7801);
            pch.setPch_desc(obj.getOmreznaSkupina());
            result.add(pch);
        }
        if (obj.getVrstaTelefona_number() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7802);
            pch.setPch_number(obj.getVrstaTelefona_number());
            result.add(pch);
        }
        if (obj.getVrstaTelefona_desc() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7802);
            pch.setPch_desc(obj.getVrstaTelefona_desc());
            result.add(pch);
        }
        if (obj.getZaporednaStevilkaLastnosti() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7840);
            pch.setPch_number(obj.getZaporednaStevilkaLastnosti());
            result.add(pch);
        }

        return result;
    }

    @Override
    public void updateList(Telefon obj, List<PCharacteristicVAO> characteristics) {
        updateOrAdd(characteristics, 7741, obj.getTelefon(), "desc");
        updateOrAdd(characteristics, 7800, obj.getTelefonskaStevilka(), "desc");
        updateOrAdd(characteristics, 7801, obj.getOmreznaSkupina(), "desc");
        updateOrAdd(characteristics, 7802, obj.getVrstaTelefona_number(), "number");
        updateOrAdd(characteristics, 7802, obj.getVrstaTelefona_desc(), "desc");
        updateOrAdd(characteristics, 7840, obj.getZaporednaStevilkaLastnosti(), "number");
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
    public Class<Telefon> getPropertyClass() {
        return Telefon.class;
    }
}