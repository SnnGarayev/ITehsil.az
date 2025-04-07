package com.example.demo.Repositories;

import com.example.demo.Entities.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUniversityRepo extends JpaRepository<University,Long> {

    University findByName(String universityName);
    boolean existsByName (String name);
    University save(University university);

//    @Query("SELECT u FROM University u JOIN u.city c WHERE :cityNames IS NULL OR c.name IN :cityNames AND :universityNames IS NULL OR u.name IN :universityNames")
//    List<University> findByCitiesAndUniversities(
//            @Param("cityNames") List<String> cityNames,
//            @Param("universityNames") List<String> universityNames);
//
}
