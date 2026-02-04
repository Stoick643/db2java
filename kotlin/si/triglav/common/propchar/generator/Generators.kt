package si.triglav.common.propchar.generator

/**
 * Java code generators for all output files.
 */
object Generators {

    /** Generate BaseProperties abstract class. */
    fun generateBaseProperties(): String = """package si.triglav.common.propchar.properties;

import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Common logic for all property classes.
 * Generated - do not edit manually.
 */
public abstract class BaseProperties implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
"""

    /** Generate Level 2 property class (extends BaseProperties). */
    fun generatePropertyClass(prop: Property): String = buildString {
        appendLine("package si.triglav.common.propchar.generated.properties;")
        appendLine()

        // Imports
        val imports = mutableSetOf("import si.triglav.common.propchar.properties.BaseProperties;")
        for (char in prop.characteristics) {
            for (f in char.fields) {
                when (f.javaType) {
                    "BigDecimal" -> imports.add("import java.math.BigDecimal;")
                    "SimpleDate" -> imports.add("import si.triglav.common.SimpleDate;")
                }
            }
        }
        imports.sorted().forEach { appendLine(it) }
        appendLine()

        // Class declaration
        appendLine("/**")
        appendLine(" * Typed class for TP_PROPERTY=${prop.tpProperty} (${prop.name})")
        appendLine(" * Generated - do not edit manually.")
        appendLine(" */")
        appendLine("public class ${prop.className} extends BaseProperties {")
        appendLine()
        appendLine("    private static final long serialVersionUID = 1L;")
        appendLine()

        // Fields
        for (char in prop.characteristics) {
            for (f in char.fields) {
                appendLine("    private ${f.javaType} ${f.fieldName};  // ${char.tpCharacter} ${f.columnType}")
            }
        }
        appendLine()

        // Getters and setters
        for (char in prop.characteristics) {
            for (f in char.fields) {
                val getterPrefix = if (f.javaType == "Boolean") "is" else "get"
                val getterName = "$getterPrefix${f.fieldName.replaceFirstChar { it.uppercaseChar() }}"
                val setterName = "set${f.fieldName.replaceFirstChar { it.uppercaseChar() }}"

                appendLine("    public ${f.javaType} $getterName() {")
                appendLine("        return ${f.fieldName};")
                appendLine("    }")
                appendLine()
                appendLine("    public void $setterName(${f.javaType} ${f.fieldName}) {")
                appendLine("        this.${f.fieldName} = ${f.fieldName};")
                appendLine("    }")
                appendLine()
            }
        }

        // Bridge method getCharValue()
        appendLine("    /**")
        appendLine("     * Bridge method for accessing characteristics by tp_character ID.")
        appendLine("     *")
        appendLine("     * <p><b>Use sparingly:</b> This method is provided for backward compatibility")
        appendLine("     * and legacy code migration. Prefer using typed getters directly")
        appendLine("     * (e.g., getStevilkaDokumenta() instead of getCharValue(7805)).</p>")
        appendLine("     *")
        appendLine("     * @param tpCharacter The characteristic type ID")
        appendLine("     * @return The characteristic value, or null if not found")
        appendLine("     */")
        appendLine("    public Object getCharValue(Integer tpCharacter) {")
        appendLine("        switch (tpCharacter) {")

        for (char in prop.characteristics) {
            // Prefer 'number' field for multi-column, otherwise first field
            val primaryField = char.fields.find { it.columnType == "number" } ?: char.fields.first()
            val getterPrefix = if (primaryField.javaType == "Boolean") "is" else "get"
            val getterName = "$getterPrefix${primaryField.fieldName.replaceFirstChar { it.uppercaseChar() }}"
            appendLine("            case ${char.tpCharacter}: return this.$getterName();")
        }

        appendLine("            default: return null;")
        appendLine("        }")
        appendLine("    }")
        appendLine()
        appendLine("}")
    }

    /** Generate Level 3 leaf class (extends generated class). */
    fun generateLeafClass(prop: Property): String {
        val simpleName = SlovenianNameConverter.toClassName(prop.name)
        return """package si.triglav.common.propchar.properties;

import si.triglav.common.propchar.generated.properties.${prop.className};

/**
 * Concrete implementation for ${prop.name}.
 * Use this class in your application code.
 * This file will NOT be overwritten by the generator.
 */
public class $simpleName extends ${prop.className} {

    private static final long serialVersionUID = 1L;

    public $simpleName() {
        super();
    }

    // Add custom business logic here
}
"""
    }

