package com.lcy.web.jdbcServer;

import com.lcy.web.entity.User;
import com.lcy.web.util.JdbcPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class UserJdbc {

    private static UserJdbc user;//声明一个该对象的引用，但不进行实例化，static不初始化时，s默认的值为null

    private UserJdbc(){}//保证只能在本类实例化对象

    public static synchronized UserJdbc getUserJdbc(){

        if(user==null){ //判断该引用是否为空
            user = new UserJdbc();
        }
        return user;
    }

    public LinkedList<User> getUser(){

        LinkedList<User> link = new LinkedList<>();

        Connection connection = JdbcPool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        try{
            String sql = "select * from user ";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                User user = new User();
                user.setUuid(resultSet.getString("uuid"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setAge(Integer.parseInt(resultSet.getString("age")));
                user.setSex(resultSet.getString("sex"));
                user.setAddress(resultSet.getString("address"));
                user.setPhone(resultSet.getString("phone"));
                user.setEmail(resultSet.getString("email"));
                user.setEducation(resultSet.getString("education"));
                user.setSchool(resultSet.getString("school"));
                user.setProfession(resultSet.getString("profession"));
                link.add(user);
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

    public User getUserOne(String name) {

        Connection connection = JdbcPool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        User user = null;
        try{
            String sql = "SELECT * FROM user WHERE username = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            user = new User();
            user.setUuid(resultSet.getString("uuid"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setAge(Integer.parseInt(resultSet.getString("age")));
            user.setSex(resultSet.getString("sex"));
            user.setAddress(resultSet.getString("address"));
            user.setPhone(resultSet.getString("phone"));
            user.setEmail(resultSet.getString("email"));
            user.setEducation(resultSet.getString("education"));
            user.setSchool(resultSet.getString("school"));
            user.setProfession(resultSet.getString("profession"));
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
        return user;

    }

    public boolean deleteUsere(String uuid){

        Connection connection = JdbcPool.getConnection();
        PreparedStatement preparedStatement = null;
        try{
            String sql = "DELETE \n" +
                    "FROM\n" +
                    "  `javaweb`.`user` \n" +
                    "WHERE `uuid` = ?";
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


    public boolean insertUsere(User user){

        System.out.println("user: " + user.toString());

        Connection connection = JdbcPool.getConnection();
        PreparedStatement preparedStatement = null;
        try{
            String sql = "INSERT INTO `javaweb`.`user` (\n" +
                    "  `uuid`,\n" +
                    "  `username`,\n" +
                    "  `password`,\n" +
                    "  `age`,\n" +
                    "  `sex`,\n" +
                    "  `address`,\n" +
                    "  `phone`,\n" +
                    "  `email`\n" +
                    ") \n" +
                    "VALUES\n" +
                    "  (\n" +
                    "    ?,\n" +
                    "    ?,\n" +
                    "    ?,\n" +
                    "    ?,\n" +
                    "    ?,\n" +
                    "    ?,\n" +
                    "    ?,\n" +
                    "    ?\n" +
                    "  ) ;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUuid());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.setString(5, user.getSex());
            preparedStatement.setString(6, user.getAddress());
            preparedStatement.setString(7, user.getPhone());
            preparedStatement.setString(8, user.getEmail());

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


}
