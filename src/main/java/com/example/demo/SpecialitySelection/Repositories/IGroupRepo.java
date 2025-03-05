package com.example.demo.SpecialitySelection.Repositories;

import com.example.demo.SpecialitySelection.Entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGroupRepo extends JpaRepository<Group,Long> {


    List<Group> findAllByUpGroupId(Long upGroupId);

    List<Group> findAllByDegree_Id(Long degreeId);
//
//    @Query(value = "select new com.example.demo.SpecialitySelection.Dtos.DtoOutputGroup(g.id,g.name) " +
//            "from Group g"+" where g.subGroup = true")
//    List<DtoOutputGroup> getAllUpGroupsDto(Long dgreeId);

Group findGroupByNameAndDegree_Id(String name,Long degreeId);
boolean existsGroupByNameAndDegree_Id(String name,Long degreeId);

//    @Query(value = "select new com.example.demo.SpecialitySelection.Dtos.DtoOutputGroup(g.id,g.name) " +
//            "from Group g"+" where g.upGroup.id = :upGroupId")
//    List<DtoOutputGroup> getAllSubGorups(Long upGroupId);

}
