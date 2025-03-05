package com.example.demo.Anouncement.Repository;

import com.example.demo.Anouncement.Entities.CourseAnounce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICourseAnounceRepo extends JpaRepository<CourseAnounce, Integer>{

	 Optional<CourseAnounce> findById(Long id);

	 void deleteById(Long id);

	 CourseAnounce save(CourseAnounce newAnounce);



}
