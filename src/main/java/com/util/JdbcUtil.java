package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
    private static Connection conn = null;

    public static Connection getConn(){
        PropertiesUtil.loadFile("jdbc.properties");
        String driver = PropertiesUtil.getPropertyValue("driver");
        String username = PropertiesUtil.getPropertyValue("username");
        String password = PropertiesUtil.getPropertyValue("password");
        String url = PropertiesUtil.getPropertyValue("url");

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void close(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
