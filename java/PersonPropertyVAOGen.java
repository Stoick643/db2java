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
import si.triglav.common.vao.bp.PCharacteristicVAO;
import si.triglav.common.vao.bp.PersonPropertyVAO;
import si.triglav.common.vao.bp.PersonVAO;
import si.triglav.min.services.PersistenceService;

/**
 * lastnost osebe poslovnega partnerja - naslovi, raèuni, mehki podatki (email,telefon ...)
 */
public class PersonPropertyVAOGen extends AbstractVAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * primarni kljuè
	 */
	protected Integer id_pers_property;

	/**
	 * povezava na osebo - poslovnega partnerja
	 */
	protected Integer id_person;

	/**
	 * tip lastnosti (naslov, banka, ...)
	 */
	protected Integer tp_property;

	/**
	 * zaèetek veljavnosti - prvi zapis dobi veljavnost od 1.1.1900
	 */
	protected SimpleDate prp_valid_begin;

	/**
	 * konec veljavnosti - prvi zapis dobi veljavnost do datuma popravka
	 */
	protected SimpleDate prp_valid_end;

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
	protected PersonVAO person;
	protected java.util.List<PCharacteristicVAO> pCharacteristicList;

	/*******************************************************************************************/
	//protected java.util.Set changedColumns = new java.util.HashSet();

	static final String[] columns =  new String[]
	{"id_person", "tp_property", "prp_valid_begin", "prp_valid_end", "ts_dat", 
	"id_user", "id_program", "version", "id_user_update", "id_program_update", 
	"ts_dat_update"};

	static final String[] pk = new String[] {"id_pers_property"};

	static final String dbTable = "bp.person_property";

	static final int[] columnTypes =  new int[]
	{Types.INTEGER, Types.INTEGER, Types.DATE, Types.DATE, Types.TIMESTAMP, 
	Types.INTEGER, Types.INTEGER, Types.SMALLINT, Types.INTEGER, Types.INTEGER, 
	Types.TIMESTAMP};

	static final int[] pkTypes =  new int[] {
		Types.INTEGER
	};

	static final ColumnMetadata[] columnMetadata = new ColumnMetadata[] {
		new ColumnMetadata("id_pers_property", Types.INTEGER, true, false, 4, -1), 
		new ColumnMetadata("id_person", Types.INTEGER, false, false, 4, -1), 
		new ColumnMetadata("tp_property", Types.INTEGER, false, false, 4, -1), 
		new ColumnMetadata("prp_valid_begin", Types.DATE, false, false, 4, -1), 
		new ColumnMetadata("prp_valid_end", Types.DATE, false, false, 4, -1), 
		new ColumnMetadata("ts_dat", Types.TIMESTAMP, false, false, 10, -1), 
		new ColumnMetadata("id_user", Types.INTEGER, false, false, 4, -1), 
		new ColumnMetadata("id_program", Types.INTEGER, false, false, 4, -1), 
		new ColumnMetadata("version", Types.SMALLINT, false, false, 2, -1), 
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
		{getId_pers_property()};
	}

	@Override
	public Object[] columnValues() {
		return new Object[]
		{getId_person(), getTp_property(), getPrp_valid_begin(), getPrp_valid_end(), getTs_dat(), 
		getId_user(), getId_program(), getVersion(), getId_user_update(), getId_program_update(), 
		getTs_dat_update()};
	}

	@Override
	public boolean isGenerated() {return true;}

	/*******************************************************************************************/

	// TUJI KLJUCI

	public PersonVAO getPerson (PersistenceService ps) {
		if (ps != null) {
 			beginUpdate();
			setPerson((PersonVAO) ps.parent(PersonVAO.class, new Object[] {getId_person()}));
			endUpdate();
		}
		return this.person;
	}

	public PersonVAO getPerson() {
		return getPerson(null);
	}

	public void setPerson(PersonVAO person) {
		this.person = person;
		if (person != null && person.isPkDefined()) {
			setColumnValue("id_person", person.getId_person());
		}
	}

	public java.util.List<PCharacteristicVAO> getPCharacteristicList (PersistenceService ps) {
		if (ps == null) {
			if(this.pCharacteristicList == null) this.pCharacteristicList = new java.util.ArrayList<PCharacteristicVAO>();
		}
		else {
			this.pCharacteristicList = ps.children(new PCharacteristicVAO(), new String[] {"id_pers_property"}, this.pkValues());
			for (PCharacteristicVAO vao : this.pCharacteristicList) {
				vao.beginUpdate();
				vao.setPersProperty((PersonPropertyVAO)this);
				vao.endUpdate();
			}
		}
		return this.pCharacteristicList;
	}

	public java.util.List<PCharacteristicVAO> getPCharacteristicList() {
		return getPCharacteristicList(null);
	}

	public void setPCharacteristicList(java.util.List <PCharacteristicVAO>pCharacteristicList) {
		this.pCharacteristicList = pCharacteristicList;
	}

	// GETTERSI IN SETTERSI

	/**
	 * primarni kljuè
	 */
	public Integer getId_pers_property() {
		return this.id_pers_property;
	}

	/**
	 * primarni kljuè
	 */
	public void setId_pers_property(Integer id_pers_property) {
		if (registerChange("id_pers_property", this.id_pers_property, id_pers_property)) {
			this.id_pers_property = id_pers_property;
			this.hashCode = 0;
		}
	}

	/**
	 * povezava na osebo - poslovnega partnerja
	 */
	public Integer getId_person() {
		if (this.person != null && this.id_person== null) this.id_person = (Integer) this.person.pkValues()[0];
		return this.id_person;
	}

	/**
	 * povezava na osebo - poslovnega partnerja
	 */
	public void setId_person(Integer id_person) {
		if (registerChange("id_person", this.id_person, id_person)) {
			this.id_person = id_person;
		}
	}

	/**
	 * tip lastnosti (naslov, banka, ...)
	 */
	public Integer getTp_property() {
		return this.tp_property;
	}

	/**
	 * tip lastnosti (naslov, banka, ...)
	 */
	public void setTp_property(Integer tp_property) {
		if (registerChange("tp_property", this.tp_property, tp_property)) {
			this.tp_property = tp_property;
		}
	}

	/**
	 * zaèetek veljavnosti - prvi zapis dobi veljavnost od 1.1.1900
	 */
	public SimpleDate getPrp_valid_begin() {
		return this.prp_valid_begin;
	}

	/**
	 * zaèetek veljavnosti - prvi zapis dobi veljavnost od 1.1.1900
	 */
	public void setPrp_valid_begin(SimpleDate prp_valid_begin) {
		if (registerChange("prp_valid_begin", this.prp_valid_begin, prp_valid_begin)) {
			this.prp_valid_begin = prp_valid_begin;
		}
	}

	/**
	 * konec veljavnosti - prvi zapis dobi veljavnost do datuma popravka
	 */
	public SimpleDate getPrp_valid_end() {
		return this.prp_valid_end;
	}

	/**
	 * konec veljavnosti - prvi zapis dobi veljavnost do datuma popravka
	 */
	public void setPrp_valid_end(SimpleDate prp_valid_end) {
		if (registerChange("prp_valid_end", this.prp_valid_end, prp_valid_end)) {
			this.prp_valid_end = prp_valid_end;
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
		if (names.contains("id_pers_property")) {
			value = getValue(rs, "id_pers_property", java.sql.Types.INTEGER);
			setId_pers_property((Integer) value);
		}
		if (names.contains("id_person")) {
			value = getValue(rs, "id_person", java.sql.Types.INTEGER);
			setId_person((Integer) value);
		}
		if (names.contains("tp_property")) {
			value = getValue(rs, "tp_property", java.sql.Types.INTEGER);
			setTp_property((Integer) value);
		}
		if (names.contains("prp_valid_begin")) {
			value = getValue(rs, "prp_valid_begin", java.sql.Types.DATE);
			setPrp_valid_begin((SimpleDate) value);
		}
		if (names.contains("prp_valid_end")) {
			value = getValue(rs, "prp_valid_end", java.sql.Types.DATE);
			setPrp_valid_end((SimpleDate) value);
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
		if ("id_pers_property".equals(field)) value = getId_pers_property();
		else if ("id_person".equals(field)) value = getId_person();
		else if ("tp_property".equals(field)) value = getTp_property();
		else if ("prp_valid_begin".equals(field)) value = getPrp_valid_begin();
		else if ("prp_valid_end".equals(field)) value = getPrp_valid_end();
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
			this.hashCode = 37 * this.hashCode + (this.id_pers_property != null ? this.id_pers_property.hashCode() : 0);
		}

		return this.hashCode;
	}
}
