package cn.guimei.service;

import cn.guimei.pojo.Page;
import cn.guimei.pojo.Seller;

import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: SellerServiceDao
 * @Auther: machunqi
 * @Date: 2018-12-29 16:18
 * @Description: 商家ServiceDao
 * @Version 1.0
 */

public interface SellerServiceDao {
    //登录

    Seller seLogin(String sellerUser, String sellerPassword);

    //分页查询所有

    Page<Seller> sePageQueryAll(int pageNumber, int pageSize);

    //级联查询

    List<Seller> seUnionQuery(String id, String sellerName, String sellerSex);

    //根据id查询

    Seller seQueryById(String id);

    //增删改

    int seAdd(Seller seller);

    int seDelById(String id);

    int seUpdateById(Seller seller);


}
