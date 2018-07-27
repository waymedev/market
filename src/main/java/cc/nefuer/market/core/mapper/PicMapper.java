package cc.nefuer.market.core.mapper;

import cc.nefuer.market.core.mapper.provider.PicProvider;
import cc.nefuer.market.core.mapper.provider.SortProvider;
import cc.nefuer.market.core.model.Pic;
import cc.nefuer.market.core.model.Sort;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jimi花
 * @dare 2018/7/27
 */
@Mapper
@Repository
public interface PicMapper {

    @SelectProvider(type = PicProvider.class, method = "selectByCondition")
    List<Pic> selectPic();
}
