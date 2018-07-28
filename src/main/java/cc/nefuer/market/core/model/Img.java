package cc.nefuer.market.core.model;

/**
 * @author jimi花
 * @dare 2018/7/27
 */
public class Img {
    /**
     * 图片Id
     */
    private Integer imgId;
    /**
     * 图片对应商品Id
     */
    private Integer itemId;
    /**
     * 图片url地址
     */
    private String imgUrl;

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
