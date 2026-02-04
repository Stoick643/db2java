package si.triglav.common.propchar.generator.output;

/**
 * Generates package-info.java files for the three core packages.
 */
public class PackageInfoGenerator {

    /**
     * Generate package-info.java for si.triglav.common.propchar.properties.
     */
    public String generatePropertiesPackageInfo() {
        return "/**\n" +
            " * Primary entry point for typed property classes.\n" +
            " *\n" +
            " * <p>This package contains the 3-level property class architecture:</p>\n" +
            " * <ul>\n" +
            " *   <li><b>Level 1 (Base)</b>: {@link si.triglav.common.propchar.properties.BaseProperties}\n" +
            " *       - Abstract base class providing reflection-based equals(), hashCode(), and toString()</li>\n" +
            " *   <li><b>Level 3 (Leaf)</b>: 77 concrete classes like\n" +
            " *       {@link si.triglav.common.propchar.properties.OsebniDokument},\n" +
            " *       {@link si.triglav.common.propchar.properties.Telefon}, etc.</li>\n" +
            " * </ul>\n" +
            " *\n" +
            " * <h2>Usage Guidelines</h2>\n" +
            " *\n" +
            " * <p><b>Use leaf classes from this package</b> in your application code:</p>\n" +
            " * <pre>{@code\n" +
            " * // Correct - use leaf class\n" +
            " * OsebniDokument doc = PropertyMapperFactory.fromList(OsebniDokument.class, characteristics);\n" +
            " *\n" +
            " * // Wrong - don't use generated class directly\n" +
            " * OsebniDokument_7744 doc = PropertyMapperFactory.fromList(OsebniDokument_7744.class, characteristics);\n" +
            " * }</pre>\n" +
            " *\n" +
            " * <h2>Customization</h2>\n" +
            " *\n" +
            " * <p>Leaf classes in this package are <b>safe to edit</b> and will NOT be overwritten by the generator.\n" +
            " * Add custom business logic, validation, or derived getters to leaf classes:</p>\n" +
            " * <pre>{@code\n" +
            " * public class OsebniDokument extends OsebniDokument_7744 {\n" +
            " *     // Custom method - safe to add\n" +
            " *     public boolean isExpired() {\n" +
            " *         return getKonecVeljavnosti() != null &&\n" +
            " *                getKonecVeljavnosti().before(new SimpleDate());\n" +
            " *     }\n" +
            " * }\n" +
            " * }</pre>\n" +
            " *\n" +
            " * <h2>Related Packages</h2>\n" +
            " * <ul>\n" +
            " *   <li>{@link si.triglav.common.propchar.generated.properties} - Generated Level 2 classes (internal, do not use directly)</li>\n" +
            " *   <li>{@link si.triglav.common.propchar.generated.mappers} - Mappers for EAV conversion</li>\n" +
            " * </ul>\n" +
            " *\n" +
            " * @see si.triglav.common.propchar.generated.mappers.PropertyMapperFactory\n" +
            " * @see si.triglav.common.propchar.properties.BaseProperties\n" +
            " */\n" +
            "package si.triglav.common.propchar.properties;\n";
    }

