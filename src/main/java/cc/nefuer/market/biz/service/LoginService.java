package cc.nefuer.market.biz.service;

import cc.nefuer.market.common.RestData;
import cc.nefuer.market.core.model.User;

import java.util.Map;

/**
 * @author jimi花
 * @dare 2018/7/24
 */
public interface LoginService {
    /**
     * 获取登陆信息
     * @return 登陆信息
     */
    Map<String, Object> getCode(User user);
}
