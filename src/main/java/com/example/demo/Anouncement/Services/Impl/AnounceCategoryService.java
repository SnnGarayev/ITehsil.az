package com.example.demo.Anouncement.Services.Impl;

import com.example.demo.Anouncement.Entities.AnounceCategory;
import com.example.demo.Anouncement.Enums.AnounceType;
import com.example.demo.Anouncement.Repository.IAnounceCategoryRepo;
import com.example.demo.Anouncement.Services.Interface.IAnounceCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnounceCategoryService implements IAnounceCategoryService {

private final  IAnounceCategoryRepo anounceCategoryRepo;


@Override
public Optional<AnounceCategory> findById(Long id) {
	 return anounceCategoryRepo.findById(id);
}

@Override
public AnounceCategory save(AnounceCategory jobCategory) {
	 return anounceCategoryRepo.save(jobCategory);
}

@Override
public void deleteById(Long id) {
	 anounceCategoryRepo.deleteById(id);
}

@Override
public List<AnounceCategory> findAllCourseUpCategory() {
	 return anounceCategoryRepo.findByAnounceTypeAndIsUpIsTrueOrderByCategoryName(AnounceType.CourseAnouncement);
}

@Override
public List<AnounceCategory> findAllCourseDownCategory(Long upCategoryId) {
	 return anounceCategoryRepo.findByUpCategoryIdOrderByCategoryName(upCategoryId);
}

@Override
public List<AnounceCategory> findAllJobUpCategory() {
	 return anounceCategoryRepo.findByAnounceTypeAndIsUpIsTrueOrderByCategoryName(AnounceType.JobAnouncement);
}

@Override
public List<AnounceCategory> findAllJobDownCategory(Long upCategoryId) {
	 return anounceCategoryRepo.findByUpCategoryIdOrderByCategoryName(upCategoryId);
}

}
