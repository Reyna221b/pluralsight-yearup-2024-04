package com.pluralsight.controllers;

import com.pluralsight.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController
{
    private List<Product> products = new ArrayList<>();

    public ProductsController()
    {
        // Initialize products list
        products.add(new Product(1, "Product 1", 1, 10.99));
        products.add(new Product(2, "Product 2", 1, 9.99));
        products.add(new Product(3, "Product 3", 2, 12.99));
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return products;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id) {
        for (Product product : products) {
            if (product.getProductId() == id) {
                return product;
            }
        }
        return null;
    }

}
