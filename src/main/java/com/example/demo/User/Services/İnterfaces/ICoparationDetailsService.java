package com.example.demo.User.Services.İnterfaces;

import com.example.demo.Dtos.SSelection.OutputDto.DtoOutputCopCategory;
import com.example.demo.User.Entities.CoparationDetails;

import java.util.List;
import java.util.Optional;

public interface ICoparationDetailsService {

    CoparationDetails saveDetails(CoparationDetails newCoparationDetails);

    void deletedById(Long id);

    Optional<CoparationDetails> findById(Long id);

    List<CoparationDetails> findByType(String coparationType);

    CoparationDetails changeImage(String imageLink, Long copDetailsId);

    boolean exsistById(Long id);

    List<CoparationDetails> findAll();

    public List<DtoOutputCopCategory> getCategories();

}
