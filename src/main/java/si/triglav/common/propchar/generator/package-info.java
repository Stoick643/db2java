/**
 * Java code generator for strongly-typed property classes from DB2 EAV pattern.
 *
 * <p>This package contains a generator that parses {@code docs/prochar.csv} and produces
 * typed Java classes for the 3-level property architecture.</p>
 *
 * <h2>Usage</h2>
 * <pre>{@code
 * # Generate all properties
 * java si.triglav.common.propchar.generator.GeneratorMain
 *
 * # Generate single property
 * java si.triglav.common.propchar.generator.GeneratorMain --tp 7744
 * }</pre>
 *
 * <h2>Package Structure</h2>
 * <ul>
 *   <li>{@link si.triglav.common.propchar.generator.GeneratorMain} - Entry point with main()</li>
 *   <li>{@link si.triglav.common.propchar.generator.GeneratorConfig} - Constants and type mappings</li>
 *   <li>{@code model/} - POJOs: Property, Characteristic, CharacteristicField, BooleanMapping</li>
 *   <li>{@code parser/} - CSV parsing: CsvParser, BooleanMappingLoader</li>
 *   <li>{@code naming/} - Name conversion: SlovenianNameConverter</li>
 *   <li>{@code output/} - Code generators for each file type</li>
 *   <li>{@code util/} - FileWriter utility</li>
 * </ul>
 *
 * <h2>Generated Output</h2>
 * <p>The generator produces files in three packages:</p>
 * <ul>
 *   <li>{@code si.triglav.common.propchar.properties} - Level 1 base + Level 3 leaf classes</li>
 *   <li>{@code si.triglav.common.propchar.generated.properties} - Level 2 generated classes</li>
 *   <li>{@code si.triglav.common.propchar.generated.mappers} - Mappers and factory</li>
 * </ul>
 *
 * @see si.triglav.common.propchar.generator.GeneratorMain
 */
package si.triglav.common.propchar.generator;