    /** Generate mapper class with fromList/toList methods. */
    fun generateMapperClass(prop: Property): String = buildString {
        val leafClassName = SlovenianNameConverter.toClassName(prop.name)

        appendLine("package si.triglav.common.propchar.generated.mappers;")
        appendLine()
        appendLine("import java.math.BigDecimal;")
        appendLine("import java.util.ArrayList;")
        appendLine("import java.util.List;")
        appendLine()
        appendLine("import si.triglav.common.propchar.properties.$leafClassName;")
        appendLine("import si.triglav.common.SimpleDate;")
        appendLine("import si.triglav.common.vao.bp.PCharacteristicVAO;")
        appendLine()
        appendLine("/**")
        appendLine(" * Mapper for TP_PROPERTY=${prop.tpProperty} (${prop.name})")
        appendLine(" * Generated - do not edit manually.")
        appendLine(" */")
        appendLine("public class ${prop.className}_Mapper implements PropertyMapper<$leafClassName> {")
        appendLine()

        // fromList method
        appendLine("    @Override")
        appendLine("    public $leafClassName fromList(List<PCharacteristicVAO> characteristics) {")
        appendLine("        $leafClassName result = new $leafClassName();")
        appendLine()
        appendLine("        for (PCharacteristicVAO pch : characteristics) {")
        appendLine("            switch (pch.getTp_character()) {")

        for (char in prop.characteristics) {
            appendLine("                case ${char.tpCharacter}:")
            if (char.isBoolean) {
                val f = char.fields.first()
                val setterName = "set${f.fieldName.replaceFirstChar { it.uppercaseChar() }}"
                appendLine("                    result.$setterName(pch.getPch_number() != null && pch.getPch_number() == ${char.booleanTrueVal});")
            } else {
                for (f in char.fields) {
                    val setterName = "set${f.fieldName.replaceFirstChar { it.uppercaseChar() }}"
                    val getter = GeneratorConfig.GETTER_MAP[f.columnType]
                    appendLine("                    result.$setterName(pch.$getter);")
                }
            }
            appendLine("                    break;")
        }

        appendLine("            }")
        appendLine("        }")
        appendLine()
        appendLine("        return result;")
        appendLine("    }")
        appendLine()

        // toList method
        appendLine("    @Override")
        appendLine("    public List<PCharacteristicVAO> toList($leafClassName obj, Integer idPersProperty) {")
        appendLine("        List<PCharacteristicVAO> result = new ArrayList<>();")
        appendLine()

        for (char in prop.characteristics) {
            if (char.isBoolean) {
                val f = char.fields.first()
                val getterName = "is${f.fieldName.replaceFirstChar { it.uppercaseChar() }}"
                appendLine("        if (obj.$getterName() != null) {")
                appendLine("            PCharacteristicVAO pch = new PCharacteristicVAO();")
                appendLine("            pch.setId_pers_property(idPersProperty);")
                appendLine("            pch.setTp_character(${char.tpCharacter});")
                appendLine("            pch.setPch_number(obj.$getterName() ? ${char.booleanTrueVal} : ${char.booleanFalseVal});")
                appendLine("            result.add(pch);")
                appendLine("        }")
            } else {
                for (f in char.fields) {
                    val getterName = "get${f.fieldName.replaceFirstChar { it.uppercaseChar() }}"
                    val setter = GeneratorConfig.SETTER_MAP[f.columnType]
                    appendLine("        if (obj.$getterName() != null) {")
                    appendLine("            PCharacteristicVAO pch = new PCharacteristicVAO();")
                    appendLine("            pch.setId_pers_property(idPersProperty);")
                    appendLine("            pch.setTp_character(${char.tpCharacter});")
                    appendLine("            pch.$setter(obj.$getterName());")
                    appendLine("            result.add(pch);")
                    appendLine("        }")
                }
            }
        }

        appendLine()
        appendLine("        return result;")
        appendLine("    }")
        appendLine()

        // updateList method
        appendLine("    @Override")
        appendLine("    public void updateList($leafClassName obj, List<PCharacteristicVAO> characteristics) {")

        for (char in prop.characteristics) {
            if (char.isBoolean) {
                val f = char.fields.first()
                val getterName = "is${f.fieldName.replaceFirstChar { it.uppercaseChar() }}"
                appendLine("        updateOrAddBoolean(characteristics, ${char.tpCharacter}, obj.$getterName(), ${char.booleanTrueVal}, ${char.booleanFalseVal});")
            } else {
                for (f in char.fields) {
                    val getterName = "get${f.fieldName.replaceFirstChar { it.uppercaseChar() }}"
                    appendLine("        updateOrAdd(characteristics, ${char.tpCharacter}, obj.$getterName(), \"${f.columnType}\");")
                }
            }
        }

        appendLine("    }")
        appendLine()

        // Helper methods
        appendLine("    private PCharacteristicVAO findByTpCharacter(List<PCharacteristicVAO> list, int tpChar) {")
        appendLine("        for (PCharacteristicVAO pch : list) {")
        appendLine("            if (pch.getTp_character() != null && pch.getTp_character() == tpChar) {")
        appendLine("                return pch;")
        appendLine("            }")
        appendLine("        }")
        appendLine("        return null;")
        appendLine("    }")
        appendLine()

        appendLine("    private void updateOrAdd(List<PCharacteristicVAO> list, int tpChar, Object value, String type) {")
        appendLine("        if (value == null) return;")
        appendLine("        PCharacteristicVAO existing = findByTpCharacter(list, tpChar);")
        appendLine("        if (existing != null) {")
        appendLine("            setValue(existing, value, type);")
        appendLine("        } else {")
        appendLine("            PCharacteristicVAO pch = new PCharacteristicVAO();")
        appendLine("            pch.setTp_character(tpChar);")
        appendLine("            setValue(pch, value, type);")
        appendLine("            list.add(pch);")
        appendLine("        }")
        appendLine("    }")
        appendLine()

        appendLine("    private void updateOrAddBoolean(List<PCharacteristicVAO> list, int tpChar, Boolean value, int trueVal, int falseVal) {")
        appendLine("        if (value == null) return;")
        appendLine("        PCharacteristicVAO existing = findByTpCharacter(list, tpChar);")
        appendLine("        if (existing != null) {")
        appendLine("            existing.setPch_number(value ? trueVal : falseVal);")
        appendLine("        } else {")
        appendLine("            PCharacteristicVAO pch = new PCharacteristicVAO();")
        appendLine("            pch.setTp_character(tpChar);")
        appendLine("            pch.setPch_number(value ? trueVal : falseVal);")
        appendLine("            list.add(pch);")
        appendLine("        }")
        appendLine("    }")
        appendLine()

        appendLine("    private void setValue(PCharacteristicVAO pch, Object value, String type) {")
        appendLine("        switch (type) {")
        appendLine("            case \"desc\": pch.setPch_desc((String) value); break;")
        appendLine("            case \"number\": pch.setPch_number((Integer) value); break;")
        appendLine("            case \"date\": pch.setPch_date((SimpleDate) value); break;")
        appendLine("            case \"value\": pch.setPch_value((BigDecimal) value); break;")
        appendLine("        }")
        appendLine("    }")
        appendLine()

        appendLine("    @Override")
        appendLine("    public Class<$leafClassName> getPropertyClass() {")
        appendLine("        return $leafClassName.class;")
        appendLine("    }")
        append("}")
    }

