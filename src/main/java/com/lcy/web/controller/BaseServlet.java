package com.lcy.web.controller;

import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BaseServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext sc = req.getServletContext();
        Integer count = 0;
        sc.setAttribute("count", count);

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");


    }

}
