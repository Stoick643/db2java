package si.triglav.common.propchar.generated.properties;

import si.triglav.common.propchar.properties.BaseProperties;

/**
 * Typed class for TP_PROPERTY=8316 (Posebni email naslov)
 * Generated - do not edit manually.
 */
public class PosebniEmailNaslov_8316 extends BaseProperties {

    private static final long serialVersionUID = 1L;

    private Integer zaporednaStevilkaLastnosti;  // 7840 number
    private Integer tipPosebnegaEmailNaslova;  // 8317 number
    private String emailNaslov;  // 8318 desc
    private Integer tpcharspecialemailverified;  // 8575 number

    public Integer getZaporednaStevilkaLastnosti() {
        return zaporednaStevilkaLastnosti;
    }

    public void setZaporednaStevilkaLastnosti(Integer zaporednaStevilkaLastnosti) {
        this.zaporednaStevilkaLastnosti = zaporednaStevilkaLastnosti;
    }

    public Integer getTipPosebnegaEmailNaslova() {
        return tipPosebnegaEmailNaslova;
    }

    public void setTipPosebnegaEmailNaslova(Integer tipPosebnegaEmailNaslova) {
        this.tipPosebnegaEmailNaslova = tipPosebnegaEmailNaslova;
    }

    public String getEmailNaslov() {
        return emailNaslov;
    }

    public void setEmailNaslov(String emailNaslov) {
        this.emailNaslov = emailNaslov;
    }

    public Integer getTpcharspecialemailverified() {
        return tpcharspecialemailverified;
    }

    public void setTpcharspecialemailverified(Integer tpcharspecialemailverified) {
        this.tpcharspecialemailverified = tpcharspecialemailverified;
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
            case 7840: return this.getZaporednaStevilkaLastnosti();
            case 8317: return this.getTipPosebnegaEmailNaslova();
            case 8318: return this.getEmailNaslov();
            case 8575: return this.getTpcharspecialemailverified();
            default: return null;
        }
    }

}