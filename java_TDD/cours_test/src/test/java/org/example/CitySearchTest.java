package org.example;

import org.example.exception.CityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CitySearchTest {

    private CitySearch citySearch;

    @BeforeEach
    void setup() {
        citySearch = new CitySearch();
    }

    @Test
    void testSearchCitiesShouldRaiseNotFoundExceptionWhenSearhTextIsLt2char() {
         //Arrange => avec setup
        citySearch.setCities(Arrays.asList("Paris, Valence"));
        //Act And Assert When Exception
        Assertions.assertThrowsExactly(CityNotFoundException.class, () -> {
            citySearch.searchCities("t");
        });
    }

}
