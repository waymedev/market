package cc.nefuer.market.web;

import cc.nefuer.market.biz.service.ItemService;
import cc.nefuer.market.common.ErrorMessage;
import cc.nefuer.market.common.RestData;
import cc.nefuer.market.common.util.TokenUtil;
import cc.nefuer.market.core.model.Item;
import cc.nefuer.market.core.model.User;
import cc.nefuer.market.core.model.vo.ItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * @author jimi花
 * @date 2018/7/28
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
    public RestData getItem(ItemVo itemVo, HttpServletRequest request) {
        User currentUser = TokenUtil.getUserByToken(request);
        if (null == currentUser) {
            return new RestData(2, ErrorMessage.PLEASE_RELOGIN);
        }
        return itemService.getItem(itemVo,request);
    }

    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.DELETE)
    public RestData deletePic(@PathVariable(value = "itemId") int itemId, HttpServletRequest request) {
        User currentUser = TokenUtil.getUserByToken(request);
        if (null == currentUser) {
            return new RestData(2, ErrorMessage.PLEASE_RELOGIN);
        }
        return new RestData(itemService.deleteItem(itemId));
    }

    @RequestMapping(value = "/item", method = RequestMethod.PUT)
    public RestData putItem(@RequestBody Item item, HttpServletRequest request) {
        User currentUser = TokenUtil.getUserByToken(request);
        if (null == currentUser) {
            return new RestData(2, ErrorMessage.PLEASE_RELOGIN);
        }

        return new RestData(itemService.putItem(item));
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public RestData search(ItemVo itemVo, HttpServletRequest request) {
        User currentUser = TokenUtil.getUserByToken(request);
        if (null == currentUser) {

            return new RestData(2, ErrorMessage.PLEASE_RELOGIN);
        }
        return itemService.search(itemVo);
    }
}
