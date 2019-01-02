package cn.guimei.service;

import cn.guimei.pojo.Customer;
import cn.guimei.pojo.Page;

import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: CustomerServiceDao
 * @Auther: machunqi
 * @Date: 2018-12-30 02:15
 * @Description: 顾客ServiceDao
 * @Version 1.0
 */

public interface CustomerServiceDao {
    //登录

    Customer login(String cusLoginName, String cusPassword);

    //分页查询所有

    Page<Customer> pageQueryAll(int pageNumber, int pageSize);

    //分页级联查询

    Page<Customer> unionQuery(String id, String cusName, String cusSex,int pageSize,int pageNumber);

    //根据id查询

    Customer queryById(String id);

    //增删改

    int add(Customer customer);

    int delById(String id);

    int updateById(Customer customer);

}
