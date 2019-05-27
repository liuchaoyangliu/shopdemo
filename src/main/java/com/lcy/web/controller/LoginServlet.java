package com.lcy.web.controller;


import com.lcy.web.entity.User;
import com.lcy.web.server.LoginService;
import com.lcy.web.server.impl.LoginServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/loginServlet")
public class LoginServlet extends BaseServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User();
        /**
         * 先检查cookie如果有用户名和密码，则把用户名和密码放入session中
         * 并跳转进入指定页面
         */
        String name = null;
        String password = null;
        String type = null;
        type = request.getParameter("type");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie2 : cookies) {
            if(cookie2.getName().equals("name")){
                name = cookie2.getValue();
            }
            if(cookie2.getName().equals("password")){
                password = cookie2.getValue();
            }
        }

        if(name != null && password != null){
            HttpSession session = request.getSession();
            user.setUsername(name);
            user.setPassword(password);
            session.setAttribute("user", user);
//            response.sendRedirect("backstage.jsp");
            if(type == null){
                response.sendRedirect("backstage.jsp");
            }else{
                response.sendRedirect("frontDesk.jsp");
            }
            return;
        }

        /**
         * 如果cookie中没有登录信息
         * 则从request中获取相关登录信息
         */
        name = request.getParameter("name");
        password = request.getParameter("password");

        if(name != null && password != null){
            LoginService login = new LoginServiceImpl();
            user = login.login(name, password);
            if(user == null){
                // 未登录成功返回重新登录
                response.sendRedirect("backstage.jsp");
            }else {

                Cookie cookie = new Cookie("name",name);
                cookie.setMaxAge(360*24*60);//设置一年有效期
                cookie.setPath("/");//可在同一应用服务器内共享方法
                response.addCookie(cookie);//放松到客户段

                Cookie cookie2 = new Cookie("password",password);
                cookie2.setMaxAge(360*24*60);//设置一年有效期
                cookie2.setPath("/");//可在同一应用服务器内共享方法
                response.addCookie(cookie2);//放松到客户段

                HttpSession session = request.getSession();
                user.setUsername(name);
                user.setPassword(password);
                session.setAttribute("user", user);

                if(type == null){
                    response.sendRedirect("backstage.jsp");
                }else{
                    response.sendRedirect("frontDesk.jsp");
                }
            }
        }else {
            if(type == null){
                response.sendRedirect("backstage.jsp");
            }else{
                response.sendRedirect("frontDesk.jsp");
            }
        }

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}