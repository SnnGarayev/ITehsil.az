package com.example.demo.Services.Interfaces;

import com.example.demo.Dtos.OutputDto.DtoOutputSubGroup;
import com.example.demo.Dtos.OutputDto.DtoOutputUpGroup;
import com.example.demo.Entities.Group;

import java.util.List;

public interface IGroupService {

    Group save(Group newGroup);

    void deletedById(Long id);

    List<Group> findAllByUpGroupId(Long upGroupId);

    List<Group> findAllByDegree(Long degreeId);

    List<Group> findAll();
    Group findGroupByNameAndDegreeId(String name,Long degreeId);

    boolean existsGroupByNameAndDegree_Id(String name,Long degreeId);

    List<DtoOutputUpGroup> getAllUpGroupsDto(Long degreeId);

    List<DtoOutputSubGroup> getAllSubGroupsDto(Long upGroupId);

}
