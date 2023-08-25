package org.example;

public class Shop {
    public void update(Product product){
        product.setQuality(product.getQuality()-1);
        product.setSellIn(product.getSellIn()-1);
    }
}
