package org.example;

import org.example.exception.MaxQualityException;
import org.example.exception.NegativeQualityException;

public class Shop {
    public void update(Product product){
        int minusQuality = 0;
        if(product.getQuality() <= 0) {
            throw new NegativeQualityException();
        }
        if(product.getQuality() > 50) {
            throw new MaxQualityException();
        }
        if(product.getType() != null && product.getType().equals("laitier")) {
            if(product.getName() != null && product.getName().equals("brie vieilli")) {
               minusQuality = -1;
            }else {
                if(product.getSellIn() == 0) {
                    if(product.getQuality()>3)
                       minusQuality = 4;
                    else
                        minusQuality = product.getQuality();
                }
                else {
                    if(product.getQuality() > 1)
                        minusQuality = 2;
                    else
                        minusQuality = product.getQuality();
                }

            }
        }

        else {
            if(product.getSellIn() <= 0) {
                if(product.getQuality() == 1){
                    minusQuality = product.getQuality();
                }else {
                    minusQuality = 2;
                }
            }else {
               minusQuality = 1;
            }
        }
        product.setQuality(product.getQuality() - minusQuality);
        product.setSellIn(product.getSellIn()-1);
    }
}
