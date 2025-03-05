package com.example.demo.Anouncement.Services.Interface;

import com.example.demo.Anouncement.Entities.CourseAnounce;
import com.example.demo.Dtos.Announcment.InputDto.DtoInputCourseAnounce;

import java.util.Optional;

public interface ICourseAnounceService {

	 Optional<CourseAnounce> findById(Long id);
	 CourseAnounce save(CourseAnounce courseAnounce);
	 void deleteByid(Long id);
	 CourseAnounce update(DtoInputCourseAnounce courseAnounce);

}
