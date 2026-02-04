package si.triglav.common.propchar.generator.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a tp_property with its characteristics.
 */
public class Property {

    private final int tpProperty;
    private final String name;
    private final String className;
    private final List<Characteristic> characteristics;

    public Property(int tpProperty, String name, String className) {
        this.tpProperty = tpProperty;
        this.name = name;
        this.className = className;
        this.characteristics = new ArrayList<>();
    }

    public int getTpProperty() {
        return tpProperty;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public List<Characteristic> getCharacteristics() {
        return characteristics;
    }

    public void addCharacteristic(Characteristic characteristic) {
        this.characteristics.add(characteristic);
    }
}
