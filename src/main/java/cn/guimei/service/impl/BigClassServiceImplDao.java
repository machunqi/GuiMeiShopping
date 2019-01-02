package cn.guimei.service.impl;

import cn.guimei.dao.impl.BigClassImplDao;
import cn.guimei.pojo.BigClass;
import cn.guimei.pojo.Page;
import cn.guimei.service.BigClassServiceDao;

import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: BigClassServiceImplDao
 * @Auther: machunqi
 * @Date: 2018-12-30 12:54
 * @Description: 大分类
 * @Version 1.0
 */

public class BigClassServiceImplDao implements BigClassServiceDao {
    private static BigClassServiceImplDao ourInstance = new BigClassServiceImplDao();

    public static BigClassServiceImplDao getInstance() {
        return ourInstance;
    }

    private BigClassServiceImplDao() {
    }

    //获取SellerImplDao对象
    private BigClassImplDao implDao = BigClassImplDao.getInstance();


    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public Page<BigClass> pageQueryAll(int pageNumber, int pageSize) {
        return implDao.pageQuery(pageSize,pageNumber,null);
    }

    /**
     * 级联查询
     * @param id
     * @param bigName
     * @param bigText
     * @return
     */
    @Override
    public List<BigClass> unionQuery(String id, String bigName, String bigText) {
        if(id!=null && bigName!=null && bigText!=null){
            int idSize = id.length();
            int nameSize = bigName.length();
            int sexSize = bigText.length();
            if(idSize == 0 && nameSize == 0 && sexSize ==0 ){
                //查询所有
                String sql = "select * from bigclass";
                List<BigClass> list = implDao.query(sql,null);
                if(list!=null && list.size()>0){
                    return  list;
                }
            }else if(idSize > 0 && nameSize == 0 && sexSize ==0 ){
                //根据 id 具体查询
                Object []parameter = {id};
                String sql = "select * from bigclass where id = ?";
                List<BigClass> list = implDao.query(sql,parameter);
                if(list!=null && list.size()>0){
                    return  list;
                }
            }else if(idSize == 0 && nameSize > 0 && sexSize ==0){
                //根据 姓名 模糊查询
                Object []parameter = {"%"+bigName+"%"};
                String sql = "select * from bigclass where cusName like ?";
                List<BigClass> list = implDao.query(sql,parameter);
                if(list!=null && list.size()>0){
                    return  list;
                }
            }else if(idSize == 0 && nameSize == 0 && sexSize > 0){
                //根据 性别查询
                Object []parameter = {bigText};
                String sql = "select * from bigclass where bigText = ?";
                List<BigClass> list = implDao.query(sql,parameter);
                if(list!=null && list.size()>0){
                    return  list;
                }
            }else if(idSize > 0 && nameSize > 0 && sexSize > 0){
                //根据 id 姓名  性别 级联查询
                Object []parameter = {id,"%"+bigName+"%",bigText};
                String sql = "select * from bigclass where id = ? and bigName like ? and bigText = ?";
                List<BigClass> list = implDao.query(sql,parameter);
                if(list!=null && list.size()>0){
                    return  list;
                }
            }else if(idSize > 0 && nameSize > 0 && sexSize == 0){
                //根据 id 姓名 级联查询
                Object []parameter = {id,"%"+bigName+"%"};
                String sql = "select * from bigclass where id = ? and bigName like ?";
                List<BigClass> list = implDao.query(sql,parameter);
                if(list!=null && list.size()>0){
                    return  list;
                }
            }else if(idSize == 0 && nameSize > 0 && sexSize > 0){
                //根据  姓名 性别 级联查询
                Object []parameter = {"%"+bigName+"%",bigText};
                String sql = "select * from bigclass where bigName like ? and bigText = ?";
                List<BigClass> list = implDao.query(sql,parameter);
                if(list!=null && list.size()>0){
                    return  list;
                }
            }else if(idSize > 0 && nameSize == 0 && sexSize > 0){
                //根据  id 性别 级联查询
                Object []parameter = {id,bigText};
                String sql = "select * from bigclass where id = ? and bigText = ?";
                List<BigClass> list = implDao.query(sql,parameter);
                if(list!=null && list.size()>0){
                    return  list;
                }
            }
        }
        return null;
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Override
    public BigClass queryById(String id) {
        String sql = "select * from bigclass where id = ?";
        Object []parameter = {id};
        List<BigClass> list = implDao.query(sql,parameter);
        if(list!=null && list.size()>0){
            return  list.get(0);
        }
        return null;
    }

    /**
     * 增加
     * @param bigClass
     * @return
     */
    @Override
    public int add(BigClass bigClass) {
        String sql = "insert into bigclass values(?,?,?)";
        return implDao.add(sql,bigClass);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public int delById(String id) {
        String sql="delete from bigclass where id=?";
        Object[] parameter={id};
        int i=implDao.del(sql,parameter);
        return i;
    }

    /**
     * 修改
     * @param bigClass
     * @return
     */
    @Override
    public int updateById(BigClass bigClass) {
        String sql = "update bigclass set bigName = ?,bigText = ?, where id = ?";
        Object []parameter = {
                bigClass.getId(),
                bigClass.getBigName(),
                bigClass.getBigText(),
        };
        int i = implDao.update(sql,parameter);
        return i;
    }
}
