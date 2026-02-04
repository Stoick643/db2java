package si.triglav.common.propchar.generator.output;

import si.triglav.common.propchar.generator.model.Property;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Generates factory with generic fromList method.
 */
public class FactoryGenerator {

    public String generate(Map<Integer, Property> properties) {
        StringBuilder sb = new StringBuilder();

        sb.append("package si.triglav.common.propchar.generated.mappers;\n");
        sb.append("\n");
        sb.append("import java.util.ArrayList;\n");
        sb.append("import java.util.HashMap;\n");
        sb.append("import java.util.List;\n");
        sb.append("import java.util.Map;\n");
        sb.append("\n");
        sb.append("import si.triglav.common.vao.bp.PCharacteristicVAO;\n");

        // Import all mappers
        List<Integer> sortedKeys = new ArrayList<>(properties.keySet());
        Collections.sort(sortedKeys);

        for (Integer tpProperty : sortedKeys) {
            Property prop = properties.get(tpProperty);
            sb.append("import si.triglav.common.propchar.generated.mappers.")
              .append(prop.getClassName()).append("_Mapper;\n");
        }

        sb.append("\n");
        sb.append("/**\n");
        sb.append(" * Factory for property mappers.\n");
        sb.append(" * Generated - do not edit manually.\n");
        sb.append(" */\n");
        sb.append("public class PropertyMapperFactory {\n");
        sb.append("\n");
        sb.append("    private static final Map<Class<?>, PropertyMapper<?>> registryByClass = new HashMap<>();\n");
        sb.append("    private static final Map<Integer, PropertyMapper<?>> registryByTpProperty = new HashMap<>();\n");
        sb.append("\n");
        sb.append("    static {\n");

        for (Integer tpProperty : sortedKeys) {
            Property prop = properties.get(tpProperty);
            sb.append("        register(new ").append(prop.getClassName()).append("_Mapper(), ")
              .append(tpProperty).append(");\n");
        }

        sb.append("    }\n");
        sb.append("\n");
        sb.append("    private static <T> void register(PropertyMapper<T> mapper, Integer tpProperty) {\n");
        sb.append("        registryByClass.put(mapper.getPropertyClass(), mapper);\n");
        sb.append("        registryByTpProperty.put(tpProperty, mapper);\n");
        sb.append("    }\n");
        sb.append("\n");

        // Generic fromList by class
        sb.append("    @SuppressWarnings(\"unchecked\")\n");
        sb.append("    public static <T> T fromList(Class<T> clazz, List<PCharacteristicVAO> characteristics) {\n");
        sb.append("        PropertyMapper<T> mapper = (PropertyMapper<T>) registryByClass.get(clazz);\n");
        sb.append("        if (mapper == null) {\n");
        sb.append("            throw new IllegalArgumentException(\"No mapper for class: \" + clazz.getName());\n");
        sb.append("        }\n");
        sb.append("        return mapper.fromList(characteristics);\n");
        sb.append("    }\n");
        sb.append("\n");

        // Generic toList by class
        sb.append("    @SuppressWarnings(\"unchecked\")\n");
        sb.append("    public static <T> List<PCharacteristicVAO> toList(T obj, Integer idPersProperty) {\n");
        sb.append("        PropertyMapper<T> mapper = (PropertyMapper<T>) registryByClass.get(obj.getClass());\n");
        sb.append("        if (mapper == null) {\n");
        sb.append("            throw new IllegalArgumentException(\"No mapper for class: \" + obj.getClass().getName());\n");
        sb.append("        }\n");
        sb.append("        return mapper.toList(obj, idPersProperty);\n");
        sb.append("    }\n");
        sb.append("\n");

        // Generic updateList by class
        sb.append("    @SuppressWarnings(\"unchecked\")\n");
        sb.append("    public static <T> void updateList(T obj, List<PCharacteristicVAO> characteristics) {\n");
        sb.append("        PropertyMapper<T> mapper = (PropertyMapper<T>) registryByClass.get(obj.getClass());\n");
        sb.append("        if (mapper == null) {\n");
        sb.append("            throw new IllegalArgumentException(\"No mapper for class: \" + obj.getClass().getName());\n");
        sb.append("        }\n");
        sb.append("        mapper.updateList(obj, characteristics);\n");
        sb.append("    }\n");
        sb.append("\n");

        // Check if mapper exists
        sb.append("    public static boolean hasMapper(Class<?> clazz) {\n");
        sb.append("        return registryByClass.containsKey(clazz);\n");
        sb.append("    }\n");
        sb.append("\n");
        sb.append("    public static boolean hasMapper(Integer tpProperty) {\n");
        sb.append("        return registryByTpProperty.containsKey(tpProperty);\n");
        sb.append("    }\n");
        sb.append("}\n");

        return sb.toString();
    }
}
