package cc.nefuer.market.common.util;

import cc.nefuer.market.common.Page;

/**
 * @author jimi花
 * @dare 2018/8/5
 */
public class PageUtil {
    public static String getLimit(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        int size = pageSize;
        return start + "," + size;
    }

    public static Page checkPage(Page page) {
        Page rtv = new Page();
        int currentPage = page.getCurrentPage();
        int totalSize = page.getTotalSize();
        int pageSize = page.getPageSize();
        int totalPage = 0 == totalSize % pageSize ? totalSize / pageSize : totalSize / pageSize + 1;
        if (1 > totalPage) {
            totalPage = 1;
        }
        if (1 > currentPage) {
            currentPage = 1;
        } else if (currentPage > totalPage) {
            currentPage = totalPage;
        }
        rtv.setTotalPage(totalPage);
        rtv.setCurrentPage(currentPage);
        rtv.setTotalSize(totalSize);
        rtv.setPageSize(pageSize);
        return rtv;
    }
}