    /** Generate PropertyMapper interface. */
    fun generateInterface(): String = """package si.triglav.common.propchar.generated.mappers;

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
"""

    /** Generate factory with generic fromList method. */
    fun generateFactory(properties: Map<Int, Property>): String = buildString {
        appendLine("package si.triglav.common.propchar.generated.mappers;")
        appendLine()
        appendLine("import java.util.ArrayList;")
        appendLine("import java.util.HashMap;")
        appendLine("import java.util.List;")
        appendLine("import java.util.Map;")
        appendLine()
        appendLine("import si.triglav.common.vao.bp.PCharacteristicVAO;")

        // Import all mappers
        properties.keys.sorted().forEach { tpProperty ->
            val prop = properties[tpProperty]!!
            appendLine("import si.triglav.common.propchar.generated.mappers.${prop.className}_Mapper;")
        }

        appendLine()
        appendLine("/**")
        appendLine(" * Factory for property mappers.")
        appendLine(" * Generated - do not edit manually.")
        appendLine(" */")
        appendLine("public class PropertyMapperFactory {")
        appendLine()
        appendLine("    private static final Map<Class<?>, PropertyMapper<?>> registryByClass = new HashMap<>();")
        appendLine("    private static final Map<Integer, PropertyMapper<?>> registryByTpProperty = new HashMap<>();")
        appendLine()
        appendLine("    static {")

        properties.keys.sorted().forEach { tpProperty ->
            val prop = properties[tpProperty]!!
            appendLine("        register(new ${prop.className}_Mapper(), $tpProperty);")
        }

        appendLine("    }")
        appendLine()
        appendLine("    private static <T> void register(PropertyMapper<T> mapper, Integer tpProperty) {")
        appendLine("        registryByClass.put(mapper.getPropertyClass(), mapper);")
        appendLine("        registryByTpProperty.put(tpProperty, mapper);")
        appendLine("    }")
        appendLine()

        appendLine("    @SuppressWarnings(\"unchecked\")")
        appendLine("    public static <T> T fromList(Class<T> clazz, List<PCharacteristicVAO> characteristics) {")
        appendLine("        PropertyMapper<T> mapper = (PropertyMapper<T>) registryByClass.get(clazz);")
        appendLine("        if (mapper == null) {")
        appendLine("            throw new IllegalArgumentException(\"No mapper for class: \" + clazz.getName());")
        appendLine("        }")
        appendLine("        return mapper.fromList(characteristics);")
        appendLine("    }")
        appendLine()

        appendLine("    @SuppressWarnings(\"unchecked\")")
        appendLine("    public static <T> List<PCharacteristicVAO> toList(T obj, Integer idPersProperty) {")
        appendLine("        PropertyMapper<T> mapper = (PropertyMapper<T>) registryByClass.get(obj.getClass());")
        appendLine("        if (mapper == null) {")
        appendLine("            throw new IllegalArgumentException(\"No mapper for class: \" + obj.getClass().getName());")
        appendLine("        }")
        appendLine("        return mapper.toList(obj, idPersProperty);")
        appendLine("    }")
        appendLine()

        appendLine("    @SuppressWarnings(\"unchecked\")")
        appendLine("    public static <T> void updateList(T obj, List<PCharacteristicVAO> characteristics) {")
        appendLine("        PropertyMapper<T> mapper = (PropertyMapper<T>) registryByClass.get(obj.getClass());")
        appendLine("        if (mapper == null) {")
        appendLine("            throw new IllegalArgumentException(\"No mapper for class: \" + obj.getClass().getName());")
        appendLine("        }")
        appendLine("        mapper.updateList(obj, characteristics);")
        appendLine("    }")
        appendLine()

        appendLine("    public static boolean hasMapper(Class<?> clazz) {")
        appendLine("        return registryByClass.containsKey(clazz);")
        appendLine("    }")
        appendLine()
        appendLine("    public static boolean hasMapper(Integer tpProperty) {")
        appendLine("        return registryByTpProperty.containsKey(tpProperty);")
        appendLine("    }")
        append("}")
    }

