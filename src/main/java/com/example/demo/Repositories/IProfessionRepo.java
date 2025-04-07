package com.example.demo.Repositories;

import com.example.demo.Dtos.OutputDto.DtoOutputProfession;
import com.example.demo.Entities.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProfessionRepo extends JpaRepository<Profession,Long> {

    Profession findByName(String name);

    List<Profession> findAllByGroup_Id(Long id);

    boolean existsByName(String name);

    @Query("SELECT new com.example.demo.Dtos.OutputDto.DtoOutputProfession(p.id,p.name) " +
            "FROM Profession p WHERE p.group.id =:groupId")
    List<DtoOutputProfession> getAllProfessionsDtoByGroupId(@Param("groupId")Long groupId);

}
