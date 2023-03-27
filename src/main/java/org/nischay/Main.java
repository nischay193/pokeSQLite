package org.nischay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String createTableQuery =
                    "CREATE TABLE nischay_test (\n" +
                    "\tid INTEGER PRIMARY KEY,\n" +
                    "\tfirst_name TEXT NOT NULL,\n" +
                    "\tlast_name TEXT NOT NULL\n" +
                    ")";
            statement.executeUpdate(createTableQuery);
            statement.close();
            connection.close();
            System.out.println("Table has been created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}