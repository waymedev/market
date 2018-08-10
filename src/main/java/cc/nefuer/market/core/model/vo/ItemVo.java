package cc.nefuer.market.core.model.vo;

/**
 * @author jimi花
 * @date 2018/8/5
 */
public class ItemVo {

    /**
     * 页数
     */
    private Integer page;

    /**
     * 分类ID
     */
    private Integer sortId;

    /**
     * 商品ID
     */
    private Integer itemId;

    /**
     * 发布者ID
     */
    private Integer publishId;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getPublishId() {
        return publishId;
    }

    public void setPublishId(Integer publishId) {
        this.publishId = publishId;
    }
}
