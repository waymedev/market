package cc.nefuer.market.biz.service;

import cc.nefuer.market.common.RestData;
import cc.nefuer.market.core.model.User;

import java.util.Map;

/**
 * @author jimi花
 * @date 2018/7/24
 */
public interface LoginService {
    /**
     * 获取登陆信息
     * @return 登陆信息
     */
    Map<String, Object> getCode(User user);

    /**
     * 获取json返回值
     * @param url
     * @return
     */
    String loadJSON(String url);

    /**
     * 添加用户
     *
     * @param user 参数集
     * @return 是否添加成功
     */
    boolean postUser(User user);

    /**
     * 获取用户详细信息
     * @param userId
     * @return
     */
    RestData getInfo(int userId);

    /**
     * get用户ID
     * @param user
     * @return
     */
    RestData getUserId(User user);

    /**
     * 修改用户信息
     *
     * @param user 参数集
     * @return 是否修改成功
     */
    boolean putInfo(User user);
}
