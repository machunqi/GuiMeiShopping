package cn.guimei.service.impl;

import cn.guimei.dao.impl.SuperuserImplDao;
import cn.guimei.pojo.Page;
import cn.guimei.pojo.Superuser;
import cn.guimei.service.SuperuserServiceDao;

import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: SuperuserServiceImplDao
 * @Auther: machunqi
 * @Date: 2018-12-29 13:18
 * @Description: 管理员ServiceImplDao
 * @Version 1.0
 */

public class SuperuserServiceImplDao implements SuperuserServiceDao {
    private static SuperuserServiceImplDao ourInstance = new SuperuserServiceImplDao();

    public static SuperuserServiceImplDao getInstance() {
        return ourInstance;
    }

    private SuperuserServiceImplDao() {
    }

    //获取SuperuserImplDao对象
    private SuperuserImplDao implDao = SuperuserImplDao.getInstance();


    /**
     * 登录
     * @param userLoginName
     * @param userPassword
     * @return
     */
    @Override
    public Superuser login(String userLoginName, String userPassword) {
        String sql = "select * from superuser where userLoginName = ? and userPassword = ?";
        Object []parameter = {userLoginName,userPassword};
        List<Superuser> suList = implDao.query(sql,parameter);
        if(suList!=null && suList.size()>0){
            return  suList.get(0);
        }
        return null;
    }

