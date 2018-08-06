package cc.nefuer.market.core.mapper.provider;

import cc.nefuer.market.common.Page;
import cc.nefuer.market.common.util.PageUtil;
import cc.nefuer.market.core.model.Item;
import cc.nefuer.market.core.model.vo.ItemVo;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author jimi花
 * @dare 2018/7/28
 */
public class ItemProvider {

    public String countByCondition(ItemVo itemVo) {
        return new SQL() {
            {

                SELECT("count(item_id) AS totalSize");
                FROM("tb_item");
                if (null != itemVo.getSortId()) {
                    WHERE("sort_id=" + itemVo.getSortId());
                }
            }
        }.toString();
    }


    public String selectByCondition(ItemVo itemVo, Page page) {
        String limit = "4";
        if (null != page) {
            limit = PageUtil.getLimit(page.getCurrentPage(), page.getPageSize());
        }

        String finalLimit = limit;
        return new SQL() {
            {
                SELECT("item_id AS itemId,name," +
                        "price, content, sort_id AS sortId , publish_id AS publishId, " +
                        "purchase_id AS purchaseId, views, status, create_time AS createTime," +
                        "last_edit_time AS lastEditTime");
                FROM("tb_item");
                if (null != itemVo.getItemId()) {
                    WHERE("item_id=" + itemVo.getItemId());
                }
                if (null != itemVo.getSortId()) {
                    WHERE("sort_id=" + itemVo.getSortId());
                }
                ORDER_BY("item_id DESC,item_id LIMIT " + finalLimit);
            }
        }.toString();
    }

    public String updateByItemId(Item item) {
        return new SQL() {
            {
                UPDATE("tb_item");
                if (null != item.getViews()) {
                    SET("views=#{views}");
                }
                if (null != item.getName()) {
                    SET("name=#{name}");
                }
                if (null != item.getPrice()) {
                    SET("price=#{price}");
                }
                if (null != item.getContent()) {
                    SET("content=#{content}");
                }
                if (null != item.getSortId()) {
                    SET("sort_id=#{sortId}");
                }
                if (null != item.getPurchaseId()) {
                    SET("purchase_id=#{purchaseId}");
                }
                if (null != item.getStatus()) {
                    SET("status=#{status}");
                }
                if (null != item.getLastEditTime()) {
                    SET("last_edit_time=#{lastEditTime}");
                }
                WHERE("item_id=#{itemId}");

            }
        }.toString();
    }
}
