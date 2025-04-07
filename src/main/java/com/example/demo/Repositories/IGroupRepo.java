package com.example.demo.Repositories;

import com.example.demo.Dtos.OutputDto.DtoOutputDegree;
import com.example.demo.Dtos.OutputDto.DtoOutputSubGroup;
import com.example.demo.Dtos.OutputDto.DtoOutputUpGroup;
import com.example.demo.Entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGroupRepo extends JpaRepository<Group,Long> {


    List<Group> findAllByUpGroupId(Long upGroupId);

    List<Group> findAllByDegree_Id(Long degreeId);

    Group findGroupByNameAndDegree_Id(String name,Long degreeId);
    boolean existsGroupByNameAndDegree_Id(String name,Long degreeId);
        @Query(value = "SELECT new com.example.demo.Dtos.OutputDto.DtoOutputUpGroup(g.id, g.name)" +
                " FROM Group g " +
                "WHERE g.subGroup = false AND g.degree.id = :degreeId")
    List<DtoOutputUpGroup> getUpGroupsDto(@Param("degreeId") Long degreeId);

    @Query(value = "SELECT new com.example.demo.Dtos.OutputDto.DtoOutputSubGroup(g.id,g.upGroup.id, g.name)" +
            " FROM Group g " +
            "WHERE g.subGroup = true AND g.upGroup.id = :upGroupId")
    List<DtoOutputSubGroup> getSubGroupsDto(@Param("upGroupId") Long upGroupId);



//    @Query(value = "select new com.example.demo.SpecialitySelection.Dtos.DtoOutputGroup(g.id,g.name) " +
//            "from Group g"+" where g.upGroup.id = :upGroupId")
//    List<DtoOutputGroup> getAllSubGorups(Long upGroupId);

//
//    @Query(value = "select new com.example.demo.SpecialitySelection.Dtos.DtoOutputGroup(g.id,g.name) " +
//            "from Group g"+" where g.subGroup = true")
//    List<DtoOutputGroup> getAllUpGroupsDto(Long dgreeId);

}
