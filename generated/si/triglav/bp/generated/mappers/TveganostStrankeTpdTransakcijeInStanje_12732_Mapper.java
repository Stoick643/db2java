package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.TveganostStrankeTpdTransakcijeInStanje;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=12732 (Tveganost stranke TPD - TRANSAKCIJE in STANJE)
 * Generated - do not edit manually.
 */
public class TveganostStrankeTpdTransakcijeInStanje_12732_Mapper implements PropertyMapper<TveganostStrankeTpdTransakcijeInStanje> {

    @Override
    public TveganostStrankeTpdTransakcijeInStanje fromList(List<PCharacteristicVAO> characteristics) {
        TveganostStrankeTpdTransakcijeInStanje result = new TveganostStrankeTpdTransakcijeInStanje();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 12733:
                    result.setTveganostStrankeTpdTransakcijeInStanje(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(TveganostStrankeTpdTransakcijeInStanje obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getTveganostStrankeTpdTransakcijeInStanje() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(12733);
            pch.setPch_number(obj.getTveganostStrankeTpdTransakcijeInStanje());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<TveganostStrankeTpdTransakcijeInStanje> getPropertyClass() {
        return TveganostStrankeTpdTransakcijeInStanje.class;
    }
}