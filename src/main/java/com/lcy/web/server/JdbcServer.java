package com.lcy.web.server;

import com.lcy.web.entity.Student;
import org.apache.log4j.Logger;
import util.JdbcPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcServer {

    static Logger logger = Logger.getLogger(JdbcServer.class);

    public Student get(String name){
        Connection connection = JdbcPool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        Student stu = null;
        try{
            String sql = "SELECT * FROM student WHERE name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            stu = new Student();
            stu.setUuid(resultSet.getString("uuid"));
            stu.setName(resultSet.getString("name"));
            stu.setPassword(resultSet.getString("password"));
            stu.setProfessional(resultSet.getString("professional"));
            stu.setSchool(resultSet.getString("school"));
            stu.setTechnical(resultSet.getString("technical"));

            preparedStatement.close();
            connection.close();
            logger.info("通过姓名得到该对象，返回一个student: " + stu.toString());
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
        return stu;
    }


    public boolean setProSchool(String name, String school, String prof){
        logger.info("更改学生学校和专业, 传入参数,name:" + name + " school:" + school + " prof:" + prof);
        Connection connection = JdbcPool.getConnection();
        PreparedStatement preparedStatement = null;
        int result = 0;
        try{
            String sql = "UPDATE `student` SET `professional` = ?, `school` = ? WHERE `name` = ? ;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, prof);
            preparedStatement.setString(2, school);
            preparedStatement.setString(3, name);
            result = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

            logger.info("更改学生学校和专业，成功");
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
        if(result == 1){
            return true;
        }else {
            return false;
        }
    }


    public boolean setTech(String name, String[] tech){
        String tech1 = "";
        for (int i = 0; i < tech.length; i++) {
            tech1 += tech[i] + ",";
        }
        logger.info("更改学生掌握技术，传入参数tech：" + tech1);
        Connection connection = JdbcPool.getConnection();
        PreparedStatement preparedStatement = null;
        int result = 0;
        try{
            String sql = "UPDATE `student` SET `technical` = ?WHERE `name` = ? ;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tech1);
            preparedStatement.setString(2, name);
            result = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            logger.info("更改学生掌握技术成功！");
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
        if(result == 1){
            return true;
        }else {
            return false;
        }

    }

}
