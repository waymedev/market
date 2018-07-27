package cc.nefuer.market.biz.service.impl;

import cc.nefuer.market.biz.service.PicService;
import cc.nefuer.market.common.RestData;
import cc.nefuer.market.core.mapper.PicMapper;
import cc.nefuer.market.core.model.Pic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jimi花
 * @dare 2018/7/27
 */
@Service
public class PicServiceImpl implements PicService {

    private final PicMapper picMapper;

    @Autowired
    public PicServiceImpl(PicMapper picMapper) {
        this.picMapper = picMapper;
    }

    @Override
    public RestData getPic() {

        List<Map<String, Object>> rtv = new ArrayList<>();

        List<Pic> data =  picMapper.selectPic();
        for (Pic pics : data) {
            Map<String, Object> map = new HashMap<>(3);
            map.put("picId",pics.getPicId());
            map.put("name",pics.getName());
            map.put("picUrl",pics.getPicUrl());

            rtv.add(map);
        }
        return new RestData(rtv);

    }
}
