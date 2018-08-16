package cc.nefuer.market.web;

import cc.nefuer.market.biz.service.StarService;
import cc.nefuer.market.common.ErrorMessage;
import cc.nefuer.market.common.RestData;
import cc.nefuer.market.common.util.TokenUtil;
import cc.nefuer.market.core.model.Star;
import cc.nefuer.market.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jimi花
 * @date 2018/8/8
 */
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class StarAPI {

    private final StarService starService;

    @Autowired
    public StarAPI(StarService starService) {
        this.starService = starService;
    }

    @RequestMapping(value = "/star", method = RequestMethod.POST)
    public RestData postStar(@RequestBody Star star, HttpServletRequest request) {
        User currentUser = TokenUtil.getUserByToken(request);
        if (null == currentUser) {
            return new RestData(2, ErrorMessage.PLEASE_RELOGIN);
        }
        return new RestData(starService.postStar(star));
    }

    @RequestMapping(value = "/star", method = RequestMethod.GET)
    public RestData getStar(Star star, HttpServletRequest request) {
        User currentUser = TokenUtil.getUserByToken(request);
        if (null == currentUser) {
            return new RestData(2, ErrorMessage.PLEASE_RELOGIN);
        }
        return starService.getStar(star);
    }

    @RequestMapping(value = "/star/{starId}", method = RequestMethod.DELETE)
    public RestData deletePic(@PathVariable(value = "starId") int starId, HttpServletRequest request) {
        User currentUser = TokenUtil.getUserByToken(request);
        if (null == currentUser) {
            return new RestData(2, ErrorMessage.PLEASE_RELOGIN);
        }
        return new RestData(starService.delete(starId));
    }

    @RequestMapping(value = "/isstar", method = RequestMethod.GET)
    public RestData isStar(Star star, HttpServletRequest request) {
        User currentUser = TokenUtil.getUserByToken(request);
        if (null == currentUser) {
            return new RestData(2, ErrorMessage.PLEASE_RELOGIN);
        }
        return new RestData(starService.isStar(star));
    }
}
