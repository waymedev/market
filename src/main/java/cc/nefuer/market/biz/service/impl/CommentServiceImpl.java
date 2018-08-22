package cc.nefuer.market.biz.service.impl;

import cc.nefuer.market.biz.service.CommentService;
import cc.nefuer.market.common.Page;
import cc.nefuer.market.common.RestData;
import cc.nefuer.market.common.util.PageUtil;
import cc.nefuer.market.core.mapper.CommentMapper;
import cc.nefuer.market.core.mapper.ImgMapper;
import cc.nefuer.market.core.mapper.UserMapper;
import cc.nefuer.market.core.model.Star;
import cc.nefuer.market.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.nefuer.market.core.model.Comment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jimi花
 * @date 2018/8/16
 */
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;
    private final UserMapper userMapper;
    private final ImgMapper imgMapper;

    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper,UserMapper userMapper,ImgMapper imgMapper) {
        this.commentMapper = commentMapper;
        this.userMapper = userMapper;
        this.imgMapper = imgMapper;
    }
    @Override
    public boolean postComment(Comment comment) {
        boolean rtv = false;
        rtv = 0 < commentMapper.insert(comment);
        return rtv;
    }

    @Override
    public RestData getComment(Comment comment) {
        Page page ;
        if(null == comment.getPage())
            comment.setPage(1);

        page = commentMapper.countByCondition(comment);
        page.setCurrentPage(comment.getPage());
        page.setPageSize(8);
        page = PageUtil.checkPage(page);
        List<Map<String,Object>> rtv = new ArrayList<>();
        List<Comment> data = commentMapper.selectByCondition(comment,page);
        for(Comment comment1 : data) {
            User user = userMapper.selectByUserId(comment1.getUserId());
            Map<String, Object> map = new HashMap<>(7);
            map.put("commentId",comment1.getCommentId());
            map.put("wechatName",user.getWechatName());
            map.put("profileImg",user.getProfileImg());
            map.put("content",comment1.getContent());
            map.put("parentId",comment1.getParentId());
            map.put("createTime",comment1.getCreateTime());
            rtv.add(map);
        }
        return new RestData(rtv,page);
    }

    @Override
    public boolean delete(int commentId) {
        return 0 < commentMapper.deleteByCommentId(commentId);
    }
}
