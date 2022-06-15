package com.example.lab7;

import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.Properties;


import com.mysql.jdbc.Driver;

public class TestConnection {

    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        String serverName="localhost";
        String database = "mydb";
        Number portnumber = 3306;
        Connection conn = null;
        Properties connProperties = new Properties();
        connProperties.put("user","root");
        connProperties.put("password","38050");
        connProperties.put("serverTimezone","Europe/Warsaw");

        conn = DriverManager.getConnection(
                "jdbc:mysql://"+serverName+":"+portnumber+"/"+database,connProperties);
        System.out.printf("Connected to datebase");
    }
}