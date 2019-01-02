package cn.guimei.dao.impl;

import cn.guimei.core.util.PageUtil;
import cn.guimei.dao.BaseDao;
import cn.guimei.dao.OrderseDao;
import cn.guimei.pojo.Orderse;
import cn.guimei.pojo.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: OrderseImplDao
 * @Auther: machunqi
 * @Date: 2018-12-30 21:40
 * @Description: 订单
 * @Version 1.0
 */

public class OrderseImplDao extends BaseDao implements OrderseDao {
    private static OrderseImplDao ourInstance = new OrderseImplDao();

    public static OrderseImplDao getInstance() {
        return ourInstance;
    }

    private OrderseImplDao() {
    }

    /**
     * 增加
     * @param sql
     * @param orderse
     * @return
     */
    @Override
    public int add(String sql, Orderse orderse) {
        Object[] parameter = {orderse.getId(),orderse.getOrderseGoodsId(),orderse.getOrderseCusId(),orderse.getOrderseDate(),
                orderse.getOrderseAddress(),orderse.getOrderseMoney(),orderse.getOrderseStatus(),orderse.getOrderseStatus(),};
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
    public List<Orderse> query(String sql, Object[] parameter) {
        ResultSet rs = getQuery(sql,parameter);
        List<Orderse> list = new ArrayList<Orderse>();
        try{
            while(rs.next()){
                Orderse orderse = new Orderse();
                orderse.setId(rs.getLong("id"));
                orderse.setOrderseGoodsId(rs.getLong("orderseGoodsId"));
                orderse.setOrderseCusId(rs.getLong("orderseCusId"));
                orderse.setOrderseDate(rs.getDate("orderseDate"));
                orderse.setOrderseAddress(rs.getString("orderseAddress"));
                orderse.setOrderseMoney(rs.getLong("orderseMoney"));
                orderse.setOrderseStatus(rs.getLong("orderseStatus"));
                list.add(orderse);
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
    public Page<Orderse> pageQuery(int pageSize, int pageNumber, Object[] parameter) {
        Page<Orderse> page = new Page<Orderse>();
        page.setPageSize(pageSize);
        page.setPageNumber(pageNumber);
        String sql1 = "select count(1) from orderse";
        String sql2 = "select * from orderse";
        page.setTotalRecode(PageUtil.getTotalRecode(sql1,null));
        List<Orderse> list = new ArrayList<Orderse>();
        ResultSet rs = PageUtil.getPageDate(sql2,pageSize,pageNumber,null);
        try{
            while(rs.next()){
                Orderse orderse = new Orderse();
                orderse.setId(rs.getLong("id"));
                orderse.setOrderseGoodsId(rs.getLong("orderseGoodsId"));
                orderse.setOrderseCusId(rs.getLong("orderseCusId"));
                orderse.setOrderseDate(rs.getDate("orderseDate"));
                orderse.setOrderseAddress(rs.getString("orderseAddress"));
                orderse.setOrderseMoney(rs.getLong("orderseMoney"));
                orderse.setOrderseStatus(rs.getLong("orderseStatus"));
                list.add(orderse);
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
