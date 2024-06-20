package com.pluralsight.dao;

import com.pluralsight.models.Category;

import java.util.List;

public interface CategoriesDao
{
    List<Category> getAll();
    Category getById(int id);
}

