package si.triglav.common.propchar.generator

import java.io.File

/**
 * File writing utility.
 */
object FileWriter {

    /**
     * Write content to file, creating directories if needed.
     * @param filepath The path to write to
     * @param content The content to write
     * @param overwrite If false, skip existing files
     * @return true if file was written, false if skipped
     */
    fun writeFile(filepath: String, content: String, overwrite: Boolean = true): Boolean {
        val file = File(filepath)

        if (!overwrite && file.exists()) {
            println("Skipped (exists): $filepath")
            return false
        }

        file.parentFile?.mkdirs()
        file.writeText(content)
        println("Generated: $filepath")
        return true
    }
}
