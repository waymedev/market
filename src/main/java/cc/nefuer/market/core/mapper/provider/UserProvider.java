package cc.nefuer.market.core.mapper.provider;

import cc.nefuer.market.core.model.User;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author jimi花
 * @dare 2018/7/26
 */
public class UserProvider {
    public String selectByCondition(User user) {
        return new SQL() {
            {
                SELECT("user_id AS userId, wechat_name AS wechatName, name," +
                        "profile_img AS profileImg, ,gender, tel_number AS telNumber, address, " +
                        "open_di AS openId,session_key AS sessionKey," +
                        "create_time AS createTime,last_edit_time AS lastEditTime");
                FROM("tb_user");
                if (null != user.getUserId()) {
                    WHERE("user_id=#{userId}");
                }
                if (null != user.getOpenId()) {
                    WHERE("open_id=#{open_Id}");
                }
            }
        }.toString();
    }
}
