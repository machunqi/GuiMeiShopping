package cn.guimei.controller;

import cn.guimei.pojo.Announcement;
import cn.guimei.pojo.Page;
import cn.guimei.service.impl.AnnouncementServiceImplDao;

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
 * @ClassName: AnnouncementServlet
 * @Auther: machunqi
 * @Date: 2018-12-28 11:17
 * @Description: 公告Servlet
 * @Version 1.0
 */

@WebServlet(name = "AnnouncementServlet",urlPatterns = "/doAnnouncement")
public class AnnouncementServlet extends HttpServlet {
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
        AnnouncementServiceImplDao serviceImplDao = AnnouncementServiceImplDao.getInstance();


        /**
         * 分页查询所有
         */

        if(action!=null && action.equals("queryAll")){
            //定义每页显示的条数
            int pageSize = 5;
            //接收要查看的页码
            int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
            //调用带有分页的查询业务方法
            Page<Announcement> page = serviceImplDao.pageQueryAll(pageNumber,pageSize);
            session.setAttribute("Page",page);
            request.setAttribute("ServletUrl","/doAnnouncement?action=queryAll");
            request.getRequestDispatcher(path+"/pages/backPages/announcement/showInfo.jsp").forward(request,response);
        }

        /**
         * 级连查询
         */
        if(action!=null && action.equals("unionQuery")){
            String id  = request.getParameter("id").trim();
            String aTitle = request.getParameter("aTitle").trim();
            String aText = request.getParameter("aText").trim();
            Date aDate = Date.valueOf(request.getParameter("aDate"));
            List<Announcement> list = serviceImplDao.unionQuery(id,aTitle,aText);
            session.setAttribute("List",list);
            response.sendRedirect(path+"/pages/backPages/announcement/showInfo.jsp");

        }


        /**
         * 增加
         */

        if(action!=null && action.equals("add")){
            Long id  = Long.parseLong(request.getParameter("id"));
            String aTitle  = request.getParameter("aTitle");
            String aText  = request.getParameter("aText");
            Date aDate  = Date.valueOf(request.getParameter("aDate"));
            Announcement announcement=new Announcement(id,aTitle,aText,aDate);
            int add = serviceImplDao.add(announcement);
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
            String aTitle  = request.getParameter("aTitle");
            String aText  = request.getParameter("aText");
            Date aDate  = Date.valueOf(request.getParameter("aDate"));
            Announcement announcement=new Announcement(id,aTitle,aText,aDate);
            int update = serviceImplDao.updateById(announcement);
            if(update>0){
                session.setAttribute("Announcement",announcement);
                response.sendRedirect(path+"/beforePage/managerPage/otherPage.jsp?msg=1");
            }else{
                out.println("<h3>修改失败</h3>");
            }
        }
    }
}
