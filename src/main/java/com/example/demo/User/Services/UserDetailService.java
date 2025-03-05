package com.example.demo.User.Services;

import com.example.demo.User.Entities.UsersDetails;
import com.example.demo.User.Repositories.IUsersDetailsRepo;
import com.example.demo.User.Services.İnterfaces.IUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailService implements IUserDetailsService {

    @Autowired
	 IUsersDetailsRepo repo;

    @Override
    public UsersDetails saveDetails(UsersDetails newUserDetails) {
        return repo.save(newUserDetails);
    }

    @Override
    public void deletedById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<UsersDetails> findById(Long id) {
        return findById(id);
    }


    @Override
    public UsersDetails changeImage(String imageLink, Long userDetailsId) {
        UsersDetails usersDetails;
        usersDetails = repo.findById((userDetailsId)).get();
        usersDetails.setImage(imageLink);
        return repo.save(usersDetails);
    }

    @Override
    public boolean exsistById(Long id) {
        return repo.existsById(id);
    }

    @Override
    public List<UsersDetails> findAll() {
        return repo.findAll();
    }
}
