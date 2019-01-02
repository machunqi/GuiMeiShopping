package cn.guimei.dao.impl;

import cn.guimei.core.util.PageUtil;
import cn.guimei.dao.BaseDao;
import cn.guimei.dao.GoodsDao;
import cn.guimei.pojo.Goods;
import cn.guimei.pojo.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: GoodsImplDao
 * @Auther: machunqi
 * @Date: 2018-12-30 14:35
 * @Description: 商品
 * @Version 1.0
 */

public class GoodsImplDao extends BaseDao implements GoodsDao {
    private static GoodsImplDao ourInstance = new GoodsImplDao();

    public static GoodsImplDao getInstance() {
        return ourInstance;
    }

    private GoodsImplDao() {
    }

    /**
     * 增加
     * @param sql
     * @param goods
     * @return
     */
    @Override
    public int add(String sql, Goods goods) {
        Object[] parameter = {goods.getId(),goods.getGoodsName(),goods.getGoodsSellerId(),goods.getGoodsMoney(),
                goods.getGoodsNumber(),goods.getGoodsImage(),goods.getGoodsCarriage(),goods.getGoodsType(),
                goods.getGoodsSellerId(),goods.getGoodsDiscId()};
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
    public List<Goods> query(String sql, Object[] parameter) {
        ResultSet rs = getQuery(sql,parameter);
        List<Goods> list = new ArrayList<Goods>();
        try{
            while(rs.next()){
                Goods goods = new Goods();
                goods.setId(rs.getLong("id"));
                goods.setGoodsName(rs.getString("goodsName"));
                goods.setGoodsSmallId(rs.getLong("goodsSmallId"));
                goods.setGoodsMoney(rs.getLong("goodsMoney"));
                goods.setGoodsNumber(rs.getLong("goodsNumber"));
                goods.setGoodsImage(rs.getString("goodsImage"));
                goods.setGoodsCarriage(rs.getLong("goodsCarriage"));
                goods.setGoodsType(rs.getLong("goodsType"));
                goods.setGoodsSellerId(rs.getLong("goodsSellerId"));
                goods.setGoodsDiscId(rs.getLong("goodsDiscId"));
                list.add(goods);
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
    public Page<Goods> pageQuery(int pageSize, int pageNumber, Object[] parameter) {
        Page<Goods> page = new Page<Goods>();
        page.setPageSize(pageSize);
        page.setPageNumber(pageNumber);
        String sql1 = "select count(1) from goods";
        String sql2 = "select * from goods";
        page.setTotalRecode(PageUtil.getTotalRecode(sql1,null));
        List<Goods> list = new ArrayList<Goods>();
        ResultSet rs = PageUtil.getPageDate(sql2,pageSize,pageNumber,null);
        try{
            while(rs.next()){
                Goods goods = new Goods();
                goods.setId(rs.getLong("id"));
                goods.setGoodsName(rs.getString("goodsName"));
                goods.setGoodsSmallId(rs.getLong("goodsSmallId"));
                goods.setGoodsMoney(rs.getLong("goodsMoney"));
                goods.setGoodsNumber(rs.getLong("goodsNumber"));
                goods.setGoodsImage(rs.getString("goodsImage"));
                goods.setGoodsCarriage(rs.getLong("goodsCarriage"));
                goods.setGoodsType(rs.getLong("goodsType"));
                goods.setGoodsSellerId(rs.getLong("goodsSellerId"));
                goods.setGoodsDiscId(rs.getLong("goodsDiscId"));
                list.add(goods);
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
