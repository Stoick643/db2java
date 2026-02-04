package si.triglav.common.propchar.generator;

import si.triglav.common.propchar.generator.model.BooleanMapping;
import si.triglav.common.propchar.generator.model.Characteristic;
import si.triglav.common.propchar.generator.model.Property;
import si.triglav.common.propchar.generator.naming.SlovenianNameConverter;
import si.triglav.common.propchar.generator.output.BasePropertiesGenerator;
import si.triglav.common.propchar.generator.output.FactoryGenerator;
import si.triglav.common.propchar.generator.output.InterfaceGenerator;
import si.triglav.common.propchar.generator.output.LeafClassGenerator;
import si.triglav.common.propchar.generator.output.MapperClassGenerator;
import si.triglav.common.propchar.generator.output.PackageInfoGenerator;
import si.triglav.common.propchar.generator.output.PropertyClassGenerator;
import si.triglav.common.propchar.generator.parser.BooleanMappingLoader;
import si.triglav.common.propchar.generator.parser.CsvParser;
import si.triglav.common.propchar.generator.util.FileWriter;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Main entry point for the Java generator.
 * Generates strongly-typed Java classes from DB2 EAV pattern.
 *
 * <p>Usage:</p>
 * <pre>
 * java si.triglav.common.propchar.generator.GeneratorMain [--tp PROPERTY_ID]
 * </pre>
 */
public class GeneratorMain {

    public static void main(String[] args) {
        new GeneratorMain().run(args);
    }

