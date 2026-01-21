package si.triglav.common.propchar.generated.mappers;

import java.util.List;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Interface for property mappers.
 * Generated - do not edit manually.
 */
public interface PropertyMapper<T> {
    T fromList(List<PCharacteristicVAO> characteristics);
    List<PCharacteristicVAO> toList(T typedObject, Integer idPersProperty);
    void updateList(T typedObject, List<PCharacteristicVAO> characteristics);
    Class<T> getPropertyClass();
}
