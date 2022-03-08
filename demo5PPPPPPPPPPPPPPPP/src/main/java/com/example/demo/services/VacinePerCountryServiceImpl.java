package com.example.demo.services;

import com.example.demo.models.VaccinePerCountry;
import com.example.demo.repository.VacinePerCountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacinePerCountryServiceImpl implements VacinePerCountryService {
    private final VacinePerCountryRepository vacinePerCountryRepository;

    public VacinePerCountryServiceImpl(VacinePerCountryRepository vacinePerCountryRepository) {
        this.vacinePerCountryRepository = vacinePerCountryRepository;
    }

    @Override
    public VaccinePerCountry getbyCountry(String country) {
        return this.vacinePerCountryRepository.getByCountry(country);
    }

    @Override
    public List<VaccinePerCountry> getAll() {
        List<VaccinePerCountry> vaccinePerCountries=this.vacinePerCountryRepository.findAll();

       return vaccinePerCountries;
    }
}
