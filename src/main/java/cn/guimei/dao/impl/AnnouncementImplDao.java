package cn.guimei.dao.impl;

import cn.guimei.core.util.PageUtil;
import cn.guimei.dao.AnnouncementDao;
import cn.guimei.dao.BaseDao;
import cn.guimei.pojo.Announcement;
import cn.guimei.pojo.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: AnnouncementImplDao
 * @Auther: machunqi
 * @Date: 2018-12-30 19:11
 * @Description: 公告
 * @Version 1.0
 */

public class AnnouncementImplDao extends BaseDao implements AnnouncementDao {
    private static AnnouncementImplDao ourInstance = new AnnouncementImplDao();

    public static AnnouncementImplDao getInstance() {
        return ourInstance;
    }

    private AnnouncementImplDao() {
    }

    /**
     * 增加
     *
     * @param sql
     * @param announcement
     * @return
     */
    @Override
    public int add(String sql, Announcement announcement) {
        Object[] parameter = {announcement.getId(), announcement.getaTitle(), announcement.getaText(),
                                announcement.getaDate()};
        return getUpdate(sql, parameter);
    }

    /**
     * 删除
     *
     * @param sql
     * @param parameter
     * @return
     */
    @Override
    public int del(String sql, Object[] parameter) {
        int del = getUpdate(sql, parameter);
        return del;
    }

    /**
     * 修改
     *
     * @param sql
     * @param parameter
     * @return
     */
    @Override
    public int update(String sql, Object[] parameter) {
        return getUpdate(sql, parameter);
    }

    /**
     * 查询
     *
     * @param sql
     * @param parameter
     * @return
     */
    @Override
    public List<Announcement> query(String sql, Object[] parameter) {
        ResultSet rs = getQuery(sql, parameter);
        List<Announcement> list = new ArrayList<Announcement>();
        try {
            while (rs.next()) {
                Announcement announcement = new Announcement();
                announcement.setId(rs.getLong("id"));
                announcement.setaTitle(rs.getString("aTitle"));
                announcement.setaText(rs.getString("aText"));
                announcement.setaDate(rs.getDate("aDate"));
                list.add(announcement);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        return null;
    }

    /**
     * 分页查询
     *
     * @param pageSize
     * @param pageNumber
     * @param parameter
     * @return
     */
    @Override
    public Page<Announcement> pageQuery(int pageSize, int pageNumber, Object[] parameter) {
        Page<Announcement> page = new Page<Announcement>();
        page.setPageSize(pageSize);
        page.setPageNumber(pageNumber);
        String sql1 = "select count(1) from announcement";
        String sql2 = "select * from announcement";
        page.setTotalRecode(PageUtil.getTotalRecode(sql1, null));
        List<Announcement> list = new ArrayList<Announcement>();
        ResultSet rs = PageUtil.getPageDate(sql2, pageSize, pageNumber, null);
        try {
            while (rs.next()) {
                Announcement announcement = new Announcement();
                announcement.setId(rs.getLong("id"));
                announcement.setaTitle(rs.getString("aTitle"));
                announcement.setaText(rs.getString("aText"));
                announcement.setaDate(rs.getDate("aDate"));
                list.add(announcement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        page.setPageData(list);
        return page;
    }
}
