package cn.guimei.service;

import cn.guimei.pojo.Announcement;
import cn.guimei.pojo.Page;

import java.sql.Date;
import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: AnnouncementServiceDao
 * @Auther: machunqi
 * @Date: 2018-12-30 19:12
 * @Description: 公告
 * @Version 1.0
 */

public interface AnnouncementServiceDao {
    //分页查询所有

    Page<Announcement> pageQueryAll(int pageNumber, int pageSize);

    //级联查询

    List<Announcement> unionQuery(String id, String aTitle, String aText);

    //根据id查询

    Announcement queryById(String id);

    //增删改

    int add(Announcement announcement);

    int delById(String id);

    int updateById(Announcement announcement);
}
