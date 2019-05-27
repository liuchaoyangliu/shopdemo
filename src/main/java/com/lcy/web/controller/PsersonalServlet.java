package com.lcy.web.controller;

import com.lcy.web.entity.User;
import com.lcy.web.jdbcServer.UserJdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "PsersonalServlet", urlPatterns = "/psersonalServlet")
public class PsersonalServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String target = null;
        target = request.getParameter("target");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        UserJdbc userJdbc = UserJdbc.getUserJdbc();
        user = userJdbc.getUserOne(user.getUsername());
        System.out.println(user.toString());
        request.setAttribute("user", user);
        if(target.equals("1")){
            request.getRequestDispatcher("person.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("personPerfect.jsp").forward(request, response);
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}