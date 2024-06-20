package com.pluralsight.controllers;

import com.pluralsight.models.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class CategoriesController
{
    private List<Category> categories = new ArrayList<>();

    public CategoriesController() {
        // Initialize categories list
        categories.add(new Category(1, "Category 1"));
        categories.add(new Category(2, "Category 2"));
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categories;
    }

    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable int id) {
        for (Category category : categories) {
            if (category.getCategoryID() == id) {
                return category;
            }
        }
        return null; // Return null if no category is found with the given id
    }
}
