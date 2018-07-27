package cc.nefuer.market.common.util;

import cc.nefuer.market.core.mapper.UserMapper;
import cc.nefuer.market.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author jimi花
 * @dare 2018/7/26
 */
@Component
public class TokenUtil {

    private static UserMapper userMapper;
    @Autowired
    public TokenUtil(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public static User getUserByToken(HttpServletRequest request) {
        User user = null;
        String openId = request.getHeader("openId");
        if(null != openId) {
            User userCondition = new User();
            userCondition.setOpenId(openId);
            List<User> managers = userMapper.selectByCondition(userCondition);
            if (1 == managers.size()) {
                user = managers.get(0);
            }
        }
        return  user;
    }
}
