package si.triglav.bp.generated.mappers;

import java.util.List;
import si.triglav.common.vao.bp.PCharacteristicVAO;

/**
 * Interface for property mappers.
 * Generated - do not edit manually.
 */
public interface PropertyMapper<T> {
    T fromList(List<PCharacteristicVAO> characteristics);
    List<PCharacteristicVAO> toList(T typedObject, Integer idPersProperty);
    Class<T> getPropertyClass();
}
