package com.umermahar.testcases.lab8.online_shopping_system;

import java.util.ArrayList;
import java.util.List;

public class Favorites {
    private List<Product> favoriteProducts = new ArrayList<>();

    public void addToFavorites(Product product) {
        favoriteProducts.add(product);
        System.out.println(product.getName() + " added to favorites.");
    }

    public void removeFromFavorites(Product product) {
        favoriteProducts.remove(product);
        System.out.println(product.getName() + " removed from favorites.");
    }

    public List<Product> getFavorites() {
        return favoriteProducts;
    }
}

