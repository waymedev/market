package cc.nefuer.market.core.mapper;

import cc.nefuer.market.core.mapper.provider.ImgProvider;
import cc.nefuer.market.core.mapper.provider.ItemProvider;
import cc.nefuer.market.core.model.Img;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jimi花
 * @dare 2018/7/28
 */
@Mapper
@Repository
public interface ImgMapper {
    /**
     * 插入新纪录
     *
     * @param img 参数集
     * @return 插入记录数
     */
    @Insert("INSERT INTO tb_img( item_id, img_url) VALUES(" +
            "#{itemId},#{imgUrl})")
    @Options(useGeneratedKeys = true, keyProperty = "imgId")
    int insert(Img img);

    /**
     * 条件查询
     * @param img
     * @return
     */
    @SelectProvider(type = ImgProvider.class, method = "selectByCondition")
    List<Img> selectImg(Img img);

    /**
     * 根据ImgId查询
     * @param imgId
     * @return
     */
    @Select("SELECT * FROM tb_img WHERE img_id=#{imgId};")
    @Results({
            @Result(property = "itemId", column = "item_id"),
            @Result(property = "imgUrl", column = "img_url"),
    })
    Img selectByImgId(int imgId);
}
