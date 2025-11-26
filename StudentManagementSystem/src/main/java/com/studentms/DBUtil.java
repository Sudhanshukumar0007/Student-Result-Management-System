package com.studentms;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    private static final String JDBC_URL  = "jdbc:mysql://localhost:3306/studentdb";
    private static final String JDBC_USER = "root";      // change if needed
    private static final String JDBC_PASS = "Vivek2003#";          // your MySQL password

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }
}
