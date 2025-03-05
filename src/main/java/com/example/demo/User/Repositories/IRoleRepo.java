package com.example.demo.User.Repositories;

import com.example.demo.User.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepo extends JpaRepository<Role,Long> {
}
