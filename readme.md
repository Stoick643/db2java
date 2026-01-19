# Project Context: DB2 EAV Pattern to Strongly-Typed Java Classes

## Background

Working on Triglav insurance company codebase. We have an Entity-Attribute-Value (EAV) pattern in DB2:

- Table `bp.person_property` (metadata about properties)
- Table `bp.p_characteristic` (actual values in 4 columns: PCH_NUMBER, PCH_VALUE, PCH_DATE, PCH_DESC)
- Only ONE of the 4 value columns is non-null per row
- Each `TP_PROPERTY` type has specific `TP_CHARACTER` fields with consistent data types

## Goal

Transform generic `List<PCharacteristic>` into strongly-typed Java classes for better type safety and maintainability.

## Data Files

You have two key documents uploaded in this conversation:

1. **Metadata query results** - shows which column (PCH_NUMBER/PCH_VALUE/PCH_DATE/PCH_DESC) is used for each (TP_PROPERTY, TP_CHARACTER) pair
2. **Cipher mappings** - shows human-readable names for TP_PROPERTY and TP_CHARACTER codes

## Type Mappings

- `PCH_NUMBER` → `Integer`
- `PCH_VALUE` → `BigDecimal`
- `PCH_DATE` → `SimpleDate` (custom class, extends java.sql.Date)
- `PCH_DESC` → `String`

## Naming Conventions

### Class Names
Format: `{SlovenianName}_{TP_PROPERTY_CODE}`

Example: `OsebniDokument_7744`

### Field Names
- camelCase
- Remove spaces
- Replace special characters: č→c, š→s, ž→z
- Example: `"Datum izdaje"` → `datumIzdaje`

## Code Generation Tasks

### Task 1: Generate Typed Classes

For each TP_PROPERTY, create a Java class with:
- Fields for each TP_CHARACTER (ignore rows where active_column = "none")
- Proper types based on which PCH_* column is active
- Standard getters/setters

**Example for TP_PROPERTY=7744:**

```java
public class OsebniDokument_7744 {
    private Integer vrstaDokumenta;           // 7806 PCH_NUMBER
    private SimpleDate datumIzdaje;           // 7807 PCH_DATE
    private SimpleDate konecVeljavnosti;      // 7808 PCH_DATE
    private Integer konecVeljavnostiPermanentno; // 9111 PCH_NUMBER
    
    // getters/setters
    public Integer getVrstaDokumenta() {
        return vrstaDokumenta;
    }
    
    public void setVrstaDokumenta(Integer vrstaDokumenta) {
        this.vrstaDokumenta = vrstaDokumenta;
    }
    
    // ... etc for all fields
}
```

### Task 2: Generate Mapper Classes

For each TP_PROPERTY, create a bidirectional mapper:

```java
public class OsebniDokument_7744_Mapper implements PropertyMapper {
    
    @Override
    public OsebniDokument_7744 toTyped(List<PCharacteristic> characteristics) {
        OsebniDokument_7744 result = new OsebniDokument_7744();
        
        for (PCharacteristic pch : characteristics) {
            switch (pch.getTpCharacter()) {
                case 7806:
                    result.setVrstaDokumenta(pch.getPchNumber());
                    break;
                case 7807:
                    result.setDatumIzdaje(pch.getPchDate());
                    break;
                case 7808:
                    result.setKonecVeljavnosti(pch.getPchDate());
                    break;
                case 9111:
                    result.setKonecVeljavnostiPermanentno(pch.getPchNumber());
                    break;
            }
        }
        
        return result;
    }
    
    @Override
    public List<PCharacteristic> fromTyped(Object typedObject, Integer idPersProperty) {
        OsebniDokument_7744 obj = (OsebniDokument_7744) typedObject;
        List<PCharacteristic> result = new ArrayList<>();
        
        if (obj.getVrstaDokumenta() != null) {
            result.add(createPChar(idPersProperty, 7806, obj.getVrstaDokumenta(), null, null, null));
        }
        if (obj.getDatumIzdaje() != null) {
            result.add(createPChar(idPersProperty, 7807, null, null, obj.getDatumIzdaje(), null));
        }
        if (obj.getKonecVeljavnosti() != null) {
            result.add(createPChar(idPersProperty, 7808, null, null, obj.getKonecVeljavnosti(), null));
        }
        if (obj.getKonecVeljavnostiPermanentno() != null) {
            result.add(createPChar(idPersProperty, 9111, obj.getKonecVeljavnostiPermanentno(), null, null, null));
        }
        
        return result;
    }
    
    private PCharacteristic createPChar(Integer idPersProperty, Integer tpChar, 
                                        Integer pchNum, BigDecimal pchVal, 
                                        SimpleDate pchDate, String pchDesc) {
        PCharacteristic pch = new PCharacteristic();
        pch.setIdPersProperty(idPersProperty);
        pch.setTpCharacter(tpChar);
        pch.setPchNumber(pchNum);
        pch.setPchValue(pchVal);
        pch.setPchDate(pchDate);
        pch.setPchDesc(pchDesc);
        return pch;
    }
}
```

