package com.lcy.web.controller;

import com.lcy.web.entity.User;
import com.lcy.web.jdbcServer.UserJdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteUserServlet", urlPatterns = "/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uuid = request.getParameter("id");

        UserJdbc userJdbc = UserJdbc.getUserJdbc();

        userJdbc.deleteUsere(uuid);

        response.sendRedirect("userServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}