package com.lcy.web.controller;

import com.lcy.web.entity.Student;
import com.lcy.web.server.JdbcServer;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/loginServlet")
public class LoginServlet extends BaseServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name =req.getParameter("name");
        String password = req.getParameter("password");
        logger.info("LoginServlet被调用");
        logger.info("传入参数：name" + name + ",password:" + password);
        try{
            Student stu = jdbcServer.get(name);
            if(stu != null && stu.getPassword().equals(password)){
                ServletContext servletContext = req.getServletContext();
                servletContext.setAttribute("stu", stu);
                req.getRequestDispatcher("success.jsp").forward(req, resp);
            }else {
                resp.sendRedirect("error.jsp");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("用户名错误");
            resp.sendRedirect("error.jsp");
        }


    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}