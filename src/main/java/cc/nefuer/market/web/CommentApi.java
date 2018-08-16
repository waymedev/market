package cc.nefuer.market.web;

import cc.nefuer.market.biz.service.CommentService;
import cc.nefuer.market.common.ErrorMessage;
import cc.nefuer.market.common.RestData;
import cc.nefuer.market.common.util.TokenUtil;
import cc.nefuer.market.core.model.Star;
import cc.nefuer.market.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import cc.nefuer.market.core.model.Comment;

/**
 * @author jimi花
 * @date 2018/8/16
 */
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class CommentApi {

    private final CommentService commentService;

    @Autowired
    public CommentApi(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public RestData postComment(@RequestBody Comment comment, HttpServletRequest request) {
        User currentUser = TokenUtil.getUserByToken(request);
        if (null == currentUser) {
            return new RestData(2, ErrorMessage.PLEASE_RELOGIN);
        }
        return new RestData(commentService.postComment(comment));
    }

    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    public RestData getComment(Comment comment, HttpServletRequest request) {
        User currentUser = TokenUtil.getUserByToken(request);
        if (null == currentUser) {
            return new RestData(2, ErrorMessage.PLEASE_RELOGIN);
        }
        return commentService.getComment(comment);
    }

    @RequestMapping(value = "/comment/{commentId}", method = RequestMethod.DELETE)
    public RestData deletePic(@PathVariable(value = "commentId") int commentId, HttpServletRequest request) {
        User currentUser = TokenUtil.getUserByToken(request);
        if (null == currentUser) {
            return new RestData(2, ErrorMessage.PLEASE_RELOGIN);
        }
        return new RestData(commentService.delete(commentId));
    }
}
