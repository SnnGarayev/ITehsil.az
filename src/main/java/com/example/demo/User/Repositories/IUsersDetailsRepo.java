package com.example.demo.User.Repositories;

import com.example.demo.User.Entities.UsersDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsersDetailsRepo extends JpaRepository<UsersDetails,Long> {
}
