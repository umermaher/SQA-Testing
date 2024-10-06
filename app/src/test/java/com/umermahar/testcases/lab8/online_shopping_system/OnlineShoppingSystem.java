package com.umermahar.testcases.lab8.online_shopping_system;

public class OnlineShoppingSystem {
    private Cart cart = new Cart();
    private Favorites favorites = new Favorites();

    public Cart getCart() {
        return cart;
    }

    public Favorites getFavorites() {
        return favorites;
    }

    public void addToCart(Product product) {
        cart.addToCart(product);
    }

    public void removeFromCart(Product product) {
        cart.removeFromCart(product);
    }

    public void addToFavorites(Product product) {
        favorites.addToFavorites(product);
    }

    public void removeFromFavorites(Product product) {
        favorites.removeFromFavorites(product);
    }

    public void checkout() {
        cart.checkout();
    }
}