    /**
     * Generate package-info.java for si.triglav.common.propchar.generated.properties.
     */
    public String generateGeneratedPropertiesPackageInfo() {
        return "/**\n" +
            " * Generated Level 2 typed property classes - DO NOT USE DIRECTLY.\n" +
            " *\n" +
            " * <p><b>WARNING</b>: This package contains auto-generated classes that are regenerated from\n" +
            " * {@code docs/prochar.csv}. These files will be <b>overwritten</b> whenever the generator runs.\n" +
            " * <b>DO NOT EDIT</b> any files in this package.</p>\n" +
            " *\n" +
            " * <h2>Architecture Role</h2>\n" +
            " *\n" +
            " * <p>This package contains Level 2 generated classes (e.g., {@code OsebniDokument_7744}) that:</p>\n" +
            " * <ul>\n" +
            " *   <li>Extend {@link si.triglav.common.propchar.properties.BaseProperties}</li>\n" +
            " *   <li>Provide typed fields for all characteristics (e.g., stevilkaDokumenta, vrstaDokumenta)</li>\n" +
            " *   <li>Provide getters/setters for type-safe access</li>\n" +
            " *   <li>Include {@code getCharValue(Integer tpCharacter)} bridge method for legacy compatibility</li>\n" +
            " * </ul>\n" +
            " *\n" +
            " * <h2>DO NOT Use These Classes Directly</h2>\n" +
            " *\n" +
            " * <p>Application code should <b>never import</b> classes from this package. Instead, use the\n" +
            " * leaf classes from {@link si.triglav.common.propchar.properties}:</p>\n" +
            " * <pre>{@code\n" +
            " * // Correct - use leaf class from parent package\n" +
            " * import si.triglav.common.propchar.properties.OsebniDokument;\n" +
            " * OsebniDokument doc = PropertyMapperFactory.fromList(OsebniDokument.class, characteristics);\n" +
            " *\n" +
            " * // Wrong - don't use generated class directly\n" +
            " * import si.triglav.common.propchar.generated.properties.OsebniDokument_7744;\n" +
            " * OsebniDokument_7744 doc = ...; // DON'T DO THIS\n" +
            " * }</pre>\n" +
            " *\n" +
            " * <h2>Class Naming Convention</h2>\n" +
            " *\n" +
            " * <p>Generated classes follow the pattern: {@code ClassName_TPPROPERTY}\n" +
            " * (e.g., {@code OsebniDokument_7744}, {@code Telefon_7741})\n" +
            " * where the numeric suffix is the TP_PROPERTY database identifier.</p>\n" +
            " *\n" +
            " * <h2>Generation</h2>\n" +
            " *\n" +
            " * <p>These classes are generated by running:</p>\n" +
            " * <pre>{@code\n" +
            " * python generate_classes.py\n" +
            " * }</pre>\n" +
            " *\n" +
            " * <p>The generator parses {@code docs/prochar.csv} which contains the database schema\n" +
            " * (TP_PROPERTY, TP_CHARACTER, column usage counts).</p>\n" +
            " *\n" +
            " * @see si.triglav.common.propchar.properties\n" +
            " * @see si.triglav.common.propchar.properties.BaseProperties\n" +
            " */\n" +
            "package si.triglav.common.propchar.generated.properties;\n";
    }

