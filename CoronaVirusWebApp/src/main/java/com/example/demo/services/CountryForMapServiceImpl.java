package com.example.demo.services;

import com.example.demo.models.CountryForMap;
import com.example.demo.repository.CountryForMapRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryForMapServiceImpl implements CountryForMapService {

    private final CountryForMapRepository countryForMapRepository;

    public CountryForMapServiceImpl(CountryForMapRepository countryForMapRepository) {
        this.countryForMapRepository = countryForMapRepository;
    }

    @Override
    public List<CountryForMap> giveAll() {
        return this.countryForMapRepository.findAll();
    }
}
