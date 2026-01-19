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


def parse_prochar_csv(filepath: str) -> Dict[int, Property]:
    """
    Parse prochar.csv with count columns.
    Format: TP_PROPERTY;SIF_OPIS;TP_CHARACTER;SIF_OPIS;CNT_NUMBER;CNT_VALUE;CNT_DATE;CNT_DESC
    """
    properties: Dict[int, Property] = {}

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
    return '''package si.triglav.bp.properties;

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
    lines.append("package si.triglav.bp.generated.properties;")
    lines.append("")

    # Imports
    imports = set()
    imports.add("import si.triglav.bp.properties.BaseProperties;")
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

    lines.append("}")
    return "\n".join(lines)


def generate_leaf_class(prop: Property) -> str:
    """Generate Level 3 leaf class (extends generated class)."""
    # Extract simple class name without _XXXX suffix for leaf
    simple_name = slovenian_to_class_name(prop.name)

    lines = []
    lines.append("package si.triglav.bp.properties;")
    lines.append("")
    lines.append(f"import si.triglav.bp.generated.properties.{prop.class_name};")
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
    lines.append("package si.triglav.bp.generated.mappers;")
    lines.append("")
    lines.append("import java.math.BigDecimal;")
    lines.append("import java.util.ArrayList;")
    lines.append("import java.util.List;")
    lines.append("")
    lines.append(f"import si.triglav.bp.properties.{leaf_class_name};")
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
    return '''package si.triglav.bp.generated.mappers;

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


def generate_factory(properties: Dict[int, Property]) -> str:
    """Generate factory with generic fromList method."""
    lines = []
    lines.append("package si.triglav.bp.generated.mappers;")
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
        lines.append(f"import si.triglav.bp.generated.mappers.{prop.class_name}_Mapper;")

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
    csv_path = os.path.join(script_dir, 'docs', 'prochar.csv')
    base_output_dir = os.path.join(script_dir, 'generated')

    print(f"Parsing {csv_path}...")
    all_properties = parse_prochar_csv(csv_path)

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
    filepath = os.path.join(base_output_dir, 'si', 'triglav', 'bp', 'properties', 'BaseProperties.java')
    write_file(filepath, generate_base_properties())

    # Level 2: Generated property classes
    for prop in properties.values():
        filepath = os.path.join(base_output_dir, 'si', 'triglav', 'bp', 'generated', 'properties', f"{prop.class_name}.java")
        write_file(filepath, generate_property_class(prop))

    # Level 3: Leaf classes (only if not exist)
    for prop in properties.values():
        simple_name = slovenian_to_class_name(prop.name)
        filepath = os.path.join(base_output_dir, 'si', 'triglav', 'bp', 'properties', f"{simple_name}.java")
        write_file(filepath, generate_leaf_class(prop), overwrite=False)

    # Mappers
    for prop in properties.values():
        filepath = os.path.join(base_output_dir, 'si', 'triglav', 'bp', 'generated', 'mappers', f"{prop.class_name}_Mapper.java")
        write_file(filepath, generate_mapper_class(prop))

    # Interface
    filepath = os.path.join(base_output_dir, 'si', 'triglav', 'bp', 'generated', 'mappers', 'PropertyMapper.java')
    write_file(filepath, generate_interface())

    # Factory (always includes ALL properties for complete registry)
    filepath = os.path.join(base_output_dir, 'si', 'triglav', 'bp', 'generated', 'mappers', 'PropertyMapperFactory.java')
    write_file(filepath, generate_factory(all_properties))

    total_files = 1 + len(properties) * 3 + 2  # BaseProperties + (prop + leaf + mapper) * N + interface + factory
    print(f"\nDone! Generated {total_files} files.")


if __name__ == '__main__':
    main()
