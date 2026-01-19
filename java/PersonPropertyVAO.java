/**
 *
 * Ta datoteka je bila generirana s programom VAOGenerator
 *
 * Avtor: VAOGenerator
 *
 */

package si.triglav.common.vao.bp;


import java.math.BigDecimal;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import si.triglav.common.SimpleDate;
import si.triglav.common.StringUtils;
import si.triglav.common.constants.Const;
import si.triglav.common.interfaces.Period;
import si.triglav.common.sifrant.Sifra;
import si.triglav.common.vao.gen.bp.PersonPropertyVAOGen;
import si.triglav.min.services.PersistenceService;


public class PersonPropertyVAO extends PersonPropertyVAOGen implements Period, StateHolderVAO {

	/**
	 *
	 */
	private static final long serialVersionUID = 2969672864904910357L;
	private int changeStatus = StateHolderVAO.ORIGINAL;
	private boolean smsProp;

	public PersonPropertyVAO() {}

	public PersonPropertyVAO(Integer id_person, Integer tp_propety, SimpleDate from) {
		this.id_person = id_person;
		this.tp_property = tp_propety;
		this.prp_valid_begin = from;
		this.prp_valid_end = SimpleDate.max;
	}

	/* (non-Javadoc)
	 * @see si.triglav.common.vao.AbstractVAO#onSave(si.triglav.min.services.PersistenceService, boolean)
	 */
	@Override
	public void onSave(PersistenceService ps, boolean genereatePk) {

		if (this.getBegin() == null)
			this.setBegin(Const.DISTANT_PAST);
		if (this.getEnd() == null)
			this.setEnd(Const.DISTANT_FUTURE);

		super.onSave(ps, genereatePk);
	}

	public void updateOrCharacteristic(Object value, Integer characteristicType) {
		PCharacteristicVAO characteristic = this.findFirstCharacteristic(characteristicType);

		if (characteristic != null) {
			if (characteristic.getPersProperty()==null) characteristic.setPersProperty(this);
			if (!characteristic.getPersProperty().isSmsProp() && Sifra.TP_CHAR_TEL_TYPE.equals(characteristic.getTp_character())) {
				characteristic.setPch_number((Integer) value);
				characteristic.setPch_desc(null);
			}
			else if (characteristic.getPersProperty().isSmsProp() && Sifra.TP_CHAR_TEL_TYPE.equals(characteristic.getTp_character())) {
				characteristic.setPch_number((Integer) value);
				if ((Sifra.TP_TELEPHONE_MOBILNI.equals(characteristic.getPch_number()))) {
					characteristic.setPch_desc("1");
				} else {
					characteristic.setPch_desc(null);
				}
			}
			else characteristic.updateValue(value);
		} else {
			characteristic = new PCharacteristicVAO();
			characteristic.setNew(true);
			characteristic.setTp_character(characteristicType);
			characteristic.setPersProperty(this);
			if ((!(characteristic.getPersProperty().isSmsProp())) && (Sifra.TP_CHAR_TEL_TYPE.equals(characteristic.getTp_character()))){
				characteristic.setPch_desc(null);
				characteristic.setPch_number((Integer) value);
			}
			else if (((characteristic.getPersProperty().isSmsProp())) && (Sifra.TP_CHAR_TEL_TYPE.equals(characteristic.getTp_character()))){
				characteristic.setPch_desc("1");
				characteristic.setPch_number((Integer) value);
			}
			else characteristic.updateValue(value);
			this.getPCharacteristicList().add(characteristic);
		}
	}

	/**
	 * Updates a specific characteristic value or creates a new one if it doesn't exitst yet.
	 *
	 * @param value
	 *            Characteristic value.
	 * @param characteristicType
	 *            Type of characteristic to update.
	 */
	public void updateCharacteristic(Object value, Integer characteristicType) {
		PCharacteristicVAO characteristic = this.findFirstCharacteristic(characteristicType);

		if (characteristic != null) {

			if ((!(characteristic.getPersProperty().isSmsProp())) && Sifra.TP_CHAR_TEL_TYPE.equals(characteristic.getTp_character())){
				characteristic.setPch_number((Integer) value);
				characteristic.setPch_desc(null);
			}
			else if (((characteristic.getPersProperty().isSmsProp())) && Sifra.TP_CHAR_TEL_TYPE.equals(characteristic.getTp_character())){
				characteristic.setPch_number((Integer) value);
				if ((Sifra.TP_TELEPHONE_MOBILNI.equals(characteristic.getPch_number()))) {
					characteristic.setPch_desc("1");
				} else {
					characteristic.setPch_desc(null);
				}


			}
			else characteristic.updateValue(value);

		} else {

			characteristic = new PCharacteristicVAO();
			characteristic.setTp_character(characteristicType);
			characteristic.setPersProperty(this);
			if ((!(characteristic.getPersProperty().isSmsProp())) && Sifra.TP_CHAR_TEL_TYPE.equals(characteristic.getTp_character())){
				characteristic.setPch_desc(null);
				characteristic.setPch_number((Integer) value);
			}
			else if (((characteristic.getPersProperty().isSmsProp())) && Sifra.TP_CHAR_TEL_TYPE.equals(characteristic.getTp_character())){
				characteristic.setPch_desc("1");
				characteristic.setPch_number((Integer) value);
			}
			else characteristic.updateValue(value);
			this.getPCharacteristicList().add(characteristic);
		}
	}


