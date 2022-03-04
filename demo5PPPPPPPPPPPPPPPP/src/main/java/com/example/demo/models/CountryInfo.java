package com.example.demo.models;

import lombok.Data;

@Data
public class CountryInfo {
 public    String country;
    public  String countryImg;
    public  Integer cases;
    public  Integer totalCases;
    public  Integer deaths;
    public  Integer todayDeaths;
    public   Integer recovered;
    public   Integer todayRecovered;
    public  Integer active;
    public  Integer population;
    public  Integer tests;

    public CountryInfo(String country, String countryImg, Integer cases, Integer totalCases, Integer deaths, Integer todayDeaths, Integer recovered, Integer todayRecovered, Integer active, Integer population, Integer tests) {
        this.country = country;
        this.cases = cases;
        this.totalCases = totalCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.todayRecovered = todayRecovered;
        this.active = active;
        this.population = population;
        this.tests = tests;
        this.countryImg=countryImg;
    }

    public CountryInfo() {
    }
}
