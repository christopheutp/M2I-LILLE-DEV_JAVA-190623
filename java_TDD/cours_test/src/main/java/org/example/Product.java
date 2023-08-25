package org.example;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private int sellIn;
    private int quality;
    private String name;
    private String type;
}
