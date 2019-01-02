package cn.guimei.dao;

import cn.guimei.pojo.Customer;
import cn.guimei.pojo.Page;

import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: CustomerDao
 * @Auther: machunqi
 * @Date: 2018-12-30 02:21
 * @Description: 顾客
 * @Version 1.0
 */

public interface CustomerDao {
    //顾客增删改查

    int add(String sql, Customer customer);

    int del(String sql,Object parameter[]);

    int update(String sql,Object parameter[]);

    List<Customer> query(String sql, Object parameter[]);

    Page<Customer> pageQuery(int pageNumber,int pageSize,String sql1,String sql2,Object parameter[]);

}
