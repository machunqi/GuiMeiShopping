package cn.guimei.dao;

import cn.guimei.pojo.Page;
import cn.guimei.pojo.SmallClass;

import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: SmallClassDao
 * @Auther: machunqi
 * @Date: 2018-12-30 14:11
 * @Description: 小分类
 * @Version 1.0
 */

public interface SmallClassDao {
    //大分类增删改查

    int add(String sql, SmallClass smallClass);

    int del(String sql,Object parameter[]);

    int update(String sql,Object parameter[]);

    List<SmallClass> query(String sql, Object parameter[]);

    Page<SmallClass> pageQuery(int pageSize, int pageNumber, Object []parameter);

}
