package cn.guimei.service.impl;

import cn.guimei.dao.impl.DiscountImplDao;
import cn.guimei.pojo.Discount;
import cn.guimei.pojo.Page;
import cn.guimei.service.DiscountServiceDao;

import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: DiscountServiceImplDao
 * @Auther: machunqi
 * @Date: 2018-12-31 02:11
 * @Description: 折扣
 * @Version 1.0
 */

public class DiscountServiceImplDao implements DiscountServiceDao {
    private static DiscountServiceImplDao ourInstance = new DiscountServiceImplDao();

    public static DiscountServiceImplDao getInstance() {
        return ourInstance;
    }

    private DiscountServiceImplDao() {
    }

    //获取SellerImplDao对象
    private DiscountImplDao implDao = DiscountImplDao.getInstance();


    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public Page<Discount> pageQueryAll(int pageNumber, int pageSize) {
        return implDao.pageQuery(pageSize,pageNumber,null);
    }

    /**
     * 级联查询
     * @param id
     * @param discrate
     * @return
     */
    @Override
    public List<Discount> unionQuery(String id, Double discrate) {
        if(id!=null && discrate!=null){
            int idSize = id.length();
            int nameSize = discrate.intValue();
            if(idSize == 0 && nameSize == 0 ){
                //查询所有
                String sql = "select * from discount";
                List<Discount> list = implDao.query(sql,null);
                if(list!=null && list.size()>0){
                    return  list;
                }
            }else if(idSize > 0 && nameSize == 0 ){
                //根据 id 具体查询
                Object []parameter = {id};
                String sql = "select * from discount where id = ?";
                List<Discount> list = implDao.query(sql,parameter);
                if(list!=null && list.size()>0){
                    return  list;
                }
            }else if(idSize == 0 && nameSize > 0 ){
                //根据 姓名 模糊查询
                Object []parameter = {"%"+discrate+"%"};
                String sql = "select * from discount where discrate like ?";
                List<Discount> list = implDao.query(sql,parameter);
                if(list!=null && list.size()>0){
                    return  list;
                }
            }else if(idSize > 0 && nameSize > 0 ){
                //根据 id 姓名  性别 级联查询
                Object []parameter = {id,"%"+discrate+"%"};
                String sql = "select * from discount where id = ? and discrate like ?";
                List<Discount> list = implDao.query(sql,parameter);
                if(list!=null && list.size()>0){
                    return  list;
                }
            }
        }
        return null;
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    @Override
    public Discount queryById(String id) {
        String sql = "select * from discount where id = ?";
        Object []parameter = {id};
        List<Discount> list = implDao.query(sql,parameter);
        if(list!=null && list.size()>0){
            return  list.get(0);
        }
        return null;
    }

    /**
     * 增加
     * @param discount
     * @return
     */
    @Override
    public int add(Discount discount) {
        String sql = "insert into discount values(?,?)";
        return implDao.add(sql,discount);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public int delById(String id) {
        String sql="delete from discount where id=?";
        Object[] parameter={id};
        int i=implDao.del(sql,parameter);
        return i;
    }

    /**
     * 修改
     * @param discount
     * @return
     */
    @Override
    public int updateById(Discount discount) {
        String sql = "update discount set discRate = ? where id = ?";
        Object []parameter = {
                discount.getId(),
        };
        int i = implDao.update(sql,parameter);
        return i;
    }
}
