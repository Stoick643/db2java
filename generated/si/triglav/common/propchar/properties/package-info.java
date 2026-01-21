/**
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
