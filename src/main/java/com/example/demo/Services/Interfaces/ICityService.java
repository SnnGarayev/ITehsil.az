package com.example.demo.Services.Interfaces;

import com.example.demo.Dtos.OutputDto.DtoOutputCity;
import com.example.demo.Entities.City;

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

    List<DtoOutputCity> findAllCitiesDto();




}
