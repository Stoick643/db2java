#!/usr/bin/env python3
"""
Generator for strongly-typed Java classes from DB2 EAV pattern.
Parses prochar.csv and generates property classes, mappers, and factory.
Supports multi-column characteristics and 3-level architecture.
"""

import argparse
import csv
import os
import re
from collections import defaultdict
from dataclasses import dataclass, field
from typing import Dict, List, Tuple

# Configuration
THRESHOLD = 5  # Ignore counts <= this value as data errors
POC_FILTER = None  # Set to {7744, 7741, 7742} for POC mode

# Type mappings
TYPE_MAP = {
    'number': 'Integer',
    'value': 'BigDecimal',
    'date': 'SimpleDate',
    'desc': 'String'
}

GETTER_MAP = {
    'number': 'getPch_number()',
    'value': 'getPch_value()',
    'date': 'getPch_date()',
    'desc': 'getPch_desc()'
}

SETTER_MAP = {
    'number': 'setPch_number',
    'value': 'setPch_value',
    'date': 'setPch_date',
    'desc': 'setPch_desc'
}


def load_boolean_mappings(filepath: str) -> Dict[int, Dict[str, int]]:
    """Load boolean characteristic mappings from CSV.
    Returns: {tp_character: {"true": true_val, "false": false_val}}
    """
    mappings = {}
    if not os.path.exists(filepath):
        return mappings

    with open(filepath, 'r', encoding='utf-8') as f:
        reader = csv.reader(f)
        next(reader)  # Skip header
        for row in reader:
            if len(row) >= 3:
                tp_char = int(row[0].strip())
                true_val = int(row[1].strip())
                false_val = int(row[2].strip())
                mappings[tp_char] = {"true": true_val, "false": false_val}
    return mappings


@dataclass
class CharacteristicField:
    """Represents a single field for a characteristic (may have multiple if multi-column)."""
    field_name: str
    java_type: str
    column_type: str  # 'number', 'value', 'date', 'desc'


@dataclass
class Characteristic:
    """Represents a tp_character with one or more fields."""
    tp_character: int
    name: str
    fields: List[CharacteristicField] = field(default_factory=list)
    is_boolean: bool = False
    boolean_true_val: int = None
    boolean_false_val: int = None


@dataclass
class Property:
    """Represents a tp_property with its characteristics."""
    tp_property: int
    name: str
    class_name: str
    characteristics: List[Characteristic] = field(default_factory=list)


def slovenian_to_java_name(name: str) -> str:
    """Convert Slovenian name to valid Java field name (camelCase)."""
    replacements = {
        'č': 'c', 'Č': 'C', 'š': 's', 'Š': 'S',
        'ž': 'z', 'Ž': 'Z', 'đ': 'd', 'Đ': 'D', 'ć': 'c', 'Ć': 'C'
    }
    for slo, java in replacements.items():
        name = name.replace(slo, java)

    name = re.sub(r'[^a-zA-Z0-9\s]', '', name)
    words = name.split()
    if not words:
        return "unknown"

    result = words[0].lower()
    for word in words[1:]:
        if word:
            result += word.capitalize()
    return result


def slovenian_to_class_name(name: str) -> str:
    """Convert Slovenian name to valid Java class name (PascalCase)."""
    replacements = {
        'č': 'c', 'Č': 'C', 'š': 's', 'Š': 'S',
        'ž': 'z', 'Ž': 'Z', 'đ': 'd', 'Đ': 'D', 'ć': 'c', 'Ć': 'C'
    }
    for slo, java in replacements.items():
        name = name.replace(slo, java)

    name = re.sub(r'[^a-zA-Z0-9\s]', '', name)
    words = name.split()
    result = ''.join(word.capitalize() for word in words if word)
    return result if result else "Unknown"


