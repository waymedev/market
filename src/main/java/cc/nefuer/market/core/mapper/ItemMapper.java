package cc.nefuer.market.core.mapper;

import cc.nefuer.market.common.Page;
import cc.nefuer.market.core.mapper.provider.ItemProvider;
import cc.nefuer.market.core.mapper.provider.SortProvider;
import cc.nefuer.market.core.model.Item;
import cc.nefuer.market.core.model.Sort;
import cc.nefuer.market.core.model.User;
import cc.nefuer.market.core.model.vo.ItemVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jimi花
 * @dare 2018/7/28
 */
@Mapper
@Repository
public interface ItemMapper {

    /**
     * 插入新纪录
     *
     * @param item 参数集
     * @return 插入记录数
     */
    @Insert("INSERT INTO tb_item(name,price,content,sort_id," +
            "publish_id,purchase_id,views,status,create_time,last_edit_time) VALUES(#{name}," +
            "#{price},#{content},#{sortId},#{publishId},#{purchaseId},#{views}," +
            "#{status},#{createTime},#{lastEditTime})")
    @Options(useGeneratedKeys = true, keyProperty = "itemId")
    int insert(Item item);

    /**
     * 根据条件查询
     * @return 分类集合
     */
    @SelectProvider(type = ItemProvider.class, method = "selectByCondition")
    List<Item> selectItem(Item item);

    /**
     * 条件查询计数
     *
     * @param itemVo 参数集
     * @return 符合条件的记录
     */
    @SelectProvider(type = ItemProvider.class, method = "countByCondition")
    Page countByCondition(ItemVo itemVo);

    /**
     * 分页查询
     *
     * @param itemVo 参数集
     * @param page   分页信息
     * @return 符合条件的记录
     */
    @SelectProvider(type = ItemProvider.class, method = "selectByCondition")
    List<Item> selectByCondition(ItemVo itemVo, Page page);

    @UpdateProvider(type = ItemProvider.class, method = "updateByItemId")
    int updateByItemId(Item item);
}
