package org.example;

public class Calculatrice {

    public double addition(double a, double b) {
        return a +b;
    }

    public double division(double a, double b) {
        if(b != 0)
            return a / b;
        throw new RuntimeException("Erreur division par 0");
    }
}
