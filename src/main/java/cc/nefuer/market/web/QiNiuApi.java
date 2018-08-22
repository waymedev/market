package cc.nefuer.market.web;

import cc.nefuer.market.biz.service.QiNiuService;
import cc.nefuer.market.common.RestData;
import cc.nefuer.market.core.model.QiNiu;
import cc.nefuer.market.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author jimi花
 * @date 2018/7/25
 */
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class QiNiuApi {

    private final QiNiuService qiNiuService;

    @Autowired
    public QiNiuApi(QiNiuService qiNiuService) {
        this.qiNiuService = qiNiuService;
    }

    @RequestMapping(value = "/uptoken", method = RequestMethod.GET)
    public Map<String, Object> getUpToken() {
        return qiNiuService.getUpToken();
    }

}
