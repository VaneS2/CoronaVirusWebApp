package com.example.demo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class VaccinePerCountry {

    @Id
    Long id;
    String REPORT_COUNTRY;
    String dayUpdated;
    String firstVaccineDate;
    double TOTAL_VACCINATIONS;
    double PERSONS_FULLY_VACCINATED;

    public VaccinePerCountry() {
    }

    public VaccinePerCountry(Long id, String REPORT_COUNTRY, String dayUpdated, String firstVaccineDate, int TOTAL_VACCINATIONS, int PERSONS_FULLY_VACCINATED) {
        this.id = id;
        this.REPORT_COUNTRY = REPORT_COUNTRY;
        this.dayUpdated = dayUpdated;
        this.firstVaccineDate = firstVaccineDate;
        this.TOTAL_VACCINATIONS = TOTAL_VACCINATIONS;
        this.PERSONS_FULLY_VACCINATED = PERSONS_FULLY_VACCINATED;
    }
}
