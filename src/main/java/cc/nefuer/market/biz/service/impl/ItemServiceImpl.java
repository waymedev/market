package cc.nefuer.market.biz.service.impl;

import cc.nefuer.market.biz.service.ItemService;
import cc.nefuer.market.common.Page;
import cc.nefuer.market.common.RestData;
import cc.nefuer.market.common.util.PageUtil;
import cc.nefuer.market.core.mapper.ImgMapper;
import cc.nefuer.market.core.mapper.ItemMapper;
import cc.nefuer.market.core.mapper.UserMapper;
import cc.nefuer.market.core.model.Img;
import cc.nefuer.market.core.model.Item;
import cc.nefuer.market.core.model.User;
import cc.nefuer.market.core.model.vo.ItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jimi花
 * @dare 2018/7/28
 */
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemMapper itemMapper;
    private final UserMapper userMapper;
    private final ImgMapper imgMapper;

    @Autowired
    public ItemServiceImpl(ItemMapper itemMapper,UserMapper userMapper,ImgMapper imgMapper) {
        this.userMapper = userMapper;
        this.itemMapper = itemMapper;
        this.imgMapper = imgMapper;
    }

    @Override
    public boolean postItem(Item item) {
        boolean rtv = false;
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        item.setCreateTime(localDateTime.format(format));
        item.setLastEditTime(localDateTime.format(format));
        rtv = 0 < itemMapper.insert(item);
        return rtv;
    }

    @Override
    public RestData getItem(ItemVo itemVo, HttpServletRequest request) {

        //System.out.println("itemId" + itemVo.getItemId());
        //System.out.println("sortId" + itemVo.getSortId());

        Page page ;
        if(null == itemVo.getPage())
            itemVo.setPage(1);

        page = itemMapper.countByCondition(itemVo);
        page.setCurrentPage(itemVo.getPage());
        page.setPageSize(4);
        page = PageUtil.checkPage(page);
        List<Map<String,Object>> rtv = new ArrayList<>();
        List<Item> data = itemMapper.selectByCondition(itemVo,page);
        //System.out.println("data:" + data);
        if(data.size() == 1 && itemVo.getItemId() != null) {
            Img img = new Img();
            img.setItemId(data.get(0).getItemId());

            //当用户自己浏览自己的商品 浏览人数不增加
            if(!request.getHeader("userId").equals(data.get(0).getPublishId().toString())) {
                //System.out.println(request.getHeader("userId"));
                //System.out.println(data.get(0).getPublishId());
                int views = data.get(0).getViews();
                views++;
                data.get(0).setViews(views);
                Item itemTmp = new Item();
                itemTmp.setItemId(data.get(0).getItemId());
                itemTmp.setViews(data.get(0).getViews());
                itemMapper.updateByItemId(itemTmp);
            }

            List<Img> imgList = imgMapper.selectImg(img);
            User user = userMapper.selectByUserId(data.get(0).getPublishId());
            Map<String, Object> map = new HashMap<>(8);
            map.put("itemId",data.get(0).getItemId());
            map.put("name",data.get(0).getName());
            map.put("price",data.get(0).getPrice());
            map.put("content",data.get(0).getContent());
            map.put("sortId",data.get(0).getSortId());
            map.put("publishId",data.get(0).getPublishId());
            map.put("profileImg",user.getProfileImg());
            map.put("wechatName",user.getWechatName());
            map.put("views",data.get(0).getViews());
            map.put("status",data.get(0).getStatus());
            map.put("createTime",data.get(0).getCreateTime());
            map.put("img",imgList);
            return new RestData(map);
        } else {
            for(Item items : data) {
                if(items.getStatus() == 1) {
                    Img img = new Img();
                    img.setItemId(items.getItemId());
                    List<Img> imgList = imgMapper.selectImg(img);
                    User user = userMapper.selectByUserId(items.getPublishId());
                    Map<String, Object> map = new HashMap<>(11);
                    map.put("itemId",items.getItemId());
                    map.put("name",items.getName());
                    map.put("price",items.getPrice());
                    map.put("sortId",items.getSortId());
                    map.put("content",items.getContent());
                    map.put("publishId",items.getPublishId());
                    map.put("profileImg",user.getProfileImg());
                    map.put("wechatName",user.getWechatName());
                    map.put("views",items.getViews());
                    map.put("createTime",items.getCreateTime());
                    map.put("img",imgList);
                    rtv.add(map);
                }
            }

            return new RestData(rtv,page);
        }

    }
}