    public void run(String[] args) {
        // Parse command-line arguments
        Integer tpFilter = parseArgs(args);

        // Determine paths
        String baseDir = findBaseDir();
        String csvPath = baseDir + File.separator + "docs" + File.separator + "prochar.csv";
        String booleanCsvPath = baseDir + File.separator + "docs" + File.separator + "booleans.csv";
        String outputDir = baseDir + File.separator + "generated";

        // Load boolean mappings
        BooleanMappingLoader booleanLoader = new BooleanMappingLoader();
        Map<Integer, BooleanMapping> booleanMappings = booleanLoader.load(booleanCsvPath);
        System.out.println("Loaded " + booleanMappings.size() + " boolean mappings");

        // Parse CSV
        System.out.println("Parsing " + csvPath + "...");
        CsvParser csvParser = new CsvParser();
        Map<Integer, Property> allProperties = csvParser.parse(csvPath, booleanMappings);
        System.out.println("\nFound " + allProperties.size() + " properties");

        // Count multi-column characteristics
        int multiColCount = 0;
        for (Property prop : allProperties.values()) {
            for (Characteristic charObj : prop.getCharacteristics()) {
                if (charObj.getFields().size() > 1) {
                    multiColCount++;
                    System.out.println("  Multi-column: " + prop.getTpProperty() + "/" +
                        charObj.getTpCharacter() + " (" + charObj.getName() + ")");
                }
            }
        }
        System.out.println("\nMulti-column characteristics: " + multiColCount);

        // Filter for single tp_property if specified
        Map<Integer, Property> properties;
        if (tpFilter != null) {
            if (!allProperties.containsKey(tpFilter)) {
                System.err.println("\nError: tp_property " + tpFilter + " not found in CSV");
                return;
            }
            properties = new LinkedHashMap<>();
            properties.put(tpFilter, allProperties.get(tpFilter));
            System.out.println("\nSingle property mode: generating only tp_property=" + tpFilter);
        } else {
            properties = allProperties;
        }

        System.out.println("\nGenerating Java files...");

        // Initialize generators
        FileWriter fileWriter = new FileWriter();
        BasePropertiesGenerator baseGen = new BasePropertiesGenerator();
        PropertyClassGenerator propGen = new PropertyClassGenerator();
        LeafClassGenerator leafGen = new LeafClassGenerator();
        MapperClassGenerator mapperGen = new MapperClassGenerator();
        InterfaceGenerator interfaceGen = new InterfaceGenerator();
        FactoryGenerator factoryGen = new FactoryGenerator();
        PackageInfoGenerator packageInfoGen = new PackageInfoGenerator();

        // Level 1: BaseProperties
        String filepath = outputDir + File.separator + "si" + File.separator + "triglav" +
            File.separator + "common" + File.separator + "propchar" + File.separator +
            "properties" + File.separator + "BaseProperties.java";
        fileWriter.writeFile(filepath, baseGen.generate());

        // Level 2: Generated property classes
        for (Property prop : properties.values()) {
            filepath = outputDir + File.separator + "si" + File.separator + "triglav" +
                File.separator + "common" + File.separator + "propchar" + File.separator +
                "generated" + File.separator + "properties" + File.separator +
                prop.getClassName() + ".java";
            fileWriter.writeFile(filepath, propGen.generate(prop));
        }

        // Level 3: Leaf classes (only if not exist)
        for (Property prop : properties.values()) {
            String simpleName = SlovenianNameConverter.toJavaClassName(prop.getName());
            filepath = outputDir + File.separator + "si" + File.separator + "triglav" +
                File.separator + "common" + File.separator + "propchar" + File.separator +
                "properties" + File.separator + simpleName + ".java";
            fileWriter.writeFile(filepath, leafGen.generate(prop), false);
        }

        // Mappers
        for (Property prop : properties.values()) {
            filepath = outputDir + File.separator + "si" + File.separator + "triglav" +
                File.separator + "common" + File.separator + "propchar" + File.separator +
                "generated" + File.separator + "mappers" + File.separator +
                prop.getClassName() + "_Mapper.java";
            fileWriter.writeFile(filepath, mapperGen.generate(prop));
        }

        // Interface
        filepath = outputDir + File.separator + "si" + File.separator + "triglav" +
            File.separator + "common" + File.separator + "propchar" + File.separator +
            "generated" + File.separator + "mappers" + File.separator + "PropertyMapper.java";
        fileWriter.writeFile(filepath, interfaceGen.generate());

        // Factory (always includes ALL properties for complete registry)
        filepath = outputDir + File.separator + "si" + File.separator + "triglav" +
            File.separator + "common" + File.separator + "propchar" + File.separator +
            "generated" + File.separator + "mappers" + File.separator + "PropertyMapperFactory.java";
        fileWriter.writeFile(filepath, factoryGen.generate(allProperties));

        // Package-info files
        System.out.println("\nGenerating package-info.java files...");

        filepath = outputDir + File.separator + "si" + File.separator + "triglav" +
            File.separator + "common" + File.separator + "propchar" + File.separator +
            "properties" + File.separator + "package-info.java";
        fileWriter.writeFile(filepath, packageInfoGen.generatePropertiesPackageInfo());

        filepath = outputDir + File.separator + "si" + File.separator + "triglav" +
            File.separator + "common" + File.separator + "propchar" + File.separator +
            "generated" + File.separator + "properties" + File.separator + "package-info.java";
        fileWriter.writeFile(filepath, packageInfoGen.generateGeneratedPropertiesPackageInfo());

        filepath = outputDir + File.separator + "si" + File.separator + "triglav" +
            File.separator + "common" + File.separator + "propchar" + File.separator +
            "generated" + File.separator + "mappers" + File.separator + "package-info.java";
        fileWriter.writeFile(filepath, packageInfoGen.generateMappersPackageInfo());

        // Summary
        int totalFiles = 1 + properties.size() * 3 + 2 + 3;
        System.out.println("\nDone! Generated " + totalFiles + " files.");
    }

    /**
     * Parse command-line arguments.
     *
     * @param args Command-line arguments
     * @return tp_property filter value, or null if not specified
     */
    private Integer parseArgs(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if ("--tp".equals(args[i]) && i + 1 < args.length) {
                try {
                    return Integer.parseInt(args[i + 1]);
                } catch (NumberFormatException e) {
                    System.err.println("Warning: invalid --tp value: " + args[i + 1]);
                }
            }
        }
        return null;
    }

    /**
     * Find the base directory (project root).
     * Looks for the docs/prochar.csv file.
     */
    private String findBaseDir() {
        // Try current directory
        File current = new File(".");
        if (new File(current, "docs/prochar.csv").exists()) {
            return current.getAbsolutePath();
        }

        // Try parent directories
        File parent = current.getAbsoluteFile().getParentFile();
        while (parent != null) {
            if (new File(parent, "docs/prochar.csv").exists()) {
                return parent.getAbsolutePath();
            }
            parent = parent.getParentFile();
        }

        // Default to current directory
        return ".";
    }
}
