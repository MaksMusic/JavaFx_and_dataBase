package com.example.javafxanddatabase.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnectionManager {

    private final String url;
    private final String userName;
    private final String password;

    public DataBaseConnectionManager(String url, String userName, String password) {
        this.url = url;
        this.userName = userName;
        this.password = password;
    }

    public Connection getConnection () throws SQLException {
       return DriverManager.getConnection(url,userName,password);
    }
}
