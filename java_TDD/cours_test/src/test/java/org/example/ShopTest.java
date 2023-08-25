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
    void testUpdateShouldDecreaseQuality() {
        //Arrange
        product = Product.builder().quality(10).sellIn(10).build();

        //Act
        shop.update(product);

        //Assert
        Assertions.assertEquals(9, product.getQuality());

    }

    @Test
    void testUpdateShouldDecreaseSellIn() {
        //Arrange
        product = Product.builder().quality(10).sellIn(10).build();

        //Act
        shop.update(product);

        //Assert
        Assertions.assertEquals(9, product.getSellIn());

    }


    @Test
    void testUpdateShouldDecreaseQualityTwiceWhenSellInIs0() {
        product = Product.builder().sellIn(0).quality(10).build();
        shop.update(product);
        Assertions.assertEquals(8, product.getQuality());
    }
}
