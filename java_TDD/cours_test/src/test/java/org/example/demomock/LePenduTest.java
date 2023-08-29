package org.example.demomock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LePenduTest {

    @Mock
    private FakeGenerateurMot fakeGenerateurMot;
    private LePendu lePendu;

    @BeforeEach
    void setUp() {
        //fakeGenerateurMot = new FakeGenerateurMot();
        lePendu = new LePendu();
        Mockito.when(fakeGenerateurMot.generer()).thenReturn("toto");
    }

    @Test
    void testGenererMasqueShouldBeCorrect() {

        //Arrange


        lePendu.genererMasque(fakeGenerateurMot);
        Assertions.assertEquals("****", lePendu.getMasque());
    }

    @Test
    void testTestCharShouldBeTrueWhenCharExists() {
        //Arrange
        lePendu.genererMasque(fakeGenerateurMot);
        //Act
        boolean result = lePendu.testChar('t');
        Assertions.assertTrue(result);
    }

    @Test
    void testTestCharShouldBeFalseWhenCharNotExists() {
        //Arrange
        lePendu.genererMasque(fakeGenerateurMot);
        //Act
        boolean result = lePendu.testChar('a');
        Assertions.assertFalse(result);
    }

    @Test
    void testTestCharShouldBeFalseWhenNbEssaiIs0() {
        //Arrange
        lePendu.setNbEssai(0);
        lePendu.genererMasque(fakeGenerateurMot);
        //Act
        boolean result = lePendu.testChar('t');
        Assertions.assertFalse(result);
    }

    @Test
    void testTestCharShouldUpdateMasqueWhenCharExists() {
        //Arrange
        lePendu.genererMasque(fakeGenerateurMot);
        //Act
        lePendu.testChar('t');
        Assertions.assertEquals("t*t*", lePendu.getMasque());
    }

    @Test
    void testTestCharShouldNotUpdateMasqueWhenCharNotExists() {
        //Arrange
        lePendu.genererMasque(fakeGenerateurMot);
        //Act
        lePendu.testChar('t');
        lePendu.testChar('a');
        Assertions.assertEquals("t*t*", lePendu.getMasque());
    }

    @Test
    void testTestCharShouldDecreaseNbEssaiWhenCharNotExists() {
        //Arrange
        int oldNbEssai = lePendu.getNbEssai();
        lePendu.genererMasque(fakeGenerateurMot);
        //Act
        lePendu.testChar('a');
        Assertions.assertEquals(oldNbEssai-1, lePendu.getNbEssai());
    }

    @Test
    void testTestCharShouldNotDecreaseNbEssaiWhenCharExists() {
        //Arrange
        int oldNbEssai = lePendu.getNbEssai();
        lePendu.genererMasque(fakeGenerateurMot);
        //Act
        lePendu.testChar('t');
        Assertions.assertEquals(oldNbEssai, lePendu.getNbEssai());
    }

    @Test
    void testTestWinShouldBeTrueWhenCorrectWord() {
        //Arrange
        lePendu.genererMasque(fakeGenerateurMot);

        //Act
        lePendu.testChar('t');
        lePendu.testChar('o');

        boolean result = lePendu.testWin();

        Assertions.assertTrue(result);
    }

    @Test
    void testTestWinShouldBeFalseWhenCorrectWord() {
        //Arrange
        lePendu.genererMasque(fakeGenerateurMot);
        //Act
        lePendu.testChar('a');

        boolean result = lePendu.testWin();

        Assertions.assertFalse(result);
    }
}
