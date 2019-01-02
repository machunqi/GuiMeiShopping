package cn.guimei.service.impl;

import cn.guimei.dao.impl.GoodsImplDao;
import cn.guimei.pojo.Goods;
import cn.guimei.pojo.Page;
import cn.guimei.service.GoodsServiceDao;

import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: GoodsServiceImplDao
 * @Auther: machunqi
 * @Date: 2018-12-30 14:37
 * @Description: 商品
 * @Version 1.0
 */

public class GoodsServiceImplDao implements GoodsServiceDao {
    private static GoodsServiceImplDao ourInstance = new GoodsServiceImplDao();

    public static GoodsServiceImplDao getInstance() {
        return ourInstance;
    }

    private GoodsServiceImplDao() {
    }

    //获取SellerImplDao对象
    private GoodsImplDao implDao = GoodsImplDao.getInstance();


    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public Page<Goods> pageQueryAll(int pageNumber, int pageSize) {
        return implDao.pageQuery(pageSize,pageNumber,null);
    }

    /**
     * 级联查询
     * @param id
     * @param goodsName
     * @param goodsSmallId
     * @return
     */
    @Override
    public List<Goods> unionQuery(String id, String goodsName, String goodsSmallId) {
        if(id!=null && goodsName!=null && goodsSmallId!=null){
            int idSize = id.length();
            int nameSize = goodsName.length();
            int sexSize = goodsSmallId.length();
            if(idSize == 0 && nameSize == 0 && sexSize ==0 ){
                //查询所有
                String sql = "select * from goods";
                List<Goods> list = implDao.query(sql,null);
                if(list!=null && list.size()>0){
                    return  list;
                }
            }else if(idSize > 0 && nameSize == 0 && sexSize ==0 ){
                //根据 id 具体查询
                Object []parameter = {id};
                String sql = "select * from goods where id = ?";
                List<Goods> list = implDao.query(sql,parameter);
                if(list!=null && list.size()>0){
                    return  list;
                }
            }else if(idSize == 0 && nameSize > 0 && sexSize ==0){
                //根据 姓名 模糊查询
                Object []parameter = {"%"+goodsName+"%"};
                String sql = "select * from goods where goodsName like ?";
                List<Goods> list = implDao.query(sql,parameter);
                if(list!=null && list.size()>0){
                    return  list;
                }
            }else if(idSize == 0 && nameSize == 0 && sexSize > 0){
                //根据 性别查询
                Object []parameter = {goodsSmallId};
                String sql = "select * from goods where bigText = ?";
                List<Goods> list = implDao.query(sql,parameter);
                if(list!=null && list.size()>0){
                    return  list;
                }
            }else if(idSize > 0 && nameSize > 0 && sexSize > 0){
                //根据 id 姓名  性别 级联查询
                Object []parameter = {id,"%"+goodsName+"%",goodsSmallId};
                String sql = "select * from goods where id = ? and goodsName like ? and goodsSmallId = ?";
                List<Goods> list = implDao.query(sql,parameter);
                if(list!=null && list.size()>0){
                    return  list;
                }
            }else if(idSize > 0 && nameSize > 0 && sexSize == 0){
                //根据 id 姓名 级联查询
                Object []parameter = {id,"%"+goodsName+"%"};
                String sql = "select * from goods where id = ? and goodsName like ?";
                List<Goods> list = implDao.query(sql,parameter);
                if(list!=null && list.size()>0){
                    return  list;
                }
            }else if(idSize == 0 && nameSize > 0 && sexSize > 0){
                //根据  姓名 性别 级联查询
                Object []parameter = {"%"+goodsName+"%",goodsSmallId};
                String sql = "select * from goods where goodsName like ? and bigText = ?";
                List<Goods> list = implDao.query(sql,parameter);
                if(list!=null && list.size()>0){
                    return  list;
                }
            }else if(idSize > 0 && nameSize == 0 && sexSize > 0){
                //根据  id 性别 级联查询
                Object []parameter = {id,goodsSmallId};
                String sql = "select * from goods where id = ? and bigText = ?";
                List<Goods> list = implDao.query(sql,parameter);
                if(list!=null && list.size()>0){
                    return  list;
                }
            }
        }
        return null;
    }

    @Override
    public Goods queryById(String id) {
        String sql = "select * from goods where id = ?";
        Object []parameter = {id};
        List<Goods> list = implDao.query(sql,parameter);
        if(list!=null && list.size()>0){
            return  list.get(0);
        }
        return null;
    }

    /**
     * 增加
     * @param goods
     * @return
     */
    @Override
    public int add(Goods goods) {
        String sql = "insert into goods values(?,?,?,?,?,?,?,?,?,?)";
        return implDao.add(sql,goods);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public int delById(String id) {
        String sql="delete from goods where id=?";
        Object[] parameter={id};
        int i=implDao.del(sql,parameter);
        return i;
    }

    /**
     * 修改
     * @param goods
     * @return
     */
    @Override
    public int updateById(Goods goods) {
        String sql = "update goods set goodsName = ?,goodSmallId = ?,goodsMoney = ?,goodsNumber = ?," +
                "goodsImage = ?,goodsCarriage = ?,goodsType = ?,goodsSellerId = ?,goodsDiscId = ? where id = ?";
        Object []parameter = {
                goods.getId(),
        };
        int i = implDao.update(sql,parameter);
        return i;
    }
}
