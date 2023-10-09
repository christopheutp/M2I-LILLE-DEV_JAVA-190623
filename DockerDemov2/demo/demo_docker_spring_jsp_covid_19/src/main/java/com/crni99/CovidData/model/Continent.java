package com.crni99.CovidData.model;


import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Continent {

	private long updated;
	private long cases;
	private long todayCases;
	private long deaths;
	private long todayDeaths;
	private long recovered;
	private long todayRecovered;
	private long active;
	private long critical;
	private float casesPerOneMillion;
	private float deathsPerOneMillion;
	private long tests;
	private float testsPerOneMillion;
	private long population;
	private String continent;
	private float activePerOneMillion;
	private float recoveredPerOneMillion;
	private float criticalPerOneMillion;
	private List<ContinentInfo> continentInfo;
	private List<String> countries;
	
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
	public long getCritical() {
		return critical;
	}
	public void setCritical(long critical) {
		this.critical = critical;
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
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public float getActivePerOneMillion() {
		return activePerOneMillion;
	}
	public void setActivePerOneMillion(float activePerOneMillion) {
		this.activePerOneMillion = activePerOneMillion;
	}
	public float getRecoveredPerOneMillion() {
		return recoveredPerOneMillion;
	}
	public void setRecoveredPerOneMillion(float recoveredPerOneMillion) {
		this.recoveredPerOneMillion = recoveredPerOneMillion;
	}
	public float getCriticalPerOneMillion() {
		return criticalPerOneMillion;
	}
	public void setCriticalPerOneMillion(float criticalPerOneMillion) {
		this.criticalPerOneMillion = criticalPerOneMillion;
	}
	public List<ContinentInfo> getContinentInfo() {
		return continentInfo;
	}
	public void setContinentInfo(List<ContinentInfo> continentInfo) {
		this.continentInfo = continentInfo;
	}
	public List<String> getCountries() {
		return countries;
	}
	public void setCountries(List<String> countries) {
		this.countries = countries;
	}
	
	@Override
	public String toString() {
		return "Continent [updated=" + updated + ", cases=" + cases + ", todayCases=" + todayCases + ", deaths="
				+ deaths + ", todayDeaths=" + todayDeaths + ", recovered=" + recovered + ", todayRecovered="
				+ todayRecovered + ", active=" + active + ", critical=" + critical + ", casesPerOneMillion="
				+ casesPerOneMillion + ", deathsPerOneMillion=" + deathsPerOneMillion + ", tests=" + tests
				+ ", testsPerOneMillion=" + testsPerOneMillion + ", population=" + population + ", continent="
				+ continent + ", activePerOneMillion=" + activePerOneMillion + ", recoveredPerOneMillion="
				+ recoveredPerOneMillion + ", criticalPerOneMillion=" + criticalPerOneMillion + ", continentInfo="
				+ continentInfo + ", countries=" + countries + "]";
	}
	
}
