package cc.nefuer.market.biz.service;

import cc.nefuer.market.common.RestData;

import cc.nefuer.market.core.model.Comment;

/**
 * @author jimi花
 * @date 2018/8/16
 */
public interface CommentService {
    /**
     * 添加收藏
     *
     * @param comment 参数集
     * @return 是否添加成功
     */
    boolean postComment(Comment comment);

    /**
     * 获取收藏列表
     * @param comment
     * @return
     */
    RestData getComment(Comment comment);

    /**
     * 根据主键删除记录
     * @param commentId
     * @return
     */
    boolean delete(int commentId);
}
