package com.example.lab7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class MyDB {

    public String host = "localhost";
    public String dbName = "mydb";
    public Number port = 3306;
    Connection conn = null;
    Statement statement = null;
    private String user = "root";
    private String password = "root";

    public String setUser(String user) {
        return user;
    }
    public String setPassword(String password) {
        return password;
    }
    public MyDB(String host, String dbName, Number port)  {
    }
    private void connect() {
        Properties connectionProps = new Properties();
        connectionProps.put("user", user);
        connectionProps.put("password", password);
        connectionProps.put("serverTimezone", "Europe/Warsaw");

        String jdbcString = "jdbc:mysql://" + host + ":" + port + "/" + dbName;

        try {
            conn = DriverManager.getConnection(jdbcString, connectionProps);
            statement = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Blad polaczenia: " + jdbcString);
            System.out.println("Blad: " + e.getMessage());
            conn = null;
        }
        System.out.println("Connected dataBase " + dbName);
    }
    public Connection getConnection() {
        if (conn == null)
            connect();
        return conn;
    }

    public void closeConnetcion() {
    }

    public ResultSet selectData(String selectStatement){
        if ((conn != null) && (statement != null))
            try{
                return statement.executeQuery(selectStatement);
            } catch (SQLException e){
                System.out.println("Blad realizacji zapytania: "+selectStatement+" , "+e.getMessage());
            }
        return null;
    }

}
