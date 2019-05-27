package com.lcy.web.controller;

import com.lcy.web.entity.Commodity;
import com.lcy.web.jdbcServer.ShopServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShopCartServlet", urlPatterns = "/shopCartServlet")
public class ShopCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ShopServer shopServer = ShopServer.getShopJdbc();
        List<Commodity> shopList = null;
        String target = null;
        String deleteCommodity = null;
        target = request.getParameter("shopCard");
        deleteCommodity = request.getParameter("deleteCommodity");
        if(target!= null && target.equals("shopCard")){
            shopList = shopServer.getCommodity();
            request.setAttribute("shopList", shopList);
            request.getRequestDispatcher("shopCard.jsp").forward(request, response);
        }else if (deleteCommodity!= null){
            shopList = shopServer.removeCommodity(deleteCommodity);
            request.setAttribute("shopList", shopList);
            request.getRequestDispatcher("shopCard.jsp").forward(request, response);
        }else{
            String uuid = request.getParameter("uuid");
            shopList = shopServer.addCommodity(uuid);
            request.getRequestDispatcher("commodityServlet?target=2").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
