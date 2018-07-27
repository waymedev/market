package cc.nefuer.market.core.model;

/**
 * @author jimi花
 * @dare 2018/7/27
 */
public class Sort {
    /**
     * 分类ID
     */
    private Integer sortId;

    /**
     * 分类名
     */
    private String sortName;

    /**
     * 分类权重
     */
    private Integer sortIndex;

    /**
     * 分类创建时间
     */
    private String createTime;

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }


    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
