package com.example.demo.Services.Interfaces;

import com.example.demo.Dtos.OutputDto.DtoOutputProfession;
import com.example.demo.Entities.Profession;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IProfessionService {

    Profession save(Profession newProfession);

    void deletedById(Long id);

    Optional<Profession> findById(Long id);

    Profession findByName(String name);

    List<Profession> findAllByGroupId(Long groupId);

    List<Profession> findAll();

    boolean existsByProfessionName(String name);
List<DtoOutputProfession> getAllProfessionsDtoByGroupId(Long groupId);



}
