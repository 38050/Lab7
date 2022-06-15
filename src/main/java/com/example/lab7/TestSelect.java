package com.example.lab7;
import com.example.lab7.MyDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import com.mysql.jdbc.Driver;

public class TestSelect {
    public static void main(String[] args) throws SQLException {
        MyDB db = new MyDB("localhost", "mydb", 3306);
        db.setUser("root");
        db.setPassword("38050");
        Connection conn = db.getConnection();
        if (conn != null) {
            Statement polecenie = conn.createStatement();
            ResultSet res = polecenie.executeQuery("SELECT * FROM coffee_houses");
            System.out.printf("%10s%20s%7s%7s%7s\n", "STORE_ID", "CITY", "COFFE", "MERCH", "TOTAL");
            while (res.next()) {
                System.out.printf("%10s%20s%7s%7s%7s\n", res.getInt(1), res.getString("CITY"), res.getInt(3),
                        res.getInt(4), res.getInt(5));
            }
        }
        db.closeConnetcion();
        System.out.println("Polaczenie zakonczone");
    }
}

