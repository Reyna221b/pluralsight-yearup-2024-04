package com.pluralsight.controllers;

import com.pluralsight.dao.CategoriesDao;
import com.pluralsight.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class CategoriesController
{
    private final CategoriesDao categoryDao;

    @Autowired
    public CategoriesController(CategoriesDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryDao.getAll();
    }

    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable int id) {
        return categoryDao.getById(id);
    }
}
