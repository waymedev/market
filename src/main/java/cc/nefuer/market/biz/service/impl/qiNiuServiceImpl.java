package cc.nefuer.market.biz.service.impl;

import cc.nefuer.market.biz.service.QiNiuService;
import cc.nefuer.market.common.RestData;
import cc.nefuer.market.common.util.QiNiuUtil;
import cc.nefuer.market.core.model.QiNiu;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jimi花
 * @date 2018/7/25
 */
@Service
public class qiNiuServiceImpl implements QiNiuService {
    @Override
    public Map<String, Object> getUpToken(QiNiu qiNiu) {
        Map<String, Object> map = new HashMap<>(1);
        String upToken = QiNiuUtil.createUpdateToken(qiNiu.getAk(),qiNiu.getSk(),qiNiu.getBucket());
        map.put("uptoken",upToken);
        return map;
    }
}
