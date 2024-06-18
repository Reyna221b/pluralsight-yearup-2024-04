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
        Connection connection = null;

        try {
            // load the MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 1. open a connection to the database
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/northwind",
                    username,
                    password);

            switch (option) {
                case 1:
                    displayProducts(connection);
                    break;
                case 2:
                    displayCustomers(connection);
                    break;
                case 3:
                    displayCategories(connection, scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading MySQL driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
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
                if (option < 0 || option > 3) {
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

    public static void displayProducts(Connection connection) {
        String sql = """
        SELECT ProductID
            , ProductName
            , UnitPrice
            , UnitsInStock
        FROM products;
        """;
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.print("Product ");
            while (resultSet.next()) {
                int id = resultSet.getInt("ProductID");
                String name = resultSet.getString("ProductName");
                float unitPrice = resultSet.getFloat("UnitPrice");
                int unitStock = resultSet.getInt("UnitsInStock");

                System.out.printf(" ID: %3d\n Name: %-32s\n Price: %.2f\n Stock: %d\n", id, name, unitPrice, unitStock);
                System.out.println("-".repeat(37));
            }
        } catch (SQLException e) {
            System.out.println("Error displaying products: " + e.getMessage());
        }
    }

    public static void displayCustomers(Connection connection) {
        String sql = """
        SELECT CompanyName
            , ContactName
            , City
            , Country
            , Phone
        FROM customers
        ORDER BY Country;
        """;
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {

                String company = resultSet.getString("CompanyName");
                String contact = resultSet.getString("ContactName");
                String city = resultSet.getString("city");
                String country = resultSet.getString("Country");
                String phone = resultSet.getString("Phone");

                System.out.printf(" Company: %-10s\n Contact: %-32s\n City: %-20s\n Country: %-20s\n Phone: %-20s\n", company, contact,city, country, phone);
                System.out.println("-".repeat(52));
            }
        } catch (SQLException e) {
            System.out.println("Error displaying customers: " + e.getMessage());
        }
    }

    public static void displayCategories(Connection connection, Scanner scanner) {
        String sql = """
        SELECT CategoryID
            , CategoryName
            , Description
        FROM categories
        ORDER BY CategoryID;
        """;
        try ( PreparedStatement statement = connection.prepareStatement(sql);
              ResultSet resultSet = statement.executeQuery(sql))
        {

            System.out.print("Category ");
            while (resultSet.next()) {
                int id = resultSet.getInt("CategoryID");
                String name = resultSet.getString("CategoryName");
                String desc = resultSet.getString("Description");

                System.out.printf(" ID: %3d\n Name: %-32s\n Description: %-50s\n", id, name, desc);
                System.out.println("-".repeat(37));
            }

            System.out.print("Enter a Category ID to display products: ");
            int categoryID = scanner.nextInt();

            sql = """
            SELECT ProductID
                , ProductName
                , UnitPrice
                , UnitsInStock
            FROM products
            WHERE CategoryID = ?
            ORDER BY ProductID;
            """;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, categoryID);
            ResultSet result = preparedStatement.executeQuery();

            System.out.print("Product ");
            while (result.next())
            {
                int id = result.getInt("ProductID");
                String name = result.getString("ProductName");
                float unitPrice = result.getFloat("UnitPrice");
                int unitStock = result.getInt("UnitsInStock");

                System.out.printf(" ID: %3d\n Name: %-32s\n Price: %.2f\n Stock: %d\n", id, name, unitPrice, unitStock);
                System.out.println("-".repeat(37));
            }
        } catch (SQLException e) {
            System.out.println("Error displaying categories: " + e.getMessage());
        }
    }





}