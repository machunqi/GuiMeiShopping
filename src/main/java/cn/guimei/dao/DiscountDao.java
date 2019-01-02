package cn.guimei.dao;

import cn.guimei.pojo.Discount;
import cn.guimei.pojo.Page;

import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: DiscountDao
 * @Auther: machunqi
 * @Date: 2018-12-31 02:05
 * @Description: 折扣
 * @Version 1.0
 */

public interface DiscountDao {
    //折扣增删改查

    int add(String sql, Discount discount);

    int del(String sql,Object parameter[]);

    int update(String sql,Object parameter[]);

    List<Discount> query(String sql, Object parameter[]);

    Page<Discount> pageQuery(int pageSize, int pageNumber, Object []parameter);
}
