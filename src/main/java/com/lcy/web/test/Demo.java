package com.lcy.web.test;

import org.junit.jupiter.api.Test;
import util.JdbcPool;
import util.Uuid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo {

    @Test
    public void test1() throws SQLException {
        Connection connection = JdbcPool.getConnection();
        String sql = "INSERT INTO `student` (`uuid`,`name`,`password`,`professional`,`school`,`technical`) VALUES(?,?,?,'professional','school','technical')";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //4.SQL语句占位符设置实际参数
        preparedStatement.setString(1, Uuid.getUuid());
        preparedStatement.setString(2, "zhang");
        preparedStatement.setString(3, "1234");

        //5.执行SQL语句
        int line = preparedStatement.executeUpdate();
        System.out.println("更新记录数"+ line);
        //6.释放资源
        preparedStatement.close();
        connection.close();

    }

    @Test
    public void test2() throws SQLException {

        String name = "zhang";
        String[] tech = {"java", "php", "c#", "python", "scala"};
        String tech1 = "";
        for (int i = 0; i < tech.length; i++) {
            tech1 += tech[i] + ",";
        }
        System.out.println(tech1);

        Connection connection = JdbcPool.getConnection();
        PreparedStatement preparedStatement = null;
        try{
            String sql = "UPDATE `student` SET `technical` = ?WHERE `name` = ? ;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tech1);
            preparedStatement.setString(2, name);

            int result = preparedStatement.executeUpdate();

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

    }

}
