package com.lcy.web.controller;

import com.lcy.web.entity.Student;
import com.lcy.web.server.JdbcServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProfSchoolServlet", urlPatterns = "/profSchoolServlet")
public class ProfSchoolServlet extends BaseServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student stu = (Student) request.getSession().getAttribute("stu");

        String school =request.getParameter("school");
        String prof = request.getParameter("prof");
        logger.info("ProfSchoolServlet方法被调用，传入参数，school：" + school + ",prof:" + prof);
        if(JdbcServer.setProSchool(stu.getName(), school, prof)){
            response.sendRedirect("updateMsg2.jsp");
        }else {
            response.sendRedirect("updateMsg.jsp");
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
