package com.example.demo.Services.impl;

import com.example.demo.Dtos.OutputDto.DtoOutputCity;
import com.example.demo.Entities.City;
import com.example.demo.Repositories.ICityRepo;
import com.example.demo.Services.Interfaces.ICityService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class CityService implements ICityService {

    private final ICityRepo cityRepo;

    @Override
    public City saveCity(City newCity) {
        if(newCity!=null)
        {
            if(!existsByName(newCity.getName()))
            {
                return cityRepo.save(newCity);
            }
            return findByName(newCity.getName());
        }
        return null;
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepo.findById(id);
    }

    @Override
    public void DeletedCityById(Long id) {
        cityRepo.deleteById(id);
    }

    @Override
    public boolean isExistingById(Long id) {
        return cityRepo.existsById(id);
    }

    @Override
    public List<City> findAll() {
        return cityRepo.findAll();
    }

    @Override
    public boolean existsByName(String name) {
        return cityRepo.existsByName(name);
    }

    @Override
    public City findByName(String name) {
        return cityRepo.findByName(name);
    }

    @Override
    public List<DtoOutputCity> findAllCitiesDto() {
        return cityRepo.getCitiesDto();
    }


}
