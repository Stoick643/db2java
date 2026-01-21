package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=7742 (Kontakt - email naslov)
 * Generated - do not edit manually.
 */
public class KontaktEmailNaslov_7742 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private String emailNaslov;  // 7803 desc
    private Integer zaporednaStevilkaLastnosti;  // 7840 number

    public String getEmailNaslov() {
        return emailNaslov;
    }

    public void setEmailNaslov(String emailNaslov) {
        this.emailNaslov = emailNaslov;
    }

    public Integer getZaporednaStevilkaLastnosti() {
        return zaporednaStevilkaLastnosti;
    }

    public void setZaporednaStevilkaLastnosti(Integer zaporednaStevilkaLastnosti) {
        this.zaporednaStevilkaLastnosti = zaporednaStevilkaLastnosti;
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
            case 7803: return this.getEmailNaslov();
            case 7840: return this.getZaporednaStevilkaLastnosti();
            default: return null;
        }
    }

}