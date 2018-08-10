package cc.nefuer.market.web;

import cc.nefuer.market.biz.service.SortService;
import cc.nefuer.market.common.RestData;
import cc.nefuer.market.core.model.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jimi花
 * @date 2018/7/27
 */
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class SortApi {

    private final SortService sortService;

    @Autowired
    public SortApi(SortService sortService) {
        this.sortService = sortService;
    }

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public RestData getSort() {
        return sortService.getSort();
    }

}
