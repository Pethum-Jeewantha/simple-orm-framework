package com.pethumjeewantha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TableCreation {

    public static void init(String url, String userName, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(url, userName, password);

    }
}
