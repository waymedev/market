package cc.nefuer.market.core.model;

/**
 * @author jimi花
 * @date 2018/7/28
 */
public class Item {

    /**
     * 商品ID
     */
    private Integer itemId;
    /**
     * 商品名字
     */
    private String name;
    /**
     * 商品价格
     */
    private Integer price;
    /**
     * 商品描述
     */
    private String content;
    /**
     * 分类Id
     */
    private Integer sortId;
    /**
     * 发布ID
     */
    private Integer publishId;
    /**
     * 购买ID
     */
    private Integer purchaseId;
    /**
     * 浏览人数
     */
    private Integer views;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private String createTime;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public Integer getPublishId() {
        return publishId;
    }

    public void setPublishId(Integer publishId) {
        this.publishId = publishId;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    private String lastEditTime;
}
