package cc.nefuer.market.web;

import cc.nefuer.market.biz.service.LoginService;
import cc.nefuer.market.common.ErrorMessage;
import cc.nefuer.market.common.RestData;
import cc.nefuer.market.common.util.TokenUtil;
import cc.nefuer.market.core.model.User;
import jdk.nashorn.internal.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jimi花
 * @dare 2018/7/24
 */
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class LoginApi {
    private final LoginService loginService;

    @Autowired
    public LoginApi(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/openid", method = RequestMethod.POST)
    public RestData postOpenId(@RequestBody User user) {
        return new RestData(loginService.getCode(user));
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public RestData postUser(@RequestBody User user, HttpServletRequest request) {
        User currentUser = TokenUtil.getUserByToken(request);
        System.out.println(user);
        if(null != currentUser) {
            user.setOpenId(request.getHeader("openId"));
            return loginService.getUserId(user);
        }
        if (null != user.getOpenId() && loginService.postUser(user)) {
            return new RestData(user.getUserId());
        }else {
            return new RestData(0, ErrorMessage.PLEASE_RELOGIN);
        }
    }

    @RequestMapping(value = "/info/{userId}", method = RequestMethod.GET)
    public RestData postUser(@PathVariable(value = "userId") int userId, HttpServletRequest request) {
        User currentUser = TokenUtil.getUserByToken(request);
        if(null == currentUser) {
            return new RestData(2, ErrorMessage.PLEASE_RELOGIN);
        }
        return loginService.getInfo(userId);
    }
}
