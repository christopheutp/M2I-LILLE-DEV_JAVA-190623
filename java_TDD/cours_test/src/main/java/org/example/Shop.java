package org.example;

import org.example.exception.MaxQualityException;
import org.example.exception.NegativeQualityException;

public class Shop {
    public void update(Product product){
        if(product.getQuality() <= 0) {
            throw new NegativeQualityException();
        }
        if(product.getQuality() > 50) {
            throw new MaxQualityException();
        }
        if(product.getType() != null && product.getType().equals("laitier")) {
            if(product.getName() != null && product.getName().equals("brie vieilli")) {
                product.setQuality(product.getQuality() + 1);
            }else {
                product.setQuality(product.getQuality() - 2);
            }
        }

        else {
            if(product.getSellIn() <= 0) {
                if(product.getQuality() == 1){
                    product.setQuality(0);
                }else {
                    product.setQuality(product.getQuality()-2);
                }
            }else {
                product.setQuality(product.getQuality()-1);
            }
        }
        product.setSellIn(product.getSellIn()-1);
    }
}
