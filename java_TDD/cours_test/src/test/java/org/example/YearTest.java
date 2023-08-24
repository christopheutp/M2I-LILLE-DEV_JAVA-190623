package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class YearTest {

    private Year year;

    @BeforeEach
    void setUp() {
        year = new Year();
    }

    @Test
    void testLeapShoulbBeTrueWhenYearIs2000() {

        boolean result = year.isLeap(2000);
        Assertions.assertTrue(result);
    }

    @Test
    void testLeapShoulbBeTrueWhenYearIs2020() {

        boolean result = year.isLeap(2020);
        Assertions.assertTrue(result);
    }

    @Test
    void testLeapShoulbBeTrueWhenYearIs8000() {

        boolean result = year.isLeap(8000);
        Assertions.assertTrue(result);
    }

    @Test
    void testLeapShoulbBeFalseWhenYearIs1987() {

        boolean result = year.isLeap(1987);
        Assertions.assertFalse(result);
    }
}
