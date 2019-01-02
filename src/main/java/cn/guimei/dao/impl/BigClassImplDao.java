package cn.guimei.dao.impl;

import cn.guimei.core.util.PageUtil;
import cn.guimei.dao.BaseDao;
import cn.guimei.dao.BigClassDao;
import cn.guimei.pojo.BigClass;
import cn.guimei.pojo.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: BigClassImplDao
 * @Auther: machunqi
 * @Date: 2018-12-30 12:40
 * @Description: 大分类
 * @Version 1.0
 */

public class BigClassImplDao extends BaseDao implements BigClassDao {
    private static BigClassImplDao ourInstance = new BigClassImplDao();

    public static BigClassImplDao getInstance() {
        return ourInstance;
    }

    private BigClassImplDao() {
    }


    /**
     * 增加
     * @param sql
     * @param bigClass
     * @return
     */
    @Override
    public int add(String sql, BigClass bigClass) {
        Object[] parameter = {bigClass.getId(),bigClass.getBigName(),bigClass.getBigText()};
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
    public List<BigClass> query(String sql, Object[] parameter) {
        ResultSet rs = getQuery(sql,parameter);
        List<BigClass> list = new ArrayList<BigClass>();
        try{
            while(rs.next()){
                BigClass bigClass = new BigClass();
                bigClass.setId(rs.getLong("id"));
                bigClass.setBigName(rs.getString("bigName"));
                bigClass.setBigText(rs.getString("bigText"));
                list.add(bigClass);
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
    public Page<BigClass> pageQuery(int pageSize, int pageNumber, Object[] parameter) {
        Page<BigClass> page = new Page<BigClass>();
        page.setPageSize(pageSize);
        page.setPageNumber(pageNumber);
        String sql1 = "select count(1) from bigclass";
        String sql2 = "select * from bigclass";
        page.setTotalRecode(PageUtil.getTotalRecode(sql1,null));
        List<BigClass> list = new ArrayList<BigClass>();
        ResultSet rs = PageUtil.getPageDate(sql2,pageSize,pageNumber,null);
        try{
            while(rs.next()){
                BigClass bigClass = new BigClass();
                bigClass.setId(rs.getLong("id"));
                bigClass.setBigName(rs.getString("bigName"));
                bigClass.setBigText(rs.getString("bigText"));
                list.add(bigClass);
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
