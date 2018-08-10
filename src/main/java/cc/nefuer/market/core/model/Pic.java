package cc.nefuer.market.core.model;

/**
 * @author jimi花
 * @date 2018/7/27
 */
public class Pic {
    /**
     * 轮播图Id
     */
    private Integer picId;
    /**
     * 轮播图名称
     */
    private String name;
    /**
     * 轮播图url
     */
    private String picUrl;

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
