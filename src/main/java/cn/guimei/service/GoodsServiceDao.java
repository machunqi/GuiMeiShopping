package cn.guimei.service;

import cn.guimei.pojo.Goods;
import cn.guimei.pojo.Page;

import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: GoodsServiceDao
 * @Auther: machunqi
 * @Date: 2018-12-30 14:37
 * @Description: 商品
 * @Version 1.0
 */

public interface GoodsServiceDao {
    //分页查询所有

    Page<Goods> pageQueryAll(int pageNumber, int pageSize);

    //级联查询

    List<Goods> unionQuery(String id, String goodsName, String bigText);

    //根据id查询

    Goods queryById(String id);

    //增删改

    int add(Goods goods);

    int delById(String id);

    int updateById(Goods goods);

}
