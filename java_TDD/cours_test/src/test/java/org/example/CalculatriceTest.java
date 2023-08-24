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

    @Test
    public void testDivisionAvecBDiff0() {
        //A => Arrange
        Calculatrice calculatrice = new Calculatrice();

        //A => Act
        double result = calculatrice.division(10,2);

        //A => Assert
        Assertions.assertEquals(5, result);

    }


    @Test
    public void testDivisionAvecBEgale0() {
        //A => Arrange
        Calculatrice calculatrice = new Calculatrice();


        //Assert

        Assertions.assertThrowsExactly(RuntimeException.class, ()-> {
            //A => Act
            calculatrice.division(10,0);
        });
    }
}
