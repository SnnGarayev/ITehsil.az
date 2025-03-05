package com.example.demo.SpecialitySelection.Repositories;

import com.example.demo.SpecialitySelection.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProfessionRepo extends JpaRepository<Profession,Long> {

    Profession findByProfessionName(String name);

    List<Profession> findAllByGroup_Id(Long id);

    boolean existsByProfessionName(String name);
}
