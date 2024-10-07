package com.umermahar.testcases.lab8.grocery_shop_delivery_service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroceryShopDeliveryServiceTest {
    private GroceryShopDeliveryService groceryShopDeliveryService;
    private Product mockProduct1;
    private Product mockProduct2;

    @Before
    public void setUp() {
        groceryShopDeliveryService = new GroceryShopDeliveryService();
        mockProduct1 = mock(Product.class);
        mockProduct2 = mock(Product.class);
    }

    @Test
    public void testAddProduct() {
        groceryShopDeliveryService.addProduct(mockProduct1);

        assert(groceryShopDeliveryService.getProducts().contains(mockProduct1));
    }

    @Test
    public void testRemoveProduct() {
        groceryShopDeliveryService.addProduct(mockProduct1);
        groceryShopDeliveryService.removeProduct(mockProduct1);
        assert(!groceryShopDeliveryService.getProducts().contains(mockProduct1));
    }

    @Test
    public void testSortByName() {
        when(mockProduct1.getName()).thenReturn("Apple");
        when(mockProduct2.getName()).thenReturn("Banana");

        groceryShopDeliveryService.addProduct(mockProduct2);
        groceryShopDeliveryService.addProduct(mockProduct1);
        groceryShopDeliveryService.sort(Sort.NAME);

        List<Product> products = groceryShopDeliveryService.getProducts();

        assert(products.get(0).getName().equals("Apple")); // Apple should be first after sorting
        assert(products.get(1).getName().equals("Banana")); // Banana should be second
    }


    @Test
    public void testSortByPrice() {
        when(mockProduct1.getPrice()).thenReturn(5.0);
        when(mockProduct2.getPrice()).thenReturn(2.0);

        groceryShopDeliveryService.addProduct(mockProduct1);
        groceryShopDeliveryService.addProduct(mockProduct2);
        groceryShopDeliveryService.sort(Sort.PRICE);

        List<Product> products = groceryShopDeliveryService.getProducts();

        assert(products.get(0).getPrice() == 2.0); // Cheapest product should be first
        assert(products.get(1).getPrice() == 5.0); // Expensive product should be second
    }

    @Test
    public void testSortByName2() {
        List<Product> list = new ArrayList<>();

        for (int index = 0; index < 26; index++) {
            char c = (char) ('a' + index);
            list.add(new Product(String.valueOf(c), index + 1)); // Use index + 1 for price
        }
        Collections.shuffle(list);

        for (Product product : list) {
            groceryShopDeliveryService.addProduct(product);
        }

        groceryShopDeliveryService.sort(Sort.NAME);
        List<Product> productList = groceryShopDeliveryService.getProducts();

        for (int index = 0; index < productList.size() - 1; index++) {
            assert(
                    productList.get(index).getName().charAt(0) < productList.get(index + 1).getName().charAt(0)
            );
        }
    }

}
