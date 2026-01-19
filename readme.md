# db2java

Python generator that creates strongly-typed Java classes from DB2 EAV (Entity-Attribute-Value) pattern.

## Quick Start

```bash
# Generate all Java classes
python generate_classes.py
```

## Usage in Java

```java
import si.triglav.bp.properties.OsebniDokument;
import si.triglav.bp.generated.mappers.PropertyMapperFactory;

// Read from VAO
List<PCharacteristicVAO> characteristics = personPropertyVAO.getPCharacteristicList();
OsebniDokument dokument = PropertyMapperFactory.fromList(OsebniDokument.class, characteristics);

// Access with type-safe getters
String stevilka = dokument.getStevilkaDokumenta();
SimpleDate izdaja = dokument.getDatumIzdaje();

// Modify and update in place (preserves database IDs)
dokument.setKonecVeljavnosti(new SimpleDate(2035, 12, 31));
PropertyMapperFactory.updateList(dokument, characteristics);
```

## Architecture (3-Level)

```
Level 1: BaseProperties (abstract)
         └── equals(), hashCode(), toString()

Level 2: OsebniDokument_7744 (generated - DO NOT EDIT)
         └── Fields and getters/setters

Level 3: OsebniDokument (customizable)
         └── Add your business logic here
```

Always use Level 3 classes in your code (e.g., `OsebniDokument`, not `OsebniDokument_7744`).

## API Reference

| Method | Description |
|--------|-------------|
| `PropertyMapperFactory.fromList(Class, List)` | Convert characteristics to typed object |
| `PropertyMapperFactory.toList(Object, idPersProperty)` | Create new characteristic list |
| `PropertyMapperFactory.updateList(Object, List)` | Update existing list in place (preserves IDs) |
| `PropertyMapperFactory.hasMapper(Class)` | Check if mapper exists |

## Project Structure

```
db2java/
├── generate_classes.py          # Python generator
├── docs/
│   └── prochar.csv              # Database export (input)
├── generated/
│   └── si/triglav/bp/
│       ├── properties/          # Level 3 classes (customizable)
│       │   ├── BaseProperties.java
│       │   ├── OsebniDokument.java
│       │   └── ...
│       └── generated/
│           ├── properties/      # Level 2 classes (do not edit)
│           │   ├── OsebniDokument_7744.java
│           │   └── ...
│           └── mappers/         # Mappers and factory
│               ├── PropertyMapper.java
│               ├── PropertyMapperFactory.java
│               ├── OsebniDokument_7744_Mapper.java
│               └── ...
└── java/                        # Reference VAO classes
```

## Regenerating Classes

When database schema changes:

1. Export new `prochar.csv` from database
2. Run `python generate_classes.py`
3. Level 2 classes and mappers are overwritten
4. Level 3 classes are preserved (not overwritten if they exist)

## Type Mappings

| DB Column | Java Type |
|-----------|-----------|
| PCH_NUMBER | Integer |
| PCH_VALUE | BigDecimal |
| PCH_DATE | SimpleDate |
| PCH_DESC | String |
