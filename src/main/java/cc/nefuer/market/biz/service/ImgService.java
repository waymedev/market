package cc.nefuer.market.biz.service;

import cc.nefuer.market.common.RestData;
import cc.nefuer.market.core.model.Img;
import cc.nefuer.market.core.model.Item;

import java.util.List;

/**
 * @author jimi花
 * @date 2018/7/28
 */
public interface ImgService {

    /**
     * 添加商品
     *
     * @param imgs 参数集
     * @return 是否添加成功
     */
    RestData postImg(List<Img> imgs);

    /**
     * 获取商品图片
     * @param img
     * @return
     */
    RestData getImg(Img img);

    /**
     * 获取图片详细信息
     * @param imgId
     * @return
     */
    RestData getImgInfo(int imgId);

    /**
     * 根据主键删除记录
     * @param itemId
     * @return
     */
    boolean deleteImg(int itemId);
}
