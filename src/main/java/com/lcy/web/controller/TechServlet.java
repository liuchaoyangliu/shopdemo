package com.lcy.web.controller;

import com.lcy.web.entity.Student;
import com.lcy.web.server.JdbcServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TechServlet", urlPatterns = "/techServlet")
public class TechServlet extends BaseServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student stu = (Student) request.getSession().getAttribute("stu");

        String[] tech =request.getParameterValues("category");

        logger.info("TechServlet被调用，传入参数，tech：" + tech);
        JdbcServer.setTech(stu.getName(), tech);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);

    }
}
