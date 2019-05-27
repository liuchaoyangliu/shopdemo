package com.lcy.web.controller;

import com.lcy.web.entity.Commodity;
import com.lcy.web.jdbcServer.CommoditySrver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "CommodityServlet", urlPatterns = "/commodityServlet")
public class CommodityServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommoditySrver commoditySrver = CommoditySrver.getCommoditySrver();
        LinkedList<Commodity> listCommodity = commoditySrver.getCommodity();
        request.setAttribute("listCommodity", listCommodity);

        String target = null;
        target = request.getParameter("target");

        if(target != null && target.equals("2")){
            request.getRequestDispatcher("frontCommodity.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("commodity.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
