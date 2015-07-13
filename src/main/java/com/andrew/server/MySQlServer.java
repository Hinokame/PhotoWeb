package com.andrew.server;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQlServer {
    public static void main(String... args) {
        MysqlDataSource dataSource = new MysqlDataSource();
        // set MySql data-properties to access:
        dataSource.setUser("root");
        dataSource.setPassword("MySql_ADmIn12");
        dataSource.setServerName("127.0.0.1");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("test");

        // now try connect to mysql server with given data
        try {
            java.sql.Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement(); // create sql query
            ResultSet rs = stmt.executeQuery("SHOW DATABASES"); // execute sql and get result
            while (rs.next()) { // print all results
                String result = rs.getString(1);
                System.out.println(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
