/**
 *
 * Ta datoteka je bila generirana s programom VAOGenerator
 *
 * Avtor: VAOGenerator
 *	Verzija: 2.2
 */

package si.triglav.common.vao.gen.bp;

import java.sql.Types;
import com.fasterxml.jackson.annotation.JsonIgnore;

import si.triglav.common.SimpleDate;
import si.triglav.common.vao.AbstractVAO;
import si.triglav.common.vao.ColumnMetadata;
import si.triglav.common.vao.bp.PersonPropertyVAO;
import si.triglav.min.services.PersistenceService;

/**
 * mehki podatki (email,telefon,zaposlitev ...)
 */
public class PCharacteristicVAOGen extends AbstractVAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * null
	 */
	protected Integer id_p_character;

	/**
	 * primarni kljuè
	 */
	protected Integer id_pers_property;

	/**
	 * null
	 */
	protected Integer tp_character;

	/**
	 * null
	 */
	protected Integer pch_number;

	/**
	 * null
	 */
	protected java.math.BigDecimal pch_value;

	/**
	 * telefon, email, zaposlitev, ...
	 */
	protected String pch_desc;

	/**
	 * datumska vrednost
	 */
	protected SimpleDate pch_date;

	/**
	 * Casovna znamka spremembe zapisa
	 */
	protected java.sql.Timestamp ts_dat;

	/**
	 * Stevilka uporabnika, ki je spremenil zapis
	 */
	protected Integer id_user;

	/**
	 * Stevilka programa, iz katerega je spremenjen zapis
	 */
	protected Integer id_program;

	/**
	 * verzija zapisa - zagotovitev, da popravljamo zadnji zapis; Ob update-u se sprašujemo, èe je zapis isti (isti version kot pri branju) in ga ob popravljanju poveèamo za ena
	 */
	protected Short version;

	/**
	 * null
	 */
	protected Integer id_user_update;

	/**
	 * null
	 */
	protected Integer id_program_update;

	/**
	 * null
	 */
	protected java.sql.Timestamp ts_dat_update;

	protected int hashCode = 0;

	@JsonIgnore
	protected PersonPropertyVAO persProperty;

	/*******************************************************************************************/
	//protected java.util.Set changedColumns = new java.util.HashSet();

	static final String[] columns =  new String[]
	{"id_pers_property", "tp_character", "pch_number", "pch_value", "pch_desc", 
	"pch_date", "ts_dat", "id_user", "id_program", "version", 
	"id_user_update", "id_program_update", "ts_dat_update"};

	static final String[] pk = new String[] {"id_p_character"};

	static final String dbTable = "bp.p_characteristic";

	static final int[] columnTypes =  new int[]
	{Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.DECIMAL, Types.VARCHAR, 
	Types.DATE, Types.TIMESTAMP, Types.INTEGER, Types.INTEGER, Types.SMALLINT, 
	Types.INTEGER, Types.INTEGER, Types.TIMESTAMP};

	static final int[] pkTypes =  new int[] {
		Types.INTEGER
	};

	static final ColumnMetadata[] columnMetadata = new ColumnMetadata[] {
		new ColumnMetadata("id_p_character", Types.INTEGER, true, false, 4, -1), 
		new ColumnMetadata("id_pers_property", Types.INTEGER, false, false, 4, -1), 
		new ColumnMetadata("tp_character", Types.INTEGER, false, false, 4, -1), 
		new ColumnMetadata("pch_number", Types.INTEGER, false, true, 4, -1), 
		new ColumnMetadata("pch_value", Types.DECIMAL, false, true, 15, 4), 
		new ColumnMetadata("pch_desc", Types.VARCHAR, false, true, 500, -1), 
		new ColumnMetadata("pch_date", Types.DATE, false, true, 4, -1), 
		new ColumnMetadata("ts_dat", Types.TIMESTAMP, false, true, 10, -1), 
		new ColumnMetadata("id_user", Types.INTEGER, false, true, 4, -1), 
		new ColumnMetadata("id_program", Types.INTEGER, false, true, 4, -1), 
		new ColumnMetadata("version", Types.SMALLINT, false, true, 2, -1), 
		new ColumnMetadata("id_user_update", Types.INTEGER, false, true, 4, -1), 
		new ColumnMetadata("id_program_update", Types.INTEGER, false, true, 4, -1), 
		new ColumnMetadata("ts_dat_update", Types.TIMESTAMP, false, true, 10, -1)
	};

	@Override
	public String[] columns() {
		return columns.clone();
	}

	@Override
	public String[] pk() {
		return pk.clone();
	}

	@Override
	public ColumnMetadata[] getColumnsMetadata() {
		return columnMetadata.clone();
	}

	@Override
	public int[] columnTypes() {
		return columnTypes.clone();
	}

	@Override
	public int[] pkTypes() {
		return pkTypes.clone();
	}

	@Override
	public String dbTable() {
		return dbTable;
	}


	@Override
	public Object[] pkValues() {
		return new Object[]
		{getId_p_character()};
	}

	@Override
	public Object[] columnValues() {
		return new Object[]
		{getId_pers_property(), getTp_character(), getPch_number(), getPch_value(), getPch_desc(), 
		getPch_date(), getTs_dat(), getId_user(), getId_program(), getVersion(), 
		getId_user_update(), getId_program_update(), getTs_dat_update()};
	}

	@Override
	public boolean isGenerated() {return true;}

	/*******************************************************************************************/

	// TUJI KLJUCI

	public PersonPropertyVAO getPersProperty (PersistenceService ps) {
		if (ps != null) {
 			beginUpdate();
			setPersProperty((PersonPropertyVAO) ps.parent(PersonPropertyVAO.class, new Object[] {getId_pers_property()}));
			endUpdate();
		}
		return this.persProperty;
	}

	public PersonPropertyVAO getPersProperty() {
		return getPersProperty(null);
	}

	public void setPersProperty(PersonPropertyVAO persProperty) {
		this.persProperty = persProperty;
		if (persProperty != null && persProperty.isPkDefined()) {
			setColumnValue("id_pers_property", persProperty.getId_pers_property());
		}
	}

	// GETTERSI IN SETTERSI

	/**
	 * null
	 */
	public Integer getId_p_character() {
		return this.id_p_character;
	}

	/**
	 * null
	 */
	public void setId_p_character(Integer id_p_character) {
		if (registerChange("id_p_character", this.id_p_character, id_p_character)) {
			this.id_p_character = id_p_character;
			this.hashCode = 0;
		}
	}

	/**
	 * primarni kljuè
	 */
	public Integer getId_pers_property() {
		if (this.persProperty != null && this.id_pers_property== null) this.id_pers_property = (Integer) this.persProperty.pkValues()[0];
		return this.id_pers_property;
	}

	/**
	 * primarni kljuè
	 */
	public void setId_pers_property(Integer id_pers_property) {
		if (registerChange("id_pers_property", this.id_pers_property, id_pers_property)) {
			this.id_pers_property = id_pers_property;
		}
	}

	/**
	 * null
	 */
	public Integer getTp_character() {
		return this.tp_character;
	}

	/**
	 * null
	 */
	public void setTp_character(Integer tp_character) {
		if (registerChange("tp_character", this.tp_character, tp_character)) {
			this.tp_character = tp_character;
		}
	}

	/**
	 * null
	 */
	public Integer getPch_number() {
		return this.pch_number;
	}

	/**
	 * null
	 */
	public void setPch_number(Integer pch_number) {
		if (registerChange("pch_number", this.pch_number, pch_number)) {
			this.pch_number = pch_number;
		}
	}

	/**
	 * null
	 */
	public java.math.BigDecimal getPch_value() {
		return this.pch_value;
	}

	/**
	 * null
	 */
	public void setPch_value(java.math.BigDecimal pch_value) {
		if (registerChange("pch_value", this.pch_value, pch_value)) {
			this.pch_value = pch_value;
		}
	}

	/**
	 * telefon, email, zaposlitev, ...
	 */
	public String getPch_desc() {
		return this.pch_desc;
	}

	/**
	 * telefon, email, zaposlitev, ...
	 */
	public void setPch_desc(String pch_desc) {
		if (registerChange("pch_desc", this.pch_desc, pch_desc)) {
			this.pch_desc = pch_desc;
		}
	}

	/**
	 * datumska vrednost
	 */
	public SimpleDate getPch_date() {
		return this.pch_date;
	}

	/**
	 * datumska vrednost
	 */
	public void setPch_date(SimpleDate pch_date) {
		if (registerChange("pch_date", this.pch_date, pch_date)) {
			this.pch_date = pch_date;
		}
	}

	/**
	 * Casovna znamka spremembe zapisa
	 */
	@Override
	public java.sql.Timestamp getTs_dat() {
		return (java.sql.Timestamp) (this.ts_dat == null ? null : this.ts_dat.clone());
	}

	/**
	 * Casovna znamka spremembe zapisa
	 */
	@Override
	public void setTs_dat(java.sql.Timestamp ts_dat) {
		if (registerChange("ts_dat", this.ts_dat, ts_dat)) {
			this.ts_dat = (java.sql.Timestamp) (ts_dat == null ? null : ts_dat.clone());
		}
	}

	/**
	 * Stevilka uporabnika, ki je spremenil zapis
	 */
	@Override
	public Integer getId_user() {
		return this.id_user;
	}

	/**
	 * Stevilka uporabnika, ki je spremenil zapis
	 */
	@Override
	public void setId_user(Integer id_user) {
		if (registerChange("id_user", this.id_user, id_user)) {
			this.id_user = id_user;
		}
	}

	/**
	 * Stevilka programa, iz katerega je spremenjen zapis
	 */
	@Override
	public Integer getId_program() {
		return this.id_program;
	}

	/**
	 * Stevilka programa, iz katerega je spremenjen zapis
	 */
	@Override
	public void setId_program(Integer id_program) {
		if (registerChange("id_program", this.id_program, id_program)) {
			this.id_program = id_program;
		}
	}

	/**
	 * verzija zapisa - zagotovitev, da popravljamo zadnji zapis; Ob update-u se sprašujemo, èe je zapis isti (isti version kot pri branju) in ga ob popravljanju poveèamo za ena
	 */
	@Override
	public Short getVersion() {
		return this.version;
	}

	/**
	 * verzija zapisa - zagotovitev, da popravljamo zadnji zapis; Ob update-u se sprašujemo, èe je zapis isti (isti version kot pri branju) in ga ob popravljanju poveèamo za ena
	 */
	@Override
	public void setVersion(Short version) {
		if (registerChange("version", this.version, version)) {
			this.version = version;
		}
	}

	/**
	 * null
	 */
	@Override
	public Integer getId_user_update() {
		return this.id_user_update;
	}

	/**
	 * null
	 */
	@Override
	public void setId_user_update(Integer id_user_update) {
		if (registerChange("id_user_update", this.id_user_update, id_user_update)) {
			this.id_user_update = id_user_update;
		}
	}

	/**
	 * null
	 */
	@Override
	public Integer getId_program_update() {
		return this.id_program_update;
	}

	/**
	 * null
	 */
	@Override
	public void setId_program_update(Integer id_program_update) {
		if (registerChange("id_program_update", this.id_program_update, id_program_update)) {
			this.id_program_update = id_program_update;
		}
	}

	/**
	 * null
	 */
	@Override
	public java.sql.Timestamp getTs_dat_update() {
		return (java.sql.Timestamp) (this.ts_dat_update == null ? null : this.ts_dat_update.clone());
	}

	/**
	 * null
	 */
	@Override
	public void setTs_dat_update(java.sql.Timestamp ts_dat_update) {
		if (registerChange("ts_dat_update", this.ts_dat_update, ts_dat_update)) {
			this.ts_dat_update = (java.sql.Timestamp) (ts_dat_update == null ? null : ts_dat_update.clone());
		}
	}

	@Override public java.util.List<String> getExcludedColumns() {
		 return DEFAULT_EXCLUDED_COLUMNS;
	}

	@Override public void fillVao(java.sql.ResultSet rs, si.triglav.min.util.SqlMetadata metadata) {
		// java.util.Set<String> labels = metadata.getLabels();
		java.util.Set<String> names = metadata.getNames();
		Object value = null;
		if (names.contains("id_p_character")) {
			value = getValue(rs, "id_p_character", java.sql.Types.INTEGER);
			setId_p_character((Integer) value);
		}
		if (names.contains("id_pers_property")) {
			value = getValue(rs, "id_pers_property", java.sql.Types.INTEGER);
			setId_pers_property((Integer) value);
		}
		if (names.contains("tp_character")) {
			value = getValue(rs, "tp_character", java.sql.Types.INTEGER);
			setTp_character((Integer) value);
		}
		if (names.contains("pch_number")) {
			value = getValue(rs, "pch_number", java.sql.Types.INTEGER);
			setPch_number((Integer) value);
		}
		if (names.contains("pch_value")) {
			value = getValue(rs, "pch_value", java.sql.Types.DECIMAL);
			setPch_value((java.math.BigDecimal) value);
		}
		if (names.contains("pch_desc")) {
			value = getValue(rs, "pch_desc", java.sql.Types.VARCHAR);
			setPch_desc((String) value);
		}
		if (names.contains("pch_date")) {
			value = getValue(rs, "pch_date", java.sql.Types.DATE);
			setPch_date((SimpleDate) value);
		}
		if (names.contains("ts_dat")) {
			value = getValue(rs, "ts_dat", java.sql.Types.TIMESTAMP);
			setTs_dat((java.sql.Timestamp) value);
		}
		if (names.contains("id_user")) {
			value = getValue(rs, "id_user", java.sql.Types.INTEGER);
			setId_user((Integer) value);
		}
		if (names.contains("id_program")) {
			value = getValue(rs, "id_program", java.sql.Types.INTEGER);
			setId_program((Integer) value);
		}
		if (names.contains("version")) {
			value = getValue(rs, "version", java.sql.Types.SMALLINT);
			setVersion((Short) value);
		}
		if (names.contains("id_user_update")) {
			value = getValue(rs, "id_user_update", java.sql.Types.INTEGER);
			setId_user_update((Integer) value);
		}
		if (names.contains("id_program_update")) {
			value = getValue(rs, "id_program_update", java.sql.Types.INTEGER);
			setId_program_update((Integer) value);
		}
		if (names.contains("ts_dat_update")) {
			value = getValue(rs, "ts_dat_update", java.sql.Types.TIMESTAMP);
			setTs_dat_update((java.sql.Timestamp) value);
		}
	}

	@Override protected Object getValueImpl(String field) {
		Object value = null;
		if ("id_p_character".equals(field)) value = getId_p_character();
		else if ("id_pers_property".equals(field)) value = getId_pers_property();
		else if ("tp_character".equals(field)) value = getTp_character();
		else if ("pch_number".equals(field)) value = getPch_number();
		else if ("pch_value".equals(field)) value = getPch_value();
		else if ("pch_desc".equals(field)) value = getPch_desc();
		else if ("pch_date".equals(field)) value = getPch_date();
		else if ("ts_dat".equals(field)) value = getTs_dat();
		else if ("id_user".equals(field)) value = getId_user();
		else if ("id_program".equals(field)) value = getId_program();
		else if ("version".equals(field)) value = getVersion();
		else if ("id_user_update".equals(field)) value = getId_user_update();
		else if ("id_program_update".equals(field)) value = getId_program_update();
		else if ("ts_dat_update".equals(field)) value = getTs_dat_update();
		return value;
	}

	@Override
	public boolean hasLastUpdateColumns() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		return super.equals(o);
	}

	@Override
	public int hashCode() {

		if (this.hashCode == 0) {
			this.hashCode = 17;
			this.hashCode = 37 * this.hashCode + (this.id_p_character != null ? this.id_p_character.hashCode() : 0);
		}

		return this.hashCode;
	}
}
