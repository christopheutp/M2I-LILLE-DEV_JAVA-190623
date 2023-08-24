package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatriceTest {

    //Test de la Méthode addition
    @Test
    public void testAddition() {
        //A => Arrange
        Calculatrice  calculatrice = new Calculatrice();

        // A => Act
        double result = calculatrice.addition(10,20);

        //A => Assert
        Assertions.assertEquals(30, result);
    }
}
