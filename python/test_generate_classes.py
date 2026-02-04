#!/usr/bin/env python3
"""
Unit tests for generate_classes.py
Run with: python -m pytest test_generate_classes.py -v
      or: python test_generate_classes.py
"""

import unittest
import os
from generate_classes import (
    slovenian_to_java_name,
    slovenian_to_class_name,
    parse_prochar_csv,
    generate_property_class,
    generate_mapper_class,
    Property,
    Characteristic,
    CharacteristicField
)


class TestNameConversion(unittest.TestCase):
    """Test Slovenian to Java name conversion."""

    def test_simple_name(self):
        self.assertEqual(slovenian_to_java_name("Datum"), "datum")

    def test_two_words(self):
        self.assertEqual(slovenian_to_java_name("Datum izdaje"), "datumIzdaje")

    def test_three_words(self):
        self.assertEqual(slovenian_to_java_name("Konec veljavnosti permanentno"), "konecVeljavnostiPermanentno")

    def test_special_chars_c(self):
        self.assertEqual(slovenian_to_java_name("Številka"), "stevilka")

    def test_special_chars_s(self):
        self.assertEqual(slovenian_to_java_name("Šifra"), "sifra")

    def test_special_chars_z(self):
        self.assertEqual(slovenian_to_java_name("Žiro račun"), "ziroRacun")

    def test_mixed_special_chars(self):
        self.assertEqual(slovenian_to_java_name("Številka dokumenta"), "stevilkaDokumenta")

    def test_uppercase_input(self):
        self.assertEqual(slovenian_to_java_name("DATUM IZDAJE"), "datumIzdaje")


class TestClassNameConversion(unittest.TestCase):
    """Test Slovenian to Java class name conversion."""

    def test_simple_name(self):
        self.assertEqual(slovenian_to_class_name("Telefon"), "Telefon")

    def test_two_words(self):
        self.assertEqual(slovenian_to_class_name("Osebni dokument"), "OsebniDokument")

    def test_special_chars(self):
        self.assertEqual(slovenian_to_class_name("Številka računa"), "StevilkaRacuna")

    def test_lowercase_input(self):
        self.assertEqual(slovenian_to_class_name("osebni dokument"), "OsebniDokument")


class TestCsvParsing(unittest.TestCase):
    """Test CSV parsing."""

    def setUp(self):
        self.csv_path = os.path.join(os.path.dirname(__file__), 'docs', 'prochar.csv')

    def test_csv_exists(self):
        self.assertTrue(os.path.exists(self.csv_path), f"CSV file not found: {self.csv_path}")

    def test_parse_returns_dict(self):
        properties = parse_prochar_csv(self.csv_path)
        self.assertIsInstance(properties, dict)

    def test_parse_has_properties(self):
        properties = parse_prochar_csv(self.csv_path)
        self.assertGreater(len(properties), 0)

    def test_property_7744_exists(self):
        properties = parse_prochar_csv(self.csv_path)
        self.assertIn(7744, properties)

    def test_property_7744_name(self):
        properties = parse_prochar_csv(self.csv_path)
        self.assertEqual(properties[7744].name, "Osebni dokument")

    def test_property_7744_has_characteristics(self):
        properties = parse_prochar_csv(self.csv_path)
        self.assertGreater(len(properties[7744].characteristics), 0)


class TestCodeGeneration(unittest.TestCase):
    """Test Java code generation."""

    def setUp(self):
        # Create a simple test property
        self.test_prop = Property(
            tp_property=9999,
            name="Test property",
            class_name="TestProperty_9999",
            characteristics=[
                Characteristic(
                    tp_character=1001,
                    name="Test field",
                    fields=[CharacteristicField("testField", "String", "desc")]
                ),
                Characteristic(
                    tp_character=1002,
                    name="Test number",
                    fields=[CharacteristicField("testNumber", "Integer", "number")]
                )
            ]
        )

    def test_property_class_has_package(self):
        code = generate_property_class(self.test_prop)
        self.assertIn("package si.triglav.common.propchar.generated.properties;", code)

    def test_property_class_has_class_name(self):
        code = generate_property_class(self.test_prop)
        self.assertIn("public class TestProperty_9999", code)

    def test_property_class_has_fields(self):
        code = generate_property_class(self.test_prop)
        self.assertIn("private String testField;", code)
        self.assertIn("private Integer testNumber;", code)

    def test_property_class_has_getters(self):
        code = generate_property_class(self.test_prop)
        self.assertIn("public String getTestField()", code)
        self.assertIn("public Integer getTestNumber()", code)

    def test_property_class_has_setters(self):
        code = generate_property_class(self.test_prop)
        self.assertIn("public void setTestField(String testField)", code)
        self.assertIn("public void setTestNumber(Integer testNumber)", code)

    def test_mapper_has_from_list(self):
        code = generate_mapper_class(self.test_prop)
        self.assertIn("public TestProperty fromList(", code)

    def test_mapper_has_to_list(self):
        code = generate_mapper_class(self.test_prop)
        self.assertIn("public List<PCharacteristicVAO> toList(", code)

    def test_mapper_has_update_list(self):
        code = generate_mapper_class(self.test_prop)
        self.assertIn("public void updateList(", code)

    def test_mapper_has_switch_cases(self):
        code = generate_mapper_class(self.test_prop)
        self.assertIn("case 1001:", code)
        self.assertIn("case 1002:", code)


class TestMultiColumnCharacteristic(unittest.TestCase):
    """Test multi-column characteristic handling."""

    def setUp(self):
        # Create property with multi-column characteristic
        self.test_prop = Property(
            tp_property=8888,
            name="Multi test",
            class_name="MultiTest_8888",
            characteristics=[
                Characteristic(
                    tp_character=2001,
                    name="Multi field",
                    fields=[
                        CharacteristicField("multiField_number", "Integer", "number"),
                        CharacteristicField("multiField_desc", "String", "desc")
                    ]
                )
            ]
        )

    def test_multi_column_has_both_fields(self):
        code = generate_property_class(self.test_prop)
        self.assertIn("private Integer multiField_number;", code)
        self.assertIn("private String multiField_desc;", code)

    def test_multi_column_mapper_sets_both(self):
        code = generate_mapper_class(self.test_prop)
        self.assertIn("setMultiField_number", code)
        self.assertIn("setMultiField_desc", code)


if __name__ == '__main__':
    unittest.main()
