package com.lcy.web.util;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcPool {
    // BasicDataSource 也就是DBCP所使用数据源
    private static BasicDataSource basicDataSource;

    /**
     * 读取配置文件，并且初始化连接池
     */
    private static void init(){
        // 根据上面所放类路径读取配置文件
        InputStream inputStream = JdbcPool.class.getClassLoader()
                .getResourceAsStream("properties.properties");
        Properties properties = new Properties();
        try {
            // 加载properties文件
            properties.load(inputStream);

            // 新建一个BasicDataSource
            basicDataSource = new BasicDataSource();

            // 设置对应的参数
            basicDataSource.setUrl(properties.getProperty("dataSource.url"));
            basicDataSource.setDriverClassName(properties.getProperty("dataSource.driverClassName"));
            basicDataSource.setUsername(properties.getProperty("dataSource.username"));
            basicDataSource.setPassword(properties.getProperty("dataSource.password"));

            basicDataSource.setInitialSize(Integer.parseInt(properties.getProperty("dataSource.initialSize")));
            basicDataSource.setMaxIdle(Integer.parseInt(properties.getProperty("dataSource.maxIdle")));
            basicDataSource.setMinIdle(Integer.parseInt(properties.getProperty("dataSource.minIdle")));
            basicDataSource.setMaxActive(Integer.parseInt(properties.getProperty("dataSource.maxActive")));
            basicDataSource.setMaxWait(Integer.parseInt(properties.getProperty("dataSource.maxWait")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得Connection
     * @return Connection
     */
    public synchronized static Connection getConnection(){
        if (basicDataSource == null){
            init();
        }
        try {
            return basicDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
