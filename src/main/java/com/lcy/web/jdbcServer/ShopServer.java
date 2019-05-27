package com.lcy.web.jdbcServer;

import com.lcy.web.entity.Commodity;

import java.util.ArrayList;
import java.util.List;

public class ShopServer {

    List<Commodity> shopList = new ArrayList<>();

    private static ShopServer shopServer;//声明一个该对象的引用，但不进行实例化，static不初始化时，s默认的值为null

    private ShopServer(){}//保证只能在本类实例化对象

    public static synchronized ShopServer getShopJdbc(){

        if(shopServer==null){ //判断该引用是否为空
            shopServer = new ShopServer();
        }
        return shopServer;
    }

    public List<Commodity> addCommodity(String uuid){

        CommoditySrver commoditySrver = CommoditySrver.getCommoditySrver();
        Commodity commodityOne = commoditySrver.getCommodityOne(uuid);


        shopList.add(commodityOne);
        return shopList;
    }

    public List<Commodity> removeCommodity(String uuid){

        for (int i = 0; i < shopList.size(); i++) {
            if(shopList.get(i).getUuid().equals(uuid)){
                shopList.remove(i);
                return shopList;
            }
        }

        return shopList;
    }

    public List<Commodity> getCommodity(){
        return shopList;
    }

}
