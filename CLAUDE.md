# Project: db2java

## Overview
Generator that creates typed Java classes from DB2 EAV (Entity-Attribute-Value) pattern.
Converts `prochar.csv` database export into strongly-typed property classes with mappers.
Available in Python and Kotlin implementations.

## Architecture (3-Level)
```
Level 1: BaseProperties (abstract)
    └── equals(), hashCode(), toString() via reflection

Level 2: OsebniDokument_7744 (generated - DO NOT EDIT)
    └── Fields, getters/setters for all characteristics

Level 3: OsebniDokument (customizable - SAFE TO EDIT)
    └── Add business logic here
```

## Directory Structure
```
db2java/
├── docs/                    # Input data
│   ├── prochar.csv          # Database export
│   └── booleans.csv         # Boolean characteristic mappings
├── generated/               # Output (Java files)
├── python/                  # Python generator
│   ├── generate_classes.py
│   └── test_generate_classes.py
├── java/                    # Java generator (reference)
└── kotlin/                  # Kotlin generator
```

## Regenerate Classes

### Python (primary)
```bash
python python/generate_classes.py
python python/generate_classes.py --tp 7744  # single property
```

### Kotlin
```bash
kotlinc kotlin/ -include-runtime -d generator.jar
java -jar generator.jar
```

## Java Usage
```java
// Read
OsebniDokument doc = PropertyMapperFactory.fromList(OsebniDokument.class, characteristics);

// Modify & update in place (preserves IDs)
doc.setKonecVeljavnosti(newDate);
PropertyMapperFactory.updateList(doc, characteristics);
```

## User Preferences
- Do NOT use multiple choice questions at end of responses
- User handles git commands themselves (just provide commit messages when asked)
- Keep responses concise
