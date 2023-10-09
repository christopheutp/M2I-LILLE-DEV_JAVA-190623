package com.crni99.CovidData.controller;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.crni99.CovidData.exception.NoDataException;
import com.crni99.CovidData.model.AllData;
import com.crni99.CovidData.model.Continent;
import com.crni99.CovidData.model.SpecificCountry;
import com.crni99.CovidData.model.SpecificState;
import com.crni99.CovidData.model.States;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MainController implements ErrorController {

	private static ObjectMapper mapper = new ObjectMapper();

	private static final String ALL = "https://disease.sh/v3/covid-19/all";
	private static final String STATES = "https://disease.sh/v3/covid-19/states";
	private static final String STATE = "https://disease.sh/v3/covid-19/states/";
	private static final String COUNTRIES = "https://disease.sh/v3/covid-19/countries";
	private static final String COUNTRY = "https://disease.sh/v3/covid-19/countries/";
	private static final String CONTINENT = "https://disease.sh/v3/covid-19/continents/";

	private static final String ALLDATA_PAGE = "all";
	private static final String CONTINENT_PAGE = "continent";
	private static final String COUNTRIES_PAGE = "countries";
	private static final String COUNTRY_PAGE = "country";
	private static final String STATES_PAGE = "states";
	private static final String STATE_PAGE = "state";
	private static final String ERROR_PAGE = "error";

	@GetMapping("/all")
	public String all(final Model model) {
		try {
			URL COUNTRIES_URL = new URL(ALL);
			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

			URLConnection urlc = COUNTRIES_URL.openConnection();
			InputStream inputFile = urlc.getInputStream();

			List<AllData> allDataList = mapper.readValue(inputFile, new TypeReference<List<AllData>>() {
			});
			if (allDataList.isEmpty()) {
				throw new NoDataException("World data does not exist.");
			}
			model.addAttribute("allData", allDataList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ALLDATA_PAGE;
	}

	@GetMapping("/states")
	public String states(final Model model) {
		try {
			URL STATES_URL = new URL(STATES);
			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			List<States> statesList = mapper.readValue(STATES_URL, new TypeReference<List<States>>() {
			});
			if (statesList.isEmpty()) {
				throw new NoDataException("States does not exists.");
			}
			model.addAttribute("states", statesList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return STATES_PAGE;
	}

	@GetMapping("/state/{state}")
	public String specificState(@PathVariable String state, Model model) {
		try {
			URL STATE_URL = new URL(STATE + state);
			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			List<SpecificState> stateList = mapper.readValue(STATE_URL, new TypeReference<List<SpecificState>>() {
			});
			if (stateList.isEmpty()) {
				throw new NoDataException("Data for " + state + " does not exist.");
			}
			model.addAttribute("state", stateList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return STATE_PAGE;
	}

	@GetMapping("/countries")
	public String countries(final Model model) {
		try {
			URL COUNTRIES_URL = new URL(COUNTRIES);
			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			List<SpecificCountry> countryList = mapper.readValue(COUNTRIES_URL,
					new TypeReference<List<SpecificCountry>>() {
					});
			if (countryList.isEmpty()) {
				throw new NoDataException("Countries does not exists.");
			}
			model.addAttribute("country", countryList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return COUNTRIES_PAGE;
	}

	@GetMapping("/country/{country}")
	public String specificCountry(@PathVariable String country, final Model model) {
		try {
			URL COUNTRY_URL = new URL(COUNTRY + country + "?strict=true");
			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			List<SpecificCountry> countryList = mapper.readValue(COUNTRY_URL,
					new TypeReference<List<SpecificCountry>>() {
					});
			if (countryList.isEmpty()) {
				throw new NoDataException("Data for " + country + " does not exist.");
			}
			model.addAttribute("country", countryList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return COUNTRY_PAGE;
	}

	@GetMapping("/continent/{continent}")
	public String specificContinent(@PathVariable String continent, final Model model) {
		try {
			URL CONTINENT_URL = new URL(CONTINENT + continent + "?strict=true");
			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			List<Continent> continentList = mapper.readValue(CONTINENT_URL, new TypeReference<List<Continent>>() {
			});
			if (continentList.isEmpty()) {
				throw new NoDataException("Data for " + continent + " does not exist.");
			}
			model.addAttribute("continent", continentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CONTINENT_PAGE;
	}

	@GetMapping("/error")
	public String handleError() {

		return ERROR_PAGE;
	}

}
