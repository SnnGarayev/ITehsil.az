package com.example.demo.Services.Interfaces;
import com.example.demo.Entities.University;
import java.util.List;

public interface IUniversityService {

    University save(University newUniversity);

    University findById(Long id);

    void deletedById(Long id);

    University findByName(String universityName);

    List<University> findAll();

    boolean existsByName (String name);
//List<UniProffession> findByUniversityIdInAndProfessionIdIn
//        (List<Long> universityId, List<Long> professionId);

}
