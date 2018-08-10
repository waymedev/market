package cc.nefuer.market.core.mapper;

import cc.nefuer.market.core.mapper.provider.SortProvider;
import cc.nefuer.market.core.model.Sort;
import cc.nefuer.market.core.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jimi花
 * @date 2018/7/27
 */
@Mapper
@Repository
public interface SortMapper {

    /**
     * 遍历数据库中所有分类
     * @return 分类集合
     */
    @SelectProvider(type = SortProvider.class, method = "selectByCondition")
    List<Sort> selectSort();
}
