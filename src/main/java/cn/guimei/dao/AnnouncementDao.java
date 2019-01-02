package cn.guimei.dao;

import cn.guimei.pojo.Announcement;
import cn.guimei.pojo.Page;

import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: AnnouncementDao
 * @Auther: machunqi
 * @Date: 2018-12-30 19:11
 * @Description: 公告
 * @Version 1.0
 */

public interface AnnouncementDao {
    //大分类增删改查

    int add(String sql, Announcement announcement);

    int del(String sql,Object parameter[]);

    int update(String sql,Object parameter[]);

    List<Announcement> query(String sql, Object parameter[]);

    Page<Announcement> pageQuery(int pageSize, int pageNumber, Object []parameter);


}
