package cc.nefuer.market.biz.service.impl;

import cc.nefuer.market.biz.service.ImgService;
import cc.nefuer.market.common.RestData;
import cc.nefuer.market.core.mapper.ImgMapper;
import cc.nefuer.market.core.model.Img;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jimi花
 * @dare 2018/7/28
 */
@Service
public class ImgServiceImpl implements ImgService {

    private final ImgMapper imgMapper;

    @Autowired
    public ImgServiceImpl(ImgMapper imgMapper) {
        this.imgMapper = imgMapper;
    }

    @Override
    public RestData postImg(List<Img> imgs) {
        List<Map<String, Object>> rtv = new ArrayList<>();

        for (Img img : imgs) {
            if (imgMapper.insert(img) > 0) {
                Map<String, Object> map = new HashMap<>(1);
                map.put("imgId", img.getImgId());
                rtv.add(map);
            }
        }

        return new RestData(rtv);
    }

    @Override
    public RestData getImg(Img img) {
        List<Map<String, Object>> rtv = new ArrayList<>();
        List<Img> data = imgMapper.selectImg(img);
        if (data.size() == 1) {
            Map<String, Object> map = new HashMap<>(3);
            map.put("imgId", data.get(0).getImgId());
            map.put("itemId", data.get(0).getItemId());
            map.put("imgUrl", data.get(0).getImgUrl());
            return new RestData(map);
        } else {
            for (Img img1 : data) {
                Map<String, Object> map = new HashMap<>(3);
                map.put("imgId", img1.getImgId());
                map.put("itemId", img1.getItemId());
                map.put("imgUrl", img1.getImgUrl());
                rtv.add(map);
            }
            return new RestData(rtv);
        }
    }

    @Override
    public RestData getImgInfo(int imgId) {

        Map<String, Object> map = new HashMap<>();

        Img img = imgMapper.selectByImgId(imgId);

        map.put("itemId", img.getItemId());
        map.put("imgUrl",img.getImgUrl());

        return new RestData(map);
    }

    @Override
    public boolean deleteImg(int imgId) {
        return 0 < imgMapper.deleteByImgId(imgId);
    }
}
