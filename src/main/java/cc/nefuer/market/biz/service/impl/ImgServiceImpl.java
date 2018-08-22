package cc.nefuer.market.biz.service.impl;

import cc.nefuer.market.biz.service.ImgService;
import cc.nefuer.market.biz.service.QiNiuService;
import cc.nefuer.market.common.RestData;
import cc.nefuer.market.common.util.QiNiuUtil;
import cc.nefuer.market.core.mapper.ImgMapper;
import cc.nefuer.market.core.model.Img;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;
import com.qiniu.util.UrlSafeBase64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jimi花
 * @date 2018/7/28
 */
@Service
public class ImgServiceImpl implements ImgService {

    private final ImgMapper imgMapper;
    private final QiNiuService qiNiuService;

    @Autowired
    public ImgServiceImpl(ImgMapper imgMapper,QiNiuService qiNiuService) {
        this.imgMapper = imgMapper;
        this.qiNiuService = qiNiuService;
    }

    @Override
    public RestData postImg(List<Img> imgs) {
        List<Map<String, Object>> rtv = new ArrayList<>();

        for (Img img : imgs) {
            if (imgMapper.insert(img) > 0) {
                Map<String, Object> map = new HashMap<>(1);
                map.put("imgId", img.getImgId());
                rtv.add(map);
            }
        }

        return new RestData(rtv);
    }

    @Override
    public RestData getImg(Img img) {
        List<Map<String, Object>> rtv = new ArrayList<>();
        List<Img> data = imgMapper.selectImg(img);
        if (data.size() == 1) {
            Map<String, Object> map = new HashMap<>(3);
            map.put("imgId", data.get(0).getImgId());
            map.put("itemId", data.get(0).getItemId());
            map.put("imgUrl", data.get(0).getImgUrl());
            return new RestData(map);
        } else {
            for (Img img1 : data) {
                Map<String, Object> map = new HashMap<>(3);
                map.put("imgId", img1.getImgId());
                map.put("itemId", img1.getItemId());
                map.put("imgUrl", img1.getImgUrl());
                rtv.add(map);
            }
            return new RestData(rtv);
        }
    }

    @Override
    public RestData getImgInfo(int imgId) {

        Map<String, Object> map = new HashMap<>();

        Img img = imgMapper.selectByImgId(imgId);

        map.put("itemId", img.getItemId());
        map.put("imgUrl",img.getImgUrl());

        return new RestData(map);
    }

    @Override
    public boolean deleteImg(int itemId) {

        List<Img> datas = imgMapper.selectByItemId(itemId);
        //System.out.println(datas);
        List<String> imgNameList = new ArrayList<>();
        for (Img imgs : datas) {
            String temp = imgs.getImgUrl();
            imgNameList.add(temp.substring(temp.indexOf("/") + 1));
            //System.out.println(temp.substring(temp.indexOf("/")+ 1));
        }

       Auth auth =  Auth.create("J3GdyGZQ0-_6IXr0o1oPtStijmbQ66wsz0Euoi2h","F2ea5kVfOlX1h_dv4yIIic0NH7eU_X18566dN3o2");
        Configuration config = new Configuration(Zone.autoZone());
        BucketManager bucketManager = new BucketManager(auth, config);
        String bucketName = "nefuer";

        for(int i=0; i<imgNameList.size(); i++) {
            String fileName = imgNameList.get(i);

            try {
                bucketManager.delete(bucketName,fileName);//当前为7.2.1；  7.2.2后才能传多个key ，即：第二个参数为数组 (String... deleteTargets)
                //System.out.println(true + fileName);
            } catch (QiniuException e) {
                e.printStackTrace();
            }
        }

        return 0 < imgMapper.deleteByItemId(itemId);

    }
}