def parse_prochar_csv(filepath: str, boolean_mappings: Dict[int, Dict[str, int]] = None) -> Dict[int, Property]:
    """
    Parse prochar.csv with count columns.
    Format: TP_PROPERTY;SIF_OPIS;TP_CHARACTER;SIF_OPIS;CNT_NUMBER;CNT_VALUE;CNT_DATE;CNT_DESC
    """
    properties: Dict[int, Property] = {}
    if boolean_mappings is None:
        boolean_mappings = {}

    with open(filepath, 'r', encoding='cp1250') as f:
        reader = csv.reader(f, delimiter=';')
        header = next(reader)  # Skip header

        for row in reader:
            if len(row) < 8:
                continue

            try:
                tp_property = int(row[0])
                prop_name = row[1]
                tp_character = int(row[2])
                char_name = row[3]
                cnt_number = int(row[4]) if row[4] else 0
                cnt_value = int(row[5]) if row[5] else 0
                cnt_date = int(row[6]) if row[6] else 0
                cnt_desc = int(row[7]) if row[7] else 0

                # Determine which columns are active (above threshold)
                active_columns = []
                if cnt_number > THRESHOLD:
                    active_columns.append(('number', cnt_number))
                if cnt_value > THRESHOLD:
                    active_columns.append(('value', cnt_value))
                if cnt_date > THRESHOLD:
                    active_columns.append(('date', cnt_date))
                if cnt_desc > THRESHOLD:
                    active_columns.append(('desc', cnt_desc))

                # Skip if no active columns
                if not active_columns:
                    continue

                # Create property if not exists
                if tp_property not in properties:
                    class_name = slovenian_to_class_name(prop_name)
                    properties[tp_property] = Property(
                        tp_property=tp_property,
                        name=prop_name,
                        class_name=f"{class_name}_{tp_property}"
                    )

                # Create characteristic with fields
                base_field_name = slovenian_to_java_name(char_name)
                is_multi_column = len(active_columns) > 1

                char = Characteristic(tp_character=tp_character, name=char_name)

                # Check if this is a boolean characteristic
                if tp_character in boolean_mappings:
                    char.is_boolean = True
                    char.boolean_true_val = boolean_mappings[tp_character]["true"]
                    char.boolean_false_val = boolean_mappings[tp_character]["false"]
                    # Override field type to Boolean (single field)
                    char.fields = [CharacteristicField(
                        field_name=base_field_name,
                        java_type='Boolean',
                        column_type='boolean'
                    )]
                else:
                    for col_type, _ in active_columns:
                        if is_multi_column:
                            field_name = f"{base_field_name}_{col_type}"
                        else:
                            field_name = base_field_name

                        char.fields.append(CharacteristicField(
                            field_name=field_name,
                            java_type=TYPE_MAP[col_type],
                            column_type=col_type
                        ))

                properties[tp_property].characteristics.append(char)

            except (ValueError, IndexError) as e:
                print(f"Warning: skipping row: {e}")
                continue

    return properties


def generate_base_properties() -> str:
    """Generate BaseProperties abstract class."""
    return '''package si.triglav.common.propchar.properties;

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
'''