    /** Generate package-info.java for si.triglav.common.propchar.properties. */
    fun generatePropertiesPackageInfo(): String = """/**
 * Primary entry point for typed property classes.
 *
 * <p>This package contains the 3-level property class architecture:</p>
 * <ul>
 *   <li><b>Level 1 (Base)</b>: {@link si.triglav.common.propchar.properties.BaseProperties}
 *       - Abstract base class providing reflection-based equals(), hashCode(), and toString()</li>
 *   <li><b>Level 3 (Leaf)</b>: 77 concrete classes like
 *       {@link si.triglav.common.propchar.properties.OsebniDokument},
 *       {@link si.triglav.common.propchar.properties.Telefon}, etc.</li>
 * </ul>
 *
 * <h2>Usage Guidelines</h2>
 *
 * <p><b>Use leaf classes from this package</b> in your application code:</p>
 * <pre>{@code
 * // Correct - use leaf class
 * OsebniDokument doc = PropertyMapperFactory.fromList(OsebniDokument.class, characteristics);
 *
 * // Wrong - don't use generated class directly
 * OsebniDokument_7744 doc = PropertyMapperFactory.fromList(OsebniDokument_7744.class, characteristics);
 * }</pre>
 *
 * <h2>Customization</h2>
 *
 * <p>Leaf classes in this package are <b>safe to edit</b> and will NOT be overwritten by the generator.
 * Add custom business logic, validation, or derived getters to leaf classes:</p>
 * <pre>{@code
 * public class OsebniDokument extends OsebniDokument_7744 {
 *     // Custom method - safe to add
 *     public boolean isExpired() {
 *         return getKonecVeljavnosti() != null &&
 *                getKonecVeljavnosti().before(new SimpleDate());
 *     }
 * }
 * }</pre>
 *
 * <h2>Related Packages</h2>
 * <ul>
 *   <li>{@link si.triglav.common.propchar.generated.properties} - Generated Level 2 classes (internal, do not use directly)</li>
 *   <li>{@link si.triglav.common.propchar.generated.mappers} - Mappers for EAV conversion</li>
 * </ul>
 *
 * @see si.triglav.common.propchar.generated.mappers.PropertyMapperFactory
 * @see si.triglav.common.propchar.properties.BaseProperties
 */
package si.triglav.common.propchar.properties;
"""

