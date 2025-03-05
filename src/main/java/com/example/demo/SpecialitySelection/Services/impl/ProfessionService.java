package com.example.demo.SpecialitySelection.Services.impl;

import com.example.demo.SpecialitySelection.Entities.*;
import com.example.demo.SpecialitySelection.Repositories.IProfessionRepo;
import com.example.demo.SpecialitySelection.Services.Interfaces.IProfessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class ProfessionService implements IProfessionService {

    private final IProfessionRepo iProfessionRepo;

    @Override
    public Profession save(Profession newProfession) {
    if(newProfession!=null)
    {
        if(!existsByProfessionName(newProfession.getProfessionName()))
        {
            return iProfessionRepo.save(newProfession);
        }
        return findByName(newProfession.getProfessionName());

    }
    return null;
}
    @Override
    public void deletedById(Long id) {
        iProfessionRepo.deleteById(id);
    }

    @Override
    public Optional<Profession> findById(Long id) {
        return iProfessionRepo.findById(id);
    }

    @Override
    public Profession findByName(String name) {
        return iProfessionRepo.findByProfessionName(name);
    }

    @Override
    public List<Profession> findAllByGroupId(Long id) {
        return iProfessionRepo.findAllByGroup_Id(id);
    }

    @Override
    public List<Profession> findAll() {
        return iProfessionRepo.findAll();

    }

@Override
public boolean existsByProfessionName(String name) {
    return iProfessionRepo.existsByProfessionName(name);
}
}
