package cc.nefuer.market.core.mapper;

import cc.nefuer.market.common.Page;
import cc.nefuer.market.core.mapper.provider.CommentProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import cc.nefuer.market.core.model.Comment;
import java.util.List;

/**
 * @author jimi花
 * @date 2018/8/16
 */
@Mapper
@Repository
public interface CommentMapper {
    /**
     * 插入新纪录
     *
     * @param comment 参数集
     * @return 插入记录数
     */
    @Insert("INSERT INTO tb_comment(content,item_id,parent_id,user_id) VALUES(" +
            "#{content},#{itemId},#{parentId},#{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "commentId")
    int insert(Comment comment);

    /**
     * 条件查询计数
     *
     * @param comment 参数集
     * @return 符合条件的记录
     */
    @SelectProvider(type = CommentProvider.class, method = "countByCondition")
    Page countByCondition(Comment comment);

    /**
     * 分页查询
     *
     * @param comment 参数集
     * @param page   分页信息
     * @return 符合条件的记录
     */
    @SelectProvider(type = CommentProvider.class, method = "selectByCondition")
    List<Comment> selectByCondition(Comment comment, Page page);

    /**
     * 根据主键删除记录
     *
     * @param commentId 主键
     * @return 删除记录数
     */
    @Delete("DELETE FROM tb_comment WHERE comment_id=#{commentId}")
    int deleteByCommentId(int commentId);
}
