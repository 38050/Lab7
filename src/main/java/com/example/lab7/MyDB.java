package com.example.lab7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyDB {

    private
    String DBAdress;
    String DBName;
    Number port;

    String user;
    String passsword;

    Connection conn=null;
    void connect(){
        Properties connProperties = new Properties();
        connProperties.put("user",user);
        connProperties.put("password",passsword);
        connProperties.put("serverTimezone","Europe/Warsaw");

        String jdbc = "jdbc:mysql://"+DBAdress+":"+port+"/"+DBName;
        try{
            conn = DriverManager.getConnection(jdbc,connProperties);
        }catch(SQLException e){
            System.out.printf("blad");
            conn = null;
        }
        System.out.printf("Connected");

    }
    void closeConnection(){
        if(conn!=null){
            try{
                conn.close();
            }catch(SQLException e){
                System.out.printf("nie powiodlo sie");
            }
        }
        conn=null;
    }
    public MyDB(String adres,String nazwa,Number port){
        this.DBAdress=adres;
        this.port=port;
        this.DBName=nazwa;
    }
    public void setUser(String u){
        this.user=u;
    }
    public void setPasssword(String p){
        this.passsword=p;
    }
    Connection getConnection(){
        if(conn==null){
            connect();
        }
        return conn;
    }
}

