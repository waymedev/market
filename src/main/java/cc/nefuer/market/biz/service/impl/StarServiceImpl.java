package cc.nefuer.market.biz.service.impl;

import cc.nefuer.market.biz.service.StarService;
import cc.nefuer.market.common.Page;
import cc.nefuer.market.common.RestData;
import cc.nefuer.market.common.util.PageUtil;
import cc.nefuer.market.core.mapper.StarMapper;
import cc.nefuer.market.core.model.Star;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jimi花
 * @date 2018/8/8
 */
@Service
public class StarServiceImpl implements StarService {

    private final StarMapper starMapper;


    @Autowired
    public StarServiceImpl(StarMapper starMapper) {
        this.starMapper = starMapper;

    }

    @Override
    public boolean postStar(Star star) {
        boolean rtv = false;
        rtv = 0 < starMapper.insert(star);
        return rtv;
    }

    @Override
    public RestData getStar(Star star) {

        Page page ;
        if(null == star.getPage())
            star.setPage(1);

        page = starMapper.countByCondition(star);
        page.setCurrentPage(star.getPage());
        page.setPageSize(8);
        page = PageUtil.checkPage(page);
        List<Map<String,Object>> rtv = new ArrayList<>();
        List<Star> data = starMapper.selectByCondition(star,page);
        for(Star stars : data) {
            Map<String, Object> map = new HashMap<>(3);
            map.put("starId",stars.getStarId());
            map.put("userId",stars.getUserId());
            map.put("itemId",stars.getItemId());
            rtv.add(map);
        }
        return new RestData(rtv,page);
    }

    @Override
    public boolean delete(int starId) {
        return 0 < starMapper.deleteByStarId(starId);
    }

    @Override
    public Star isStar(Star star) {
        Star star1 =  starMapper.isSelect(star);
        return star1;
    }
}
