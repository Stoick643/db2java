// ==========================================
// LEVEL 1: THE SHARED BASE CLASS
// ==========================================
package si.triglav.bp.properties;

import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Common logic for all 50+ property classes.
 * Using Reflection ensures that if new fields are added by the generator,
 * they are automatically included in equals, hashCode, and toString.
 */
public abstract class BaseProperties implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}

// ==========================================
// LEVEL 2: THE GENERATED CLASS (Superclass)
// ==========================================
package si.triglav.bp.generated.properties;

import si.triglav.common.SimpleDate;
import si.triglav.bp.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=8019 (Datum zdravstvenega pregleda)
 * Generated - do not edit manually.
 */
public class DatumZdravstvenegaPregleda_8019 extends BaseProperties {

    private SimpleDate datumPredvidenegaPregleda;  // 8029
    private SimpleDate datumOpravljenegaPregleda;  // 8030
    private Integer periodaPregleda;              // 8038
    private SimpleDate datumVabilaNaPregled;       // 8044
    private SimpleDate datumOpomina;               // 8045

    // Getters and Setters
    public SimpleDate getDatumPredvidenegaPregleda() { return datumPredvidenegaPregleda; }
    public void setDatumPredvidenegaPregleda(SimpleDate d) { this.datumPredvidenegaPregleda = d; }
    
    public SimpleDate getDatumOpravljenegaPregleda() { return datumOpravljenegaPregleda; }
    public void setDatumOpravljenegaPregleda(SimpleDate d) { this.datumOpravljenegaPregleda = d; }

    public Integer getPeriodaPregleda() { return periodaPregleda; }
    public void setPeriodaPregleda(Integer p) { this.periodaPregleda = p; }

    public SimpleDate getDatumVabilaNaPregled() { return datumVabilaNaPregled; }
    public void setDatumVabilaNaPregled(SimpleDate d) { this.datumVabilaNaPregled = d; }

    public SimpleDate getDatumOpomina() { return datumOpomina; }
    public void setDatumOpomina(SimpleDate d) { this.datumOpomina = d; }
}

// ==========================================
// LEVEL 3: THE CUSTOM LEAF CLASS (Subclass)
// ==========================================
package si.triglav.bp.properties;

import si.triglav.bp.generated.properties.DatumZdravstvenegaPregleda_8019;

/**
 * Concrete implementation for Health Check Dates.
 * Use this class in your application code.
 * This file will NOT be overwritten by the generator.
 */
public class DatumZdravstvenegaPregleda extends DatumZdravstvenegaPregleda_8019 {
    
    private static final long serialVersionUID = 1L;

    public DatumZdravstvenegaPregleda() {
        super();
    }

    // This class is now ready for business logic, 
    // while inheriting equals/toString from the base!
}