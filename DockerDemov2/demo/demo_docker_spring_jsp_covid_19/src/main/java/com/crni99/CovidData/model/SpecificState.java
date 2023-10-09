package com.crni99.CovidData.model;

public class SpecificState {

	private String state;
	private long updated;
	private long cases;
	private long todayCases;
	private long deaths;
	private long todayDeaths;
	private long recovered;
	private long todayRecovered;
	private long active;
	private float casesPerOneMillion;
	private float deathsPerOneMillion;
	private long tests;
	private float testsPerOneMillion;
	private long population;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getUpdated() {
		return updated;
	}
	public void setUpdated(long updated) {
		this.updated = updated;
	}
	public long getCases() {
		return cases;
	}
	public void setCases(long cases) {
		this.cases = cases;
	}
	public long getTodayCases() {
		return todayCases;
	}
	public void setTodayCases(long todayCases) {
		this.todayCases = todayCases;
	}
	public long getDeaths() {
		return deaths;
	}
	public void setDeaths(long deaths) {
		this.deaths = deaths;
	}
	public long getTodayDeaths() {
		return todayDeaths;
	}
	public void setTodayDeaths(long todayDeaths) {
		this.todayDeaths = todayDeaths;
	}
	public long getRecovered() {
		return recovered;
	}
	public void setRecovered(long recovered) {
		this.recovered = recovered;
	}
	public long getTodayRecovered() {
		return todayRecovered;
	}
	public void setTodayRecovered(long todayRecovered) {
		this.todayRecovered = todayRecovered;
	}
	public long getActive() {
		return active;
	}
	public void setActive(long active) {
		this.active = active;
	}
	public float getCasesPerOneMillion() {
		return casesPerOneMillion;
	}
	public void setCasesPerOneMillion(float casesPerOneMillion) {
		this.casesPerOneMillion = casesPerOneMillion;
	}
	public float getDeathsPerOneMillion() {
		return deathsPerOneMillion;
	}
	public void setDeathsPerOneMillion(float deathsPerOneMillion) {
		this.deathsPerOneMillion = deathsPerOneMillion;
	}
	public long getTests() {
		return tests;
	}
	public void setTests(long tests) {
		this.tests = tests;
	}
	public float getTestsPerOneMillion() {
		return testsPerOneMillion;
	}
	public void setTestsPerOneMillion(float testsPerOneMillion) {
		this.testsPerOneMillion = testsPerOneMillion;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	
}
