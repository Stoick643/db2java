package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.VirDohodka;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8296 (Vir dohodka)
 * Generated - do not edit manually.
 */
public class VirDohodka_8296_Mapper implements PropertyMapper<VirDohodka> {

    @Override
    public VirDohodka fromList(List<PCharacteristicVAO> characteristics) {
        VirDohodka result = new VirDohodka();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8057:
                    result.setPoslanoSStraniInkaso(pch.getPch_number());
                    break;
                case 8058:
                    result.setPoslanoSStraniTarifacija(pch.getPch_number());
                    break;
                case 8284:
                    result.setDrugo(pch.getPch_desc());
                    break;
                case 8297:
                    result.setTipViraDohodka(pch.getPch_number());
                    break;
                case 8298:
                    result.setDodatniOpisViraDohodka(pch.getPch_desc());
                    break;
                case 8605:
                    result.setCashoriginyesno(pch.getPch_number());
                    break;
                case 9196:
                    result.setTpcharcashoriginpioyes(pch.getPch_number());
                    break;
                case 9197:
                    result.setTpcharcashoriginpaymentover15k(pch.getPch_number());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(VirDohodka obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getPoslanoSStraniInkaso() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8057);
            pch.setPch_number(obj.getPoslanoSStraniInkaso());
            result.add(pch);
        }
        if (obj.getPoslanoSStraniTarifacija() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8058);
            pch.setPch_number(obj.getPoslanoSStraniTarifacija());
            result.add(pch);
        }
        if (obj.getDrugo() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8284);
            pch.setPch_desc(obj.getDrugo());
            result.add(pch);
        }
        if (obj.getTipViraDohodka() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8297);
            pch.setPch_number(obj.getTipViraDohodka());
            result.add(pch);
        }
        if (obj.getDodatniOpisViraDohodka() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8298);
            pch.setPch_desc(obj.getDodatniOpisViraDohodka());
            result.add(pch);
        }
        if (obj.getCashoriginyesno() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8605);
            pch.setPch_number(obj.getCashoriginyesno());
            result.add(pch);
        }
        if (obj.getTpcharcashoriginpioyes() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(9196);
            pch.setPch_number(obj.getTpcharcashoriginpioyes());
            result.add(pch);
        }
        if (obj.getTpcharcashoriginpaymentover15k() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(9197);
            pch.setPch_number(obj.getTpcharcashoriginpaymentover15k());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<VirDohodka> getPropertyClass() {
        return VirDohodka.class;
    }
}