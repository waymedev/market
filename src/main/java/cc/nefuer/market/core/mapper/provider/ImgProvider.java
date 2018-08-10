package cc.nefuer.market.core.mapper.provider;

import cc.nefuer.market.core.model.Img;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author jimi花
 * @date 2018/7/28
 */
public class ImgProvider {
    public String selectByCondition(Img img) {
        return new SQL() {
            {
                SELECT("img_id AS ImgId,item_id AS itemId," +
                        "img_url AS imgUrl");
                FROM("tb_img");
                if (null != img.getImgId()) {
                    WHERE("img_id=#{imgId}");
                }
                if (null != img.getItemId()) {
                    WHERE("item_id=#{itemId}");
                }
                ORDER_BY("img_id DESC");
            }
        }.toString();
    }
}
