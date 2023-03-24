package com.example.demo.repository;


import com.example.demo.models.VaccinePerCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VacinePerCountryRepository extends JpaRepository<VaccinePerCountry,Long> {

    @Query("select u from VaccinePerCountry u where u.REPORT_COUNTRY  =?1  ")
    VaccinePerCountry getByCountry (String country);
}
