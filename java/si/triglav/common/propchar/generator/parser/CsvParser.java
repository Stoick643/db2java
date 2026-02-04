package si.triglav.common.propchar.generator.parser;

import si.triglav.common.propchar.generator.GeneratorConfig;
import si.triglav.common.propchar.generator.model.BooleanMapping;
import si.triglav.common.propchar.generator.model.Characteristic;
import si.triglav.common.propchar.generator.model.CharacteristicField;
import si.triglav.common.propchar.generator.model.Property;
import si.triglav.common.propchar.generator.naming.SlovenianNameConverter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Parses prochar.csv with count columns.
 * Format: TP_PROPERTY;SIF_OPIS;TP_CHARACTER;SIF_OPIS;CNT_NUMBER;CNT_VALUE;CNT_DATE;CNT_DESC
 */
public class CsvParser {

    private static final Charset CP1250 = Charset.forName("windows-1250");

    /**
     * Parse prochar.csv and return properties map.
     *
     * @param filepath Path to prochar.csv
     * @param booleanMappings Map of boolean mappings (can be null or empty)
     * @return Map from tp_property to Property
     */
    public Map<Integer, Property> parse(String filepath, Map<Integer, BooleanMapping> booleanMappings) {
        Map<Integer, Property> properties = new LinkedHashMap<>();

        if (booleanMappings == null) {
            booleanMappings = new java.util.HashMap<>();
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filepath), CP1250))) {

            // Skip header
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                try {
                    parseLine(line, properties, booleanMappings);
                } catch (Exception e) {
                    System.err.println("Warning: skipping row: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read CSV file: " + filepath, e);
        }

        return properties;
    }

    private void parseLine(String line, Map<Integer, Property> properties,
                          Map<Integer, BooleanMapping> booleanMappings) {
        String[] parts = parseCsvLine(line);

        if (parts.length < 8) {
            return;
        }

        int tpProperty = Integer.parseInt(parts[0].trim());
        String propName = unquote(parts[1]);
        int tpCharacter = Integer.parseInt(parts[2].trim());
        String charName = unquote(parts[3]);
        int cntNumber = parseIntOrZero(parts[4]);
        int cntValue = parseIntOrZero(parts[5]);
        int cntDate = parseIntOrZero(parts[6]);
        int cntDesc = parseIntOrZero(parts[7]);

        // Determine which columns are active (above threshold)
        List<Map.Entry<String, Integer>> activeColumns = new ArrayList<>();
        if (cntNumber > GeneratorConfig.THRESHOLD) {
            activeColumns.add(new AbstractMap.SimpleEntry<>("number", cntNumber));
        }
        if (cntValue > GeneratorConfig.THRESHOLD) {
            activeColumns.add(new AbstractMap.SimpleEntry<>("value", cntValue));
        }
        if (cntDate > GeneratorConfig.THRESHOLD) {
            activeColumns.add(new AbstractMap.SimpleEntry<>("date", cntDate));
        }
        if (cntDesc > GeneratorConfig.THRESHOLD) {
            activeColumns.add(new AbstractMap.SimpleEntry<>("desc", cntDesc));
        }

        // Skip if no active columns
        if (activeColumns.isEmpty()) {
            return;
        }

        // Create property if not exists
        if (!properties.containsKey(tpProperty)) {
            String className = SlovenianNameConverter.toJavaClassName(propName);
            properties.put(tpProperty, new Property(tpProperty, propName, className + "_" + tpProperty));
        }

        // Create characteristic with fields
        String baseFieldName = SlovenianNameConverter.toJavaFieldName(charName);
        boolean isMultiColumn = activeColumns.size() > 1;

        Characteristic charObj = new Characteristic(tpCharacter, charName);

        // Check if this is a boolean characteristic
        BooleanMapping boolMapping = booleanMappings.get(tpCharacter);
        if (boolMapping != null) {
            charObj.setBoolean(true);
            charObj.setBooleanTrueVal(boolMapping.getTrueValue());
            charObj.setBooleanFalseVal(boolMapping.getFalseValue());
            // Override field type to Boolean (single field)
            charObj.addField(new CharacteristicField(baseFieldName, "Boolean", "boolean"));
        } else {
            for (Map.Entry<String, Integer> entry : activeColumns) {
                String colType = entry.getKey();
                String fieldName;
                if (isMultiColumn) {
                    fieldName = baseFieldName + "_" + colType;
                } else {
                    fieldName = baseFieldName;
                }

                charObj.addField(new CharacteristicField(
                    fieldName,
                    GeneratorConfig.TYPE_MAP.get(colType),
                    colType
                ));
            }
        }

        properties.get(tpProperty).addCharacteristic(charObj);
    }

    /**
     * Parse a semicolon-delimited CSV line, handling quoted fields.
     */
    private String[] parseCsvLine(String line) {
        List<String> parts = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '"') {
                inQuotes = !inQuotes;
                current.append(c);
            } else if (c == ';' && !inQuotes) {
                parts.add(current.toString());
                current = new StringBuilder();
            } else {
                current.append(c);
            }
        }
        parts.add(current.toString());

        return parts.toArray(new String[0]);
    }

    private String unquote(String value) {
        if (value == null) {
            return "";
        }
        value = value.trim();
        if (value.startsWith("\"") && value.endsWith("\"") && value.length() >= 2) {
            return value.substring(1, value.length() - 1);
        }
        return value;
    }

    private int parseIntOrZero(String value) {
        if (value == null || value.trim().isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
