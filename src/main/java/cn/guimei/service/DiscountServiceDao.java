package cn.guimei.service;

import cn.guimei.pojo.Discount;
import cn.guimei.pojo.Page;

import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: DiscountServiceDao
 * @Auther: machunqi
 * @Date: 2018-12-31 02:12
 * @Description: 折扣
 * @Version 1.0
 */

public interface DiscountServiceDao {
    //分页查询所有

    Page<Discount> pageQueryAll(int pageNumber, int pageSize);

    //级联查询

    List<Discount> unionQuery(String id, Double discRate);

    //根据id查询

    Discount queryById(String id);

    //增删改

    int add(Discount discount);

    int delById(String id);

    int updateById(Discount discount);

}
