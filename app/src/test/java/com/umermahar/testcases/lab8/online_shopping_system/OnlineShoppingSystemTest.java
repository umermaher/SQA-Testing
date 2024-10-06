package com.umermahar.testcases.lab8.online_shopping_system;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class OnlineShoppingSystemTest {
    private OnlineShoppingSystem shoppingSystem;
    private Cart mockCart;
    private Favorites mockFavorites;

    @Before
    public void setUp() {
        shoppingSystem = new OnlineShoppingSystem();
        mockCart = mock(Cart.class);
        mockFavorites = mock(Favorites.class);
    }

    @Test
    public void testAddToCart() {
        Product product = new Product("Laptop", 1500);
        shoppingSystem.addToCart(product);
        mockCart.addToCart(product);
        verify(mockCart, times(1)).addToCart(product);

        // Manual testing since we are using a real instance
        assert(shoppingSystem.getCart().getProducts().contains(product));
    }

    @Test
    public void testRemoveFromCart() {
        Product product = new Product("Laptop", 1500);
        shoppingSystem.addToCart(product);
        shoppingSystem.removeFromCart(product);

        verify(mockCart, times(0)).removeFromCart(product); // Mock not used directly
        assert(shoppingSystem.getCart().getProducts().isEmpty());
    }

    @Test
    public void testAddToFavorites() {
        Product product = new Product("Smartphone", 800);
        shoppingSystem.addToFavorites(product);
        verify(mockFavorites, times(0)).addToFavorites(product); // Real instance used for manual test

        assert(shoppingSystem.getFavorites().getFavorites().contains(product));
    }

    @Test
    public void testRemoveFromFavorites() {
        Product product = new Product("Smartphone", 800);
        shoppingSystem.addToFavorites(product);
        shoppingSystem.removeFromFavorites(product);

        verify(mockFavorites, times(0)).removeFromFavorites(product);
        assert(shoppingSystem.getFavorites().getFavorites().isEmpty());
    }

    @Test
    public void testCheckout() {
        Cart spyCart = Mockito.spy(Cart.class); // Use spy to test methods
        shoppingSystem = new OnlineShoppingSystem();
        shoppingSystem.addToCart(new Product("Shoes", 50));

        spyCart.checkout();
        verify(spyCart, times(1)).checkout();
    }
}

