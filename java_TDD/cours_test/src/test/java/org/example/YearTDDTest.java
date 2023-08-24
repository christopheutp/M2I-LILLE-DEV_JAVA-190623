package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class YearTDDTest {

    @Test
    void testLeapYearWhenYearIs2000() {
        YearTDD yearTDD = new YearTDD();
        boolean result = yearTDD.isLeap(2000);
        Assertions.assertTrue(result);
    }

    @Test
    void testLeapYearWhenYearIs2020() {
        YearTDD yearTDD = new YearTDD();
        boolean result = yearTDD.isLeap(2020);
        Assertions.assertTrue(result);
    }

    @Test
    void testLeapYearWhenYearIs1987() {
        YearTDD yearTDD = new YearTDD();
        boolean result = yearTDD.isLeap(1987);
        Assertions.assertFalse(result);
    }
}
