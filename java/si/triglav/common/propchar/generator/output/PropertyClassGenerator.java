package si.triglav.common.propchar.generator.output;

import si.triglav.common.propchar.generator.model.Characteristic;
import si.triglav.common.propchar.generator.model.CharacteristicField;
import si.triglav.common.propchar.generator.model.Property;

import java.util.Set;
import java.util.TreeSet;

/**
 * Generates Level 2 property classes (extends BaseProperties).
 */
public class PropertyClassGenerator {

    public String generate(Property prop) {
        StringBuilder sb = new StringBuilder();

        sb.append("package si.triglav.common.propchar.generated.properties;\n");
        sb.append("\n");

        // Imports
        Set<String> imports = new TreeSet<>();
        imports.add("import si.triglav.common.propchar.properties.BaseProperties;");
        for (Characteristic charObj : prop.getCharacteristics()) {
            for (CharacteristicField f : charObj.getFields()) {
                if ("BigDecimal".equals(f.getJavaType())) {
                    imports.add("import java.math.BigDecimal;");
                } else if ("SimpleDate".equals(f.getJavaType())) {
                    imports.add("import si.triglav.common.SimpleDate;");
                }
            }
        }

        for (String imp : imports) {
            sb.append(imp).append("\n");
        }
        sb.append("\n");

        // Class declaration
        sb.append("/**\n");
        sb.append(" * Typed class for TP_PROPERTY=").append(prop.getTpProperty())
          .append(" (").append(prop.getName()).append(")\n");
        sb.append(" * Generated - do not edit manually.\n");
        sb.append(" */\n");
        sb.append("public class ").append(prop.getClassName()).append(" extends BaseProperties {\n");
        sb.append("\n");
        sb.append("    private static final long serialVersionUID = 1L;\n");
        sb.append("\n");

        // Fields
        for (Characteristic charObj : prop.getCharacteristics()) {
            for (CharacteristicField f : charObj.getFields()) {
                sb.append("    private ").append(f.getJavaType()).append(" ").append(f.getFieldName())
                  .append(";  // ").append(charObj.getTpCharacter()).append(" ").append(f.getColumnType()).append("\n");
            }
        }

        sb.append("\n");

        // Getters and setters
        for (Characteristic charObj : prop.getCharacteristics()) {
            for (CharacteristicField f : charObj.getFields()) {
                String getterName;
                if ("Boolean".equals(f.getJavaType())) {
                    getterName = "is" + capitalize(f.getFieldName());
                } else {
                    getterName = "get" + capitalize(f.getFieldName());
                }
                String setterName = "set" + capitalize(f.getFieldName());

                sb.append("    public ").append(f.getJavaType()).append(" ").append(getterName).append("() {\n");
                sb.append("        return ").append(f.getFieldName()).append(";\n");
                sb.append("    }\n");
                sb.append("\n");
                sb.append("    public void ").append(setterName).append("(").append(f.getJavaType())
                  .append(" ").append(f.getFieldName()).append(") {\n");
                sb.append("        this.").append(f.getFieldName()).append(" = ").append(f.getFieldName()).append(";\n");
                sb.append("    }\n");
                sb.append("\n");
            }
        }

        // Add getCharValue() bridge method
        sb.append("    /**\n");
        sb.append("     * Bridge method for accessing characteristics by tp_character ID.\n");
        sb.append("     *\n");
        sb.append("     * <p><b>Use sparingly:</b> This method is provided for backward compatibility\n");
        sb.append("     * and legacy code migration. Prefer using typed getters directly\n");
        sb.append("     * (e.g., getStevilkaDokumenta() instead of getCharValue(7805)).</p>\n");
        sb.append("     *\n");
        sb.append("     * @param tpCharacter The characteristic type ID\n");
        sb.append("     * @return The characteristic value, or null if not found\n");
        sb.append("     */\n");
        sb.append("    public Object getCharValue(Integer tpCharacter) {\n");
        sb.append("        switch (tpCharacter) {\n");

        // Generate case statements for each characteristic
        for (Characteristic charObj : prop.getCharacteristics()) {
            // For multi-column characteristics, prefer the 'number' field
            CharacteristicField primaryField = null;
            for (CharacteristicField f : charObj.getFields()) {
                if ("number".equals(f.getColumnType())) {
                    primaryField = f;
                    break;
                }
            }
            if (primaryField == null) {
                primaryField = charObj.getFields().get(0);
            }

            String getterName;
            if ("Boolean".equals(primaryField.getJavaType())) {
                getterName = "is" + capitalize(primaryField.getFieldName());
            } else {
                getterName = "get" + capitalize(primaryField.getFieldName());
            }
            sb.append("            case ").append(charObj.getTpCharacter())
              .append(": return this.").append(getterName).append("();\n");
        }

        sb.append("            default: return null;\n");
        sb.append("        }\n");
        sb.append("    }\n");
        sb.append("\n");

        sb.append("}\n");

        return sb.toString();
    }

    private String capitalize(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
}