    /** Generate package-info.java for si.triglav.common.propchar.generated.properties. */
    fun generateGeneratedPropertiesPackageInfo(): String = """/**
 * Generated Level 2 typed property classes - DO NOT USE DIRECTLY.
 *
 * <p><b>WARNING</b>: This package contains auto-generated classes that are regenerated from
 * {@code docs/prochar.csv}. These files will be <b>overwritten</b> whenever the generator runs.
 * <b>DO NOT EDIT</b> any files in this package.</p>
 *
 * <h2>Architecture Role</h2>
 *
 * <p>This package contains Level 2 generated classes (e.g., {@code OsebniDokument_7744}) that:</p>
 * <ul>
 *   <li>Extend {@link si.triglav.common.propchar.properties.BaseProperties}</li>
 *   <li>Provide typed fields for all characteristics (e.g., stevilkaDokumenta, vrstaDokumenta)</li>
 *   <li>Provide getters/setters for type-safe access</li>
 *   <li>Include {@code getCharValue(Integer tpCharacter)} bridge method for legacy compatibility</li>
 * </ul>
 *
 * <h2>DO NOT Use These Classes Directly</h2>
 *
 * <p>Application code should <b>never import</b> classes from this package. Instead, use the
 * leaf classes from {@link si.triglav.common.propchar.properties}:</p>
 * <pre>{@code
 * // Correct - use leaf class from parent package
 * import si.triglav.common.propchar.properties.OsebniDokument;
 * OsebniDokument doc = PropertyMapperFactory.fromList(OsebniDokument.class, characteristics);
 *
 * // Wrong - don't use generated class directly
 * import si.triglav.common.propchar.generated.properties.OsebniDokument_7744;
 * OsebniDokument_7744 doc = ...; // DON'T DO THIS
 * }</pre>
 *
 * <h2>Class Naming Convention</h2>
 *
 * <p>Generated classes follow the pattern: {@code ClassName_TPPROPERTY}
 * (e.g., {@code OsebniDokument_7744}, {@code Telefon_7741})
 * where the numeric suffix is the TP_PROPERTY database identifier.</p>
 *
 * <h2>Generation</h2>
 *
 * <p>These classes are generated by running:</p>
 * <pre>{@code
 * python generate_classes.py
 * }</pre>
 *
 * <p>The generator parses {@code docs/prochar.csv} which contains the database schema
 * (TP_PROPERTY, TP_CHARACTER, column usage counts).</p>
 *
 * @see si.triglav.common.propchar.properties
 * @see si.triglav.common.propchar.properties.BaseProperties
 */
package si.triglav.common.propchar.generated.properties;
"""

