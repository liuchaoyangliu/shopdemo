package com.lcy.web.controller;

import com.lcy.web.entity.User;
import com.lcy.web.jdbcServer.UserJdbc;
import com.lcy.web.util.Uuid;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddUserServlet", urlPatterns = "/addUserServlet")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int age = Integer.parseInt(request.getParameter("age"));
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        User user = new User();
        user.setUuid(Uuid.getUuid());
        user.setUsername(username);
        user.setPassword(password);
        user.setAge(age);
        user.setSex(sex);
        user.setAddress(address);
        user.setPhone(phone);
        user.setEmail(email);

        UserJdbc userJdbc = UserJdbc.getUserJdbc();
        userJdbc.insertUsere(user);

        response.sendRedirect("userServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
