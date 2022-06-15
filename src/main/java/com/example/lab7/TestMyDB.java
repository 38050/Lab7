package com.example.lab7;
import com.example.lab7.MyDB;
import java.sql.Connection;
import java.sql.*;

public class TestMyDB {
    public static void main(String[] args)  {
      MyDB db = new MyDB("localhost", "mydb", 3306);
      db.setUser("root");
      db.setPassword("38050");
      Connection conn = db.getConnection();
      if (conn != null)
          System.out.println("Polaczenie z baza udane");
      db.closeConnetcion();
      System.out.println("Polaczenie z baza zakonczone");
    }

}