package com.example.demo.Anouncement.Services.Impl;

import com.example.demo.Anouncement.Entities.CourseAnounce;
import com.example.demo.Anouncement.Repository.ICourseAnounceRepo;
import com.example.demo.Anouncement.Services.Interface.ICourseAnounceService;
import com.example.demo.Dtos.Announcment.InputDto.DtoInputCourseAnounce;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseAnounceService implements ICourseAnounceService {

private final ICourseAnounceRepo courseAnounceRepo;

@Override
public Optional<CourseAnounce> findById(Long id) {
	 return courseAnounceRepo.findById(id);
}

@Override
public CourseAnounce save(CourseAnounce courseAnounce) {
	 return courseAnounceRepo.save(courseAnounce);
}

@Override
public void deleteByid(Long id) {
	 courseAnounceRepo.deleteById(id);

}

@Override
public CourseAnounce update(DtoInputCourseAnounce courseAnounce) {
	 return null;
}


}
