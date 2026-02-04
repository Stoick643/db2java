package si.triglav.common.propchar.generator

/**
 * Converts Slovenian names to valid Java identifiers.
 */
object SlovenianNameConverter {

    /** Convert Slovenian name to valid Java field name (camelCase). */
    fun toFieldName(name: String): String {
        var result = replaceSlovenianChars(name)
        result = result.replace(Regex("[^a-zA-Z0-9\\s]"), "")
        val words = result.split(Regex("\\s+")).filter { it.isNotEmpty() }
        if (words.isEmpty()) return "unknown"

        return words[0].lowercase() + words.drop(1).joinToString("") { it.replaceFirstChar { c -> c.uppercaseChar() } }
    }

    /** Convert Slovenian name to valid Java class name (PascalCase). */
    fun toClassName(name: String): String {
        var result = replaceSlovenianChars(name)
        result = result.replace(Regex("[^a-zA-Z0-9\\s]"), "")
        val words = result.split(Regex("\\s+")).filter { it.isNotEmpty() }
        if (words.isEmpty()) return "Unknown"

        return words.joinToString("") { it.replaceFirstChar { c -> c.uppercaseChar() } }
    }

    private fun replaceSlovenianChars(name: String): String {
        val sb = StringBuilder()
        for (c in name) {
            sb.append(when (c) {
                '\u010D' -> 'c'  // č
                '\u010C' -> 'C'  // Č
                '\u0161' -> 's'  // š
                '\u0160' -> 'S'  // Š
                '\u017E' -> 'z'  // ž
                '\u017D' -> 'Z'  // Ž
                '\u0111' -> 'd'  // đ
                '\u0110' -> 'D'  // Đ
                '\u0107' -> 'c'  // ć
                '\u0106' -> 'C'  // Ć
                else -> c
            })
        }
        return sb.toString()
    }
}
