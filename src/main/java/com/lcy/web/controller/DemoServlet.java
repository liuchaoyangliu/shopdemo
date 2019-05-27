package com.lcy.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DemoServlet", urlPatterns = "/demoServlet")
public class DemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("DemoServlet被访问");

        request.setCharacterEncoding("utf-8");
        response.setContentType("text.html;charaset-utf-8");

        request.getAttribute("");

        response.sendRedirect("");

        request.getRequestDispatcher("new.jsp").forward(request, response);




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
