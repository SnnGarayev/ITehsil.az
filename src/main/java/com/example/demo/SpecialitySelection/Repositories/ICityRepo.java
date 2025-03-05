package com.example.demo.SpecialitySelection.Repositories;

import com.example.demo.SpecialitySelection.Entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepo extends JpaRepository<City,Long> {

    boolean existsByName(String name);

    City save(City city);
    City findByName(String name);
}
