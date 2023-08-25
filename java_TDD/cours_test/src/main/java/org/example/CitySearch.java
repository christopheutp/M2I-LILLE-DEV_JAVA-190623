package org.example;
import org.example.exception.CityNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CitySearch {
    private List<String> cities;

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public List<String> searchCities(String searchText) {

        if(searchText.equals("*")) {
            return cities;
        }
        if(searchText.length() < 2){
            throw new CityNotFoundException();
        }else {
            /*List<String> searchCities = new ArrayList<>();
            for(String city: cities) {
                if(city.toLowerCase().contains(searchText.toLowerCase())) {
                    searchCities.add(city);
                }
            }
            return searchCities;*/

            return cities.stream()
                    .filter(c->c.toLowerCase().contains(searchText.toLowerCase()))
                    .collect(Collectors.toList());
        }

    }
}
