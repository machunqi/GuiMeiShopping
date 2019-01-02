package cn.guimei.service;

import cn.guimei.pojo.Page;
import cn.guimei.pojo.Superuser;

import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: SuperuserServiceDao
 * @Auther: machunqi
 * @Date: 2018-12-29 13:17
 * @Description: 管理员ServiceDao
 * @Version 1.0
 */

public interface SuperuserServiceDao {

    //登录

    Superuser login(String userLoginName, String userPassword);

    //查询

    List<Superuser> query();

    //分页查询

    Page<Superuser> pageQuery(int pageNumber, int pageSize);

    //级联查询

    List<Superuser> unionQuery(String id, String userName, String userSex);

    //分页级联查询

    Page<Superuser> pageUnionQuery(String id,String userName,String userSex,int pageSize,int pageNumber);


    //根据id查询

    Superuser queryById(String id);


   //增删改

    int add(Superuser superuser);

    int delById(String id);

    int updateById(Superuser superuser);


}
