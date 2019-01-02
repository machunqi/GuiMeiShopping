package cn.guimei.core.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName CheckUserFilter
 * @Author xiaoHei
 * @Date 2018/12/20 13:54
 * @Version 1.0
 **/
public class CheckUserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /**
         * 拦截资源，并进行拦截处理
         *     1.要验证当前请求有没有进行登陆操作
         *         1.1:如果标识是否登陆 session.setAttribute("Student",stu);
         */
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        Object studentObj = session.getAttribute("Student");
        String path = request.getContextPath();
        if(studentObj!=null){
            //说明经过了session.setAttribute("Student",stu);这行代码
            //放行 请求和响应对象
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            response.sendRedirect(path+"/Login.jsp?msg=1");
        }

    }

    @Override
    public void destroy() {

    }
}
