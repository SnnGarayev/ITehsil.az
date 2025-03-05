package com.example.demo.SpecialitySelection.Services.impl;

import com.example.demo.SpecialitySelection.Entities.Degree;
import com.example.demo.SpecialitySelection.Repositories.IDegreeRepo;
import com.example.demo.SpecialitySelection.Services.Interfaces.IDegreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class DegreeService implements IDegreeService {

	 private final IDegreeRepo iDegreeRepo;

    @Override
    public Degree save(Degree newDegree) {
        if(newDegree.getName()!=null) {
            if (!existsDegreeByName(newDegree.getName())) {
                 return iDegreeRepo.saveAndFlush(newDegree);
            }
            return findByName(newDegree.getName());
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        iDegreeRepo.deleteById(id);
    }

    @Override
    public List<Degree> findAll() {
        return iDegreeRepo.findAll();
    }

    @Override
    public Optional<Degree> findById(Long id) {
        return iDegreeRepo.findById(id);
    }

    @Override
    public boolean existsDegreeByName(String name) {
        return iDegreeRepo.existsDegreeByName(name);
    }

    @Override
    public Degree findByName(String name) {
        return iDegreeRepo.findByName(name);
    }

}
