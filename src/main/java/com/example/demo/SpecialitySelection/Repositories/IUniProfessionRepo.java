package com.example.demo.SpecialitySelection.Repositories;

import com.example.demo.SpecialitySelection.Entities.UniProffession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUniProfessionRepo extends JpaRepository<UniProffession,Long> {

    List<UniProffession> findByUniCity_Id(Long uniId);

    List<UniProffession> findByProfessionId(Long profId);

//    List<UniProffession> findByUniCity_UniversityIdAndProfessionId(List<Long> universityId, List<Long> professionId);
}
