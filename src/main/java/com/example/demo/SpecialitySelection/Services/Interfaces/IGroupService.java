package com.example.demo.SpecialitySelection.Services.Interfaces;

import com.example.demo.SpecialitySelection.Entities.Group;

import java.util.List;

public interface IGroupService {

    Group save(Group newGroup);

    void deletedById(Long id);

    List<Group> findAllByUpGroupId(Long upGroupId);

    List<Group> findAllByDegree(Long degreeId);

    List<Group> findAll();
    Group findGroupByNameAndDegreeId(String name,Long degreeId);

    boolean existsGroupByNameAndDegree_Id(String name,Long degreeId);

//    List<DtoOutputGroup> getAllUpGroupsDto(Long degreeId);
//
//    List<DtoOutputGroup> getAllSubGroupsDto(Long upGroupId);

}
