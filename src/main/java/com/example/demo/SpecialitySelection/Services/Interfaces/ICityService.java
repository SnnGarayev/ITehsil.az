package com.example.demo.SpecialitySelection.Services.Interfaces;

import com.example.demo.SpecialitySelection.Entities.City;

import java.util.List;
import java.util.Optional;

public interface ICityService {

    City saveCity (City newCity);

    Optional<City> findById(Long id);

    void DeletedCityById(Long id);

    boolean isExistingById (Long id);

    List<City> findAll();

    boolean existsByName (String name);

    City findByName(String name);




}
