package cc.nefuer.market.core.mapper;

import cc.nefuer.market.core.mapper.provider.UserProvider;
import cc.nefuer.market.core.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jimi花
 * @dare 2018/7/26
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * 根据主键查询记录
     * @param userId
     * @return
     */
    @Select("SELECT * FROM tb_user WHERE user_id=#{userId};")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "wechatName", column = "wechat_name"),
            @Result(property = "name", column = "name"),
            @Result(property = "profileImg", column = "profile_img"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "telNumber", column = "tel_number"),
            @Result(property = "address", column = "address"),
            @Result(property = "openId", column = "open_id"),
            @Result(property = "sessionKey", column = "session_key"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "lastEditTime", column = "last_edit_time"),
    })
    User selectByUserId(String userId);

    /**
     * 插入新纪录
     *
     * @param user 参数集
     * @return 插入记录数
     */
    @Insert("INSERT INTO tb_user(wechat_name,gender,profile_img,name," +
            "tel_number,address,open_id,session_key,create_time,last_edit_time) VALUES(#{wechatName}," +
            "#{gender},#{profileImg},#{name},#{telNumber},#{address},#{openId}," +
            "#{sessionKey},#{createTime},#{lastEditTime})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insert(User user);

    /**
     * 根据条件查询结果
     * @param user
     * @return 满足条件的返回集合
     */
    @SelectProvider(type = UserProvider.class, method = "selectByCondition")
    List<User> selectByCondition(User user);
}
