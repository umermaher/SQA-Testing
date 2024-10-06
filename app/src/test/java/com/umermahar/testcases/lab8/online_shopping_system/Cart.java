package com.umermahar.testcases.lab8.online_shopping_system;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products = new ArrayList<>();

    public void addToCart(Product product) {
        products.add(product);
        System.out.println(product.getName() + " added to cart.");
    }

    public void removeFromCart(Product product) {
        products.remove(product);
        System.out.println(product.getName() + " removed from cart.");
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateTotal() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public void checkout() {
        if (products.isEmpty()) {
            System.out.println("Cart is empty. Please add products before checking out.");
        } else {
            double total = calculateTotal();
            System.out.println("Checked out with total amount: $" + total);
        }
    }
}

