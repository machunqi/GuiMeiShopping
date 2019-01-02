package cn.guimei.controller;

import cn.guimei.pojo.Discount;
import cn.guimei.pojo.Page;
import cn.guimei.service.impl.DiscountServiceImplDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Program: GuiMeiShopping
 * @ClassName: DiscountServlet
 * @Auther: machunqi
 * @Date: 2018-12-28 11:17
 * @Description: 折扣Servlet
 * @Version 1.0
 */

@WebServlet(name = "DiscountServlet",urlPatterns = "/doDiscount")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
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
        DiscountServiceImplDao serviceImplDao = DiscountServiceImplDao.getInstance();


        /**
         * 分页查询
         */

        if(action!=null && action.equals("queryAll")){
            //定义每页显示的条数
            int pageSize = 5;
            //接收要查看的页码
            int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
            //调用带有分页的查询业务方法
            Page<Discount> page = serviceImplDao.pageQueryAll(pageNumber,pageSize);
            session.setAttribute("Page",page);
            request.setAttribute("ServletUrl","/doDiscount?action=queryAll");
            request.getRequestDispatcher(path+"/pages/backPages/discount/showInfo.jsp").forward(request,response);
        }

        /**
         * 级连查询
         */
        if(action!=null && action.equals("unionQuery")){
            String id = request.getParameter("id").trim();
            Double discRate = Double.parseDouble(request.getParameter("discRate"));
            List<Discount> list = serviceImplDao.unionQuery(id,discRate);
            session.setAttribute("List",list);
            response.sendRedirect(path+"/pages/backPages/discount/showInfo.jsp");

        }


        /**
         * 增加
         */

        if(action!=null && action.equals("add")){
            Long id  = Long.parseLong(request.getParameter("id"));
            Double discRate = Double.parseDouble(request.getParameter("discRate"));
            Discount discount=new Discount(id,discRate);
            int add = serviceImplDao.add(discount);
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
            Double discRate = Double.parseDouble(request.getParameter("discRate"));
            Discount discount=new Discount(id,discRate);
            int update = serviceImplDao.updateById(discount);
            if(update>0){
                session.setAttribute("Discount",discount);
                response.sendRedirect(path+"/beforePage/managerPage/otherPage.jsp?msg=1");
            }else{
                out.println("<h3>修改失败</h3>");
            }
        }
    }
}
