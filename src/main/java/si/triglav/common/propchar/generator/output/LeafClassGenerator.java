package si.triglav.common.propchar.generator.output;

import si.triglav.common.propchar.generator.model.Property;
import si.triglav.common.propchar.generator.naming.SlovenianNameConverter;

/**
 * Generates Level 3 leaf classes (extends generated class).
 */
public class LeafClassGenerator {

    public String generate(Property prop) {
        // Extract simple class name without _XXXX suffix for leaf
        String simpleName = SlovenianNameConverter.toJavaClassName(prop.getName());

        StringBuilder sb = new StringBuilder();

        sb.append("package si.triglav.common.propchar.properties;\n");
        sb.append("\n");
        sb.append("import si.triglav.common.propchar.generated.properties.").append(prop.getClassName()).append(";\n");
        sb.append("\n");
        sb.append("/**\n");
        sb.append(" * Concrete implementation for ").append(prop.getName()).append(".\n");
        sb.append(" * Use this class in your application code.\n");
        sb.append(" * This file will NOT be overwritten by the generator.\n");
        sb.append(" */\n");
        sb.append("public class ").append(simpleName).append(" extends ").append(prop.getClassName()).append(" {\n");
        sb.append("\n");
        sb.append("    private static final long serialVersionUID = 1L;\n");
        sb.append("\n");
        sb.append("    public ").append(simpleName).append("() {\n");
        sb.append("        super();\n");
        sb.append("    }\n");
        sb.append("\n");
        sb.append("    // Add custom business logic here\n");
        sb.append("}\n");

        return sb.toString();
    }
}
