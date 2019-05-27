package com.lcy.web.controller;

import com.lcy.web.entity.User;
import com.lcy.web.server.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserUpdateServlet", urlPatterns = "/userUpdateServlet")
public class UserUpdateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String target = request.getParameter("target");
        if(target.equals("1")){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String age = request.getParameter("age");
            String sex = request.getParameter("sex");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
        }else {

            String education = request.getParameter("education");
            String school = request.getParameter("school");
            String profession = request.getParameter("profession");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
