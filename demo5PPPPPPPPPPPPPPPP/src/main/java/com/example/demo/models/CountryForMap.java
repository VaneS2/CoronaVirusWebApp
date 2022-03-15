package com.example.demo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class CountryForMap {

    @Id
    Long id;
    String COUNTRY;
    String ISO3;
    String WHO_REGION;
    String DATA_SOURCE;
    String DATE_UPDATED;
    Long TOTAL_VACCINATIONS;
    Long PERSONS_VACCINATED_1PLUS_DOSE;
    Long TOTAL_VACCINATIONS_PER100;
    Long PERSONS_VACCINATED_1PLUS_DOSE_PER100;
    Long PERSONS_FULLY_VACCINATED;
    Long PERSONS_FULLY_VACCINATED_PER100;
    String VACCINES_USED;
    String FIRST_VACCINE_DATE;
    Integer NUMBER_VACCINES_TYPES_USED;

    public CountryForMap() {
    }

    public CountryForMap(Long id, String COUNTRY, String ISO3, String WHO_REGION, String DATA_SOURCE, String DATE_UPDATED, Long TOTAL_VACCINATIONS, Long PERSONS_VACCINATED_1PLUS_DOSE, Long TOTAL_VACCINATIONS_PER100, Long PERSONS_VACCINATED_1PLUS_DOSE_PER100, Long PERSONS_FULLY_VACCINATED, Long PERSONS_FULLY_VACCINATED_PER100, String VACCINES_USED, String FIRST_VACCINE_DATE, Integer NUMBER_VACCINES_TYPES_USED) {
        this.id = id;
        this.COUNTRY = COUNTRY;
        this.ISO3 = ISO3;
        this.WHO_REGION = WHO_REGION;
        this.DATA_SOURCE = DATA_SOURCE;
        this.DATE_UPDATED = DATE_UPDATED;
        this.TOTAL_VACCINATIONS = TOTAL_VACCINATIONS;
        this.PERSONS_VACCINATED_1PLUS_DOSE = PERSONS_VACCINATED_1PLUS_DOSE;
        this.TOTAL_VACCINATIONS_PER100 = TOTAL_VACCINATIONS_PER100;
        this.PERSONS_VACCINATED_1PLUS_DOSE_PER100 = PERSONS_VACCINATED_1PLUS_DOSE_PER100;
        this.PERSONS_FULLY_VACCINATED = PERSONS_FULLY_VACCINATED;
        this.PERSONS_FULLY_VACCINATED_PER100 = PERSONS_FULLY_VACCINATED_PER100;
        this.VACCINES_USED = VACCINES_USED;
        this.FIRST_VACCINE_DATE = FIRST_VACCINE_DATE;
        this.NUMBER_VACCINES_TYPES_USED = NUMBER_VACCINES_TYPES_USED;
    }

    public Long getId() {
        return id;
    }

    public String getCOUNTRY() {
        return COUNTRY;
    }

    public String getISO3() {
        return ISO3;
    }

    public String getWHO_REGION() {
        return WHO_REGION;
    }

    public String getDATA_SOURCE() {
        return DATA_SOURCE;
    }

    public String getDATE_UPDATED() {
        return DATE_UPDATED;
    }

    public Long getTOTAL_VACCINATIONS() {
        return TOTAL_VACCINATIONS;
    }

    public Long getPERSONS_VACCINATED_1PLUS_DOSE() {
        return PERSONS_VACCINATED_1PLUS_DOSE;
    }

    public Long getTOTAL_VACCINATIONS_PER100() {
        return TOTAL_VACCINATIONS_PER100;
    }

    public Long getPERSONS_VACCINATED_1PLUS_DOSE_PER100() {
        return PERSONS_VACCINATED_1PLUS_DOSE_PER100;
    }

    public Long getPERSONS_FULLY_VACCINATED() {
        return PERSONS_FULLY_VACCINATED;
    }

    public Long getPERSONS_FULLY_VACCINATED_PER100() {
        return PERSONS_FULLY_VACCINATED_PER100;
    }

    public String getVACCINES_USED() {
        return VACCINES_USED;
    }

    public String getFIRST_VACCINE_DATE() {
        return FIRST_VACCINE_DATE;
    }

    public Integer getNUMBER_VACCINES_TYPES_USED() {
        return NUMBER_VACCINES_TYPES_USED;
    }
}
