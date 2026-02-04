package si.triglav.common.propchar.generator.output;

/**
 * Generates PropertyMapper interface.
 */
public class InterfaceGenerator {

    public String generate() {
        return "package si.triglav.common.propchar.generated.mappers;\n" +
            "\n" +
            "import java.util.List;\n" +
            "import si.triglav.common.vao.bp.PCharacteristicVAO;\n" +
            "\n" +
            "/**\n" +
            " * Interface for property mappers.\n" +
            " * Generated - do not edit manually.\n" +
            " */\n" +
            "public interface PropertyMapper<T> {\n" +
            "    T fromList(List<PCharacteristicVAO> characteristics);\n" +
            "    List<PCharacteristicVAO> toList(T typedObject, Integer idPersProperty);\n" +
            "    void updateList(T typedObject, List<PCharacteristicVAO> characteristics);\n" +
            "    Class<T> getPropertyClass();\n" +
            "}\n";
    }
}
