package org.example.demomock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JeuTest {

    private Jeu jeu;

    @Test
    public void testWin() {
        //Arrange
        jeu = new Jeu(new FakeDeWinImpl());

        //Act
        boolean result = jeu.jouer();

        //Assert
        Assertions.assertTrue(result);

    }

    @Test
    public void testLose() {
        //Arrange
        jeu = new Jeu(new FakeDeLoseImpl());

        //Act
        boolean result = jeu.jouer();

        //Assert
        Assertions.assertFalse(result);

    }

}
