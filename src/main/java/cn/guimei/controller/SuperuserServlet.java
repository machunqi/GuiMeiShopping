package cn.guimei.controller;

import cn.guimei.core.util.UploadFile;
import cn.guimei.pojo.Page;
import cn.guimei.pojo.Superuser;
import cn.guimei.service.impl.SuperuserServiceImplDao;

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
import java.util.Map;

/**
 * @Program: GuiMeiShopping
 * @ClassName: SuperuserServlet
 * @Auther: machunqi
 * @Date: 2018-12-28 11:17
 * @Description: 管理员Servlet
 * @Version 1.0
 */

@WebServlet(name = "SuperuserServlet",urlPatterns = "/doSuperuser")
public class SuperuserServlet extends HttpServlet {
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
        //获取管理员的服务对象
        SuperuserServiceImplDao serviceImplDao = SuperuserServiceImplDao.getInstance();

        /**
         * 登录
         */
        if (action != null && action.equals("login")) {
            String userLoginName = request.getParameter("userLoginName");
            String userPassword = request.getParameter("userPassword");
            Superuser superuser = serviceImplDao.suLogin(userLoginName, userPassword);
            if (superuser != null) {
                session.setAttribute("Superuser", superuser);
                response.sendRedirect(path + "/pages/backPages/superuser/index.jsp");
            } else {
                response.sendRedirect(path + "/pages/otherPages/ErrorPage.jsp?msg=0");
            }
        }


        /**
         * 级连查询
         */
        if(action!=null && action.equals("unionQuery")){
            String id = request.getParameter("id").trim();
            String userName = request.getParameter("userName").trim();
            String userSex = request.getParameter("userSex");
            List<Superuser> list = serviceImplDao.suUnionQuery(id,userName,userSex);
            session.setAttribute("List",list);
            response.sendRedirect(path+"/pages/backPages/superuser/showInfo.jsp");

        }

        /**
         * 增加
         */
        if(action!=null && action.equals("add")){

            //定义要上传的文件的保存的位置
            String filePath = getServletContext().getRealPath("/static/images/icon");
            Map<String,String> map = UploadFile.uploadUtil(filePath,request,1024*1024*10L,"userImage");

//            Long id  = Long.parseLong(request.getParameter("id"));
            String userName  = request.getParameter("userName");
            String userLoginName  = request.getParameter("userLoginName");
            String userPassword  = request.getParameter("userPassword");
            String userSex  = request.getParameter("userSex");
            String userId  = request.getParameter("userId");
            String userImage  = request.getParameter("userImage");
            Long userStatus  = Long.parseLong(request.getParameter("userStatus"));
            Superuser superuser=new Superuser(userName,userLoginName,userPassword,userSex,userId,userImage,
                    userStatus);
            int add = serviceImplDao.suAdd(superuser);
            if(add>0){
                out.println("<h3>添加成功</h3>");
            }else {
                out.println("<h3>添加失败</h3>");
            }
        }

        /**
         * 根据id修改
         */
        if(action!=null && action.equals("updateById")){
            Long id  = Long.parseLong(request.getParameter("id"));
            String userName  = request.getParameter("userName");
            String userLoginName  = request.getParameter("userLoginName");
            String userPassword  = request.getParameter("userPassword");
            String userSex  = request.getParameter("userSex");
            String userId  = request.getParameter("userId");
            String userImage  = request.getParameter("userImage");
            Long userStatus  = Long.parseLong(request.getParameter("userStatus"));
            Superuser superuser=new Superuser(userName,userLoginName,userPassword,userSex,userId,userImage,
                    userStatus);
            int update = serviceImplDao.suUpdateById(superuser);
            if(update>0){
                session.setAttribute("Superuser",superuser);
                response.sendRedirect(path+"/beforePage/managerPage/otherPage.jsp?msg=1");
            }else{
                out.println("<h3>修改失败</h3>");
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
            Page<Superuser> page = serviceImplDao.suPageQueryAll(pageNumber,pageSize);
            session.setAttribute("Page",page);

            request.setAttribute("ServletUrl","/doSuperuser?action=queryAll");
            request.getRequestDispatcher(path+"/pages/backPages/superuser/showInfo.jsp").forward(request,response);
        }


    }
}

