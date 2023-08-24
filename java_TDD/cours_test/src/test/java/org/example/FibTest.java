package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FibTest {
    private Fib fib;

    @Test
    void testGetFibSeriesShouldNotBeEmptyWhenRangeIs1() {
        //Arrange
        fib = new Fib(1);

        //Act
        List<Integer> fibSeries = fib.getFibSeries();

        //Assert
        //Assertions.assertTrue(fibSeries.size() > 0);
        Assertions.assertFalse(fibSeries.isEmpty());
    }

    @Test
    void testGetFibSeriesShouldBeListWith0WhenRangeIs1() {
        //Arrange
        fib = new Fib(1);

        //Act
        List<Integer> fibSeries = fib.getFibSeries();

        //Assert
        Assertions.assertEquals(Arrays.asList(0), fibSeries);
    }

    @Test
    void testGetFibSeriesShouldContains3WhenRangeIs6() {
        fib = new Fib(6);

        List<Integer> fibSeries = fib.getFibSeries();

        Assertions.assertTrue(fibSeries.contains(3));
    }

    @Test
    void testGetFibSeriesShouldBeListWith6ElementsWhenRangeIs6() {
        fib = new Fib(6);
        List<Integer> fibSeries = fib.getFibSeries();
        //Assertions.assertTrue(fibSeries.size() == 6);
        Assertions.assertEquals(6, fibSeries.size());

    }

    @Test
    void testGetFibSeriesShouldNotContains4WhenRangeIs6() {
        fib = new Fib(6);

        List<Integer> fibSeries = fib.getFibSeries();

        Assertions.assertFalse(fibSeries.contains(4));
    }

    @Test
    void testGetFibSeriesShouldContainsRangeOfValuesWhenRangeIs6() {
        fib = new Fib(6);

        List<Integer> fibSeries = fib.getFibSeries();

        Assertions.assertTrue(fibSeries.containsAll(Arrays.asList(1,1,0,2,3,5)));
    }

    @Test
    void testGetFibSeriesShouldContainsAllValuesSortedWhenRangeIs6() {
        fib = new Fib(6);

        List<Integer> fibSeries = fib.getFibSeries();

        Assertions.assertEquals(Arrays.asList(0,1,1,2,3,5), fibSeries);
    }
}
