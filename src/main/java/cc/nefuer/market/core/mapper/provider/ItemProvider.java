package cc.nefuer.market.core.mapper.provider;

import cc.nefuer.market.core.model.Item;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author jimi花
 * @dare 2018/7/28
 */
public class ItemProvider {
    public String selectByCondition(Item item) {
        return new SQL() {
            {
                SELECT("item_id AS itemId,name," +
                        "price, content, sort_id AS sortId , publish_id AS publishId, " +
                        "purchase_id AS purchaseId, views, status, create_time AS createTime," +
                        "last_edit_time AS lastEditTime");
                FROM("tb_item");
                if (null != item.getItemId()) {
                    WHERE("item_id=#{itemId}");
                }
                if (null != item.getSortId()) {
                    WHERE("sort_id=#{sortId}");
                }
                ORDER_BY("item_id DESC");
            }
        }.toString();
    }
}
