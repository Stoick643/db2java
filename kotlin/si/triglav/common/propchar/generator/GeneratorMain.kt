package si.triglav.common.propchar.generator

import java.io.File

/**
 * Main entry point for the property generator.
 * Generates typed Java classes from DB2 EAV pattern.
 */
fun main(args: Array<String>) {
    // Parse command line arguments
    var singleTpProperty: Int? = null
    var i = 0
    while (i < args.size) {
        when (args[i]) {
            "--tp" -> {
                if (i + 1 < args.size) {
                    singleTpProperty = args[i + 1].toIntOrNull()
                    i += 2
                } else {
                    println("Error: --tp requires a value")
                    return
                }
            }
            else -> i++
        }
    }

    // Determine paths relative to script location
    val scriptDir = File(System.getProperty("user.dir"))
    val csvPath = File(scriptDir, "docs/prochar.csv").absolutePath
    val baseOutputDir = File(scriptDir, "generated").absolutePath

    // Load boolean mappings
    val booleanCsv = File(scriptDir, "docs/booleans.csv").absolutePath
    val booleanMappings = CsvParser.loadBooleanMappings(booleanCsv)
    println("Loaded ${booleanMappings.size} boolean mappings")

    println("Parsing $csvPath...")
    val allProperties = CsvParser.parseProcharCsv(csvPath, booleanMappings)
    println("\nFound ${allProperties.size} properties")

    // Count multi-column characteristics
    var multiColCount = 0
    for (prop in allProperties.values) {
        for (char in prop.characteristics) {
            if (char.fields.size > 1) {
                multiColCount++
                println("  Multi-column: ${prop.tpProperty}/${char.tpCharacter} (${char.name})")
            }
        }
    }
    println("\nMulti-column characteristics: $multiColCount")

    // Filter for single tp_property if specified
    val properties = if (singleTpProperty != null) {
        if (singleTpProperty !in allProperties) {
            println("\nError: tp_property $singleTpProperty not found in CSV")
            return
        }
        println("\nSingle property mode: generating only tp_property=$singleTpProperty")
        mapOf(singleTpProperty to allProperties[singleTpProperty]!!)
    } else {
        allProperties
    }

    println("\nGenerating Java files...")

    // Level 1: BaseProperties
    val basePropsPath = "$baseOutputDir/si/triglav/common/propchar/properties/BaseProperties.java"
    FileWriter.writeFile(basePropsPath, Generators.generateBaseProperties())

    // Level 2: Generated property classes
    for (prop in properties.values) {
        val filepath = "$baseOutputDir/si/triglav/common/propchar/generated/properties/${prop.className}.java"
        FileWriter.writeFile(filepath, Generators.generatePropertyClass(prop))
    }

    // Level 3: Leaf classes (only if not exist)
    for (prop in properties.values) {
        val simpleName = SlovenianNameConverter.toClassName(prop.name)
        val filepath = "$baseOutputDir/si/triglav/common/propchar/properties/$simpleName.java"
        FileWriter.writeFile(filepath, Generators.generateLeafClass(prop), overwrite = false)
    }

    // Mappers
    for (prop in properties.values) {
        val filepath = "$baseOutputDir/si/triglav/common/propchar/generated/mappers/${prop.className}_Mapper.java"
        FileWriter.writeFile(filepath, Generators.generateMapperClass(prop))
    }

    // Interface
    val interfacePath = "$baseOutputDir/si/triglav/common/propchar/generated/mappers/PropertyMapper.java"
    FileWriter.writeFile(interfacePath, Generators.generateInterface())

    // Factory (always includes ALL properties for complete registry)
    val factoryPath = "$baseOutputDir/si/triglav/common/propchar/generated/mappers/PropertyMapperFactory.java"
    FileWriter.writeFile(factoryPath, Generators.generateFactory(allProperties))

    // Package-info files
    println("\nGenerating package-info.java files...")

    val propsPackageInfoPath = "$baseOutputDir/si/triglav/common/propchar/properties/package-info.java"
    FileWriter.writeFile(propsPackageInfoPath, Generators.generatePropertiesPackageInfo())

    val genPropsPackageInfoPath = "$baseOutputDir/si/triglav/common/propchar/generated/properties/package-info.java"
    FileWriter.writeFile(genPropsPackageInfoPath, Generators.generateGeneratedPropertiesPackageInfo())

    val mappersPackageInfoPath = "$baseOutputDir/si/triglav/common/propchar/generated/mappers/package-info.java"
    FileWriter.writeFile(mappersPackageInfoPath, Generators.generateMappersPackageInfo())

    // Count total files
    val totalFiles = 1 + properties.size * 3 + 2 + 3 // BaseProperties + (prop + leaf + mapper) * N + interface + factory + 3 package-info
    println("\nDone! Generated $totalFiles files.")
}
