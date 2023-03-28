package org.nischay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Nischay\\Programming\\sample.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String createTableQuery =
                    "CREATE TABLE nischay_test (\n" +
                    "\tid INTEGER PRIMARY KEY,\n" +
                    "\tfirst_name TEXT NOT NULL,\n" +
                    "\tlast_name TEXT NOT NULL\n" +
                    ")";
            String insertValuesQuery =
                    "INSERT INTO nischay_test (id, first_name, last_name) VALUES (1, \"Nischay\", \"Jonnalagedda\")";
            statement.executeUpdate(createTableQuery);
            statement.executeUpdate(insertValuesQuery);
            statement.close();
            connection.close();
            System.out.println("Table has been created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}