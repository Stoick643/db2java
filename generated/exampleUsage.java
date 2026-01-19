package si.triglav.bp.examples;

import si.triglav.bp.properties.OsebniDokument;
import si.triglav.bp.generated.mappers.PropertyMapperFactory;
import si.triglav.common.SimpleDate;
import si.triglav.common.vao.bp.PCharacteristicVAO;
import si.triglav.common.vao.bp.PersonPropertyVAO;
import java.util.List;

/**
 * Usage examples for PropertyMapperFactory.
 * Copy-paste these patterns into your code.
 */
public class ExampleUsage {

    /**
     * Example 1: Reading - Convert VAO to typed object
     */
    public void readingExample(PersonPropertyVAO personPropertyVAO) {
        // Get characteristics from VAO
        List<PCharacteristicVAO> characteristics = personPropertyVAO.getPCharacteristicList();

        // Convert to typed object (use Level 3 class)
        OsebniDokument dokument = PropertyMapperFactory.fromList(OsebniDokument.class, characteristics);

        // Access fields with type-safe getters - no casting needed
        String stevilka = dokument.getStevilkaDokumenta();
        Integer vrsta = dokument.getVrstaDokumenta();
        SimpleDate izdaja = dokument.getDatumIzdaje();
        SimpleDate konec = dokument.getKonecVeljavnosti();
    }

    /**
     * Example 2: Creating - Build new typed object and convert to VAO
     */
    public List<PCharacteristicVAO> creatingExample(Integer idPersProperty) {
        // Create typed object
        OsebniDokument novDokument = new OsebniDokument();
        novDokument.setStevilkaDokumenta("AB123456");
        novDokument.setVrstaDokumenta(1);
        novDokument.setDatumIzdaje(SimpleDate.today());
        novDokument.setKonecVeljavnosti(new SimpleDate(2030, 12, 31));

        // Convert to characteristic list (creates NEW objects)
        return PropertyMapperFactory.toList(novDokument, idPersProperty);
    }

    /**
     * Example 3: Updating - Modify existing data IN PLACE (preserves IDs)
     *
     * Use this when updating existing records - database will do UPDATE not INSERT.
     */
    public void updatingExample(PersonPropertyVAO personPropertyVAO) {
        // Get existing characteristics
        List<PCharacteristicVAO> characteristics = personPropertyVAO.getPCharacteristicList();

        // Convert to typed object
        OsebniDokument dokument = PropertyMapperFactory.fromList(OsebniDokument.class, characteristics);

        // Modify values
        dokument.setKonecVeljavnosti(new SimpleDate(2035, 12, 31));
        dokument.setStevilkaDokumenta("NEW123456");

        // Update existing list IN PLACE - preserves id_p_characteristic
        PropertyMapperFactory.updateList(dokument, characteristics);

        // Now characteristics list has updated values
        // Original PCharacteristicVAO objects are modified, IDs preserved
    }

    /**
     * Example 4: Check if mapper exists before using
     */
    public void checkMapperExample() {
        // Check by class
        if (PropertyMapperFactory.hasMapper(OsebniDokument.class)) {
            // Safe to use
        }

        // Check by tp_property code
        if (PropertyMapperFactory.hasMapper(7744)) {
            // Safe to use
        }
    }
}
