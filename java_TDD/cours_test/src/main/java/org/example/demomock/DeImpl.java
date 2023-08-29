package org.example.demomock;

import java.util.Random;

public class DeImpl implements De {

    private Random random;
    public DeImpl() {
        random = new Random();
    }

    public int getValue() {
        return random.nextInt(1,7);
    }
}
