package si.triglav.common.propchar.generator.util;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

/**
 * File writing utility with overwrite protection.
 */
public class FileWriter {

    /**
     * Write content to file, creating directories if needed.
     *
     * @param filepath Path to the file
     * @param content Content to write
     * @param overwrite If false, skip if file exists
     */
    public void writeFile(String filepath, String content, boolean overwrite) {
        File file = new File(filepath);

        if (!overwrite && file.exists()) {
            System.out.println("Skipped (exists): " + filepath);
            return;
        }

        // Create parent directories if needed
        File parent = file.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }

        try (OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream(file), StandardCharsets.UTF_8)) {
            writer.write(content);
            System.out.println("Generated: " + filepath);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write file: " + filepath, e);
        }
    }

    /**
     * Write content to file, always overwriting if exists.
     */
    public void writeFile(String filepath, String content) {
        writeFile(filepath, content, true);
    }
}
