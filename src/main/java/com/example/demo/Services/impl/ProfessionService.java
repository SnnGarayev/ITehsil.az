package com.example.demo.Services.impl;

import com.example.demo.Dtos.OutputDto.DtoOutputProfession;
import com.example.demo.Entities.Profession;
import com.example.demo.Repositories.IProfessionRepo;
import com.example.demo.Services.Interfaces.IProfessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessionService implements IProfessionService {

    private final IProfessionRepo iProfessionRepo;

    @Override
    public Profession save(Profession newProfession) {
    if(newProfession!=null)
    {
        if(!existsByProfessionName(newProfession.getName()))
        {
            return iProfessionRepo.save(newProfession);
        }
        return findByName(newProfession.getName());

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
        return iProfessionRepo.findByName(name);
    }

    @Override
    public List<Profession> findAllByGroupId(Long groupId) {
        return iProfessionRepo.findAllByGroup_Id(groupId);
    }

    @Override
    public List<Profession> findAll() {
        return iProfessionRepo.findAll();

    }

@Override
public boolean existsByProfessionName(String name) {
    return iProfessionRepo.existsByName(name);
}

@Override
public List<DtoOutputProfession> getAllProfessionsDtoByGroupId(Long groupId) {
    return iProfessionRepo.getAllProfessionsDtoByGroupId(groupId);
}
}
