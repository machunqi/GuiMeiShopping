package cn.guimei.controller;

import cn.guimei.pojo.Page;
import cn.guimei.pojo.Seller;
import cn.guimei.service.impl.SellerServiceImplDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

/**
 * @Program: GuiMeiShopping
 * @ClassName: SellerServlet
 * @Auther: machunqi
 * @Date: 2018-12-28 11:17
 * @Description: 商家Servlet
 * @Version 1.0
 */

@WebServlet(name = "SellerServlet",urlPatterns = "/doSeller")
public class SellerServlet extends HttpServlet {
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
        //获取商家的服务对象
        SellerServiceImplDao serviceImplDao = SellerServiceImplDao.getInstance();

        /**
         * 登录
         */
        if (action != null && action.equals("login")) {
            String sellerUser = request.getParameter("sellerUser");
            String sellerPassword = request.getParameter("sellerPassword");
            Seller seller = serviceImplDao.seLogin(sellerUser, sellerPassword);
            if (seller != null) {
                session.setAttribute("Seller", seller);
                response.sendRedirect(path + "/pages/backPages/seller/index.jsp");
            } else {
                response.sendRedirect(path + "/pages/backPages/seller/index.jsp");
            }
        }

        /**
         * 查询所有
         */
        if(action!=null && action.equals("queryAll")){
            //定义每页显示的条数
            int pageSize = 5;
            //接收要查看的页码
            int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
            //调用带有分页的查询业务方法
            Page<Seller> page = serviceImplDao.sePageQueryAll(pageNumber,pageSize);
            session.setAttribute("Page",page);

            request.setAttribute("ServletUrl","/doSeller?action=queryAll");
            request.getRequestDispatcher(path+"/pages/backPages/seller/showInfo.jsp").forward(request,response);
        }

        /**
         * 增加
         */
        if(action!=null && action.equals("add")){
            Long id  = Long.parseLong(request.getParameter("id"));
            String sellerName  = request.getParameter("sellerName");
            String sellerUser  = request.getParameter("sellerUser");
            String sellerPassword  = request.getParameter("sellerPassword");
            String sellerSex  = request.getParameter("sellerSex");
            Date sellerBirthday  = Date.valueOf(request.getParameter("sellerBirthday"));
            String sellerIdCard  = request.getParameter("sellerIdCard");
            String sellerEmail  = request.getParameter("sellerEmail");
            String sellerTel  = request.getParameter("sellerTel");
            String sellerAddress  = request.getParameter("sellerAddress");
            Seller seller=new Seller(id,sellerName,sellerUser,sellerPassword,sellerSex,sellerBirthday,sellerIdCard,
                    sellerEmail,sellerTel,sellerAddress);
            int add = serviceImplDao.seAdd(seller);
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
            int del = serviceImplDao.seDelById(id);
            if(del>0){
                out.println("<h3>删除成功</h3>");
            }else{
                out.println("<h3>删除失败</h3>");
            }
        }

        /**
         * 修改
         */
        if(action!=null && action.equals("updateById")){
            //接收学生信息
            Long id  = Long.parseLong(request.getParameter("id"));
            String sellerName  = request.getParameter("sellerName");
            String sellerUser  = request.getParameter("sellerUser");
            String sellerPassword  = request.getParameter("sellerPassword");
            String sellerSex  = request.getParameter("sellerSex");
            Date sellerBirthday  = Date.valueOf(request.getParameter("sellerBirthday"));
            String sellerIdCard  = request.getParameter("sellerIdCard");
            String sellerEmail  = request.getParameter("sellerEmail");
            String sellerTel  = request.getParameter("sellerTel");
            String sellerAddress  = request.getParameter("sellerAddress");
            Seller seller = new Seller(id,sellerName,sellerUser,sellerPassword,sellerSex,sellerBirthday,sellerIdCard,
                    sellerEmail,sellerTel,sellerAddress);
            int update = serviceImplDao.seUpdateById(seller);
            if(update>0){
                session.setAttribute("Seller",seller);
                response.sendRedirect(path+"/beforePage/managerPage/otherPage.jsp?msg=1");
            }else{
                out.println("<h3>修改失败</h3>");
            }
        }




    }
}
