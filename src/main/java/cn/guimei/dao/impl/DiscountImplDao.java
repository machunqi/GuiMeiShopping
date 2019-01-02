package cn.guimei.dao.impl;

import cn.guimei.core.util.PageUtil;
import cn.guimei.dao.BaseDao;
import cn.guimei.dao.DiscountDao;
import cn.guimei.pojo.Discount;
import cn.guimei.pojo.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: DiscountImplDao
 * @Auther: machunqi
 * @Date: 2018-12-31 02:06
 * @Description: 折扣
 * @Version 1.0
 */

public class DiscountImplDao extends BaseDao implements DiscountDao {
    private static DiscountImplDao ourInstance = new DiscountImplDao();

    public static DiscountImplDao getInstance() {
        return ourInstance;
    }

    private DiscountImplDao() {
    }

    /**
     * 增加
     * @param sql
     * @param discount
     * @return
     */
    @Override
    public int add(String sql, Discount discount) {
        Object[] parameter = {discount.getId(),discount.getDiscRate()};
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
    public List<Discount> query(String sql, Object[] parameter) {
        ResultSet rs = getQuery(sql,parameter);
        List<Discount> list = new ArrayList<Discount>();
        try{
            while(rs.next()){
                Discount discount = new Discount();
                discount.setId(rs.getLong("id"));
                discount.setDiscRate(rs.getLong("discRate"));
                list.add(discount);
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
    public Page<Discount> pageQuery(int pageSize, int pageNumber, Object[] parameter) {
        Page<Discount> page = new Page<Discount>();
        page.setPageSize(pageSize);
        page.setPageNumber(pageNumber);
        String sql1 = "select count(1) from discount";
        String sql2 = "select * from discount";
        page.setTotalRecode(PageUtil.getTotalRecode(sql1,null));
        List<Discount> list = new ArrayList<Discount>();
        ResultSet rs = PageUtil.getPageDate(sql2,pageSize,pageNumber,null);
        try{
            while(rs.next()){
                Discount discount = new Discount();
                discount.setId(rs.getLong("id"));
                discount.setDiscRate(rs.getLong("discRate"));
                list.add(discount);
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
