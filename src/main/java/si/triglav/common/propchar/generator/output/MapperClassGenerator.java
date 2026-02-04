package si.triglav.common.propchar.generator.output;

import si.triglav.common.propchar.generator.GeneratorConfig;
import si.triglav.common.propchar.generator.model.Characteristic;
import si.triglav.common.propchar.generator.model.CharacteristicField;
import si.triglav.common.propchar.generator.model.Property;
import si.triglav.common.propchar.generator.naming.SlovenianNameConverter;

/**
 * Generates mapper class with fromList/toList/updateList methods.
 */
public class MapperClassGenerator {

    public String generate(Property prop) {
        // Level 3 class name (without _XXXX suffix)
        String leafClassName = SlovenianNameConverter.toJavaClassName(prop.getName());

        StringBuilder sb = new StringBuilder();

        sb.append("package si.triglav.common.propchar.generated.mappers;\n");
        sb.append("\n");
        sb.append("import java.math.BigDecimal;\n");
        sb.append("import java.util.ArrayList;\n");
        sb.append("import java.util.List;\n");
        sb.append("\n");
        sb.append("import si.triglav.common.propchar.properties.").append(leafClassName).append(";\n");
        sb.append("import si.triglav.common.SimpleDate;\n");
        sb.append("import si.triglav.common.vao.bp.PCharacteristicVAO;\n");
        sb.append("\n");
        sb.append("/**\n");
        sb.append(" * Mapper for TP_PROPERTY=").append(prop.getTpProperty())
          .append(" (").append(prop.getName()).append(")\n");
        sb.append(" * Generated - do not edit manually.\n");
        sb.append(" */\n");
        sb.append("public class ").append(prop.getClassName()).append("_Mapper implements PropertyMapper<")
          .append(leafClassName).append("> {\n");
        sb.append("\n");

        // fromList method
        sb.append("    @Override\n");
        sb.append("    public ").append(leafClassName).append(" fromList(List<PCharacteristicVAO> characteristics) {\n");
        sb.append("        ").append(leafClassName).append(" result = new ").append(leafClassName).append("();\n");
        sb.append("\n");
        sb.append("        for (PCharacteristicVAO pch : characteristics) {\n");
        sb.append("            switch (pch.getTp_character()) {\n");

        for (Characteristic charObj : prop.getCharacteristics()) {
            sb.append("                case ").append(charObj.getTpCharacter()).append(":\n");
            if (charObj.isBoolean()) {
                CharacteristicField f = charObj.getFields().get(0);
                String setterName = "set" + capitalize(f.getFieldName());
                sb.append("                    result.").append(setterName)
                  .append("(pch.getPch_number() != null && pch.getPch_number() == ")
                  .append(charObj.getBooleanTrueVal()).append(");\n");
            } else {
                for (CharacteristicField f : charObj.getFields()) {
                    String setterName = "set" + capitalize(f.getFieldName());
                    String getter = GeneratorConfig.GETTER_MAP.get(f.getColumnType());
                    sb.append("                    result.").append(setterName).append("(pch.").append(getter).append(");\n");
                }
            }
            sb.append("                    break;\n");
        }

        sb.append("            }\n");
        sb.append("        }\n");
        sb.append("\n");
        sb.append("        return result;\n");
        sb.append("    }\n");
        sb.append("\n");

        // toList method
        sb.append("    @Override\n");
        sb.append("    public List<PCharacteristicVAO> toList(").append(leafClassName)
          .append(" obj, Integer idPersProperty) {\n");
        sb.append("        List<PCharacteristicVAO> result = new ArrayList<>();\n");
        sb.append("\n");

        for (Characteristic charObj : prop.getCharacteristics()) {
            if (charObj.isBoolean()) {
                CharacteristicField f = charObj.getFields().get(0);
                String getterName = "is" + capitalize(f.getFieldName());
                sb.append("        if (obj.").append(getterName).append("() != null) {\n");
                sb.append("            PCharacteristicVAO pch = new PCharacteristicVAO();\n");
                sb.append("            pch.setId_pers_property(idPersProperty);\n");
                sb.append("            pch.setTp_character(").append(charObj.getTpCharacter()).append(");\n");
                sb.append("            pch.setPch_number(obj.").append(getterName).append("() ? ")
                  .append(charObj.getBooleanTrueVal()).append(" : ").append(charObj.getBooleanFalseVal()).append(");\n");
                sb.append("            result.add(pch);\n");
                sb.append("        }\n");
            } else {
                for (CharacteristicField f : charObj.getFields()) {
                    String getterName = "get" + capitalize(f.getFieldName());
                    String setter = GeneratorConfig.SETTER_MAP.get(f.getColumnType());

                    sb.append("        if (obj.").append(getterName).append("() != null) {\n");
                    sb.append("            PCharacteristicVAO pch = new PCharacteristicVAO();\n");
                    sb.append("            pch.setId_pers_property(idPersProperty);\n");
                    sb.append("            pch.setTp_character(").append(charObj.getTpCharacter()).append(");\n");
                    sb.append("            pch.").append(setter).append("(obj.").append(getterName).append("());\n");
                    sb.append("            result.add(pch);\n");
                    sb.append("        }\n");
                }
            }
        }

        sb.append("\n");
        sb.append("        return result;\n");
        sb.append("    }\n");
        sb.append("\n");

        // updateList method
        sb.append("    @Override\n");
        sb.append("    public void updateList(").append(leafClassName)
          .append(" obj, List<PCharacteristicVAO> characteristics) {\n");

        for (Characteristic charObj : prop.getCharacteristics()) {
            if (charObj.isBoolean()) {
                CharacteristicField f = charObj.getFields().get(0);
                String getterName = "is" + capitalize(f.getFieldName());
                sb.append("        updateOrAddBoolean(characteristics, ").append(charObj.getTpCharacter())
                  .append(", obj.").append(getterName).append("(), ").append(charObj.getBooleanTrueVal())
                  .append(", ").append(charObj.getBooleanFalseVal()).append(");\n");
            } else {
                for (CharacteristicField f : charObj.getFields()) {
                    String getterName = "get" + capitalize(f.getFieldName());
                    sb.append("        updateOrAdd(characteristics, ").append(charObj.getTpCharacter())
                      .append(", obj.").append(getterName).append("(), \"").append(f.getColumnType()).append("\");\n");
                }
            }
        }

        sb.append("    }\n");
        sb.append("\n");

        // Helper: findByTpCharacter
        sb.append("    private PCharacteristicVAO findByTpCharacter(List<PCharacteristicVAO> list, int tpChar) {\n");
        sb.append("        for (PCharacteristicVAO pch : list) {\n");
        sb.append("            if (pch.getTp_character() != null && pch.getTp_character() == tpChar) {\n");
        sb.append("                return pch;\n");
        sb.append("            }\n");
        sb.append("        }\n");
        sb.append("        return null;\n");
        sb.append("    }\n");
        sb.append("\n");

        // Helper: updateOrAdd
        sb.append("    private void updateOrAdd(List<PCharacteristicVAO> list, int tpChar, Object value, String type) {\n");
        sb.append("        if (value == null) return;\n");
        sb.append("        PCharacteristicVAO existing = findByTpCharacter(list, tpChar);\n");
        sb.append("        if (existing != null) {\n");
        sb.append("            setValue(existing, value, type);\n");
        sb.append("        } else {\n");
        sb.append("            PCharacteristicVAO pch = new PCharacteristicVAO();\n");
        sb.append("            pch.setTp_character(tpChar);\n");
        sb.append("            setValue(pch, value, type);\n");
        sb.append("            list.add(pch);\n");
        sb.append("        }\n");
        sb.append("    }\n");
        sb.append("\n");

        // Helper: updateOrAddBoolean
        sb.append("    private void updateOrAddBoolean(List<PCharacteristicVAO> list, int tpChar, Boolean value, int trueVal, int falseVal) {\n");
        sb.append("        if (value == null) return;\n");
        sb.append("        PCharacteristicVAO existing = findByTpCharacter(list, tpChar);\n");
        sb.append("        if (existing != null) {\n");
        sb.append("            existing.setPch_number(value ? trueVal : falseVal);\n");
        sb.append("        } else {\n");
        sb.append("            PCharacteristicVAO pch = new PCharacteristicVAO();\n");
        sb.append("            pch.setTp_character(tpChar);\n");
        sb.append("            pch.setPch_number(value ? trueVal : falseVal);\n");
        sb.append("            list.add(pch);\n");
        sb.append("        }\n");
        sb.append("    }\n");
        sb.append("\n");

        // Helper: setValue
        sb.append("    private void setValue(PCharacteristicVAO pch, Object value, String type) {\n");
        sb.append("        switch (type) {\n");
        sb.append("            case \"desc\": pch.setPch_desc((String) value); break;\n");
        sb.append("            case \"number\": pch.setPch_number((Integer) value); break;\n");
        sb.append("            case \"date\": pch.setPch_date((SimpleDate) value); break;\n");
        sb.append("            case \"value\": pch.setPch_value((BigDecimal) value); break;\n");
        sb.append("        }\n");
        sb.append("    }\n");
        sb.append("\n");

        // getPropertyClass method
        sb.append("    @Override\n");
        sb.append("    public Class<").append(leafClassName).append("> getPropertyClass() {\n");
        sb.append("        return ").append(leafClassName).append(".class;\n");
        sb.append("    }\n");
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
