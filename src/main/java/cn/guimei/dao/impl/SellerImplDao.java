package cn.guimei.dao.impl;

import cn.guimei.core.util.PageUtil;
import cn.guimei.dao.BaseDao;
import cn.guimei.dao.SellerDao;
import cn.guimei.pojo.Page;
import cn.guimei.pojo.Seller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: SellerImplDao
 * @Auther: machunqi
 * @Date: 2018-12-29 17:07
 * @Description: 商家mplDao
 * @Version 1.0
 */

public class SellerImplDao extends BaseDao implements SellerDao {
    private static SellerImplDao ourInstance = new SellerImplDao();

    public static SellerImplDao getInstance() {
        return ourInstance;
    }

    private SellerImplDao() {
    }

    /**
     * 增加
     * @param sql
     * @param seller
     * @return
     */
    @Override
    public int add(String sql, Seller seller) {
        Object[] parameter = {seller.getId(),seller.getSellerName(),seller.getSellerPassword(),seller.getSellerSex(),
                seller.getSellerBirthday(),seller.getSellerIdCard(),seller.getSellerEmail(),seller.getSellerTel(),seller.getSellerAddress()};
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

    @Override
    public List<Seller> query(String sql, Object[] parameter) {
        ResultSet rs = getQuery(sql,parameter);
        List<Seller> seList = new ArrayList<Seller>();
        try{
            while(rs.next()){
                Seller seller = new Seller();
                seller.setId(rs.getLong("id"));
                seller.setSellerName(rs.getString("sellerName"));
                seller.setSellerUser(rs.getString("sellerUser"));
                seller.setSellerPassword(rs.getString("sellerPassword"));
                seller.setSellerSex(rs.getString("sellerSex"));
                seller.setSellerBirthday(rs.getDate("sellerBirthday"));
                seller.setSellerEmail(rs.getString("sellerEmail"));
                seller.setSellerTel(rs.getString("sellerTel"));
                seller.setSellerAddress(rs.getString("sellerAddress"));
                seList.add(seller);
            }
            return  seList;
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
    public Page<Seller> pageQuery(int pageSize, int pageNumber, Object[] parameter) {
        Page<Seller> page = new Page<Seller>();
        page.setPageSize(pageSize);
        page.setPageNumber(pageNumber);
        String sql1 = "select count(1) from seller";
        String sql2 = "select * from seller";
        page.setTotalRecode(PageUtil.getTotalRecode(sql1,null));
        List<Seller> seList = new ArrayList<Seller>();
        ResultSet rs = PageUtil.getPageDate(sql2,pageSize,pageNumber,null);
        try{
            while(rs.next()){
                Seller seller = new Seller();
                seller.setId(rs.getLong("id"));
                seller.setSellerName(rs.getString("sellerName"));
                seller.setSellerUser(rs.getString("sellerUser"));
                seller.setSellerPassword(rs.getString("sellerPassword"));
                seller.setSellerSex(rs.getString("sellerSex"));
                seller.setSellerBirthday(rs.getDate("sellerBirthday"));
                seller.setSellerEmail(rs.getString("sellerEmail"));
                seller.setSellerTel(rs.getString("sellerTel"));
                seller.setSellerAddress(rs.getString("sellerAddress"));
                seList.add(seller);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        page.setPageData(seList);
        return page;
    }
}
