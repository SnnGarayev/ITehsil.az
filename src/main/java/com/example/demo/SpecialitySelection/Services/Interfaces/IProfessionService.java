package com.example.demo.SpecialitySelection.Services.Interfaces;

import com.example.demo.SpecialitySelection.Entities.*;

import java.util.List;
import java.util.Optional;

public interface IProfessionService {

    Profession save(Profession newProfession);

    void deletedById(Long id);

    Optional<Profession> findById(Long id);

    Profession findByName(String name);

    List<Profession> findAllByGroupId(Long id);

    List<Profession> findAll();

    boolean existsByProfessionName(String name);




}
