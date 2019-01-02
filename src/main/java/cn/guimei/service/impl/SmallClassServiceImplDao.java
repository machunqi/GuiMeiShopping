package cn.guimei.service.impl;

import cn.guimei.dao.impl.SmallClassImplDao;
import cn.guimei.pojo.Page;
import cn.guimei.pojo.SmallClass;
import cn.guimei.service.SmallClassServiceDao;

import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: SmallClassServiceImplDao
 * @Auther: machunqi
 * @Date: 2018-12-30 14:09
 * @Description: 小分类
 * @Version 1.0
 */

public class SmallClassServiceImplDao implements SmallClassServiceDao {
    private static SmallClassServiceImplDao ourInstance = new SmallClassServiceImplDao();

    public static SmallClassServiceImplDao getInstance() {
        return ourInstance;
    }

    private SmallClassServiceImplDao() {
    }

    //获取SellerImplDao对象
    private SmallClassImplDao implDao = SmallClassImplDao.getInstance();


    /**
     * 分页查询
     *
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public Page<SmallClass> pageQueryAll(int pageNumber, int pageSize) {
        return implDao.pageQuery(pageSize, pageNumber, null);
    }

    /**
     * 级联查询
     *
     * @param id
     * @param bigName
     * @param bigText
     * @return
     */
    @Override
    public List<SmallClass> unionQuery(String id, String bigName, String bigText) {
        if (id != null && bigName != null && bigText != null) {
            int idSize = id.length();
            int nameSize = bigName.length();
            int sexSize = bigText.length();
            if (idSize == 0 && nameSize == 0 && sexSize == 0) {
                //查询所有
                String sql = "select * from bigclass";
                List<SmallClass> list = implDao.query(sql, null);
                if (list != null && list.size() > 0) {
                    return list;
                }
            } else if (idSize > 0 && nameSize == 0 && sexSize == 0) {
                //根据 id 具体查询
                Object[] parameter = {id};
                String sql = "select * from bigclass where id = ?";
                List<SmallClass> list = implDao.query(sql, parameter);
                if (list != null && list.size() > 0) {
                    return list;
                }
            } else if (idSize == 0 && nameSize > 0 && sexSize == 0) {
                //根据 姓名 模糊查询
                Object[] parameter = {"%" + bigName + "%"};
                String sql = "select * from customer where cusName like ?";
                List<SmallClass> list = implDao.query(sql, parameter);
                if (list != null && list.size() > 0) {
                    return list;
                }
            } else if (idSize == 0 && nameSize == 0 && sexSize > 0) {
                //根据 性别查询
                Object[] parameter = {bigText};
                String sql = "select * from bigclass where bigText = ?";
                List<SmallClass> list = implDao.query(sql, parameter);
                if (list != null && list.size() > 0) {
                    return list;
                }
            } else if (idSize > 0 && nameSize > 0 && sexSize > 0) {
                //根据 id 姓名  性别 级联查询
                Object[] parameter = {id, "%" + bigName + "%", bigText};
                String sql = "select * from bigclass where id = ? and bigName like ? and bigText = ?";
                List<SmallClass> list = implDao.query(sql, parameter);
                if (list != null && list.size() > 0) {
                    return list;
                }
            } else if (idSize > 0 && nameSize > 0 && sexSize == 0) {
                //根据 id 姓名 级联查询
                Object[] parameter = {id, "%" + bigName + "%"};
                String sql = "select * from bigclass where id = ? and bigName like ?";
                List<SmallClass> list = implDao.query(sql, parameter);
                if (list != null && list.size() > 0) {
                    return list;
                }
            } else if (idSize == 0 && nameSize > 0 && sexSize > 0) {
                //根据  姓名 性别 级联查询
                Object[] parameter = {"%" + bigName + "%", bigText};
                String sql = "select * from bigclass where bigName like ? and bigText = ?";
                List<SmallClass> list = implDao.query(sql, parameter);
                if (list != null && list.size() > 0) {
                    return list;
                }
            } else if (idSize > 0 && nameSize == 0 && sexSize > 0) {
                //根据  id 性别 级联查询
                Object[] parameter = {id, bigText};
                String sql = "select * from bigclass where id = ? and bigText = ?";
                List<SmallClass> list = implDao.query(sql, parameter);
                if (list != null && list.size() > 0) {
                    return list;
                }
            }
        }
        return null;
    }

    @Override
    public SmallClass queryById(String id) {
        String sql = "select * from smallclass where id = ?";
        Object[] parameter = {id};
        List<SmallClass> list = implDao.query(sql, parameter);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 增加
     *
     * @param smallClass
     * @return
     */
    @Override
    public int add(SmallClass smallClass) {
        String sql = "insert into smallclass values(?,?,?,?)";
        return implDao.add(sql, smallClass);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public int delById(String id) {
        String sql = "delete from smallclass where id=?";
        Object[] parameter = {id};
        int i = implDao.del(sql, parameter);
        return i;
    }

    /**
     * 修改
     *
     * @param smallClass
     * @return
     */
    @Override
    public int updateById(SmallClass smallClass) {
        String sql = "update smallclass set smallName = ?,smallBigId = ?,smallText where id = ?";
        Object[] parameter = {
                smallClass.getId(),
                smallClass.getSmallName(),
                smallClass.getSmallBigId(),
                smallClass.getSmallText(),
        };
        int i = implDao.update(sql, parameter);
        return i;
    }
}