	public Object findFirstCharacteristicValue() {

	    return this.findFirstCharacteristicValue(null);
	}

	public Object findFirstCharacteristicValue(Integer characteristicType) {

	    Object value = null;

	    PCharacteristicVAO characteristic = this.findFirstCharacteristic(characteristicType);

	    if (characteristic != null) {

    		if (characteristic.getTp_character().equals(characteristicType)) {
		        if (characteristic.getPch_desc() != null) {
		            value = characteristic.getPch_desc();
		        } else if (characteristic.getPch_number() != null) {
		            value = characteristic.getPch_number();
		        } else if (characteristic.getPch_value() != null) {
		            value = characteristic.getPch_value();
		        } else if (characteristic.getPch_date() != null) {
		            value = characteristic.getPch_date();
		        }
    		}
		}

	    return value;
	}

	/**
	 * Returns value from characteristic, which is the same type as argument valueForType
	 * @param characteristicType Type of characteristic
	 * @param valueForType Type of value
	 * @return Characteristic value
	 */
	public Object findCharacteristicValueByValueType(Integer characteristicType, Object valueForType) {
		if(valueForType == null){
			throw new IllegalArgumentException("valueForType must not be null");
		}

	    Object value = null;

	    PCharacteristicVAO characteristic = this.findFirstCharacteristic(characteristicType);

	    if (characteristic != null) {

    		if (characteristic.getTp_character().equals(characteristicType)) {
    			if (valueForType instanceof String) {
    		        value = characteristic.getPch_desc();
    		    } else if (valueForType instanceof Integer) {
    		        value = characteristic.getPch_number();
    		    } else if (valueForType instanceof Date) {
    		    	value = characteristic.getPch_date();
    		    } else if (valueForType instanceof BigDecimal) {
    		        value = characteristic.getPch_value();
    		    }
    		}
		}

	    return value;
	}

	public boolean hasCharacteristicDefined(final Integer tpCharacter) {
		if (tpCharacter == null) {
			return false;
		}

		final List<PCharacteristicVAO> allCharacteristicsForTpCharacter = findAllCharacteristics(tpCharacter);
		if ((allCharacteristicsForTpCharacter == null) || allCharacteristicsForTpCharacter.isEmpty()) {
			return false;
		}

		boolean hasCharacteristicValueDefined = false;
		for (final PCharacteristicVAO pCharacteristicVao : allCharacteristicsForTpCharacter) {
			if (pCharacteristicVao == null) {
				continue;
			}

			if (pCharacteristicVao.hasCharacteristicValueDefined()) {
				hasCharacteristicValueDefined = true;
				break;
			}
		}

		return hasCharacteristicValueDefined;
	}

	public boolean hasCharacteristicValue(final Integer tpCharacter, final Object anyValue) {
		if ((tpCharacter == null) || (anyValue == null)) {
			return false;
		}

		final List<PCharacteristicVAO> allCharacteristicsForTpCharacter = findAllCharacteristics(tpCharacter);
		if ((allCharacteristicsForTpCharacter == null) || allCharacteristicsForTpCharacter.isEmpty()) {
			return false;
		}

		boolean hasCharacteristicValue = false;
		for (final PCharacteristicVAO pCharacteristicVao : allCharacteristicsForTpCharacter) {
			if (pCharacteristicVao == null) {
				continue;
			}

			if (pCharacteristicVao.hasCharacteristicValue(anyValue)) {
				hasCharacteristicValue = true;
				break;
			}
		}

		return hasCharacteristicValue;
	}

	public boolean hasCharacteristicSms(Integer characteristicType) {
		PCharacteristicVAO characteristic = this.findFirstCharacteristic(characteristicType);


	    if (characteristic != null) {
	    	if (characteristic.getTp_character().equals(characteristicType)) {
		        if (characteristic.getPch_desc() != null) {
		        	if (characteristic.getPch_desc().equals("1")) {
		        		return true;
		        	}
		        }
		    }
	    }
	    return false;
	}


	public Object findFirstCharacteristicValue2(Integer characteristicType) {

	    Object value = null;

	    PCharacteristicVAO characteristic = this.findFirstCharacteristic(characteristicType);

	    if (characteristic != null) {

    		if (characteristic.getTp_character().equals(characteristicType)) {
    			value = characteristic.getPch_number();
    		}
		}
	    return value;
	}


