package cc.nefuer.market.web;

import cc.nefuer.market.biz.service.ItemService;
import cc.nefuer.market.common.ErrorMessage;
import cc.nefuer.market.common.RestData;
import cc.nefuer.market.common.util.TokenUtil;
import cc.nefuer.market.core.model.Item;
import cc.nefuer.market.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jimi花
 * @dare 2018/7/28
 */
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class ItemApi {

    private final ItemService itemService;

    @Autowired
    public ItemApi (ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public RestData postNews(@RequestBody Item item, HttpServletRequest request) {
        User currentUser = TokenUtil.getUserByToken(request);
        if (null == currentUser) {
            return new RestData(2, ErrorMessage.PLEASE_RELOGIN);
        }
        if (itemService.postItem(item)) {
            return new RestData(item.getItemId());
        } else {
            return new RestData(1, ErrorMessage.POST_EVENT_FAILED);
        }

    }

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public RestData getItem(Item item) {
        return itemService.getItem(item);
    }
}