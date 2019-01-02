package cn.guimei.service;

import cn.guimei.pojo.Page;
import cn.guimei.pojo.SmallClass;

import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: SmallClassServiceDao
 * @Auther: machunqi
 * @Date: 2018-12-30 14:08
 * @Description: 小分类
 * @Version 1.0
 */

public interface SmallClassServiceDao {
    //分页查询所有

    Page<SmallClass> pageQueryAll(int pageNumber, int pageSize);

    //级联查询

    List<SmallClass> unionQuery(String id, String smallName, String smallBigId);

    //根据id查询

    SmallClass queryById(String id);

    //增删改

    int add(SmallClass smallClass);

    int delById(String id);

    int updateById(SmallClass smallClass);
}
