package com.pluralsight.dao;


import com.pluralsight.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcProductDao implements ProductDao {
    private DataSource dataSource;

    @Autowired
    public JdbcProductDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products;";
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rows = statement.executeQuery(sql)) {
            while (rows.next()) {
                Product product = new Product();
                product.setProductId(rows.getInt("ProductID"));
                product.setProductName(rows.getString("ProductName"));
                product.setCategoryId(rows.getInt("CategoryID"));
                product.setUnitPrice(rows.getDouble("unitPrice"));
                products.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return products;
    }

    @Override
    public Product getById(int id) {
        Product product = null;
        String sql = "SELECT * FROM products WHERE ProductID = ?;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet rows = statement.executeQuery();
            if (rows.next()) {
                product = new Product();
                product.setProductId(rows.getInt("ProductID"));
                product.setProductName(rows.getString("ProductName"));
                product.setCategoryId(rows.getInt("CategoryID"));
                product.setUnitPrice(rows.getDouble("unitPrice"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return product;
    }
}
