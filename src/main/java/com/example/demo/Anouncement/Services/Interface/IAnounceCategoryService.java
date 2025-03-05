package com.example.demo.Anouncement.Services.Interface;

import com.example.demo.Anouncement.Entities.AnounceCategory;
import com.example.demo.Anouncement.Enums.AnounceType;

import java.util.List;
import java.util.Optional;

public interface IAnounceCategoryService {

	 Optional<AnounceCategory> findById(Long id);
	 AnounceCategory save(AnounceCategory jobCategory);
	 void deleteById(Long id);

	 List<AnounceCategory> findAllCourseUpCategory();
	 List<AnounceCategory> findAllCourseDownCategory(Long upCategoryId);

	 List<AnounceCategory> findAllJobUpCategory();
	 List<AnounceCategory> findAllJobDownCategory(Long upCategoryId);



}