    /** Generate package-info.java for si.triglav.common.propchar.generated.mappers. */
    fun generateMappersPackageInfo(): String = """/**
 * Mappers for converting between EAV and typed property objects.
 *
 * <p>This package contains the conversion layer between the database EAV (Entity-Attribute-Value)
 * representation ({@code List<PCharacteristicVAO>}) and strongly-typed property objects.</p>
 *
 * <h2>Primary Entry Point</h2>
 *
 * <p>Use {@link si.triglav.common.propchar.generated.mappers.PropertyMapperFactory} static methods
 * for all conversions. Do NOT use individual mapper classes directly.</p>
 *
 * <h2>Core Operations</h2>
 *
 * <h3>1. Reading from Database (EAV to Typed Object)</h3>
 * <pre>{@code
 * List<PCharacteristicVAO> characteristics = property.getCharacteristics();
 * OsebniDokument doc = PropertyMapperFactory.fromList(OsebniDokument.class, characteristics);
 *
 * // Access typed fields
 * String docNumber = doc.getStevilkaDokumenta();
 * SimpleDate expiry = doc.getKonecVeljavnosti();
 * }</pre>
 *
 * <h3>2. Creating New Property (Typed Object to EAV)</h3>
 * <pre>{@code
 * OsebniDokument doc = new OsebniDokument();
 * doc.setStevilkaDokumenta("12345678");
 * doc.setKonecVeljavnosti(new SimpleDate(2030, 1, 1));
 *
 * // Convert to EAV for database INSERT
 * Integer idPersProperty = 999; // from PersonPropertyVAO
 * List<PCharacteristicVAO> characteristics = PropertyMapperFactory.toList(doc, idPersProperty);
 * property.setCharacteristics(characteristics);
 * }</pre>
 *
 * <h3>3. Updating Existing Property (In-Place Update)</h3>
 * <pre>{@code
 * // Load existing property
 * PersonPropertyVAO property = ...; // from database
 * List<PCharacteristicVAO> characteristics = property.getCharacteristics();
 *
 * // Convert to typed object, modify, and update in-place
 * OsebniDokument doc = PropertyMapperFactory.fromList(OsebniDokument.class, characteristics);
 * doc.setKonecVeljavnosti(new SimpleDate(2035, 1, 1));
 *
 * // Update characteristics list in-place (preserves IDs for database UPDATE)
 * PropertyMapperFactory.updateList(doc, characteristics);
 *
 * // Save property back to database
 * }</pre>
 *
 * <h2>Architecture</h2>
 *
 * <p>This package contains:</p>
 * <ul>
 *   <li><b>{@link si.triglav.common.propchar.generated.mappers.PropertyMapper}</b> -
 *       Generic interface defining fromList(), toList(), and updateList() methods</li>
 *   <li><b>{@link si.triglav.common.propchar.generated.mappers.PropertyMapperFactory}</b> -
 *       Central registry and factory providing static convenience methods</li>
 *   <li><b>77 mapper implementations</b> - One per property type (e.g., OsebniDokument_7744_Mapper)</li>
 * </ul>
 *
 * <h2>Key Methods</h2>
 *
 * <table border="1" cellpadding="5">
 *   <tr>
 *     <th>Method</th>
 *     <th>Purpose</th>
 *     <th>Use Case</th>
 *   </tr>
 *   <tr>
 *     <td>{@code fromList<T>(Class<T>, List<PCharacteristicVAO>)}</td>
 *     <td>EAV → Typed Object</td>
 *     <td>Reading from database</td>
 *   </tr>
 *   <tr>
 *     <td>{@code toList<T>(T, Integer)}</td>
 *     <td>Typed Object → EAV</td>
 *     <td>Creating new property (INSERT)</td>
 *   </tr>
 *   <tr>
 *     <td>{@code updateList<T>(T, List<PCharacteristicVAO>)}</td>
 *     <td>In-place update</td>
 *     <td>Updating existing property (UPDATE, preserves IDs)</td>
 *   </tr>
 * </table>
 *
 * <h2>Benefits Over Direct EAV Access</h2>
 *
 * <ul>
 *   <li><b>Type Safety</b>: Compile-time checking instead of runtime casting</li>
 *   <li><b>Readability</b>: {@code doc.getDatumIzdaje()} vs {@code findFirstCharacteristic(7807)}</li>
 *   <li><b>IDE Support</b>: Autocomplete, refactoring, find usages</li>
 *   <li><b>Maintainability</b>: Field names document purpose (no magic numbers)</li>
 * </ul>
 *
 * <h2>Generation</h2>
 *
 * <p><b>WARNING</b>: All files in this package are auto-generated. <b>DO NOT EDIT</b>.</p>
 * <p>Regenerate by running: {@code python generate_classes.py}</p>
 *
 * @see si.triglav.common.propchar.generated.mappers.PropertyMapperFactory
 * @see si.triglav.common.propchar.properties
 */
package si.triglav.common.propchar.generated.mappers;
"""
}
