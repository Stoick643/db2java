/**
 * Ta datoteka je bila generirana s programom VAOGenerator Avtor: VAOGenerator
 */

package si.triglav.common.vao.bp;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import si.triglav.common.SimpleDate;
import si.triglav.common.sifrant.Sifra;
import si.triglav.common.vao.gen.bp.PCharacteristicVAOGen;

public class PCharacteristicVAO extends PCharacteristicVAOGen {

	/**
	 *
	 */
	private static final long serialVersionUID = 7574095490358845513L;
	final static List<Integer> nedovoljenaStopnjaTveganja = Arrays.asList(new Integer[] { Sifra.TP_PROPERTY_RISC_NORMAL, Sifra.TP_PROPERTY_RISC_INCREASED, Sifra.TP_PROPERTY_RISC_HIGH, Sifra.TP_PROPERTY_BUSINESS_PROHIBITION });

	public PCharacteristicVAO() {}

	public PCharacteristicVAO(Integer fk, Integer tp_character, Integer pch_number) {
		this.id_pers_property = fk;
		this.tp_character = tp_character;
		this.pch_number = pch_number;
	}

	public PCharacteristicVAO(Integer fk, Integer tp_character, String pch_desc) {
		this.id_pers_property = fk;
		this.tp_character = tp_character;
		this.pch_desc = pch_desc;
	}

	public boolean isNedovoljenaStopnjaTveganja() {
		if (this.pch_number == null) {
			return false;
		}
		return nedovoljenaStopnjaTveganja.contains(this.pch_number);
	}

	public void updateValue(Object value) {

		if (value instanceof BigDecimal) {

			this.setPch_value((BigDecimal) value);

		} else if (value instanceof Integer) {

			this.setPch_number((Integer) value);

		} else if (value instanceof String) {

			this.setPch_desc((String) value);

		} else if (value instanceof SimpleDate) {

			this.setPch_date((SimpleDate) value);

		} else if (value instanceof Date) {

			this.setPch_date(SimpleDate.toSimpleDate((Date) value));

		} else if (value == null) {

			this.setPch_value(null);
			this.setPch_number(null);
			this.setPch_date(null);
			this.setPch_desc(null);

		} else {

			throw new IllegalArgumentException(
					"Invalid characteristic value type: " + value.getClass());
		}
	}

	public boolean hasCharacteristicValueDefined() {
		if (getPch_number() != null) {
			return true;
		}

		if (getPch_value() != null) {
			return true;
		}

		if (getPch_desc() != null) {
			return true;
		}

		if (getPch_date() != null) {
			return true;
		}

		return false;
	}

	public boolean hasCharacteristicValue(final Object anyValue) {
		if (anyValue == null) {
			return false;
		}

		if (anyValue.equals(getPch_number())) {
			return true;
		}

		if (anyValue.equals(getPch_value())) {
			return true;
		}

		if (anyValue.equals(getPch_desc())) {
			return true;
		}

		if (anyValue.equals(getPch_date())) {
			return true;
		}

		return false;
	}
}