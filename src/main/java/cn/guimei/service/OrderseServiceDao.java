package cn.guimei.service;

import cn.guimei.pojo.Orderse;
import cn.guimei.pojo.Page;

import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: OrderseServiceDao
 * @Auther: machunqi
 * @Date: 2018-12-30 21:41
 * @Description: 订单
 * @Version 1.0
 */

public interface OrderseServiceDao {
    //分页查询所有

    Page<Orderse> pageQueryAll(int pageNumber, int pageSize);

    //级联查询

    List<Orderse> unionQuery(String id, String orderseGoodsId, String orderseCusId);

    //根据id查询

    Orderse queryById(String id);

    //增删改

    int add(Orderse orderse);

    int delById(String id);

    int updateById(Orderse orderse);
}
