package com.lcy.web.controller;


import com.lcy.web.jdbcServer.CommoditySrver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(name = "DeleteCommodityServlet", urlPatterns = "/deleteCommodityServlet")
public class DeleteCommodityServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uuid = request.getParameter("id");
        CommoditySrver commoditySrver = CommoditySrver.getCommoditySrver();

        commoditySrver.deleteCom(uuid);

        response.sendRedirect("commodityServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}