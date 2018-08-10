package cc.nefuer.market.core.model;

import java.util.Date;

/**
 * @author jimi花
 * @date 2018/7/24
 */
public class User {
    /**
     * 用户Id
     */
    private Integer userId;
    /**
     * 微信昵称
     */
    private String wechatName;
    /**
     * 真实姓名
     */
    private String name;
    /**
     * 用户头像
     */
    private String profileImg;
    /**
     * 性别
     */
    private String gender;
    /**
     * 手机号
     */
    private String telNumber;
    /**
     * 收货地址
     */
    private String address;
    /**
     * 登陆code
     */
    private String code;
    /**
     * openID
     */
    private String openId;
    /**
     * sessionKey
     */
    private String sessionKey;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 最后编辑时间
     */
    private String lastEditTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getWechatName() {
        return wechatName;
    }

    public void setWechatName(String wechatName) {
        this.wechatName = wechatName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(String lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
