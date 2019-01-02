package cn.guimei.controller;

import cn.guimei.pojo.Customer;
import cn.guimei.pojo.Page;
import cn.guimei.service.impl.CustomerServiceImplDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;


/**
 * @Program: GuiMeiShopping
 * @ClassName: CustomerServlet
 * @Auther: machunqi
 * @Date: 2018-12-28 11:17
 * @Description: 顾客Servlet
 * @Version 1.0
 */

@WebServlet(name = "CustomerServlet",urlPatterns = "/doCustomer")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //编码方式统一操作
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取输入流对象
        PrintWriter out = response.getWriter();
        //获取path路径
        String path = request.getContextPath();
        //获取session对象
        HttpSession session = request.getSession();
        //获取参数action的值
        String action = request.getParameter("action");
        //获取学生的服务对象
        CustomerServiceImplDao serviceImplDao = CustomerServiceImplDao.getInstance();

        /**
         * 顾客登录
         */
        if(action!=null && action.equals("login")){
            String imgCode = request.getParameter("imgCode");
            String code = (String) session.getAttribute("CheckImgValue");
            if(imgCode!=null && imgCode.equalsIgnoreCase(code)){
                String stuId = request.getParameter("cusLoginName");
                String stuPwd = request.getParameter("cusPassword");
                Customer customer = serviceImplDao.login(stuId,stuPwd);
                if(customer!=null){
                    session.setAttribute("Customer",customer);
                    response.sendRedirect(path+"/pages/backPages/customer/index.jsp");
                }else{
                    response.sendRedirect(path+"/pages/backPages/customer/index.jsp");
                }
            }else{
                response.sendRedirect(path+"/pages/backPages/customer/index.jsp");
            }
        }

        /**
         * 分页查询
         */

        if(action!=null && action.equals("queryAll")){
            //定义每页显示的条数
            int pageSize = 5;
            //接收要查看的页码
            int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
            //调用带有分页的查询业务方法
            Page<Customer> page = serviceImplDao.pageQueryAll(pageNumber,pageSize);
            session.setAttribute("Page",page);

            request.setAttribute("ServletUrl","/doCustomer?action=queryAll");
            request.getRequestDispatcher(path+"/pages/backPages/customer/showInfo.jsp").forward(request,response);
        }

        /**
         * 级连查询
         */
        if(action!=null && action.equals("unionQuery")){
            String id = request.getParameter("id").trim();
            String cusName = request.getParameter("cusName").trim();
            String cusSex = request.getParameter("cusSex");


            int pageSize = 5;
            int pageNumber = 1;
            String num = request.getParameter("pageNumber");
            if(num!=null){
                pageNumber = Integer.parseInt(num);
            }
            Page<Customer> page = serviceImplDao.unionQuery(id,cusName,cusSex,pageSize,pageNumber);
            session.setAttribute("Page",page);
            session.setAttribute("ServletUrl","action=unionQuery?id= "+id+"&cusName=  "+cusName+"&cusSex= "+cusSex);
            System.out.println(page.toString());
            response.sendRedirect(path+"/pages/backPages/customer/showInfo.jsp");

        }


        /**
         * 增加
         */

        if(action!=null && action.equals("add")){
            Long id  = Long.parseLong(request.getParameter("id"));
            String cusName  = request.getParameter("cusName");
            String cusLoginName  = request.getParameter("cusLoginName");
            String cusPassword  = request.getParameter("cusPassword");
            String cusEmail  = request.getParameter("cusEmail");
            String cusSex  = request.getParameter("cusSex");
            String cusPhoto  = request.getParameter("cusPhoto");
            String cusHobby  = request.getParameter("cusHobby");
            String cusIdCard  = request.getParameter("cusIdCard");
            Date sellerBirthday  = Date.valueOf(request.getParameter("sellerBirthday"));
            Customer customer=new Customer(id,cusName,cusLoginName,cusPassword,cusEmail,cusSex,cusPhoto,
                    cusHobby,cusIdCard,sellerBirthday);
            int add = serviceImplDao.add(customer);
            if(add>0){
                out.println("<h3>添加成功</h3>");
            }else {
                out.println("<h3>添加失败</h3>");
            }
        }

        /**
         * 删除
         */

        if(action!=null && action.equals("del")){
            String id = request.getParameter("id");
            int del = serviceImplDao.delById(id);
            if(del>0){
                out.println("<h3>删除成功</h3>");
            }else{
                out.println("<h3>删除失败</h3>");
            }
        }

        /**
         * 根据id修改
         */
        if(action!=null && action.equals("updateById")){
            Long id  = Long.parseLong(request.getParameter("id"));
            String cusName  = request.getParameter("cusName");
            String cusLoginName  = request.getParameter("cusLoginName");
            String cusPassword  = request.getParameter("cusPassword");
            String cusEmail  = request.getParameter("cusEmail");
            String cusSex  = request.getParameter("cusSex");
            String cusPhoto  = request.getParameter("cusPhoto");
            String cusHobby  = request.getParameter("cusHobby");
            String cusIdCard  = request.getParameter("cusIdCard");
            Date sellerBirthday  = Date.valueOf(request.getParameter("sellerBirthday"));
            Customer customer=new Customer(id,cusName,cusLoginName,cusPassword,cusEmail,cusSex,cusPhoto,
                    cusHobby,cusIdCard,sellerBirthday);
            int update = serviceImplDao.updateById(customer);
            if(update>0){
                session.setAttribute("Customer",customer);
                response.sendRedirect(path+"/beforePage/managerPage/otherPage.jsp?msg=1");
            }else{
                out.println("<h3>修改失败</h3>");
            }
        }




    }
}
