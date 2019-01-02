package cn.guimei.dao.impl;

import cn.guimei.core.util.PageUtil;
import cn.guimei.dao.BaseDao;
import cn.guimei.dao.CustomerDao;
import cn.guimei.pojo.Customer;
import cn.guimei.pojo.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: CustomerImplDao
 * @Auther: machunqi
 * @Date: 2018-12-30 02:21
 * @Description: 顾客ImplDao
 * @Version 1.0
 */

public class CustomerImplDao extends BaseDao implements CustomerDao {
    private static CustomerImplDao ourInstance = new CustomerImplDao();

    public static CustomerImplDao getInstance() {
        return ourInstance;
    }

    private CustomerImplDao() {
    }

    /**
     * 增加
     * @param sql
     * @param customer
     * @return
     */
    @Override
    public int add(String sql, Customer customer) {
        Object[] parameter = {customer.getId(),customer.getCusName(),customer.getCusLoginName(),customer.getCusPassword(),
                customer.getCusEmail(),customer.getCusSex(),customer.getCusPhoto(),customer.getCusHobby(),customer.getCusIdCard(),customer.getCusBirthday()};
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
    public List<Customer> query(String sql, Object[] parameter) {
        ResultSet rs = getQuery(sql,parameter);
        List<Customer> cusList = new ArrayList<Customer>();
        try{
            while(rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setCusName(rs.getString("cusName"));
                customer.setCusLoginName(rs.getString("cusLoginName"));
                customer.setCusPassword(rs.getString("cusPassword"));
                customer.setCusEmail(rs.getString("cusEmail"));
                customer.setCusSex(rs.getString("cusSex"));
                customer.setCusPhoto(rs.getString("cusPhoto"));
                customer.setCusHobby(rs.getString("cusHobby"));
                customer.setCusIdCard(rs.getString("cusIdCard"));
                customer.setCusBirthday(rs.getDate("cusBirthday"));
                cusList.add(customer);
            }
            return  cusList;
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
    public Page<Customer> pageQuery(int pageNumber, int pageSize, String sql1, String sql2, Object[] parameter) {
        Page<Customer> page = new Page<Customer>();
        page.setPageSize(pageSize);
        page.setPageNumber(pageNumber);
        page.setTotalRecode(PageUtil.getTotalRecode(sql1,parameter));
        ResultSet rs = PageUtil.getPageDate(sql2,pageSize,pageNumber,parameter);
        List<Customer> cusList = new ArrayList<Customer>();
        try{
            while(rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setCusName(rs.getString("cusName"));
                customer.setCusLoginName(rs.getString("cusLoginName"));
                customer.setCusPassword(rs.getString("cusPassword"));
                customer.setCusEmail(rs.getString("cusEmail"));
                customer.setCusSex(rs.getString("cusSex"));
                customer.setCusPhoto(rs.getString("cusPhoto"));
                customer.setCusHobby(rs.getString("cusHobby"));
                customer.setCusIdCard(rs.getString("cusIdCard"));
                customer.setCusBirthday(rs.getDate("cusBirthday"));
                cusList.add(customer);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        page.setPageData(cusList);
        return page;
    }
}
