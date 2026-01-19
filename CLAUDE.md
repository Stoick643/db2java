# Project: db2java

## Overview
Python generator that creates typed Java classes from DB2 EAV (Entity-Attribute-Value) pattern.
Converts `prochar.csv` database export into strongly-typed property classes with mappers.

## Architecture (3-Level)
```
Level 1: BaseProperties (abstract)
    └── equals(), hashCode(), toString() via reflection

Level 2: OsebniDokument_7744 (generated - DO NOT EDIT)
    └── Fields, getters/setters for all characteristics

Level 3: OsebniDokument (customizable - SAFE TO EDIT)
    └── Add business logic here
```

## Key Files
- `generate_classes.py` - Python generator (single source of truth)
- `docs/prochar.csv` - Database export (input)
- `generated/` - All generated Java files (output)

## Regenerate Classes
```bash
python generate_classes.py
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
