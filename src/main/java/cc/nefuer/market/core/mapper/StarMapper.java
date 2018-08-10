package cc.nefuer.market.core.mapper;

import cc.nefuer.market.common.Page;
import cc.nefuer.market.core.mapper.provider.ItemProvider;
import cc.nefuer.market.core.mapper.provider.StarProvider;
import cc.nefuer.market.core.model.Star;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jimi花
 * @date 2018/8/8
 */
@Mapper
@Repository
public interface StarMapper {
    /**
     * 插入新纪录
     *
     * @param star 参数集
     * @return 插入记录数
     */
    @Insert("INSERT INTO tb_star(user_id,item_id) VALUES(" +
            "#{userId},#{itemId})")
    @Options(useGeneratedKeys = true, keyProperty = "starId")
    int insert(Star star);

    /**
     * 条件查询计数
     *
     * @param star 参数集
     * @return 符合条件的记录
     */
    @SelectProvider(type = StarProvider.class, method = "countByCondition")
    Page countByCondition(Star star);

    /**
     * 分页查询
     *
     * @param star 参数集
     * @param page   分页信息
     * @return 符合条件的记录
     */
    @SelectProvider(type = StarProvider.class, method = "selectByCondition")
    List<Star> selectByCondition(Star star, Page page);

    /**
     * 根据主键删除记录
     *
     * @param starId 主键
     * @return 删除记录数
     */
    @Delete("DELETE FROM tb_star WHERE star_id=#{starId}")
    int deleteByStarId(int starId);
}
