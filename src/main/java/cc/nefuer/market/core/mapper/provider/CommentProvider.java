package cc.nefuer.market.core.mapper.provider;

import cc.nefuer.market.common.Page;
import cc.nefuer.market.common.util.PageUtil;
import jdk.nashorn.internal.objects.annotations.Where;
import org.apache.ibatis.jdbc.SQL;

import cc.nefuer.market.core.model.Comment;

/**
 * @author jimi花
 * @date 2018/8/16
 */
public class CommentProvider {
    public String countByCondition(Comment comment) {
        return new SQL() {
            {

                SELECT("count(comment_id) AS totalSize");
                FROM("tb_comment");
                if(comment.getItemId() != null) {
                    WHERE("item_id=" + comment.getItemId());
                }
                if(comment.getUserId() != null) {
                    WHERE("user_id=" + comment.getUserId());
                }
            }
        }.toString();
    }

    public String selectByCondition(Comment comment, Page page) {
        String limit = "8";
        if (null != page) {
            limit = PageUtil.getLimit(page.getCurrentPage(), page.getPageSize());
        }

        String finalLimit = limit;
        return new SQL() {
            {
                SELECT("comment_id AS commentId,user_id AS userId," +
                        "item_id AS itemId, parent_id AS parentId, create_time AS createTime, content");
                FROM("tb_comment");
                if(comment.getItemId() != null) {
                    WHERE("item_id=" + comment.getItemId());
                }
                if(comment.getUserId() != null) {
                    WHERE("user_id=" + comment.getUserId());
                }
                ORDER_BY("comment_id DESC,comment_id LIMIT " + finalLimit);
            }
        }.toString();
    }
}
