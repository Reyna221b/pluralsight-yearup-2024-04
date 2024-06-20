package com.pluralsight.dao;


import com.pluralsight.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcCategoryDao implements CategoriesDao {
    private DataSource dataSource;

    @Autowired
    public JdbcCategoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM categories;";
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rows = statement.executeQuery(sql)) {
            while (rows.next()) {
                Category category = new Category();
                category.setCategoryID(rows.getInt("CategoryID"));
                category.setCategoryName(rows.getString("CategoryName"));
                categories.add(category);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return categories;
    }

    @Override
    public Category getById(int id) {
        Category category = null;
        String sql = "SELECT * FROM categories WHERE CategoryID = ?;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet rows = statement.executeQuery();
            if (rows.next()) {
                category = new Category();
                category.setCategoryID(rows.getInt("CategoryID"));
                category.setCategoryName(rows.getString("CategoryName"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return category;
    }
}
