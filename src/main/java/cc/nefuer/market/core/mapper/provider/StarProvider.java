package cc.nefuer.market.core.mapper.provider;

import cc.nefuer.market.common.Page;
import cc.nefuer.market.common.util.PageUtil;
import cc.nefuer.market.core.model.Star;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author jimi花
 * @date 2018/8/8
 */
public class StarProvider {
    public String countByCondition(Star star) {
        return new SQL() {
            {

                SELECT("count(star_id) AS totalSize");
                FROM("tb_star");
            }
        }.toString();
    }

    public String selectByCondition(Star star, Page page) {
        String limit = "4";
        if (null != page) {
            limit = PageUtil.getLimit(page.getCurrentPage(), page.getPageSize());
        }

        String finalLimit = limit;
        return new SQL() {
            {
                SELECT("star_id AS starId,user_id AS userId," +
                        "item_id AS itemId");
                FROM("tb_star");
                if (null != star.getStarId()) {
                    WHERE("star_id=" + star.getStarId());
                }
                if (null != star.getItemId()) {
                    WHERE("user_id=" + star.getUserId());
                }
                if (null != star.getUserId()) {
                    WHERE("item_id=" + star.getItemId());
                }
                ORDER_BY("star_id DESC,star_id LIMIT " + finalLimit);
            }
        }.toString();
    }
}
