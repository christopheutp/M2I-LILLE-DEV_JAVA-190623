package org.example;

import java.util.ArrayList;
import java.util.List;

public class Fib {

    private int range;

    public Fib(int r){
        range = r;
    }

    public List<Integer> getFibSeries() {
        List<Integer> result = new ArrayList<Integer>();
        int a = 0,b=1, c=0;
        if(range == 1) {
            result.add(0);
            return result;
        }
        result.add(0);
        result.add(1);
        for(int i=2; i < range; i++) {
            c = a + b;
            result.add(c);
            a = b;
            b = c;
        }
        return result;
    }

}