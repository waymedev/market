package cc.nefuer.market.core.mapper.provider;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author jimi花
 * @dare 2018/7/27
 */
public class SortProvider {
    public String selectByCondition() {
        return new SQL() {
            {
                SELECT("sort_id AS sortId,sort_name AS sortName,sort_index AS sortIndex");
                FROM("tb_sort");
                ORDER_BY("sort_index ASCz");
            }
        }.toString();
    }
}
