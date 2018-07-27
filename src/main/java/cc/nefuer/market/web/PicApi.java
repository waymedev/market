package cc.nefuer.market.web;

import cc.nefuer.market.biz.service.PicService;
import cc.nefuer.market.common.ErrorMessage;
import cc.nefuer.market.common.RestData;
import cc.nefuer.market.common.util.TokenUtil;
import cc.nefuer.market.core.model.Pic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jimi花
 * @dare 2018/7/27
 */
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class PicApi {

    private final PicService picService;
    @Autowired
    public PicApi(PicService picService) {
        this.picService = picService;
    }

    @RequestMapping(value = "/pic", method = RequestMethod.GET)
    public RestData postUser() {
        return picService.getPic();
    }
}
