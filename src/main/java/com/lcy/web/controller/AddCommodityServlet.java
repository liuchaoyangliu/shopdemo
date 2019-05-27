package com.lcy.web.controller;

import com.lcy.web.entity.Commodity;
import com.lcy.web.jdbcServer.CommoditySrver;
import com.lcy.web.util.Uuid;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddCommodityServlet", urlPatterns = "/addCommodityServlet")
public class AddCommodityServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String class1 = request.getParameter("class1");
        String class2 = request.getParameter("class2");
        Double price = Double.parseDouble(request.getParameter("price"));
        Integer totalAmount = Integer.parseInt(request.getParameter("totalAmount"));
        String description = request.getParameter("Description");

        Commodity commodity = new Commodity();
        commodity.setUuid(Uuid.getUuid());
        commodity.setName(name);
        commodity.setClass1(class1);
        commodity.setClass2(class2);
        commodity.setPrice(price);
        commodity.setTotalAmount(totalAmount);
        commodity.setDescription(description);

        CommoditySrver commoditySrver = CommoditySrver.getCommoditySrver();
        commoditySrver.insertCom(commodity);

        response.sendRedirect("commodityServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
