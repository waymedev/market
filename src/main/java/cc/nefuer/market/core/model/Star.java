package cc.nefuer.market.core.model;

/**
 * @author jimi花
 * @date 2018/8/8
 */
public class Star {

    /**
     * 收藏ID
     */
    private Integer starId;
    /**
     * 商品ID
     */
    private Integer itemId;
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 页数
     */
    private Integer page;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getStarId() {
        return starId;
    }

    public void setStarId(Integer starId) {
        this.starId = starId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
