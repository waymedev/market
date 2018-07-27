package cc.nefuer.market.biz.service.impl;

import cc.nefuer.market.biz.service.SortService;
import cc.nefuer.market.common.RestData;
import cc.nefuer.market.core.mapper.SortMapper;
import cc.nefuer.market.core.model.Sort;
import org.omg.CORBA.OBJ_ADAPTER;
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
public class SortServiceImpl implements SortService {

    private final SortMapper sortMapper;

    @Autowired
    public SortServiceImpl(SortMapper sortMapper) {
        this.sortMapper = sortMapper;
    }

    @Override
    public RestData getSort() {
        List<Map<String, Object>> rtv = new ArrayList<>();
        List<Sort> data = sortMapper.selectSort();
        for(Sort sorts : data) {
            Map<String, Object> map = new HashMap<>(4);
            map.put("sortId",sorts.getSortId());
            map.put("sortName",sorts.getSortName());
            map.put("sortIndex",sorts.getSortIndex());
            rtv.add(map);
        }
        return new RestData(rtv);
    }
}