    /**
     * 查询
     * @return
     */
    @Override
    public List<Superuser> query() {
        return null;
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public Page<Superuser> pageQuery(int pageNumber, int pageSize) {
        return implDao.pageQuery(pageSize,pageNumber,null);
    }

    /**
     * 级联查询
     * @param id
     * @param userName
     * @param userSex
     * @return
     */
    @Override
    public List<Superuser> unionQuery(String id, String userName, String userSex) {
        if(id!=null && userName!=null && userSex!=null){
            int oneSize = id.length();
            int twoSize = userName.length();
            int threeSize = userSex.length();
            if(oneSize == 0 && twoSize == 0 && threeSize ==0 ){
                //查询所有
                String sql = "select * from superuser";
                List<Superuser> cusList = implDao.query(sql,null);
                if(cusList!=null && cusList.size()>0){
                    return  cusList;
                }
            }else if(oneSize > 0 && twoSize == 0 && threeSize ==0 ){
                //根据 id 具体查询
                Object []parameter = {id};
                String sql = "select * from superuser where id = ?";
                List<Superuser> cusList = implDao.query(sql,parameter);
                if(cusList!=null && cusList.size()>0){
                    return  cusList;
                }
            }else if(oneSize == 0 && twoSize > 0 && threeSize ==0){
                //根据 姓名 模糊查询
                Object []parameter = {"%"+userName+"%"};
                String sql = "select * from superuser where userName like ?";
                List<Superuser> cusList = implDao.query(sql,parameter);
                if(cusList!=null && cusList.size()>0){
                    return  cusList;
                }
            }else if(oneSize == 0 && twoSize == 0 && threeSize > 0){
                //根据 性别查询
                Object []parameter = {userSex};
                String sql = "select * from superuser where userSex = ?";
                List<Superuser> cusList = implDao.query(sql,parameter);
                if(cusList!=null && cusList.size()>0){
                    return  cusList;
                }
            }else if(oneSize > 0 && twoSize > 0 && threeSize > 0){
                //根据 id 姓名  性别 级联查询
                Object []parameter = {id,"%"+userName+"%",userSex};
                String sql = "select * from superuser where id = ? and userName like ? and userSex = ?";
                List<Superuser> cusList = implDao.query(sql,parameter);
                if(cusList!=null && cusList.size()>0){
                    return  cusList;
                }
            }else if(oneSize > 0 && twoSize > 0 && threeSize == 0){
                //根据 id 姓名 级联查询
                Object []parameter = {id,"%"+userName+"%"};
                String sql = "select * from superuser where id = ? and userName like ?";
                List<Superuser> cusList = implDao.query(sql,parameter);
                if(cusList!=null && cusList.size()>0){
                    return  cusList;
                }
            }else if(oneSize == 0 && twoSize > 0 && threeSize > 0){
                //根据  姓名 性别 级联查询
                Object []parameter = {"%"+userName+"%",userSex};
                String sql = "select * from superuser where userName like ? and userSex = ?";
                List<Superuser> cusList = implDao.query(sql,parameter);
                if(cusList!=null && cusList.size()>0){
                    return  cusList;
                }
            }else if(oneSize > 0 && twoSize == 0 && threeSize > 0){
                //根据  id 性别 级联查询
                Object []parameter = {id,userSex};
                String sql = "select * from superuser where id = ? and userSex = ?";
                List<Superuser> cusList = implDao.query(sql,parameter);
                if(cusList!=null && cusList.size()>0){
                    return  cusList;
                }
            }
        }
        return null;
    }

    @Override
    public Page<Superuser> pageUnionQuery(String id, String userName, String userSex, int pageSize, int pageNumber) {
        Page<Superuser> page = new Page<Superuser>();
        page.setPageNumber(pageNumber);
        page.setPageSize(pageSize);

        if(id!=null && userName!=null && userSex!=null){
            int oneSize = id.length();
            int twoSize = userName.length();
            int threeSize = userSex.length();

            if(oneSize == 0 && twoSize == 0 && threeSize ==0 ){
                Page<Superuser> page1 = implDao.pageQuery(pageSize,pageNumber,null);
                return  page1;
            }else if(oneSize > 0 && twoSize == 0 && threeSize ==0 ){
                //定义sql语句
                String sql1 = "select count(1) from student where stuId = ?";
                String sql2 = "select * from student where stuId = ?";
                //定义参数
                Object []parameter = {id};
                Page<Superuser> page1 = implDao.pageQuery(pageNumber,pageSize,sql1,sql2,parameter);
                return  page1;

            }else if(oneSize == 0 && twoSize > 0 && threeSize ==0){
                //定义sql语句
                String sql1 = "select count(1) from student where stuName like ?";
                String sql2 = "select * from student where stuName like ?";
                //定义参数
                Object []parameter = {"%"+userName+"%"};
                Page<Superuser> page1 = implDao.pageQuery(pageNumber,pageSize,sql1,sql2,parameter);
                return  page1;

            }else if(oneSize == 0 && twoSize == 0 && threeSize > 0){
                //定义sql语句
                String sql1 = "select count(1) from student where stuSex =  ?";
                String sql2 = "select * from student where stuSex =  ?";
                //定义参数
                Object []parameter = {userSex};
                Page<Superuser> page1 = implDao.pageQuery(pageNumber,pageSize,sql1,sql2,parameter);
                return  page1;
            }else if(oneSize > 0 && twoSize > 0 && threeSize > 0){
                //根据 姓名 学号 性别 级联查询
                Object []parameter = {id,"%"+userName+"%",userSex};
                String sql1 = "select count(1) from student where stuId = ? and stuName like ? and stuSex = ?";
                String sql2 = "select * from student where where stuId = ? and stuName like ? and stuSex = ?";
                Page<Superuser> page1 = implDao.pageQuery(pageNumber,pageSize,sql1,sql2,parameter);
                return  page1;
            }else if(oneSize > 0 && twoSize > 0 && threeSize == 0){
                //根据 姓名 学号  级联查询
                Object []parameter = {id,"%"+userName+"%"};
                String sql1 = "select count(1) from student where stuId = ? and stuName like ?";
                String sql2 = "select * from student where where stuId = ? and stuName like ?";
                Page<Superuser> page1 = implDao.pageQuery(pageNumber,pageSize,sql1,sql2,parameter);
                return  page1;
            }else if(oneSize == 0 && twoSize > 0 && threeSize > 0){
                //根据  姓名 性别 级联查询
                Object []parameter = {"%"+stuName+"%",stuSex};
                String sql1 = "select count(1) from student where  stuName like ? and stuSex = ?";
                String sql2 = "select * from student where where  stuName like ? and stuSex = ?";
                Page<Superuser> page1 = implDao.pageQuery(pageNumber,pageSize,sql1,sql2,parameter);
                return  page1;
            }else if(oneSize > 0 && twoSize == 0 && threeSize > 0){
                //根据  学号 性别 级联查询
                Object []parameter = {id,userSex};
                String sql1 = "select count(1) from student where stuId = ? and  stuSex = ?";
                String sql2 = "select * from student where where stuId = ? and  stuSex = ?";
                Page<Superuser> page1 = implDao.pageQuery(pageNumber,pageSize,sql1,sql2,parameter);
                return  page1;
            }
        }
        return null;
    }

    @Override
    public Superuser queryById(String id) {
        return null;
    }

    @Override
    public int add(Superuser superuser) {
        return 0;
    }

    @Override
    public int delById(String id) {
        return 0;
    }

    @Override
    public int updateById(Superuser superuser) {
        return 0;
    }
}