def generate_property_class(prop: Property) -> str:
    """Generate Level 2 property class (extends BaseProperties)."""
    lines = []
    lines.append("package si.triglav.common.propchar.generated.properties;")
    lines.append("")

    # Imports
    imports = set()
    imports.add("import si.triglav.common.propchar.properties.BaseProperties;")
    for char in prop.characteristics:
        for f in char.fields:
            if f.java_type == 'BigDecimal':
                imports.add("import java.math.BigDecimal;")
            elif f.java_type == 'SimpleDate':
                imports.add("import si.triglav.common.SimpleDate;")

    for imp in sorted(imports):
        lines.append(imp)
    lines.append("")

    # Class declaration
    lines.append(f"/**")
    lines.append(f" * Typed class for TP_PROPERTY={prop.tp_property} ({prop.name})")
    lines.append(f" * Generated - do not edit manually.")
    lines.append(f" */")
    lines.append(f"public class {prop.class_name} extends BaseProperties {{")
    lines.append("")
    lines.append("    private static final long serialVersionUID = 1L;")
    lines.append("")

    # Fields
    for char in prop.characteristics:
        for f in char.fields:
            lines.append(f"    private {f.java_type} {f.field_name};  // {char.tp_character} {f.column_type}")

    lines.append("")

    # Getters and setters
    for char in prop.characteristics:
        for f in char.fields:
            # Use "is" prefix for Boolean, "get" for others
            if f.java_type == 'Boolean':
                getter_name = "is" + f.field_name[0].upper() + f.field_name[1:]
            else:
                getter_name = "get" + f.field_name[0].upper() + f.field_name[1:]
            setter_name = "set" + f.field_name[0].upper() + f.field_name[1:]

            lines.append(f"    public {f.java_type} {getter_name}() {{")
            lines.append(f"        return {f.field_name};")
            lines.append(f"    }}")
            lines.append("")
            lines.append(f"    public void {setter_name}({f.java_type} {f.field_name}) {{")
            lines.append(f"        this.{f.field_name} = {f.field_name};")
            lines.append(f"    }}")
            lines.append("")

    # Add getCharValue() bridge method
    lines.append("    /**")
    lines.append("     * Bridge method for accessing characteristics by tp_character ID.")
    lines.append("     *")
    lines.append("     * <p><b>Use sparingly:</b> This method is provided for backward compatibility")
    lines.append("     * and legacy code migration. Prefer using typed getters directly")
    lines.append("     * (e.g., getStevilkaDokumenta() instead of getCharValue(7805)).</p>")
    lines.append("     *")
    lines.append("     * @param tpCharacter The characteristic type ID")
    lines.append("     * @return The characteristic value, or null if not found")
    lines.append("     */")
    lines.append("    public Object getCharValue(Integer tpCharacter) {")
    lines.append("        switch (tpCharacter) {")

    # Generate case statements for each characteristic
    for char in prop.characteristics:
        # For multi-column characteristics, prefer the 'number' field
        # Otherwise, use the first (and only) field
        primary_field = None
        for f in char.fields:
            if f.column_type == 'number':
                primary_field = f
                break
        if primary_field is None:
            primary_field = char.fields[0]

        # Use "is" prefix for Boolean, "get" for others
        if primary_field.java_type == 'Boolean':
            getter_name = "is" + primary_field.field_name[0].upper() + primary_field.field_name[1:]
        else:
            getter_name = "get" + primary_field.field_name[0].upper() + primary_field.field_name[1:]
        lines.append(f"            case {char.tp_character}: return this.{getter_name}();")

    lines.append("            default: return null;")
    lines.append("        }")
    lines.append("    }")
    lines.append("")

    lines.append("}")
    return "\n".join(lines)


def generate_leaf_class(prop: Property) -> str:
    """Generate Level 3 leaf class (extends generated class)."""
    # Extract simple class name without _XXXX suffix for leaf
    simple_name = slovenian_to_class_name(prop.name)

    lines = []
    lines.append("package si.triglav.common.propchar.properties;")
    lines.append("")
    lines.append(f"import si.triglav.common.propchar.generated.properties.{prop.class_name};")
    lines.append("")
    lines.append(f"/**")
    lines.append(f" * Concrete implementation for {prop.name}.")
    lines.append(f" * Use this class in your application code.")
    lines.append(f" * This file will NOT be overwritten by the generator.")
    lines.append(f" */")
    lines.append(f"public class {simple_name} extends {prop.class_name} {{")
    lines.append("")
    lines.append("    private static final long serialVersionUID = 1L;")
    lines.append("")
    lines.append(f"    public {simple_name}() {{")
    lines.append("        super();")
    lines.append("    }")
    lines.append("")
    lines.append("    // Add custom business logic here")
    lines.append("}")
    return "\n".join(lines)


