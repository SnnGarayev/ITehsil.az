package com.example.demo.Repositories;

import com.example.demo.Dtos.OutputDto.DtoOutputCity;
import com.example.demo.Dtos.OutputDto.DtoOutputDegree;
import com.example.demo.Entities.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDegreeRepo extends JpaRepository<Degree,Long> {

    boolean existsDegreeByName(String name);

    Degree findByName(String name);

    @Query(value = " select new com.example.demo.Dtos.OutputDto.DtoOutputDegree(c.id,c.name)" +
            " from Degree c " +
            "ORDER BY c.name asc")
    List<DtoOutputDegree> getDegreesDto();

}
