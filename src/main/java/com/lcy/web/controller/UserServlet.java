package com.lcy.web.controller;

import com.lcy.web.entity.User;
import com.lcy.web.server.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "UserServlet", urlPatterns = "/userServlet")
public class UserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        String name = null;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println(user.toString());
        if(user == null){
            response.sendRedirect("backstage.jsp");
        }else {
//            name = user.getName();
            UserServiceImpl userService = new UserServiceImpl();
            LinkedList<User> linkUser = userService.getUser();
            request.setAttribute("linkUser", linkUser);
            request.getRequestDispatcher("userManagament.jsp").forward(request, response);
        }

//        if(name != null){
//            UserServiceImpl userService = new UserServiceImpl();
//            LinkedList<User> linkUser = userService.getUser();
//            request.setAttribute("linkUser", linkUser);
//            request.getRequestDispatcher("userManagament.jsp").forward(request, response);
//        }else {
//            response.sendRedirect("backstage.jsp");
//        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
