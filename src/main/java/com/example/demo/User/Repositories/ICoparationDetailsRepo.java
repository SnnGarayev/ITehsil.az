package com.example.demo.User.Repositories;

import com.example.demo.Dtos.OutputDto.DtoOutputCopCategory;
import com.example.demo.User.Entities.CoparationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICoparationDetailsRepo extends JpaRepository<CoparationDetails,Long> {

    List<CoparationDetails> findByType(String coparationType);

    @Query(value = "select new com.example.demo.Dtos.User.OutputDto.DtoOutputCopCategory(c.type,count (c)) " +
            "from CoparationDetails c " +
            "GROUP BY c.type order by c.type")
    List<DtoOutputCopCategory> getCategory();
}
