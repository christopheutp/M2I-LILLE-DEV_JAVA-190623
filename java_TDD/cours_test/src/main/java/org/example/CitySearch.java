package org.example;
import org.example.exception.CityNotFoundException;

import java.util.List;

public class CitySearch {
    private List<String> cities;

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public void searchCities(String searchText) {
        if(searchText.length() < 2){
            throw new CityNotFoundException();
        }
    }
}
