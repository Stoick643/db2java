package si.triglav.common.propchar.generator.naming;

/**
 * Converts Slovenian names to valid Java identifiers.
 * Handles diacritics and converts to camelCase/PascalCase.
 */
public final class SlovenianNameConverter {

    private SlovenianNameConverter() {
        // Utility class
    }

    /**
     * Convert Slovenian name to valid Java field name (camelCase).
     */
    public static String toJavaFieldName(String name) {
        String converted = replaceDiacritics(name);
        converted = removeNonAlphanumeric(converted);

        String[] words = converted.split("\\s+");
        if (words.length == 0 || (words.length == 1 && words[0].isEmpty())) {
            return "unknown";
        }

        StringBuilder result = new StringBuilder();
        result.append(words[0].toLowerCase());

        for (int i = 1; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                result.append(capitalize(words[i]));
            }
        }

        return result.toString();
    }

    /**
     * Convert Slovenian name to valid Java class name (PascalCase).
     */
    public static String toJavaClassName(String name) {
        String converted = replaceDiacritics(name);
        converted = removeNonAlphanumeric(converted);

        String[] words = converted.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(capitalize(word));
            }
        }

        return result.length() > 0 ? result.toString() : "Unknown";
    }

    /**
     * Replace Slovenian diacritics with ASCII equivalents.
     * Uses Unicode code points to avoid encoding issues.
     */
    private static String replaceDiacritics(String name) {
        // Slovenian diacritics:
        // c with caron: \u010D (lowercase), \u010C (uppercase)
        // s with caron: \u0161 (lowercase), \u0160 (uppercase)
        // z with caron: \u017E (lowercase), \u017D (uppercase)
        // d with stroke: \u0111 (lowercase), \u0110 (uppercase)
        // c with acute: \u0107 (lowercase), \u0106 (uppercase)
        return name
            .replace('\u010D', 'c').replace('\u010C', 'C')  // c, C
            .replace('\u0161', 's').replace('\u0160', 'S')  // s, S
            .replace('\u017E', 'z').replace('\u017D', 'Z')  // z, Z
            .replace('\u0111', 'd').replace('\u0110', 'D')  // d, D
            .replace('\u0107', 'c').replace('\u0106', 'C'); // c, C (acute)
    }

    /**
     * Remove all non-alphanumeric characters except spaces.
     */
    private static String removeNonAlphanumeric(String name) {
        return name.replaceAll("[^a-zA-Z0-9\\s]", "");
    }

    /**
     * Capitalize first letter, lowercase the rest.
     */
    private static String capitalize(String word) {
        if (word == null || word.isEmpty()) {
            return word;
        }
        return Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
    }
}
