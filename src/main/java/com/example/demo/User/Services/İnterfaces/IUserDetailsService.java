package com.example.demo.User.Services.İnterfaces;

import com.example.demo.User.Entities.UsersDetails;

import java.util.List;
import java.util.Optional;

public interface IUserDetailsService {

    UsersDetails saveDetails(UsersDetails newUsersDetails);

    void deletedById(Long id);

    Optional<UsersDetails> findById(Long id);

    UsersDetails changeImage(String imageLink, Long userDetailsId);

    boolean exsistById(Long id);

    List<UsersDetails> findAll();

}
