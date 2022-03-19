package com.example.demo.models;

import lombok.Data;

@Data
public class GlobalCases {
    String updated;
    String cases;
    String todayCases;
    String deaths;
    String todayDeaths;
    String recovered;
    String todayRecovered;
    String active;
    String critical;
    String casesPerOneMillion;
    String deathsPerOneMillion;
    String tests;

    public GlobalCases(String updated, String cases, String todayCases, String deaths, String todayDeaths, String recovered, String todayRecovered, String active, String critical, String casesPerOneMillion, String deathsPerOneMillion, String tests) {
        this.updated = updated;
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.todayRecovered = todayRecovered;
        this.active = active;
        this.critical = critical;
        this.casesPerOneMillion = casesPerOneMillion;
        this.deathsPerOneMillion = deathsPerOneMillion;
        this.tests = tests;
    }

    public GlobalCases() {
    }
}