	public PCharacteristicVAO findFirstCharacteristic(Integer characteristicType) {

	    PCharacteristicVAO result = null;

	    List<PCharacteristicVAO> characteristics = this.getPCharacteristicList();

	    if (characteristics != null) {

		    if (characteristicType == null && characteristics.size() > 0) {
		    	result = characteristics.get(0);
		    } else {

		    	for (PCharacteristicVAO characteristic : characteristics) {

		    		if (characteristic.getTp_character().equals(characteristicType)) {
				       result = characteristic;
				       break;
		    		}

				}
		    }
	    }

	    return result;
	}

	public List<PCharacteristicVAO> findAllCharacteristics(Integer characteristicType) {
		assert (characteristicType != null) : "characteristicType is null";

		List<PCharacteristicVAO> allCharacteristics = new LinkedList<PCharacteristicVAO>();

	    List<PCharacteristicVAO> characteristics = this.getPCharacteristicList();
	    if (characteristics == null) {
	    	return allCharacteristics;
	    }
	    if (characteristics.isEmpty()) {
	    	return allCharacteristics;
	    }

    	for (PCharacteristicVAO characteristic : characteristics) {
    		if (characteristic == null) {
    			continue;
    		}

    		Integer tpCharacter = characteristic.getTp_character();
    		if (tpCharacter == null) {
    			continue;
    		}

    		if (tpCharacter.equals(characteristicType)) {
    			allCharacteristics.add(characteristic);
    		}
		}

	    return allCharacteristics;
	}

	public String findFirstNotEmptyPchDesc(Integer characteristicType) {
		if (characteristicType == null) {
			throw new IllegalArgumentException("characteristicType must not be null");
		}

		List<PCharacteristicVAO> allCharacteristics = findAllCharacteristics(characteristicType);
		if (allCharacteristics == null) {
			return null;
		}

		if (allCharacteristics.isEmpty()) {
			return null;
		}

		String firstNotEmptyPchDesc = null;
		for (PCharacteristicVAO pCharacteristicVAO : allCharacteristics) {
			if (pCharacteristicVAO == null) {
				continue;
			}

			String pchDesc = pCharacteristicVAO.getPch_desc();
			if (!StringUtils.isStringEmpty(pchDesc)) {
				firstNotEmptyPchDesc = pchDesc;
				break;
			}
		}

		return firstNotEmptyPchDesc;
	}

	public PCharacteristicVAO addCharacteristic(Integer characteristicType, Object value) {

	    PCharacteristicVAO characteristic = new PCharacteristicVAO();
	    characteristic.setTp_character(characteristicType);
	    characteristic.setPersProperty(this);

	    if (value instanceof String) {
	        characteristic.setPch_desc((String) value);
	    } else if (value instanceof Integer) {
	        characteristic.setPch_number((Integer) value);
	    } else if (value instanceof Date) {
	        characteristic.setPch_date(SimpleDate.toSimpleDate((Date) value));
	    } else if (value instanceof BigDecimal) {
	        characteristic.setPch_value((BigDecimal) value);
	    } else if (value == null) {
	        characteristic.setPch_desc(null);
	        characteristic.setPch_number(null);
	        characteristic.setPch_date(null);
	        characteristic.setPch_value(null);
	    }
	    else {
	        throw new IllegalArgumentException("Invalid value type for characteristic: " + value.getClass());
	    }

	    this.getPCharacteristicList().add(characteristic);

	    return characteristic;
	}

	/* (non-Javadoc)
	 * @see si.triglav.common.interfaces.Period#getBegin()
	 */
	@Override
	public SimpleDate getBegin() {
		return this.getPrp_valid_begin();
	}

	/* (non-Javadoc)
	 * @see si.triglav.common.interfaces.Period#getEnd()
	 */
	@Override
	public SimpleDate getEnd() {
		return this.getPrp_valid_end();
	}

	/* (non-Javadoc)
	 * @see si.triglav.common.interfaces.Period#setBegin(si.triglav.common.SimpleDate)
	 */
	@Override
	public void setBegin(SimpleDate begin) {
		this.setPrp_valid_begin(begin);
	}

	/* (non-Javadoc)
	 * @see si.triglav.common.interfaces.Period#setEnd(si.triglav.common.SimpleDate)
	 */
	@Override
	public void setEnd(SimpleDate end) {
		this.setPrp_valid_end(end);
	}

	/* (non-Javadoc)
	 * @see si.triglav.common.vao.bp.StateHolderVAO#getChangeStatus()
	 */
	@Override
	public int getChangeStatus() {
		return this.changeStatus;
	}

	/* (non-Javadoc)
	 * @see si.triglav.common.vao.bp.StateHolderVAO#setChangeStatus(int)
	 */
	@Override
	public void setChangeStatus(int changeStatus) {
		this.changeStatus = changeStatus;
	}

	public boolean isTelephoneProperty() {
		return Sifra.TP_PROPERTY_TEL.equals(this.tp_property);
	}

	public boolean isEmailProperty() {
		return Sifra.TP_PROPERTY_EMAIL.equals(this.tp_property);
	}

	public boolean isSmsProp() {
		return this.smsProp;
	}

	public void setSmsProp(boolean sms) {
		this.smsProp = sms;
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
			return super.hashCode();
		}
		return this.hashCode;
	}

}

