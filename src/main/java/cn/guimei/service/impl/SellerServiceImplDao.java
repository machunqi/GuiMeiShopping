package cn.guimei.service.impl;

import cn.guimei.dao.impl.SellerImplDao;
import cn.guimei.pojo.Page;
import cn.guimei.pojo.Seller;
import cn.guimei.service.SellerServiceDao;

import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: SellerServiceImplDao
 * @Auther: machunqi
 * @Date: 2018-12-29 16:58
 * @Description: 商家ServiceImplDao
 * @Version 1.0
 */

public class SellerServiceImplDao implements SellerServiceDao {
    private static SellerServiceImplDao ourInstance = new SellerServiceImplDao();

    public static SellerServiceImplDao getInstance() {
        return ourInstance;
    }

    private SellerServiceImplDao() {
    }

    //获取SellerImplDao对象
    private SellerImplDao sellerImplDao = SellerImplDao.getInstance();


    /**
     * 登录
     * @param sellerUser
     * @param sellerPassword
     * @return
     */
    @Override
    public Seller seLogin(String sellerUser, String sellerPassword) {
        String sql = "select * from seller where sellerUser = ? and sellerPassword = ?";
        Object []parameter = {sellerUser,sellerPassword};
        List<Seller> seList = sellerImplDao.query(sql,parameter);
        if(seList!=null && seList.size()>0){
            return  seList.get(0);
        }
        return null;
    }

    /**
     * 分页查询所有
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public Page<Seller> sePageQueryAll(int pageNumber, int pageSize) {
        return sellerImplDao.pageQuery(pageSize,pageNumber,null);
    }


    /**
     * 级联查询
     * @param id
     * @param sellerName
     * @param sellerSex
     * @return
     */
    @Override
    public List<Seller> seUnionQuery(String id, String sellerName, String sellerSex) {
        if(id!=null && sellerName!=null && sellerSex!=null){
            int idSize = id.length();
            int nameSize = sellerName.length();
            int sexSize = sellerSex.length();
            if(idSize == 0 && nameSize == 0 && sexSize ==0 ){
                //查询所有
                String sql = "select * from seller";
                List<Seller> seList = sellerImplDao.query(sql,null);
                if(seList!=null && seList.size()>0){
                    return  seList;
                }
            }else if(idSize > 0 && nameSize == 0 && sexSize ==0 ){
                //根据 id 具体查询
                Object []parameter = {id};
                String sql = "select * from seller where id = ?";
                List<Seller> seList = sellerImplDao.query(sql,parameter);
                if(seList!=null && seList.size()>0){
                    return  seList;
                }
            }else if(idSize == 0 && nameSize > 0 && sexSize ==0){
                //根据 姓名 模糊查询
                Object []parameter = {"%"+sellerName+"%"};
                String sql = "select * from seller where sellerName like ?";
                List<Seller> seList = sellerImplDao.query(sql,parameter);
                if(seList!=null && seList.size()>0){
                    return  seList;
                }
            }else if(idSize == 0 && nameSize == 0 && sexSize > 0){
                //根据 性别查询
                Object []parameter = {sellerSex};
                String sql = "select * from seller where sellerSex = ?";
                List<Seller> seList = sellerImplDao.query(sql,parameter);
                if(seList!=null && seList.size()>0){
                    return  seList;
                }
            }else if(idSize > 0 && nameSize > 0 && sexSize > 0){
                //根据 id 姓名  性别 级联查询
                Object []parameter = {id,"%"+sellerName+"%",sellerSex};
                String sql = "select * from seller where id = ? and sellerName like ? and sellerSex = ?";
                List<Seller> seList = sellerImplDao.query(sql,parameter);
                if(seList!=null && seList.size()>0){
                    return  seList;
                }
            }else if(idSize > 0 && nameSize > 0 && sexSize == 0){
                //根据 id 姓名 级联查询
                Object []parameter = {id,"%"+sellerName+"%"};
                String sql = "select * from seller where id = ? and sellerName like ?";
                List<Seller> seList = sellerImplDao.query(sql,parameter);
                if(seList!=null && seList.size()>0){
                    return  seList;
                }
            }else if(idSize == 0 && nameSize > 0 && sexSize > 0){
                //根据  姓名 性别 级联查询
                Object []parameter = {"%"+sellerName+"%",sellerSex};
                String sql = "select * from seller where sellerName like ? and sellerSex = ?";
                List<Seller> stuList = sellerImplDao.query(sql,parameter);
                if(stuList!=null && stuList.size()>0){
                    return  stuList;
                }
            }else if(idSize > 0 && nameSize == 0 && sexSize > 0){
                //根据  id 性别 级联查询
                Object []parameter = {id,sellerSex};
                String sql = "select * from seller where id = ? and sellerSex = ?";
                List<Seller> seList = sellerImplDao.query(sql,parameter);
                if(seList!=null && seList.size()>0){
                    return  seList;
                }
            }
        }
        return null;
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public Seller seQueryById(String id) {
        String sql = "select * from seller where id = ?";
        Object []parameter = {id};
        List<Seller> seList = sellerImplDao.query(sql,parameter);
        if(seList!=null && seList.size()>0){
            return  seList.get(0);
        }
        return null;
    }

    /**
     * 增加
     * @param seller
     * @return
     */
    @Override
    public int seAdd(Seller seller) {
        String sql = "insert into Seller values(?,?,?,?,?,?,?,?,?)";
        return sellerImplDao.add(sql,seller);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @Override
    public int seDelById(String id) {
        String sql="delete from seller where id=?";
        Object[] parameter={id};
        int i=sellerImplDao.del(sql,parameter);
        return i;
    }

    /**
     * 根据id修改
     * @param seller
     * @return
     */
    @Override
    public int seUpdateById(Seller seller) {
        String sql = "update seller set sellerName = ?,sellerUser = ?,sellerPassword = ?," +
                "sellerSex = ?,sellerBirthday = ?,sellerIdCard = ?,sellerEmail = ?," +
                "sellerTel = ?,sellerAddress = ?  where id = ?";
        Object []parameter = {
                seller.getId(),
                seller.getSellerName(),
                seller.getSellerUser(),
                seller.getSellerPassword(),
                seller.getSellerSex(),
                seller.getSellerBirthday(),
                seller.getSellerIdCard(),
                seller.getSellerEmail(),
                seller.getSellerTel(),
                seller.getSellerAddress()
        };
        int i = sellerImplDao.update(sql,parameter);
        return i;
    }
}
