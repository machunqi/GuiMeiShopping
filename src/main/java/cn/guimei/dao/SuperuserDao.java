package cn.guimei.dao;

import cn.guimei.pojo.Page;
import cn.guimei.pojo.Superuser;

import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: SuperuserDao
 * @Auther: machunqi
 * @Date: 2018-12-29 13:38
 * @Description: 管理员Dao
 * @Version 1.0
 */

public interface SuperuserDao {
    //管理员增删改查

    int add(String sql, Superuser superuser);

    int del(String sql,Object parameter[]);

    int update(String sql,Object parameter[]);

    List<Superuser> query(String sql);

    List<Superuser> query(String sql, Object parameter[]);

    Page<Superuser> pageQuery(int pageSize, int pageNumber, Object []parameter);

    Page<Superuser> pageQuery(int pageNumber,int pageSize,String sql1,String sql2,Object parameter[]);

}
