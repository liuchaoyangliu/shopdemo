package com.lcy.web.controller;

import com.lcy.web.entity.User;
import com.lcy.web.jdbcServer.UserJdbc;
import com.lcy.web.server.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserUpdateServlet", urlPatterns = "/userUpdateServlet")
public class UserUpdateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String uuid = request.getParameter("uuid");
        user.setUuid(uuid);

        UserJdbc userJdbc = UserJdbc.getUserJdbc();
        String target = request.getParameter("target");
        if(target.equals("1")){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            int age = Integer.parseInt(request.getParameter("age"));
            String sex = request.getParameter("sex");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");

            user.setUsername(username);
            user.setPassword(password);
            user.setAge(age);
            user.setSex(sex);
            user.setAddress(address);
            user.setPhone(phone);
            user.setEmail(email);

            userJdbc.updateUsere(user, target);
            response.sendRedirect("psersonalServlet?target=1");

        }else {

            String education = request.getParameter("education");
            String school = request.getParameter("school");
            String profession = request.getParameter("profession");

            user.setEducation(education);
            user.setSchool(school);
            user.setProfession(profession);

            userJdbc.updateUsere(user, target);
            response.sendRedirect("psersonalServlet?target=2");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