def generate_mapper_class(prop: Property) -> str:
    """Generate mapper class with fromList/toList methods."""
    # Level 3 class name (without _XXXX suffix)
    leaf_class_name = slovenian_to_class_name(prop.name)

    lines = []
    lines.append("package si.triglav.common.propchar.generated.mappers;")
    lines.append("")
    lines.append("import java.math.BigDecimal;")
    lines.append("import java.util.ArrayList;")
    lines.append("import java.util.List;")
    lines.append("")
    lines.append(f"import si.triglav.common.propchar.properties.{leaf_class_name};")
    lines.append("import si.triglav.common.SimpleDate;")
    lines.append("import si.triglav.common.vao.bp.PCharacteristicVAO;")
    lines.append("")
    lines.append(f"/**")
    lines.append(f" * Mapper for TP_PROPERTY={prop.tp_property} ({prop.name})")
    lines.append(f" * Generated - do not edit manually.")
    lines.append(f" */")
    lines.append(f"public class {prop.class_name}_Mapper implements PropertyMapper<{leaf_class_name}> {{")
    lines.append("")

    # fromList method
    lines.append("    @Override")
    lines.append(f"    public {leaf_class_name} fromList(List<PCharacteristicVAO> characteristics) {{")
    lines.append(f"        {leaf_class_name} result = new {leaf_class_name}();")
    lines.append("")
    lines.append("        for (PCharacteristicVAO pch : characteristics) {")
    lines.append("            switch (pch.getTp_character()) {")

    for char in prop.characteristics:
        lines.append(f"                case {char.tp_character}:")
        if char.is_boolean:
            f = char.fields[0]
            setter_name = "set" + f.field_name[0].upper() + f.field_name[1:]
            lines.append(f"                    result.{setter_name}(pch.getPch_number() != null && pch.getPch_number() == {char.boolean_true_val});")
        else:
            for f in char.fields:
                setter_name = "set" + f.field_name[0].upper() + f.field_name[1:]
                getter = GETTER_MAP[f.column_type]
                lines.append(f"                    result.{setter_name}(pch.{getter});")
        lines.append("                    break;")

    lines.append("            }")
    lines.append("        }")
    lines.append("")
    lines.append("        return result;")
    lines.append("    }")
    lines.append("")

    # toList method
    lines.append("    @Override")
    lines.append(f"    public List<PCharacteristicVAO> toList({leaf_class_name} obj, Integer idPersProperty) {{")
    lines.append("        List<PCharacteristicVAO> result = new ArrayList<>();")
    lines.append("")

    for char in prop.characteristics:
        if char.is_boolean:
            f = char.fields[0]
            getter_name = "is" + f.field_name[0].upper() + f.field_name[1:]
            lines.append(f"        if (obj.{getter_name}() != null) {{")
            lines.append(f"            PCharacteristicVAO pch = new PCharacteristicVAO();")
            lines.append(f"            pch.setId_pers_property(idPersProperty);")
            lines.append(f"            pch.setTp_character({char.tp_character});")
            lines.append(f"            pch.setPch_number(obj.{getter_name}() ? {char.boolean_true_val} : {char.boolean_false_val});")
            lines.append(f"            result.add(pch);")
            lines.append(f"        }}")
        else:
            for f in char.fields:
                getter_name = "get" + f.field_name[0].upper() + f.field_name[1:]
                setter = SETTER_MAP[f.column_type]

                lines.append(f"        if (obj.{getter_name}() != null) {{")
                lines.append(f"            PCharacteristicVAO pch = new PCharacteristicVAO();")
                lines.append(f"            pch.setId_pers_property(idPersProperty);")
                lines.append(f"            pch.setTp_character({char.tp_character});")
                lines.append(f"            pch.{setter}(obj.{getter_name}());")
                lines.append(f"            result.add(pch);")
                lines.append(f"        }}")

    lines.append("")
    lines.append("        return result;")
    lines.append("    }")
    lines.append("")

    # updateList method
    lines.append("    @Override")
    lines.append(f"    public void updateList({leaf_class_name} obj, List<PCharacteristicVAO> characteristics) {{")

    for char in prop.characteristics:
        if char.is_boolean:
            f = char.fields[0]
            getter_name = "is" + f.field_name[0].upper() + f.field_name[1:]
            lines.append(f"        updateOrAddBoolean(characteristics, {char.tp_character}, obj.{getter_name}(), {char.boolean_true_val}, {char.boolean_false_val});")
        else:
            for f in char.fields:
                getter_name = "get" + f.field_name[0].upper() + f.field_name[1:]
                lines.append(f"        updateOrAdd(characteristics, {char.tp_character}, obj.{getter_name}(), \"{f.column_type}\");")

    lines.append("    }")
    lines.append("")

    # Helper: findByTpCharacter
    lines.append("    private PCharacteristicVAO findByTpCharacter(List<PCharacteristicVAO> list, int tpChar) {")
    lines.append("        for (PCharacteristicVAO pch : list) {")
    lines.append("            if (pch.getTp_character() != null && pch.getTp_character() == tpChar) {")
    lines.append("                return pch;")
    lines.append("            }")
    lines.append("        }")
    lines.append("        return null;")
    lines.append("    }")
    lines.append("")

    # Helper: updateOrAdd
    lines.append("    private void updateOrAdd(List<PCharacteristicVAO> list, int tpChar, Object value, String type) {")
    lines.append("        if (value == null) return;")
    lines.append("        PCharacteristicVAO existing = findByTpCharacter(list, tpChar);")
    lines.append("        if (existing != null) {")
    lines.append("            setValue(existing, value, type);")
    lines.append("        } else {")
    lines.append("            PCharacteristicVAO pch = new PCharacteristicVAO();")
    lines.append("            pch.setTp_character(tpChar);")
    lines.append("            setValue(pch, value, type);")
    lines.append("            list.add(pch);")
    lines.append("        }")
    lines.append("    }")
    lines.append("")

    # Helper: updateOrAddBoolean
    lines.append("    private void updateOrAddBoolean(List<PCharacteristicVAO> list, int tpChar, Boolean value, int trueVal, int falseVal) {")
    lines.append("        if (value == null) return;")
    lines.append("        PCharacteristicVAO existing = findByTpCharacter(list, tpChar);")
    lines.append("        if (existing != null) {")
    lines.append("            existing.setPch_number(value ? trueVal : falseVal);")
    lines.append("        } else {")
    lines.append("            PCharacteristicVAO pch = new PCharacteristicVAO();")
    lines.append("            pch.setTp_character(tpChar);")
    lines.append("            pch.setPch_number(value ? trueVal : falseVal);")
    lines.append("            list.add(pch);")
    lines.append("        }")
    lines.append("    }")
    lines.append("")

    # Helper: setValue
    lines.append("    private void setValue(PCharacteristicVAO pch, Object value, String type) {")
    lines.append("        switch (type) {")
    lines.append("            case \"desc\": pch.setPch_desc((String) value); break;")
    lines.append("            case \"number\": pch.setPch_number((Integer) value); break;")
    lines.append("            case \"date\": pch.setPch_date((SimpleDate) value); break;")
    lines.append("            case \"value\": pch.setPch_value((BigDecimal) value); break;")
    lines.append("        }")
    lines.append("    }")
    lines.append("")

    # getPropertyClass method
    lines.append("    @Override")
    lines.append(f"    public Class<{leaf_class_name}> getPropertyClass() {{")
    lines.append(f"        return {leaf_class_name}.class;")
    lines.append("    }")
    lines.append("}")

    return "\n".join(lines)


