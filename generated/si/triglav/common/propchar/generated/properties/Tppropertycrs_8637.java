package si.triglav.common.propchar.generated.properties;

import si.triglav.common.SimpleDate;
import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=8637 (TP_PROPERTY_CRS)
 * Generated - do not edit manually.
 */
public class Tppropertycrs_8637 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer tpcharcrsyesno;  // 8636 number
    private SimpleDate tpcharcrsnotesentdate;  // 12665 date
    private SimpleDate tpcharcrsreceivedconfirmationdate;  // 12666 date
    private SimpleDate tpcharcrsvalidbegindate;  // 12667 date

    public Integer getTpcharcrsyesno() {
        return tpcharcrsyesno;
    }

    public void setTpcharcrsyesno(Integer tpcharcrsyesno) {
        this.tpcharcrsyesno = tpcharcrsyesno;
    }

    public SimpleDate getTpcharcrsnotesentdate() {
        return tpcharcrsnotesentdate;
    }

    public void setTpcharcrsnotesentdate(SimpleDate tpcharcrsnotesentdate) {
        this.tpcharcrsnotesentdate = tpcharcrsnotesentdate;
    }

    public SimpleDate getTpcharcrsreceivedconfirmationdate() {
        return tpcharcrsreceivedconfirmationdate;
    }

    public void setTpcharcrsreceivedconfirmationdate(SimpleDate tpcharcrsreceivedconfirmationdate) {
        this.tpcharcrsreceivedconfirmationdate = tpcharcrsreceivedconfirmationdate;
    }

    public SimpleDate getTpcharcrsvalidbegindate() {
        return tpcharcrsvalidbegindate;
    }

    public void setTpcharcrsvalidbegindate(SimpleDate tpcharcrsvalidbegindate) {
        this.tpcharcrsvalidbegindate = tpcharcrsvalidbegindate;
    }

    /**
     * Bridge method for accessing characteristics by tp_character ID.
     *
     * <p><b>Use sparingly:</b> This method is provided for backward compatibility
     * and legacy code migration. Prefer using typed getters directly
     * (e.g., getStevilkaDokumenta() instead of getCharValue(7805)).</p>
     *
     * @param tpCharacter The characteristic type ID
     * @return The characteristic value, or null if not found
     */
    public Object getCharValue(Integer tpCharacter) {
        switch (tpCharacter) {
            case 8636: return this.getTpcharcrsyesno();
            case 12665: return this.getTpcharcrsnotesentdate();
            case 12666: return this.getTpcharcrsreceivedconfirmationdate();
            case 12667: return this.getTpcharcrsvalidbegindate();
            default: return null;
        }
    }

}