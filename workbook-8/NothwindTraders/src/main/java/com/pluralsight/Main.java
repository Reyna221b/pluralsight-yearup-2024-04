package com.pluralsight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        String username = "root";
        String password = "Pokemon1.";

        try {
            // load the MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 1. open a connection to the database
            // use the database URL to point to the correct database
            Connection connection;
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/northwind",
                    username,
                    password);

            // 2. execute a statement
            String sql = """
                SELECT ProductID
                    , ProductName
                    , SupplierID
                FROM products;
                """;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // 2 a. - read the results
            while (resultSet.next()) {
                int id = resultSet.getInt("ProductID");
                String name = resultSet.getString("ProductName");
                String supplierID = resultSet.getString("SupplierID");

                System.out.printf("%3d  %-32s %s\n", id, name,supplierID);
            }


            // 3. close the connection
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}