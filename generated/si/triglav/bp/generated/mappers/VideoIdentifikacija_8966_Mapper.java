package si.triglav.bp.generated.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import si.triglav.bp.properties.VideoIdentifikacija;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Mapper for TP_PROPERTY=8966 (Video identifikacija)
 * Generated - do not edit manually.
 */
public class VideoIdentifikacija_8966_Mapper implements PropertyMapper<VideoIdentifikacija> {

    @Override
    public VideoIdentifikacija fromList(List<PCharacteristicVAO> characteristics) {
        VideoIdentifikacija result = new VideoIdentifikacija();

        for (PCharacteristicVAO pch : characteristics) {
            switch (pch.getTp_character()) {
                case 8967:
                    result.setVideoIdRef(pch.getPch_desc());
                    break;
            }
        }

        return result;
    }

    @Override
    public List<PCharacteristicVAO> toList(VideoIdentifikacija obj, Integer idPersProperty) {
        List<PCharacteristicVAO> result = new ArrayList<>();

        if (obj.getVideoIdRef() != null) {
            PCharacteristicVAO pch = new PCharacteristicVAO();
            pch.setId_pers_property(idPersProperty);
            pch.setTp_character(8967);
            pch.setPch_desc(obj.getVideoIdRef());
            result.add(pch);
        }

        return result;
    }

    @Override
    public Class<VideoIdentifikacija> getPropertyClass() {
        return VideoIdentifikacija.class;
    }
}