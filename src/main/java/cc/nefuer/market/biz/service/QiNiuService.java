package cc.nefuer.market.biz.service;

import cc.nefuer.market.common.RestData;
import cc.nefuer.market.core.model.QiNiu;

import java.util.Map;

/**
 * @author jimi花
 * @date 2018/7/25
 */
public interface QiNiuService {
    /**
     * 获得uptoken
     */
    Map<String, Object> getUpToken(QiNiu qiNiu);
}
