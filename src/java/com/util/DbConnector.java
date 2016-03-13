package com.util;
import java.sql.*;
public class DbConnector {
    // System.out.println("MySQL Connect Example.");

    public static Connection getConnection() {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "ftp";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "password";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Connected to the database");
            //conn.close();
            //System.out.println("Disconnected from database");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public static void main(String arg[]){
        DbConnector.getConnection();
    }
}
