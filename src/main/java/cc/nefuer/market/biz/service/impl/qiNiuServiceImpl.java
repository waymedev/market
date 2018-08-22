package cc.nefuer.market.biz.service.impl;

import cc.nefuer.market.biz.service.QiNiuService;
import cc.nefuer.market.common.RestData;
import cc.nefuer.market.common.util.QiNiuUtil;
import cc.nefuer.market.core.model.QiNiu;
import com.qiniu.util.UrlSafeBase64;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jimi花
 * @date 2018/7/25
 */
@Service
public class qiNiuServiceImpl implements QiNiuService {
    @Override
    public Map<String, Object> getUpToken() {
        QiNiu qiNiu = new QiNiu();
        qiNiu.setAk("J3GdyGZQ0-_6IXr0o1oPtStijmbQ66wsz0Euoi2h");
        qiNiu.setSk("F2ea5kVfOlX1h_dv4yIIic0NH7eU_X18566dN3o2");
        qiNiu.setBucket("nefuer");
        Map<String, Object> map = new HashMap<>(2);
        String upToken = QiNiuUtil.createUpdateToken(qiNiu.getAk(),qiNiu.getSk(),qiNiu.getBucket());
        String s = UrlSafeBase64.encodeToString("qiniuphotos:gogopher.jpg");
        map.put("uptoken",upToken);
        map.put("url",s);
        return map;
    }
}
