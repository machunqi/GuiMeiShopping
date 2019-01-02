package cn.guimei.service.impl;

import cn.guimei.dao.impl.CustomerImplDao;
import cn.guimei.pojo.Customer;
import cn.guimei.pojo.Page;
import cn.guimei.service.CustomerServiceDao;

import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: CustomerServiceImplDao
 * @Auther: machunqi
 * @Date: 2018-12-30 02:20
 * @Description: 顾客
 * @Version 1.0
 */

public class CustomerServiceImplDao implements CustomerServiceDao {
    private static CustomerServiceImplDao ourInstance = new CustomerServiceImplDao();

    public static CustomerServiceImplDao getInstance() {
        return ourInstance;
    }

    private CustomerServiceImplDao() {
    }

    //获取SellerImplDao对象
    private CustomerImplDao customerImplDao = CustomerImplDao.getInstance();


    /**
     * 登录
     * @param cusLoginName
     * @param cusPassword
     * @return
     */
    @Override
    public Customer login(String cusLoginName, String cusPassword) {
        String sql = "select * from customer where cusLoginName = ? and cusPassword = ?";
        Object []parameter = {cusLoginName,cusPassword};
        List<Customer> cusList = customerImplDao.query(sql,parameter);
        if(cusList!=null && cusList.size()>0){
            return  cusList.get(0);
        }
        return null;
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public Page<Customer> pageQueryAll(int pageNumber, int pageSize) {
        return customerImplDao.pageQuery(pageSize,pageNumber,null,null,null);
    }

    /**
     * 分页级联查询
     * @param id
     * @param cusName
     * @param cusSex
     * @return
     */
    @Override
    public Page<Customer> unionQuery(String id, String cusName, String cusSex,int pageSize, int pageNumber) {
        Page<Customer> page = new Page<Customer>();
        page.setPageNumber(pageNumber);
        page.setPageSize(pageSize);

        if(id!=null && cusName!=null && cusSex!=null){
            int oneSize = id.length();
            int twoSize = cusName.length();
            int threeSize = cusSex.length();

            if(oneSize == 0 && twoSize == 0 && threeSize ==0 ){
                Page<Customer> page1 =customerImplDao.pageQuery(pageNumber,pageSize,null,null,null);
                return  page1;
            }else if(oneSize > 0 && twoSize == 0 && threeSize ==0 ){
                //定义sql语句
                String sql1 = "select count(1) from customer where id = ?";
                String sql2 = "select * from customer where id = ?";
                //定义参数
                Object []parameter = {id};
                Page<Customer> page1 = customerImplDao.pageQuery(pageNumber,pageSize,sql1,sql2,parameter);
                return  page1;

            }else if(oneSize == 0 && twoSize > 0 && threeSize ==0){
                //定义sql语句
                String sql1 = "select count(1) from customer where cusName like ?";
                String sql2 = "select * from customer where cusName like ?";
                //定义参数
                Object []parameter = {"%"+cusName+"%"};
                Page<Customer> page1 = customerImplDao.pageQuery(pageNumber,pageSize,sql1,sql2,parameter);
                return  page1;

            }else if(oneSize == 0 && twoSize == 0 && threeSize > 0){
                //定义sql语句
                String sql1 = "select count(1) from customer where cusSex =  ?";
                String sql2 = "select * from customer where cusSex =  ?";
                //定义参数
                Object []parameter = {cusSex};
                Page<Customer> page1 = customerImplDao.pageQuery(pageNumber,pageSize,sql1,sql2,parameter);
                return  page1;
            }else if(oneSize > 0 && twoSize > 0 && threeSize > 0){
                //根据 姓名 ID 性别 级联查询
                Object []parameter = {id,"%"+cusName+"%",cusSex};
                String sql1 = "select count(1) from customer where id = ? and cusName like ? and cusSex = ?";
                String sql2 = "select * from customer where where id = ? and cusName like ? and cusSex = ?";
                Page<Customer> page1 = customerImplDao.pageQuery(pageNumber,pageSize,sql1,sql2,parameter);
                return  page1;
            }else if(oneSize > 0 && twoSize > 0 && threeSize == 0){
                //根据 姓名 ID  级联查询
                Object []parameter = {id,"%"+cusName+"%"};
                String sql1 = "select count(1) from customer where id = ? and cusName like ?";
                String sql2 = "select * from customer where where id = ? and cusName like ?";
                Page<Customer> page1 = customerImplDao.pageQuery(pageNumber,pageSize,sql1,sql2,parameter);
                return  page1;
            }else if(oneSize == 0 && twoSize > 0 && threeSize > 0){
                //根据  姓名 性别 级联查询
                Object []parameter = {"%"+cusName+"%",cusSex};
                String sql1 = "select count(1) from customer where  cusName like ? and stuSex = ?";
                String sql2 = "select * from customer where where  cusName like ? and stuSex = ?";
                Page<Customer> page1 = customerImplDao.pageQuery(pageNumber,pageSize,sql1,sql2,parameter);
                return  page1;
            }else if(oneSize > 0 && twoSize == 0 && threeSize > 0){
                //根据  ID 性别 级联查询
                Object []parameter = {id,cusSex};
                String sql1 = "select count(1) from customer where id = ? and  cusSex = ?";
                String sql2 = "select * from customer where where id = ? and  cusSex = ?";
                Page<Customer> page1 = customerImplDao.pageQuery(pageNumber,pageSize,sql1,sql2,parameter);
                return  page1;
            }
        }
        return null;
    }

    /**
     * 根据ID查询所有
     * @param id
     * @return
     */
    @Override
    public Customer queryById(String id) {
        String sql = "select * from customer where id = ?";
        Object []parameter = {id};
        List<Customer> list = customerImplDao.query(sql,parameter);
        if(list!=null && list.size()>0){
            return  list.get(0);
        }
        return null;
    }

    /**
     * 增加
     * @param customer
     * @return
     */
    @Override
    public int add(Customer customer) {
        String sql = "insert into customer values(?,?,?,?,?,?,?,?,?,?)";
        return customerImplDao.add(sql,customer);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public int delById(String id) {
        String sql="delete from customer where id=?";
        Object[] parameter={id};
        int i=customerImplDao.del(sql,parameter);
        return i;
    }

    /**
     * 修改
     * @param customer
     * @return
     */
    @Override
    public int updateById(Customer customer) {
        String sql = "update customer set cusName = ?,cusLoginName = ?,cusPassword = ?,cusEmail = ?," +
                "cusSex = ?,cusPhoto = ?,cusHobby = ?,cusIdCard = ?,cusBirthday = ?  where id = ?";
        Object []parameter = {
                customer.getId(),
                customer.getCusName(),
                customer.getCusLoginName(),
                customer.getCusPassword(),
                customer.getCusEmail(),
                customer.getCusSex(),
                customer.getCusPhoto(),
                customer.getCusHobby(),
                customer.getCusIdCard(),
                customer.getCusBirthday()
        };
        int i = customerImplDao.update(sql,parameter);
        return i;
    }
}
