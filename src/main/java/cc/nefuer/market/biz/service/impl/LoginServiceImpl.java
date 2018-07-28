package cc.nefuer.market.biz.service.impl;

import cc.nefuer.market.biz.service.LoginService;
import cc.nefuer.market.common.RestData;
import cc.nefuer.market.core.mapper.UserMapper;
import cc.nefuer.market.core.model.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cc.nefuer.market.common.ErrorMessage.POST_EVENT_FAILED;

/**
 * @author jimi花
 * @dare 2018/7/24
 */
@Service
public class LoginServiceImpl implements LoginService {

    private final UserMapper userMapper;

    @Autowired
    public LoginServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Map<String, Object> getCode(User user) {
        //声明变量存储变量
        Map<String, Object> map = new HashMap<>(2);
        String AppId = "wx5926376844b9df5c";
        String AppSecret = "743143f3edcc4d58f8195fa1db291b51";
        String url = "https://api.weixin.qq.com/sns/jscode2session?" +
                "appid="+AppId+"&secret="+AppSecret+"&js_code="+user.getCode()+"&grant_type=authorization_code";
        String json = loadJSON(url);
        JSONObject jb;
        Object openid = null;
        Object sessionKey  = null;
        try {
            jb = new JSONObject(json);
            openid = jb.get("openid");
            sessionKey = jb.get("session_key");
            map.put("openId",openid);
            map.put("sessionKey",sessionKey);
            //System.out.println(openid+"  "+sessionKey);

        } catch (JSONException e) {

            e.printStackTrace();
        }

        return map;
    }
    @Override
    public String loadJSON(String url) {
        //处理字符串
        StringBuilder json = new StringBuilder();
        try {
            //通过一个表示URL地址的字符串可以构造一个URL对象。
            //url构造函数需要的参数。
            URL oracle = new URL(url);
            //yc是URLConnection对象，oracle.openConnection()返回的是URLConnection对象，赋值给yc。
            URLConnection yc = oracle.openConnection();

            //BufferedReader缓冲方式文本读取
            //InputStreamReader是字节流与字符流之间的桥梁，能将字节流输出为字符流，
            //并且能为字节流指定字符集，可输出一个个的字符
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream(), "utf-8"));// 防止乱码
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        return json.toString();
    }

    @Override
    public boolean postUser(User user) {
        boolean rtv = false;
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        user.setCreateTime(localDateTime.format(format));
        user.setLastEditTime(localDateTime.format(format));
        rtv = 0 < userMapper.insert(user);
        return rtv;
    }

    @Override
    public RestData getInfo(int userId) {
        Map<String,Object> map = new HashMap<>(11);
        User user = userMapper.selectByUserId(userId);
        map.put("userId",user.getUserId());
        map.put("wechatName",user.getWechatName());
        map.put("name",user.getName());
        map.put("profileImg",user.getProfileImg());
        map.put("gender",user.getGender());
        map.put("telNumber",user.getTelNumber());
        map.put("address",user.getAddress());
        map.put("openId",user.getOpenId());
        map.put("sessionKey",user.getSessionKey());
        map.put("createTime",user.getCreateTime());
        map.put("lastEditTime",user.getLastEditTime());
        return new RestData(map);
    }

    @Override
    public RestData getUserId(User user) {
        Map<String , Object> map = new HashMap<>(2);
        List<User> users = userMapper.selectByCondition(user);
        map.put("userId",users.get(0).getUserId());
        map.put("message" , POST_EVENT_FAILED);
        return new RestData(2,map);
    }
}
