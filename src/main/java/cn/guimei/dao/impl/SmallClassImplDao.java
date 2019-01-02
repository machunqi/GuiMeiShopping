package cn.guimei.dao.impl;

import cn.guimei.core.util.PageUtil;
import cn.guimei.dao.BaseDao;
import cn.guimei.dao.SmallClassDao;
import cn.guimei.pojo.Page;
import cn.guimei.pojo.SmallClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: SmallClassImplDao
 * @Auther: machunqi
 * @Date: 2018-12-30 14:11
 * @Description: 小分类
 * @Version 1.0
 */

public class SmallClassImplDao extends BaseDao implements SmallClassDao {
    private static SmallClassImplDao ourInstance = new SmallClassImplDao();

    public static SmallClassImplDao getInstance() {
        return ourInstance;
    }

    private SmallClassImplDao() {
    }

    /**
     * 增加
     * @param sql
     * @param smallClass
     * @return
     */
    @Override
    public int add(String sql, SmallClass smallClass) {
        Object[] parameter = {smallClass.getId(),smallClass.getSmallName(),smallClass.getSmallBigId(),smallClass.getSmallText()};
        return getUpdate(sql,parameter);
    }

    /**
     * 删除
     * @param sql
     * @param parameter
     * @return
     */
    @Override
    public int del(String sql, Object[] parameter) {
        int del = getUpdate(sql,parameter);
        return del;
    }

    /**
     * 修改
     * @param sql
     * @param parameter
     * @return
     */
    @Override
    public int update(String sql, Object[] parameter) {
        return getUpdate(sql,parameter);
    }

    /**
     * 查询
     * @param sql
     * @param parameter
     * @return
     */
    @Override
    public List<SmallClass> query(String sql, Object[] parameter) {
        ResultSet rs = getQuery(sql,parameter);
        List<SmallClass> list = new ArrayList<SmallClass>();
        try{
            while(rs.next()){
                SmallClass smallClass = new SmallClass();
                smallClass.setId(rs.getLong("id"));
                smallClass.setSmallName(rs.getString("smallName"));
                smallClass.setSmallBigId(rs.getLong("smallBigId"));
                smallClass.setSmallText(rs.getString("smallText"));
                list.add(smallClass);
            }
            return  list;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return null;
    }

    /**
     * 分页查询
     * @param pageSize
     * @param pageNumber
     * @param parameter
     * @return
     */
    @Override
    public Page<SmallClass> pageQuery(int pageSize, int pageNumber, Object[] parameter) {
        Page<SmallClass> page = new Page<SmallClass>();
        page.setPageSize(pageSize);
        page.setPageNumber(pageNumber);
        String sql1 = "select count(1) from smallclass";
        String sql2 = "select * from smallclass";
        page.setTotalRecode(PageUtil.getTotalRecode(sql1,null));
        List<SmallClass> list = new ArrayList<SmallClass>();
        ResultSet rs = PageUtil.getPageDate(sql2,pageSize,pageNumber,null);
        try{
            while(rs.next()){
                SmallClass smallClass = new SmallClass();
                smallClass.setId(rs.getLong("id"));
                smallClass.setSmallName(rs.getString("smallName"));
                smallClass.setSmallBigId(rs.getLong("smallBigId"));
                smallClass.setSmallText(rs.getString("smallText"));
                list.add(smallClass);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        page.setPageData(list);
        return page;
    }
}
