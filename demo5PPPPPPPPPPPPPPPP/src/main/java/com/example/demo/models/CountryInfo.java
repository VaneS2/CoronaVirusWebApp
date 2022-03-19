package com.example.demo.models;

import lombok.Data;

@Data
public class CountryInfo {
    String country;
    String countryImg;
    String cases;
    String totalCases;
    String deaths;
    String todayDeaths;
    String recovered;
    String todayRecovered;
    Integer active;
    Integer population;
    Integer tests;

    public CountryInfo(String country, String countryImg, String cases, String totalCases, String deaths, String todayDeaths, String recovered, String todayRecovered, Integer active, Integer population, Integer tests) {
        this.country = country;
        this.countryImg = countryImg;
        this.cases = cases;
        this.totalCases = totalCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.todayRecovered = todayRecovered;
        this.active = active;
        this.population = population;
        this.tests = tests;
    }

    public CountryInfo() {
    }
}
