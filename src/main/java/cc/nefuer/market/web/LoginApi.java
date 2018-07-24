package cc.nefuer.market.web;

import cc.nefuer.market.biz.service.LoginService;
import cc.nefuer.market.common.RestData;
import cc.nefuer.market.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RestData postNotice(@RequestBody User user) {
        return new RestData(loginService.getCode(user));
    }
}
