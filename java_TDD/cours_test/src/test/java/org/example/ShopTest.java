package org.example;


import org.example.exception.MaxQualityException;
import org.example.exception.NegativeQualityException;
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

    @Test
    void testUpdateShouldRaiseNegativeQualityExceptionWhenQualityIsNegative() {
        product = Product.builder().quality(-10).sellIn(5).build();
        Assertions.assertThrowsExactly(NegativeQualityException.class, () -> {
            shop.update(product);
        });
    }

    @Test
    void testUpdateShouldDecreaseQualityOnceWhenSellInIs0AndQualityIs1() {
        product = Product.builder().sellIn(0).quality(1).build();
        shop.update(product);
        Assertions.assertEquals(0, product.getQuality());
    }

    @Test
    void testUpdateShouldRaiseExceptionWhenQualityGT50() {
        product = Product.builder().sellIn(10).quality(51).build();
        Assertions.assertThrowsExactly(MaxQualityException.class,() -> {
            shop.update(product);
        });
    }

    @Test
    void testUpdateShouldIncreaseQualityWhenProductNameIsBrie() {
        product = Product.builder().type("laitier").name("brie vieilli")
                .sellIn(5).quality(10).build();
        shop.update(product);
        Assertions.assertEquals(11, product.getQuality());
    }

    @Test
    void testUpdateShouldDecreaseQualityTwiceWhenTypeIsLaitier() {
        product = Product.builder().sellIn(5).quality(10).type("laitier").build();
        shop.update(product);
        Assertions.assertEquals(8, product.getQuality());
    }

    @Test
    void testUpdateShouldDecreaseQualityOnceWhenTypeIsLaitierAndQualityIs1() {
        product = Product.builder().sellIn(5).type("laitier").quality(1).build();
        shop.update(product);
        Assertions.assertEquals(0, product.getQuality());
    }

    @Test
    void testUpdateShouldDecreaseQualityFourTimeWhenTypeIsLaitierAndSellInIs0() {
        product = Product.builder().sellIn(0).quality(10).type("laitier").build();
        shop.update(product);
        Assertions.assertEquals(6, product.getQuality());
    }

    @Test
    void testUpdateShouldDecreaseQualityThreeTimeWhenTypeIsLaitierAndSellInIs0AndQualityIs3() {
        product = Product.builder().sellIn(0).quality(3).type("laitier").build();
        shop.update(product);
        Assertions.assertEquals(0, product.getQuality());
    }
}
