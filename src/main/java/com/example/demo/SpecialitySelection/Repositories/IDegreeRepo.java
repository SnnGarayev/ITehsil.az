package com.example.demo.SpecialitySelection.Repositories;

import com.example.demo.SpecialitySelection.Entities.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDegreeRepo extends JpaRepository<Degree,Long> {

    boolean existsDegreeByName(String name);

    Degree findByName(String name);

}
