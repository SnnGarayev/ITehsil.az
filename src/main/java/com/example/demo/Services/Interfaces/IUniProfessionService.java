package com.example.demo.Services.Interfaces;

import com.example.demo.Entities.UniProffession;

import java.util.List;
import java.util.Optional;

public interface IUniProfessionService {

    UniProffession save (UniProffession newUniProfession);

    void deletedById(Long id);

    Optional<UniProffession> findById(Long id);

    List<UniProffession> findAllByUniCityId(Long uniId);

    List<UniProffession> findAllByProfiId(Long profId);

//List<UniProffession> findByUniversityIdInAndProfessionIdIn
//        (List<Long> universityId, List<Long> professionId);

//    List<UniProffession> findByUniversityIdInAndProfessionIdIn(List<Long> universityId, List<Long> professionId);

}
