package com.example.demo.Services.Interfaces;

import com.example.demo.Dtos.OutputDto.DtoOutputDegree;
import com.example.demo.Entities.Degree;

import java.util.List;
import java.util.Optional;

public interface IDegreeService {

    Degree save(Degree newDegree);

    void deleteById(Long id);

    List<Degree> findAll();

    Optional<Degree> findById(Long id);
    boolean existsDegreeByName(String name);

    Degree findByName(String name);

    List<DtoOutputDegree> getAllDegreeDto();
}
