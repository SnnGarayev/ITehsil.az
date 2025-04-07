package com.example.demo.User.Services;

import com.example.demo.Dtos.OutputDto.DtoOutputCopCategory;
import com.example.demo.User.Entities.CoparationDetails;
import com.example.demo.User.Repositories.ICoparationDetailsRepo;
import com.example.demo.User.Services.İnterfaces.ICoparationDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoparationDetailsService implements ICoparationDetailsService {

    @Autowired
	 ICoparationDetailsRepo Repo;

    @Override
    public CoparationDetails saveDetails(CoparationDetails newCoparationDetails) {
        return Repo.save(newCoparationDetails);
    }

    @Override
    public void deletedById(Long id) {
        Repo.deleteById(id);
    }

    @Override
    public Optional<CoparationDetails> findById(Long id) {
        return Repo.findById(id);
    }

    @Override
    public List<CoparationDetails> findByType(String coparationType) {
        return Repo.findByType(coparationType);
    }

    @Override
    public CoparationDetails changeImage(String imageLink, Long copDetailsId) {
        if(Repo.existsById(copDetailsId))
        {
            CoparationDetails coparationDetails;
            coparationDetails = saveDetails(findById(copDetailsId).get());
            coparationDetails.setImage(imageLink);
            return coparationDetails;
        }
        return null;
    }

    @Override
    public boolean exsistById(Long id) {
        return Repo.existsById(id);
    }


    @Override
    public List<CoparationDetails> findAll() {
        return Repo.findAll();
    }

    @Override
    public List<DtoOutputCopCategory> getCategories() {
        return Repo.getCategory();
    }


//    @Override
//    public List<TestType> getTT()
//    {
//        return Repo.getTestType();
//    }


}
