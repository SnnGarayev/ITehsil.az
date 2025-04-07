package com.example.demo.Services.impl;

import com.example.demo.Dtos.OutputDto.DtoOutputSubGroup;
import com.example.demo.Dtos.OutputDto.DtoOutputUpGroup;
import com.example.demo.Entities.Group;
import com.example.demo.Repositories.IGroupRepo;
import com.example.demo.Services.Interfaces.IGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class GroupService implements IGroupService {


    private final IGroupRepo iGroupRepo;
    @Override
    public Group save(Group newGroup) {
    if(newGroup!=null)
    {
        if(!existsGroupByNameAndDegree_Id(newGroup.getName(),newGroup.getDegree().getId()))
        {
            return iGroupRepo.save(newGroup);
        }
        return findGroupByNameAndDegreeId(newGroup.getName(),newGroup.getDegree().getId());

    }
    return null;
}

    @Override
    public void deletedById(Long id)
    {
        iGroupRepo.deleteById(id);
    }
    @Override
    public List<Group> findAllByUpGroupId(Long upGroupId)
    {
        return iGroupRepo.findAllByUpGroupId(upGroupId);
    }

    @Override
    public List<Group> findAllByDegree(Long degreeId) {
        return iGroupRepo.findAllByDegree_Id(degreeId);
    }

    @Override
    public List<Group> findAll()
    {
        return iGroupRepo.findAll();
    }

@Override
public Group findGroupByNameAndDegreeId(String name, Long degreeId) {
    return iGroupRepo.findGroupByNameAndDegree_Id(name,degreeId);
}

@Override
public boolean existsGroupByNameAndDegree_Id(String name, Long degreeId) {
    return iGroupRepo.existsGroupByNameAndDegree_Id(name,degreeId);
}

@Override
public List<DtoOutputUpGroup> getAllUpGroupsDto(Long degreeId) {
    return iGroupRepo.getUpGroupsDto(degreeId);
}

@Override
public List<DtoOutputSubGroup> getAllSubGroupsDto(Long upGroupId) {
    return iGroupRepo.getSubGroupsDto(upGroupId);
}

//    @Override
//    public List<DtoOutputGroup> getAllUpGroupsDto(Long degreeId) {
//        return repo.getAllUpGroupsDto(degreeId);
//    }
//
//    @Override
//    public List<DtoOutputGroup> getAllSubGroupsDto(Long upGroupId) {
//        return repo.getAllSubGorups(upGroupId);
//    }

}