### Task 3: Generate Factory

Create `PropertyMapperFactory` with registry pattern:

```java
public class PropertyMapperFactory {
    private Map<Integer, PropertyMapper> registry = new HashMap<>();
    
    public PropertyMapperFactory() {
        // Register all mappers
        registry.put(7744, new OsebniDokument_7744_Mapper());
        registry.put(7741, new Telefon_7741_Mapper());
        registry.put(7742, new KontaktEmailNaslov_7742_Mapper());
        // ... all other mappers
    }
    
    public Object toTyped(Integer tpProperty, List<PCharacteristic> characteristics) {
        PropertyMapper mapper = registry.get(tpProperty);
        if (mapper == null) {
            return null; // or throw exception
        }
        return mapper.toTyped(characteristics);
    }
    
    public List<PCharacteristic> fromTyped(Integer tpProperty, Object typedObject, Integer idPersProperty) {
        PropertyMapper mapper = registry.get(tpProperty);
        if (mapper == null) {
            return new ArrayList<>(); // or throw exception
        }
        return mapper.fromTyped(typedObject, idPersProperty);
    }
}
```

### Supporting Interface

```java
public interface PropertyMapper {
    Object toTyped(List<PCharacteristic> characteristics);
    List<PCharacteristic> fromTyped(Object typedObject, Integer idPersProperty);
}
```

## Phase 2 Considerations

Some (TP_PROPERTY, TP_CHARACTER) pairs have violations where 2+ columns are non-null. For now, **skip these** - we'll handle them later.

Examples of violations to skip:
- `7741, 7840`: both PCH_DESC and PCH_NUMBER
- `7744, 7805`: both PCH_DATE and PCH_DESC
- `7744, 8018`: both PCH_DATE and PCH_DESC

## Output Structure

Generate all files in proper package structure:

```
si/triglav/bp/generated/
├── properties/
│   ├── OsebniDokument_7744.java
│   ├── Telefon_7741.java
│   ├── KontaktEmailNaslov_7742.java
│   └── ... (all ~50 property classes)
├── mappers/
│   ├── PropertyMapper.java (interface)
│   ├── OsebniDokument_7744_Mapper.java
│   ├── Telefon_7741_Mapper.java
│   ├── KontaktEmailNaslov_7742_Mapper.java
│   └── ... (all ~50 mapper classes)
└── PropertyMapperFactory.java
```

## Getting Started

**Start with:** Parse the uploaded data documents and generate 2-3 example classes + mappers to validate the approach before generating all ~50 classes.

### Recommended First Steps:

1. Parse the metadata documents
2. Create data structures to hold the parsed information
3. Generate example classes for TP_PROPERTY: 7744, 7741, 7742
4. Validate output with Darko
5. Generate all remaining classes
6. Create factory with complete registry

## Notes

- Ignore all rows where `active_column = "none"`
- Handle Slovenian characters in field names properly
- Ensure all generated code compiles
- Follow Java naming conventions strictly
- Add proper JavaDoc comments if time permits
