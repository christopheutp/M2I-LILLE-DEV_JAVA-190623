package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopTest {

    private Shop shop;
    private Product product;

    @BeforeEach
    void setUp() {
        shop = new Shop();
    }

    @Test
    void testUpdateDecreaseQuality() {
        //Arrange
        product = Product.builder().quality(10).sellIn(10).build();

        //Act
        shop.update(product);

        //Assert
        Assertions.assertEquals(9, product.getQuality());

    }

    @Test
    void testUpdateDecreaseSellIn() {
        //Arrange
        product = Product.builder().quality(10).sellIn(10).build();

        //Act
        shop.update(product);

        //Assert
        Assertions.assertEquals(9, product.getSellIn());

    }

}
