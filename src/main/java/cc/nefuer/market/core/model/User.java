package cc.nefuer.market.core.model;

/**
 * @author jimi花
 * @dare 2018/7/24
 */
public class User {
    private String code;
    private String openId;
    private String sessionKey;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}
