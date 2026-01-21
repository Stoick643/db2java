/**
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
