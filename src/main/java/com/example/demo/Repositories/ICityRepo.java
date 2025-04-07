package com.example.demo.Repositories;

import com.example.demo.Dtos.OutputDto.DtoOutputCity;
import com.example.demo.Entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICityRepo extends JpaRepository<City,Long> {

    boolean existsByName(String name);

    City save(City city);
    City findByName(String name);

    @Query("SELECT new com.example.demo.Dtos.OutputDto.DtoOutputCity(c.id,c.name)  " +
            "from City c ORDER BY c.name asc")
    List<DtoOutputCity> getCitiesDto();
}
