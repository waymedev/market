package cc.nefuer.market.biz.service;

import cc.nefuer.market.common.RestData;
import cc.nefuer.market.core.model.Star;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jimi花
 * @date 2018/8/8
 */
public interface StarService {

    /**
     * 添加收藏
     *
     * @param star 参数集
     * @return 是否添加成功
     */
    boolean postStar(Star star);

    /**
     * 获取收藏列表
     * @param star
     * @return
     */
    RestData getStar(Star star);

    /**
     * 根据主键删除记录
     * @param starId
     * @return
     */
    boolean delete(int starId);

    /**
     * 是否被收藏
     * @param star
     * @return
     */
    boolean isStar(Star star);
}
