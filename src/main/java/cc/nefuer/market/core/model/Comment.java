package cc.nefuer.market.core.model;

import cc.nefuer.market.common.Page;
import org.mortbay.log.StdErrLog;

import java.util.Date;

/**
 * @author jimi花
 * @date 2018/8/16
 */
public class Comment {
    /**
     * 评论ID
     */
    private Integer commentId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 父评论ID
     */
    private Integer parentId;

    /**
     * 商品ID
     */
    private Integer itemId;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 分页
     */
    private Integer page;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
}
