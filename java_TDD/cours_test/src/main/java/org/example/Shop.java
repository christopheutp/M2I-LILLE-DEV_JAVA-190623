package org.example;

public class Shop {
    public void update(Product product){
        if(product.getSellIn() <= 0) {
            product.setQuality(product.getQuality()-2);
        }else {
            product.setQuality(product.getQuality()-1);
        }
        product.setSellIn(product.getSellIn()-1);
    }
}