    /**
     * Generate package-info.java for si.triglav.common.propchar.generated.mappers.
     */
    public String generateMappersPackageInfo() {
        return "/**\n" +
            " * Mappers for converting between EAV and typed property objects.\n" +
            " *\n" +
            " * <p>This package contains the conversion layer between the database EAV (Entity-Attribute-Value)\n" +
            " * representation ({@code List<PCharacteristicVAO>}) and strongly-typed property objects.</p>\n" +
            " *\n" +
            " * <h2>Primary Entry Point</h2>\n" +
            " *\n" +
            " * <p>Use {@link si.triglav.common.propchar.generated.mappers.PropertyMapperFactory} static methods\n" +
            " * for all conversions. Do NOT use individual mapper classes directly.</p>\n" +
            " *\n" +
            " * <h2>Core Operations</h2>\n" +
            " *\n" +
            " * <h3>1. Reading from Database (EAV to Typed Object)</h3>\n" +
            " * <pre>{@code\n" +
            " * List<PCharacteristicVAO> characteristics = property.getCharacteristics();\n" +
            " * OsebniDokument doc = PropertyMapperFactory.fromList(OsebniDokument.class, characteristics);\n" +
            " *\n" +
            " * // Access typed fields\n" +
            " * String docNumber = doc.getStevilkaDokumenta();\n" +
            " * SimpleDate expiry = doc.getKonecVeljavnosti();\n" +
            " * }</pre>\n" +
            " *\n" +
            " * <h3>2. Creating New Property (Typed Object to EAV)</h3>\n" +
            " * <pre>{@code\n" +
            " * OsebniDokument doc = new OsebniDokument();\n" +
            " * doc.setStevilkaDokumenta(\"12345678\");\n" +
            " * doc.setKonecVeljavnosti(new SimpleDate(2030, 1, 1));\n" +
            " *\n" +
            " * // Convert to EAV for database INSERT\n" +
            " * Integer idPersProperty = 999; // from PersonPropertyVAO\n" +
            " * List<PCharacteristicVAO> characteristics = PropertyMapperFactory.toList(doc, idPersProperty);\n" +
            " * property.setCharacteristics(characteristics);\n" +
            " * }</pre>\n" +
            " *\n" +
            " * <h3>3. Updating Existing Property (In-Place Update)</h3>\n" +
            " * <pre>{@code\n" +
            " * // Load existing property\n" +
            " * PersonPropertyVAO property = ...; // from database\n" +
            " * List<PCharacteristicVAO> characteristics = property.getCharacteristics();\n" +
            " *\n" +
            " * // Convert to typed object, modify, and update in-place\n" +
            " * OsebniDokument doc = PropertyMapperFactory.fromList(OsebniDokument.class, characteristics);\n" +
            " * doc.setKonecVeljavnosti(new SimpleDate(2035, 1, 1));\n" +
            " *\n" +
            " * // Update characteristics list in-place (preserves IDs for database UPDATE)\n" +
            " * PropertyMapperFactory.updateList(doc, characteristics);\n" +
            " *\n" +
            " * // Save property back to database\n" +
            " * }</pre>\n" +
            " *\n" +
            " * <h2>Architecture</h2>\n" +
            " *\n" +
            " * <p>This package contains:</p>\n" +
            " * <ul>\n" +
            " *   <li><b>{@link si.triglav.common.propchar.generated.mappers.PropertyMapper}</b> -\n" +
            " *       Generic interface defining fromList(), toList(), and updateList() methods</li>\n" +
            " *   <li><b>{@link si.triglav.common.propchar.generated.mappers.PropertyMapperFactory}</b> -\n" +
            " *       Central registry and factory providing static convenience methods</li>\n" +
            " *   <li><b>77 mapper implementations</b> - One per property type (e.g., OsebniDokument_7744_Mapper)</li>\n" +
            " * </ul>\n" +
            " *\n" +
            " * <h2>Key Methods</h2>\n" +
            " *\n" +
            " * <table border=\"1\" cellpadding=\"5\">\n" +
            " *   <tr>\n" +
            " *     <th>Method</th>\n" +
            " *     <th>Purpose</th>\n" +
            " *     <th>Use Case</th>\n" +
            " *   </tr>\n" +
            " *   <tr>\n" +
            " *     <td>{@code fromList<T>(Class<T>, List<PCharacteristicVAO>)}</td>\n" +
            " *     <td>EAV → Typed Object</td>\n" +
            " *     <td>Reading from database</td>\n" +
            " *   </tr>\n" +
            " *   <tr>\n" +
            " *     <td>{@code toList<T>(T, Integer)}</td>\n" +
            " *     <td>Typed Object → EAV</td>\n" +
            " *     <td>Creating new property (INSERT)</td>\n" +
            " *   </tr>\n" +
            " *   <tr>\n" +
            " *     <td>{@code updateList<T>(T, List<PCharacteristicVAO>)}</td>\n" +
            " *     <td>In-place update</td>\n" +
            " *     <td>Updating existing property (UPDATE, preserves IDs)</td>\n" +
            " *   </tr>\n" +
            " * </table>\n" +
            " *\n" +
            " * <h2>Benefits Over Direct EAV Access</h2>\n" +
            " *\n" +
            " * <ul>\n" +
            " *   <li><b>Type Safety</b>: Compile-time checking instead of runtime casting</li>\n" +
            " *   <li><b>Readability</b>: {@code doc.getDatumIzdaje()} vs {@code findFirstCharacteristic(7807)}</li>\n" +
            " *   <li><b>IDE Support</b>: Autocomplete, refactoring, find usages</li>\n" +
            " *   <li><b>Maintainability</b>: Field names document purpose (no magic numbers)</li>\n" +
            " * </ul>\n" +
            " *\n" +
            " * <h2>Generation</h2>\n" +
            " *\n" +
            " * <p><b>WARNING</b>: All files in this package are auto-generated. <b>DO NOT EDIT</b>.</p>\n" +
            " * <p>Regenerate by running: {@code python generate_classes.py}</p>\n" +
            " *\n" +
            " * @see si.triglav.common.propchar.generated.mappers.PropertyMapperFactory\n" +
            " * @see si.triglav.common.propchar.properties\n" +
            " */\n" +
            "package si.triglav.common.propchar.generated.mappers;\n";
    }
}
