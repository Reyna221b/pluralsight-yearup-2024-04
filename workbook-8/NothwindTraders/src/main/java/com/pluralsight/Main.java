package com.pluralsight;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int option = display(scanner);
        String username = "root";
        String password = "Pokemon1.";

        // load the MySQL Driver

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 1. open a connection to the database
            // use the database URL to point to the correct database
            Connection connection;
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/northwind",
                    username,
                    password);



            // 2. execute a statement
            String sql;
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            try {
                switch (option) {
                    case 1:
                        sql = """
                        SELECT ProductID
                            , ProductName
                            , UnitPrice
                            , UnitsInStock
                        FROM products;
                        """;
                        statement = connection.prepareStatement(sql);
                        resultSet = statement.executeQuery(sql);

                        System.out.print("Product ");
                        while (resultSet.next()) {
                            int id = resultSet.getInt("ProductID");
                            String name = resultSet.getString("ProductName");
                            float unitPrice = resultSet.getFloat("UnitPrice");
                            int unitStock = resultSet.getInt("UnitsInStock");

                            System.out.printf(" ID: %3d\n Name: %-32s\n Price: %.2f\n Stock: %d\n", id, name,unitPrice,unitStock);
                            System.out.println("-".repeat(37));
                        }
                        break;
                    case 2:
                        sql = """
                        SELECT  CompanyName
                            , ContactName
                            , city
                            , Country
                            , phone
                        FROM customers
                        ORDER BY Country;
                        """;
                        statement = connection.prepareStatement(sql);
                        resultSet = statement.executeQuery(sql);


                        while (resultSet.next()) {

                            String company = resultSet.getString("CompanyName");
                            String contact = resultSet.getString("ContactName");
                            String country = resultSet.getString("Country");
                            String city = resultSet.getString("City");
                            String phone = resultSet.getString("Phone");

                            System.out.printf("Company: %-10s\n ContactName: %-32s\n City: %-20s\n Country: %-20s\n Phone: %-20s\n",company, contact, city, country, phone);
                            System.out.println("-".repeat(52));
                        }
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
            } catch (SQLException e) {
                System.out.println("Error executing query: " + e.getMessage());
            } finally {
                // close the connection, statement, and resultSet
                try {
                    if (resultSet != null) resultSet.close();
                    if (statement != null) statement.close();
                    if (connection != null) connection.close();
                } catch (SQLException e) {
                    System.out.println("Error closing resources: " + e.getMessage());
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error loading MySQL driver: " + e.getMessage());
        }
        
    }

    public static int display(Scanner scanner) {
        int option;
        while (true) {
            try {
                System.out.println("What do you want to do?");
                System.out.println("[1] Display all products");
                System.out.println("[2] Display all customers");
                System.out.println("[3] Display all categories");
                System.out.println("[0] Exit");
                System.out.print("Select an option: ");
                option = scanner.nextInt();
                if (option < 0 || option > 2) {
                    System.out.println("Invalid option. Please select a valid option.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // discard the invalid input
            }
        }
        return option;
    }

}