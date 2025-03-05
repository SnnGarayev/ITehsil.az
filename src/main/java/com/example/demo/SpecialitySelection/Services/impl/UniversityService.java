package com.example.demo.SpecialitySelection.Services.impl;
import com.example.demo.SpecialitySelection.Entities.University;
import com.example.demo.SpecialitySelection.Repositories.IUniversityRepo;
import com.example.demo.SpecialitySelection.Services.Interfaces.IUniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class UniversityService implements IUniversityService {
    private final IUniversityRepo iUniversityRepo;

@Override
    public University save(University newUniversity) {
        if(newUniversity!=null)
        {
            if(!existsByName(newUniversity.getName()))
            {
                return iUniversityRepo.save(newUniversity);
            }
            return findByName(newUniversity.getName());
        }
        return null;
    }

    @Override
    public University findById(Long id) {
        return iUniversityRepo.getReferenceById(id);
    }

    @Override
    public void deletedById(Long id) {
        iUniversityRepo.deleteById(id);
    }

    @Override
    public University findByName(String universityName) {
        return iUniversityRepo.findByName(universityName);
    }

    @Override
    public List<University> findAll() {
        return iUniversityRepo.findAll();
    }

    @Override
    public boolean existsByName(String name) {
        return iUniversityRepo.existsByName(name);
    }

//@Override
//public List<UniProffession> findByUniversityIdInAndProfessionIdIn(List<Long> universityId, List<Long> professionId) {
//    return List.of();
//}


}
