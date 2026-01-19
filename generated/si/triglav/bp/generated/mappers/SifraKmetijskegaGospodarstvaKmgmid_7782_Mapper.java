package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.SifraKmetijskegaGospodarstvaKmgmid;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=7782 (Sifra kmetijskega gospodarstva (KMG_MID))
 * Generated - do not edit manually.
 */
public class SifraKmetijskegaGospodarstvaKmgmid_7782_Mapper implements PropertyMapper<SifraKmetijskegaGospodarstvaKmgmid> {

    @Override
    public SifraKmetijskegaGospodarstvaKmgmid fromList(List<PCharacteristicVAO> characteristics) {
        SifraKmetijskegaGospodarstvaKmgmid result = new SifraKmetijskegaGospodarstvaKmgmid();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 7825:
                    result.setSifraKmetijskegaGospodarstvaKmgmid(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(SifraKmetijskegaGospodarstvaKmgmid obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getSifraKmetijskegaGospodarstvaKmgmid() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(7825);
            pch.setPch_desc(obj.getSifraKmetijskegaGospodarstvaKmgmid());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<SifraKmetijskegaGospodarstvaKmgmid> getPropertyClass() {
        return SifraKmetijskegaGospodarstvaKmgmid.class;
    }
}