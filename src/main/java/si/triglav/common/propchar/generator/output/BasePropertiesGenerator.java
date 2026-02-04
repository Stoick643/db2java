package si.triglav.common.propchar.generator.output;

/**
 * Generates BaseProperties abstract class (Level 1).
 */
public class BasePropertiesGenerator {

    public String generate() {
        return "package si.triglav.common.propchar.properties;\n" +
            "\n" +
            "import java.io.Serializable;\n" +
            "import org.apache.commons.lang3.builder.EqualsBuilder;\n" +
            "import org.apache.commons.lang3.builder.HashCodeBuilder;\n" +
            "import org.apache.commons.lang3.builder.ToStringBuilder;\n" +
            "import org.apache.commons.lang3.builder.ToStringStyle;\n" +
            "\n" +
            "/**\n" +
            " * Common logic for all property classes.\n" +
            " * Generated - do not edit manually.\n" +
            " */\n" +
            "public abstract class BaseProperties implements Serializable {\n" +
            "    private static final long serialVersionUID = 1L;\n" +
            "\n" +
            "    @Override\n" +
            "    public boolean equals(Object obj) {\n" +
            "        return EqualsBuilder.reflectionEquals(this, obj);\n" +
            "    }\n" +
            "\n" +
            "    @Override\n" +
            "    public int hashCode() {\n" +
            "        return HashCodeBuilder.reflectionHashCode(this);\n" +
            "    }\n" +
            "\n" +
            "    @Override\n" +
            "    public String toString() {\n" +
            "        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);\n" +
            "    }\n" +
            "}\n";
    }
}
