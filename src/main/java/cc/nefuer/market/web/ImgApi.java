package cc.nefuer.market.web;

import cc.nefuer.market.biz.service.ImgService;
import cc.nefuer.market.common.ErrorMessage;
import cc.nefuer.market.common.RestData;
import cc.nefuer.market.common.util.TokenUtil;
import cc.nefuer.market.core.mapper.ImgMapper;
import cc.nefuer.market.core.model.Img;
import cc.nefuer.market.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author jimi花
 * @dare 2018/7/28
 */
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class ImgApi {

    private final ImgService imgService;

    @Autowired
    public ImgApi(ImgService imgService) {
        this.imgService = imgService;
    }

    @RequestMapping(value = "/img", method = RequestMethod.POST)
    public RestData postNews(@RequestBody List<Img> imgs, HttpServletRequest request) {
        User currentUser = TokenUtil.getUserByToken(request);
        if (null == currentUser) {
            return new RestData(2, ErrorMessage.PLEASE_RELOGIN);
        }
        return imgService.postImg(imgs);
    }

    @RequestMapping(value = "/img", method = RequestMethod.GET)
    public RestData getImg(Img img) {
        return imgService.getImg(img);
    }

    @RequestMapping(value = "/img/{imgId}", method = RequestMethod.GET)
    public RestData postUser(@PathVariable(value = "imgId") int imgId, HttpServletRequest request) {
        User currentUser = TokenUtil.getUserByToken(request);
        if(null == currentUser) {
            return new RestData(2, ErrorMessage.PLEASE_RELOGIN);
        }
        return imgService.getImgInfo(imgId);
    }
}
