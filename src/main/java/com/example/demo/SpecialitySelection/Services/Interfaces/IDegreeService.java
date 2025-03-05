package com.example.demo.SpecialitySelection.Services.Interfaces;

import com.example.demo.SpecialitySelection.Entities.Degree;

import java.util.List;
import java.util.Optional;

public interface IDegreeService {

    Degree save(Degree newDegree);

    void deleteById(Long id);

    List<Degree> findAll();

    Optional<Degree> findById(Long id);
    boolean existsDegreeByName(String name);

    Degree findByName(String name);


}
