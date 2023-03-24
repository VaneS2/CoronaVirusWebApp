package com.example.demo.services;

import com.example.demo.models.VaccinePerCountry;

import java.util.List;

public interface VacinePerCountryService {

    VaccinePerCountry getbyCountry(String country);
    List<VaccinePerCountry> getAll();

}
