package com.lcy.web.jdbcServer;

import com.lcy.web.entity.Commodity;
import com.lcy.web.util.JdbcPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class CommoditySrver {

    private static CommoditySrver commodity;//声明一个该对象的引用，但不进行实例化，static不初始化时，s默认的值为null

    private CommoditySrver(){}//保证只能在本类实例化对象

    public static synchronized CommoditySrver getCommoditySrver(){

        if(commodity==null){ //判断该引用是否为空
            commodity = new CommoditySrver();
        }
        return commodity;
    }


    public LinkedList<Commodity> getCommodity(){

        LinkedList<Commodity> link = new LinkedList<>();

        Connection connection = JdbcPool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        try{
            String sql = "select * from commodity";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Commodity commodity = new Commodity();

                commodity.setUuid(resultSet.getString("uuid"));
                commodity.setName(resultSet.getString("name"));
                commodity.setClass1(resultSet.getString("class1"));
                commodity.setClass2(resultSet.getString("class2"));
                commodity.setPrice(resultSet.getDouble("price"));
                commodity.setTotalAmount(resultSet.getInt("totalAmount"));
                commodity.setDescription(resultSet.getString("Description"));

                link.add(commodity);
            }
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return link;
    }

    public boolean insertCom(Commodity com){

        Connection connection = JdbcPool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        try{
            String sql = "INSERT INTO `commodity` (\n" +
                    "  `uuid`,\n" +
                    "  `name`,\n" +
                    "  `class1`,\n" +
                    "  `class2`,\n" +
                    "  `price`,\n" +
                    "  `totalAmount`,\n" +
                    "  `Description`\n" +
                    ") \n" +
                    "VALUES\n" +
                    "  (\n" +
                    "    ?,\n" +
                    "    ?,\n" +
                    "    ?,\n" +
                    "    ?,\n" +
                    "    ?,\n" +
                    "    ?,\n" +
                    "    ?\n" +
                    "  ) ;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, com.getUuid());
            preparedStatement.setString(2, com.getName());
            preparedStatement.setString(3, com.getClass1());
            preparedStatement.setString(4, com.getClass2());
            preparedStatement.setDouble(5,com.getPrice());
            preparedStatement.setInt(6 , com.getTotalAmount());
            preparedStatement.setString(7, com.getDescription());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    public boolean deleteCom(String uuid){

        Connection connection = JdbcPool.getConnection();
        PreparedStatement preparedStatement = null;
        try{
            String sql = "DELETE \n" +
                    "FROM\n" +
                    "  `javaweb`.`commodity` \n" +
                    "WHERE `uuid` = ? ;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, uuid);
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return true;
    }



    public Commodity getCommodityOne(String uuid){


        Connection connection = JdbcPool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        Commodity commodity = null;
        try{
            String sql = "select * from commodity where uuid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, uuid);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            commodity = new Commodity();

            commodity.setUuid(resultSet.getString("uuid"));
            commodity.setName(resultSet.getString("name"));
            commodity.setClass1(resultSet.getString("class1"));
            commodity.setClass2(resultSet.getString("class2"));
            commodity.setPrice(resultSet.getDouble("price"));
            commodity.setTotalAmount(resultSet.getInt("totalAmount"));
            commodity.setDescription(resultSet.getString("Description"));

            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return commodity;
    }

}
