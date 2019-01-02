package cn.guimei.service;

import cn.guimei.pojo.BigClass;
import cn.guimei.pojo.Page;

import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: BigClassServiceDao
 * @Auther: machunqi
 * @Date: 2018-12-30 12:54
 * @Description: 大分类
 * @Version 1.0
 */

public interface BigClassServiceDao {
    //分页查询所有

    Page<BigClass> pageQueryAll(int pageNumber, int pageSize);

    //级联查询

    List<BigClass> unionQuery(String id, String bigName, String bigText);

    //根据id查询

    BigClass queryById(String id);

    //增删改

    int add(BigClass bigClass);

    int delById(String id);

    int updateById(BigClass bigClass);
}
