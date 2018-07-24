package cc.nefuer.market.common;

/**
 * @author jimi花
 * @dare 2018/7/24
 */
public class Page {
    /**
     * 当前页码
     */
    private Integer currentPage;

    /**
     * 总页码数
     */
    private Integer totalPage;

    /**
     * 每页数据量,默认 10
     */
    private Integer pageSize = 9;

    /**
     * 数据总量
     */
    private Integer totalSize;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }
}
