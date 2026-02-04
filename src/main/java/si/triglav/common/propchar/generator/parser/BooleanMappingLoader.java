package si.triglav.common.propchar.generator.parser;

import si.triglav.common.propchar.generator.model.BooleanMapping;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Loads boolean characteristic mappings from CSV file.
 */
public class BooleanMappingLoader {

    /**
     * Load boolean characteristic mappings from CSV.
     *
     * @param filepath Path to booleans.csv
     * @return Map from tp_character to BooleanMapping
     */
    public Map<Integer, BooleanMapping> load(String filepath) {
        Map<Integer, BooleanMapping> mappings = new HashMap<>();
        File file = new File(filepath);

        if (!file.exists()) {
            return mappings;
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {

            // Skip header
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                // Parse CSV: tp_character, true, false
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    try {
                        int tpChar = Integer.parseInt(parts[0].trim());
                        int trueVal = Integer.parseInt(parts[1].trim());
                        int falseVal = Integer.parseInt(parts[2].trim());

                        mappings.put(tpChar, new BooleanMapping(tpChar, trueVal, falseVal));
                    } catch (NumberFormatException e) {
                        System.err.println("Warning: skipping invalid boolean mapping line: " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Warning: could not read boolean mappings file: " + e.getMessage());
        }

        return mappings;
    }
}
