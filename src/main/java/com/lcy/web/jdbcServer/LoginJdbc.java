package com.lcy.web.jdbcServer;

import com.lcy.web.entity.User;
import com.lcy.web.util.JdbcPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginJdbc {

    static Logger logger = Logger.getLogger(JdbcServer.class);

    private static LoginJdbc login;//声明一个该对象的引用，但不进行实例化，static不初始化时，s默认的值为null

    private LoginJdbc(){}//保证只能在本类实例化对象

    public static synchronized LoginJdbc getLoginJdbc(){

        if(login==null){ //判断该引用是否为空
            login = new LoginJdbc();
        }
        return login;
    }

    public User getUser(String name, String password){

        Connection connection = JdbcPool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        User user = null;
        try{
            String sql = "select * from user where username = ? and password = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            user = new User();
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setUuid(resultSet.getString("uuid"));

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

}
