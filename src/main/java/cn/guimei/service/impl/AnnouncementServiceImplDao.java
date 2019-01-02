package cn.guimei.service.impl;

import cn.guimei.dao.impl.AnnouncementImplDao;
import cn.guimei.pojo.Announcement;
import cn.guimei.pojo.Page;
import cn.guimei.service.AnnouncementServiceDao;

import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: AnnouncementServiceImplDao
 * @Auther: machunqi
 * @Date: 2018-12-30 19:11
 * @Description: 公告
 * @Version 1.0
 */

public class AnnouncementServiceImplDao implements AnnouncementServiceDao {
    private static AnnouncementServiceImplDao ourInstance = new AnnouncementServiceImplDao();

    public static AnnouncementServiceImplDao getInstance() {
        return ourInstance;
    }

    private AnnouncementServiceImplDao() {
    }

    //获取SellerImplDao对象
    private AnnouncementImplDao implDao = AnnouncementImplDao.getInstance();


    /**
     * 分页查询
     *
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public Page<Announcement> pageQueryAll(int pageNumber, int pageSize) {
        return implDao.pageQuery(pageSize, pageNumber, null);
    }

    /**
     * 级联查询
     *
     * @param id
     * @param aTitle
     * @param aText
     * @return
     */
    @Override
    public List<Announcement> unionQuery(String id, String aTitle, String aText) {
        if (id != null && aTitle != null && aText != null) {
            int idSize = id.length();
            int nameSize = aTitle.length();
            int sexSize = aText.length();
            if (idSize == 0 && nameSize == 0 && sexSize == 0) {
                //查询所有
                String sql = "select * from bigclass";
                List<Announcement> list = implDao.query(sql, null);
                if (list != null && list.size() > 0) {
                    return list;
                }
            } else if (idSize > 0 && nameSize == 0 && sexSize == 0) {
                //根据 id 具体查询
                Object[] parameter = {id};
                String sql = "select * from announcement where id = ?";
                List<Announcement> list = implDao.query(sql, parameter);
                if (list != null && list.size() > 0) {
                    return list;
                }
            } else if (idSize == 0 && nameSize > 0 && sexSize == 0) {
                //根据 姓名 模糊查询
                Object[] parameter = {"%" + aTitle + "%"};
                String sql = "select * from announcement where cusName like ?";
                List<Announcement> list = implDao.query(sql, parameter);
                if (list != null && list.size() > 0) {
                    return list;
                }
            } else if (idSize == 0 && nameSize == 0 && sexSize > 0) {
                //根据 性别查询
                Object[] parameter = {aText};
                String sql = "select * from announcement where bigText = ?";
                List<Announcement> list = implDao.query(sql, parameter);
                if (list != null && list.size() > 0) {
                    return list;
                }
            } else if (idSize > 0 && nameSize > 0 && sexSize > 0) {
                //根据 id 姓名  性别 级联查询
                Object[] parameter = {id, "%" + aTitle + "%", aText};
                String sql = "select * from announcement where id = ? and bigName like ? and bigText = ?";
                List<Announcement> list = implDao.query(sql, parameter);
                if (list != null && list.size() > 0) {
                    return list;
                }
            } else if (idSize > 0 && nameSize > 0 && sexSize == 0) {
                //根据 id 姓名 级联查询
                Object[] parameter = {id, "%" + aTitle + "%"};
                String sql = "select * from announcement where id = ? and bigName like ?";
                List<Announcement> list = implDao.query(sql, parameter);
                if (list != null && list.size() > 0) {
                    return list;
                }
            } else if (idSize == 0 && nameSize > 0 && sexSize > 0) {
                //根据  姓名 性别 级联查询
                Object[] parameter = {"%" + aTitle + "%", aText};
                String sql = "select * from announcement where bigName like ? and bigText = ?";
                List<Announcement> list = implDao.query(sql, parameter);
                if (list != null && list.size() > 0) {
                    return list;
                }
            } else if (idSize > 0 && nameSize == 0 && sexSize > 0) {
                //根据  id 性别 级联查询
                Object[] parameter = {id, aText};
                String sql = "select * from announcement where id = ? and bigText = ?";
                List<Announcement> list = implDao.query(sql, parameter);
                if (list != null && list.size() > 0) {
                    return list;
                }
            }
        }
        return null;
    }

    @Override
    public Announcement queryById(String id) {
        String sql = "select * from announcement where id = ?";
        Object[] parameter = {id};
        List<Announcement> list = implDao.query(sql, parameter);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 增加
     *
     * @param bigClass
     * @return
     */
    @Override
    public int add(Announcement bigClass) {
        String sql = "insert into announcement values(?,?,?)";
        return implDao.add(sql, bigClass);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public int delById(String id) {
        String sql = "delete from announcement where id=?";
        Object[] parameter = {id};
        int i = implDao.del(sql, parameter);
        return i;
    }

    /**
     * 修改
     *
     * @param announcement
     * @return
     */
    @Override
    public int updateById(Announcement announcement) {
        String sql = "update announcement set aTitle = ?,aText = ?,,aDate = ? where id = ?";
        Object[] parameter = {
                announcement.getId(),
                announcement.getaTitle(),
                announcement.getaText(),
                announcement.getaDate(),
        };
        int i = implDao.update(sql, parameter);
        return i;
    }
}
