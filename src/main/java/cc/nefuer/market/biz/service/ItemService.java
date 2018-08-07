package cc.nefuer.market.biz.service;

import cc.nefuer.market.common.RestData;
import cc.nefuer.market.core.model.Item;
import cc.nefuer.market.core.model.User;
import cc.nefuer.market.core.model.vo.ItemVo;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jimi花
 * @dare 2018/7/28
 */
public interface ItemService {

    /**
     * 添加商品
     *
     * @param item 参数集
     * @return 是否添加成功
     */
    boolean postItem(Item item);

    /**
     * 获取商品
     * @param itemVo
     * @return
     */
    RestData getItem(ItemVo itemVo, HttpServletRequest request);
}