def generate_interface() -> str:
    """Generate PropertyMapper interface with generics."""
    return '''package si.triglav.common.propchar.generated.mappers;

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
'''


def generate_properties_package_info() -> str:
    """Generate package-info.java for si.triglav.common.propchar.properties."""
    return '''/**
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
'''


def generate_generated_properties_package_info() -> str:
    """Generate package-info.java for si.triglav.common.propchar.generated.properties."""
    return '''/**
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
'''


def generate_mappers_package_info() -> str:
    """Generate package-info.java for si.triglav.common.propchar.generated.mappers."""
    return '''/**
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
'''


def generate_factory(properties: Dict[int, Property]) -> str:
    """Generate factory with generic fromList method."""
    lines = []
    lines.append("package si.triglav.common.propchar.generated.mappers;")
    lines.append("")
    lines.append("import java.util.ArrayList;")
    lines.append("import java.util.HashMap;")
    lines.append("import java.util.List;")
    lines.append("import java.util.Map;")
    lines.append("")
    lines.append("import si.triglav.common.vao.bp.PCharacteristicVAO;")

    # Import all mappers
    for tp_property in sorted(properties.keys()):
        prop = properties[tp_property]
        lines.append(f"import si.triglav.common.propchar.generated.mappers.{prop.class_name}_Mapper;")

    lines.append("")
    lines.append("/**")
    lines.append(" * Factory for property mappers.")
    lines.append(" * Generated - do not edit manually.")
    lines.append(" */")
    lines.append("public class PropertyMapperFactory {")
    lines.append("")
    lines.append("    private static final Map<Class<?>, PropertyMapper<?>> registryByClass = new HashMap<>();")
    lines.append("    private static final Map<Integer, PropertyMapper<?>> registryByTpProperty = new HashMap<>();")
    lines.append("")
    lines.append("    static {")

    for tp_property in sorted(properties.keys()):
        prop = properties[tp_property]
        lines.append(f"        register(new {prop.class_name}_Mapper(), {tp_property});")

    lines.append("    }")
    lines.append("")
    lines.append("    private static <T> void register(PropertyMapper<T> mapper, Integer tpProperty) {")
    lines.append("        registryByClass.put(mapper.getPropertyClass(), mapper);")
    lines.append("        registryByTpProperty.put(tpProperty, mapper);")
    lines.append("    }")
    lines.append("")

    # Generic fromList by class
    lines.append("    @SuppressWarnings(\"unchecked\")")
    lines.append("    public static <T> T fromList(Class<T> clazz, List<PCharacteristicVAO> characteristics) {")
    lines.append("        PropertyMapper<T> mapper = (PropertyMapper<T>) registryByClass.get(clazz);")
    lines.append("        if (mapper == null) {")
    lines.append("            throw new IllegalArgumentException(\"No mapper for class: \" + clazz.getName());")
    lines.append("        }")
    lines.append("        return mapper.fromList(characteristics);")
    lines.append("    }")
    lines.append("")

    # Generic toList by class
    lines.append("    @SuppressWarnings(\"unchecked\")")
    lines.append("    public static <T> List<PCharacteristicVAO> toList(T obj, Integer idPersProperty) {")
    lines.append("        PropertyMapper<T> mapper = (PropertyMapper<T>) registryByClass.get(obj.getClass());")
    lines.append("        if (mapper == null) {")
    lines.append("            throw new IllegalArgumentException(\"No mapper for class: \" + obj.getClass().getName());")
    lines.append("        }")
    lines.append("        return mapper.toList(obj, idPersProperty);")
    lines.append("    }")
    lines.append("")

    # Generic updateList by class
    lines.append("    @SuppressWarnings(\"unchecked\")")
    lines.append("    public static <T> void updateList(T obj, List<PCharacteristicVAO> characteristics) {")
    lines.append("        PropertyMapper<T> mapper = (PropertyMapper<T>) registryByClass.get(obj.getClass());")
    lines.append("        if (mapper == null) {")
    lines.append("            throw new IllegalArgumentException(\"No mapper for class: \" + obj.getClass().getName());")
    lines.append("        }")
    lines.append("        mapper.updateList(obj, characteristics);")
    lines.append("    }")
    lines.append("")

    # Check if mapper exists
    lines.append("    public static boolean hasMapper(Class<?> clazz) {")
    lines.append("        return registryByClass.containsKey(clazz);")
    lines.append("    }")
    lines.append("")
    lines.append("    public static boolean hasMapper(Integer tpProperty) {")
    lines.append("        return registryByTpProperty.containsKey(tpProperty);")
    lines.append("    }")
    lines.append("}")

    return "\n".join(lines)


