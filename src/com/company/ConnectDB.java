package com.company;

// Using concept of JDBC stands for Java Database Connectivity
// JDBC is a Java API to connect and execute the query with the database

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectDB {
    Connection c;
    public Statement s;
    public ConnectDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tgf", "root", "$@yeeD35");
            s = c.createStatement();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
