package org.example;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Voiture {
    private int rentDueIn;
    private int condition;
    private String type;
}