def write_file(filepath: str, content: str, overwrite: bool = True):
    """Write content to file, creating directories if needed."""
    if not overwrite and os.path.exists(filepath):
        print(f"Skipped (exists): {filepath}")
        return

    os.makedirs(os.path.dirname(filepath), exist_ok=True)
    with open(filepath, 'w', encoding='utf-8') as f:
        f.write(content)
    print(f"Generated: {filepath}")


def main():
    # Parse command-line arguments
    parser = argparse.ArgumentParser(description='Generate typed Java classes from prochar.csv')
    parser.add_argument('--tp', type=int, help='Generate only this tp_property (e.g., --tp 7744)')
    args = parser.parse_args()

    script_dir = os.path.dirname(os.path.abspath(__file__))
    project_dir = os.path.dirname(script_dir)  # Go up from python/ to project root
    csv_path = os.path.join(project_dir, 'docs', 'prochar.csv')
    base_output_dir = os.path.join(project_dir, 'generated')

    # Load boolean mappings
    boolean_csv = os.path.join(project_dir, 'docs', 'booleans.csv')
    boolean_mappings = load_boolean_mappings(boolean_csv)
    print(f"Loaded {len(boolean_mappings)} boolean mappings")

    print(f"Parsing {csv_path}...")
    all_properties = parse_prochar_csv(csv_path, boolean_mappings)

    print(f"\nFound {len(all_properties)} properties")

    # Count multi-column characteristics
    multi_col_count = 0
    for prop in all_properties.values():
        for char in prop.characteristics:
            if len(char.fields) > 1:
                multi_col_count += 1
                print(f"  Multi-column: {prop.tp_property}/{char.tp_character} ({char.name})")

    print(f"\nMulti-column characteristics: {multi_col_count}")

    # Filter for single tp_property if specified
    if args.tp:
        if args.tp not in all_properties:
            print(f"\nError: tp_property {args.tp} not found in CSV")
            return
        properties = {args.tp: all_properties[args.tp]}
        print(f"\nSingle property mode: generating only tp_property={args.tp}")
    elif POC_FILTER:
        properties = {k: v for k, v in all_properties.items() if k in POC_FILTER}
        print(f"\nPOC mode: generating only {len(properties)} properties")
    else:
        properties = all_properties

    print("\nGenerating Java files...")

    # Level 1: BaseProperties (manual package)
    filepath = os.path.join(base_output_dir, 'si', 'triglav', 'common', 'propchar', 'properties', 'BaseProperties.java')
    write_file(filepath, generate_base_properties())

    # Level 2: Generated property classes
    for prop in properties.values():
        filepath = os.path.join(base_output_dir, 'si', 'triglav', 'common', 'propchar', 'generated', 'properties', f"{prop.class_name}.java")
        write_file(filepath, generate_property_class(prop))

    # Level 3: Leaf classes (only if not exist)
    for prop in properties.values():
        simple_name = slovenian_to_class_name(prop.name)
        filepath = os.path.join(base_output_dir, 'si', 'triglav', 'common', 'propchar', 'properties', f"{simple_name}.java")
        write_file(filepath, generate_leaf_class(prop), overwrite=False)

    # Mappers
    for prop in properties.values():
        filepath = os.path.join(base_output_dir, 'si', 'triglav', 'common', 'propchar', 'generated', 'mappers', f"{prop.class_name}_Mapper.java")
        write_file(filepath, generate_mapper_class(prop))

    # Interface
    filepath = os.path.join(base_output_dir, 'si', 'triglav', 'common', 'propchar', 'generated', 'mappers', 'PropertyMapper.java')
    write_file(filepath, generate_interface())

    # Factory (always includes ALL properties for complete registry)
    filepath = os.path.join(base_output_dir, 'si', 'triglav', 'common', 'propchar', 'generated', 'mappers', 'PropertyMapperFactory.java')
    write_file(filepath, generate_factory(all_properties))

    # Package-info files
    print("\nGenerating package-info.java files...")

    # package-info for properties package (Level 1 + Level 3)
    filepath = os.path.join(base_output_dir, 'si', 'triglav', 'common', 'propchar', 'properties', 'package-info.java')
    write_file(filepath, generate_properties_package_info())

    # package-info for generated properties package (Level 2)
    filepath = os.path.join(base_output_dir, 'si', 'triglav', 'common', 'propchar', 'generated', 'properties', 'package-info.java')
    write_file(filepath, generate_generated_properties_package_info())

    # package-info for mappers package
    filepath = os.path.join(base_output_dir, 'si', 'triglav', 'common', 'propchar', 'generated', 'mappers', 'package-info.java')
    write_file(filepath, generate_mappers_package_info())

    total_files = 1 + len(properties) * 3 + 2 + 3  # BaseProperties + (prop + leaf + mapper) * N + interface + factory + 3 package-info
    print(f"\nDone! Generated {total_files} files.")


if __name__ == '__main__':
    main()
