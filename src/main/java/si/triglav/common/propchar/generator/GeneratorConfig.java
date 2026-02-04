package si.triglav.common.propchar.generator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Configuration constants for the Java generator.
 */
public final class GeneratorConfig {

    private GeneratorConfig() {
        // Utility class
    }

    /** Ignore counts <= this value as data errors */
    public static final int THRESHOLD = 5;

    /** Type mappings from CSV column types to Java types */
    public static final Map<String, String> TYPE_MAP;

    /** Getter method names for each column type */
    public static final Map<String, String> GETTER_MAP;

    /** Setter method names for each column type */
    public static final Map<String, String> SETTER_MAP;

    static {
        Map<String, String> typeMap = new HashMap<>();
        typeMap.put("number", "Integer");
        typeMap.put("value", "BigDecimal");
        typeMap.put("date", "SimpleDate");
        typeMap.put("desc", "String");
        TYPE_MAP = Collections.unmodifiableMap(typeMap);

        Map<String, String> getterMap = new HashMap<>();
        getterMap.put("number", "getPch_number()");
        getterMap.put("value", "getPch_value()");
        getterMap.put("date", "getPch_date()");
        getterMap.put("desc", "getPch_desc()");
        GETTER_MAP = Collections.unmodifiableMap(getterMap);

        Map<String, String> setterMap = new HashMap<>();
        setterMap.put("number", "setPch_number");
        setterMap.put("value", "setPch_value");
        setterMap.put("date", "setPch_date");
        setterMap.put("desc", "setPch_desc");
        SETTER_MAP = Collections.unmodifiableMap(setterMap);
    }
}
