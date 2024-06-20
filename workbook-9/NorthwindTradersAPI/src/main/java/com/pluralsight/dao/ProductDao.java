package com.pluralsight.dao;

import com.pluralsight.models.Product;

import java.util.List;

public interface ProductDao
{
    List<Product> getAll();
    Product getById(int id);
}
