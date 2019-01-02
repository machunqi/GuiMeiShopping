package cn.guimei.dao;

import cn.guimei.pojo.Page;
import cn.guimei.pojo.Seller;

import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: SellerDao
 * @Auther: machunqi
 * @Date: 2018-12-29 16:59
 * @Description: 商家Dao
 * @Version 1.0
 */

public interface SellerDao {
    //商家增删改查

    int add(String sql, Seller seller);

    int del(String sql,Object parameter[]);

    int update(String sql,Object parameter[]);

    List<Seller> query(String sql, Object parameter[]);

    Page<Seller> pageQuery(int pageSize, int pageNumber, Object []parameter);

}
