package com.jmu.javaweb_jibite.filter;

import com.jmu.javaweb_jibite.service.UserService;
import com.jmu.javaweb_jibite.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by ShaoJ
 * Date: 2020/10/29
 * Time: 22:58
 */
@Component
public class MyFilter implements Filter {
    @Autowired
    private UserServiceImpl userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String uri = request.getRequestURI();
        Boolean flag=false;
        boolean haveQuality=true;
        boolean rpLogin=false;
        String name = null;
        String password = null;
        //1.先从session中找用户，如果session中找到用户，说明已经登录，直接使用此用户对象
        HttpSession session = request.getSession(false);
        if(session!=null &&session.getAttribute("name")!=null)
            flag=true;
        //2.如果session中找不到，再从cookie中找用户信息(用户名和密码)，如果cookie中有，则查询数据库，再生成相应的session
        if(flag!=true) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if ("name".equals(c.getName())) {
                        name = c.getValue();
                    }
                    if ("password".equals(c.getName())) {
                        password = c.getValue();
                    }
                }
                if (name != null && password != null) {
                    if ( userService.isUser(name, password)) {
                        session = request.getSession(true);
                        session.setAttribute("name", name);
                        flag = true;
                    }
                }
            }
        }
        //如未登录 这些网页不能浏览
            if (uri.indexOf("myInfo") != -1 || uri.indexOf("smallFeature") != -1 || uri.indexOf("questionnaire") != -1  )
                haveQuality = false;
        //如登录，则登录页面不能浏览
        if(flag==true){
            if (uri.indexOf("loginimage") == -1 && uri.indexOf("login_success") == -1 && uri.indexOf("login") != -1 )
                rpLogin = true;
        }
        if(rpLogin){
            request.setAttribute("msg","不要重复登录哦");
            request.getRequestDispatcher("remind").forward(request,response);
        }
        else if (flag || haveQuality) {
            filterChain.doFilter(request, response);
        }
        else {
            request.setAttribute("msg","您所在的用户组没有权限浏览哦！请先登录哦< - . - >");
            request.getRequestDispatcher("remind").forward(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}