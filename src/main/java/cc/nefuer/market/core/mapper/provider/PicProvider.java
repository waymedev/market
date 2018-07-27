package cc.nefuer.market.core.mapper.provider;

import jdk.nashorn.internal.objects.annotations.Where;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author jimi花
 * @dare 2018/7/27
 */
public class PicProvider {
    public String selectByCondition() {
        return new SQL() {
            {
                SELECT("pic_id AS picId,name,pic_url AS picUrl");
                FROM("tb_pic");
                WHERE("enable = 1");
                ORDER_BY("pic_id DESC");
            }
        }.toString();
    }
}
