package com.example.demo.Services.impl;

import com.example.demo.Entities.UniProffession;
import com.example.demo.Repositories.IUniProfessionRepo;
import com.example.demo.Services.Interfaces.IUniProfessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class UniProfessionService implements IUniProfessionService {

    private final IUniProfessionRepo uniProfessionRepo;

    @Override
    public UniProffession save(UniProffession newUniProfession) {
        return uniProfessionRepo.save(newUniProfession);
    }

    @Override
    public void deletedById(Long id) {
        uniProfessionRepo.deleteById(id);
    }

    @Override
    public Optional<UniProffession> findById(Long id) {
        return uniProfessionRepo.findById(id);
    }

    @Override
    public List<UniProffession> findAllByUniCityId(Long uniId) {
        return uniProfessionRepo.findByUniCity_Id(uniId);
    }

    @Override
    public List<UniProffession> findAllByProfiId(Long profId) {
        return uniProfessionRepo.findByProfessionId(profId);
    }

//    @Override
//    public List<UniProffession> findByUniversityIdInAndProfessionIdIn
//            (List<Long> universityId, List<Long> professionId)
//    {
//        return repo.findByUniCity_UniversityIdAndProfessionId(universityId,professionId);
////        return null;
//    }


}
