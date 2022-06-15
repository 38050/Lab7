package com.example.lab7;

import java.sql.Connection;
import java.sql.*;

public class TestMyDB {
    public static void main(String[] args) {
        MyDB dataBase = new MyDB("localhost","mydb", 3306);
        dataBase.setUser("root");
        dataBase.setPasssword("38050");
        Connection conn= dataBase.getConnection();
        if(conn!=null){
            System.out.printf("powiodło sie");
            try {
                Statement polecenie = conn.createStatement();
                Number dostawa = 100;
                polecenie.executeUpdate("UPDATE coffee_houses SET COFFEE= COFFEE+"+dostawa+" WHERE CITY ='SF' ");

                ResultSet res = polecenie.executeQuery("SELECT * FROM coffee_houses");
                System.out.printf("%10s%20s%7s%7s%7s \n", "STORE_ID", "CITY", "COFFEE", "MERCH", "TOTAL");
                while (res.next()) {
                    System.out.printf("%10d%20s%7d%7d%7d \n", res.getInt(1), res.getString("CITY"), res.getInt(3), res.getInt(4), res.getInt(5));
                }

            }catch(SQLException e){
                System.out.printf("blad");
            }
        }
        dataBase.closeConnection();
        System.out.printf("polacznie");
    }

}