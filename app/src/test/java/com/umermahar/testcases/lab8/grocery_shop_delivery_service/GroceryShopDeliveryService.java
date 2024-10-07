package com.umermahar.testcases.lab8.grocery_shop_delivery_service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GroceryShopDeliveryService {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void clear(Product product) {
        products.clear();
    }

    public void sort(Sort sort) {
        switch (sort) {
            case NAME:
                products.sort(Comparator.comparing(Product::getName));
                System.out.println("sort by NAME");
                break;
            case PRICE:
                products.sort(Comparator.comparing(Product::getPrice));
                System.out.println("sort by Price");
                break;
            default:
                System.out.println("No Sort");
        }
    }

    public List<Product> getProducts() {
        return products;
    }
}

