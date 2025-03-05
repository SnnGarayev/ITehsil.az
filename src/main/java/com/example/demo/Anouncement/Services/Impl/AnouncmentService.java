package com.example.demo.Anouncement.Services.Impl;

import com.example.demo.Anouncement.Entities.Anounce;
import com.example.demo.Anouncement.Entities.CourseAnounce;
import com.example.demo.Anouncement.Entities.InternshipAnounce;
import com.example.demo.Anouncement.Entities.JobAnounce;
import com.example.demo.Anouncement.Enums.AnounceType;
import com.example.demo.Anouncement.Services.Interface.*;
import com.example.demo.Dtos.Announcment.InputDto.DtoInputAnounceMergeSubAnounce;
import com.example.demo.Dtos.Announcment.InputDto.DtoInputCourseAnounce;
import com.example.demo.Dtos.Announcment.InputDto.DtoInputInternshipAnounce;
import com.example.demo.Dtos.Announcment.InputDto.DtoInputJobAnounce;
import com.example.demo.Dtos.Announcment.OutputDto.DtoOutputAnounce;
import com.example.demo.Dtos.Announcment.OutputDto.DtoOutputAnounceMergeSubAnounce;
import com.example.demo.Dtos.IConvertDtoService;
import com.example.demo.MergeInterfaces.IAnouncesSubClasses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnouncmentService implements IAnouncmentService {

	 private final IAnounceService anounceService;
	 private final IJobAnounceService jobAnounceService;
	 private final ICourseAnounceService courseAnounceService;
	 private final IAnounceCategoryService anounceCategoryService;
	 private final IConvertDtoService convertDtoService;
	 private final IInternshipAnounceService internshipAnounceService;

// Servislerin updatesini d

	 @Override
	 public Optional<DtoOutputAnounce> findByIdAnounce(Long anounceId) {


				if(anounceId != null|| anounceService.existingAnounceById(anounceId)) {
					 return Optional.of(convertDtoService.convertOutputAnounce(anounceService.findByIdAnounce(anounceId).get()));
				}
		  return Optional.empty();
	 }
	 @Override
	 public Optional<DtoOutputAnounceMergeSubAnounce> findByIdMergingAnounce(Long anounceId) {

		  IAnouncesSubClasses subAnounces = null;
		  if(anounceId != null|| anounceService.existingAnounceById(anounceId)) {
				switch (anounceService.getType(anounceId))
				{
					 case JobAnouncement -> subAnounces= jobAnounceService.findById(anounceService.getSubAnounceId(anounceId)).get();
					 case CourseAnouncement ->subAnounces= courseAnounceService.findById(anounceService.getSubAnounceId(anounceId)).get();
					 case InternshipAnouncement ->subAnounces= internshipAnounceService.findById(anounceService.getSubAnounceId(anounceId)).get();
				}

				return Optional.ofNullable(convertDtoService.convertOutputAnounceMergeSubAnounce(anounceService.findByIdAnounce(anounceId).get(), subAnounces));
		  }
		  return Optional.empty();
	 }
	 @Override
	 public DtoOutputAnounceMergeSubAnounce saveAnounce(DtoInputAnounceMergeSubAnounce newAnounce) {
	 DtoOutputAnounceMergeSubAnounce mergeSubAnounce = new DtoOutputAnounceMergeSubAnounce();
	 if (newAnounce != null && newAnounce.getSubAnounce() != null) {
		  if (DtoInputJobAnounce.class.isAssignableFrom(newAnounce.getSubAnounce().getClass())) {
				JobAnounce jobAnounce;
				Anounce anounce;
				jobAnounce = jobAnounceService.save(convertDtoService.convertEntityJobAnounce((DtoInputJobAnounce) newAnounce.getSubAnounce()));
				anounce = convertDtoService.convertEntityAnounce(newAnounce);
				anounce.setSubAnounceId(jobAnounce.getId());
				anounce.setSharingDate(LocalDateTime.now());
				anounce.setAnounceType(AnounceType.JobAnouncement);
				anounce = anounceService.saveAnounce(anounce);
				editingOrSaving(anounce.getId());
				return convertDtoService.convertOutputAnounceMergeSubAnounce(anounce, jobAnounce);
		  }
		  else if (DtoInputCourseAnounce.class.isAssignableFrom(newAnounce.getSubAnounce().getClass())) {
				CourseAnounce courseAnounce;
				Anounce anounce;
				courseAnounce = courseAnounceService.save(convertDtoService.convertEntityCourseAnounce((DtoInputCourseAnounce) newAnounce.getSubAnounce()));
				anounce = convertDtoService.convertEntityAnounce(newAnounce);
				anounce.setSubAnounceId(courseAnounce.getId());
				anounce.setSharingDate(LocalDateTime.now());
				anounce.setAnounceType(AnounceType.CourseAnouncement);
				anounce = anounceService.saveAnounce(anounce);
				editingOrSaving(anounce.getId());
				return convertDtoService.convertOutputAnounceMergeSubAnounce(anounce, courseAnounce);
		  }
		  else {
				InternshipAnounce internshipAnounce;
				Anounce anounce;
				internshipAnounce = internshipAnounceService.save(convertDtoService.convertEntityInternshipAnounce((DtoInputInternshipAnounce) newAnounce.getSubAnounce()));
				anounce = convertDtoService.convertEntityAnounce(newAnounce);
				anounce.setSubAnounceId(internshipAnounce.getId());
				anounce.setSharingDate(LocalDateTime.now());
				anounce.setAnounceType(AnounceType.InternshipAnouncement);
				anounce = anounceService.saveAnounce(anounce);
				editingOrSaving(anounce.getId());
				return convertDtoService.convertOutputAnounceMergeSubAnounce(anounce, internshipAnounce);
		  }

	 }
	 return null;
}
	 @Override
	 public void deletedAnounceById(Long anounceId) {

		  switch (anounceService.getType(anounceId))
		  {
				case JobAnouncement -> jobAnounceService.deleteByid(anounceService.getSubAnounceId(anounceId));
				case CourseAnouncement -> courseAnounceService.deleteByid(anounceService.getSubAnounceId(anounceId));
				case InternshipAnouncement -> internshipAnounceService.deleteByid(anounceService.getSubAnounceId(anounceId));
		  }
				anounceService.deletedAnounceById(anounceId);
	 }
	 @Override
	 public boolean existingByuserIdAndAnounceId(Long anounceId, Long userId) {
		  return anounceService.existingByuserIdAndAnounceId(anounceId, userId);
	 }
	 @Override
	 public void editingOrSaving(Long anounceId) {

		  //bunun ucun AdminPanel Entitiy yarat


	 }
	 @Override
	 public DtoOutputAnounceMergeSubAnounce updateAnounce(DtoInputAnounceMergeSubAnounce newAnounce, Long userId) {

		  if (newAnounce != null && newAnounce.getSubAnounce() != null && anounceService.existingByuserIdAndAnounceId(userId, newAnounce.getId())) {
				if (DtoInputJobAnounce.class.isAssignableFrom(newAnounce.getSubAnounce().getClass())) {
					 JobAnounce jobAnounce = jobAnounceService.update((DtoInputJobAnounce) newAnounce.getSubAnounce());
					 Anounce anounce = anounceService.updateAnounce(newAnounce);
					 editingOrSaving(anounce.getId());
					 return convertDtoService.convertOutputAnounceMergeSubAnounce(anounce, jobAnounce);
				}
				else if (DtoInputCourseAnounce.class.isAssignableFrom(newAnounce.getSubAnounce().getClass())) {

					 CourseAnounce courseAnounce = courseAnounceService.update((DtoInputCourseAnounce) newAnounce.getSubAnounce());
					 Anounce anounce = anounceService.updateAnounce(newAnounce);
					 editingOrSaving(anounce.getId());
					 return convertDtoService.convertOutputAnounceMergeSubAnounce(anounce, courseAnounce);
				}
				else {
					 InternshipAnounce internshipAnounce = internshipAnounceService.update((DtoInputInternshipAnounce) newAnounce.getSubAnounce());
					 Anounce anounce = anounceService.updateAnounce(newAnounce);
					 editingOrSaving(anounce.getId());
					 return convertDtoService.convertOutputAnounceMergeSubAnounce(anounce, internshipAnounce);
				}

		  }

		  return null;
	 }
	 
	 @Override
	 public void automaticDeactivated() {
		anounceService.automaticDeactivated(Long.valueOf(15));
	 }

	 @Override
	 public void changeByIdStatusActive(Long anounceId) {
			anounceService.changeByIdStatusActive(anounceId);
	 }
	 @Override
	 public void changeByIdStatusExpaired(Long anounceId) {
			anounceService.changeByIdStatusExpaired(anounceId);
	 }
	 @Override
	 public void changeByIdStatusVerifiying(Long anounceId) {
			anounceService.changeByIdStatusVerifiying(anounceId);
	 }
	 @Override
	 public void changeByIdStatusIqnoring(Long anounceId) {
			anounceService.changeByIdStatusIqnoring(anounceId);
	 }

	 @Override
	 public List<DtoOutputAnounce> findAllInternshipsStatusActive(Pageable pageable, int page, int size) {
		  Page<Anounce> anouncePage = anounceService.findAllInternshipsStatusActive(PageRequest.of(page,size));
		  List<DtoOutputAnounce> anounceDTO = convertDtoService.convertOutputAnounce(anouncePage.getContent());
//		   Pageable
//		  anouncePage
		  return convertDtoService.convertOutputAnounce(anounceService.findAllInternshipsStatusActive(PageRequest.of(page,size)).getContent());

	 }
	 @Override
	 public List<DtoOutputAnounce> findAllInternshipsStatusVerifiyng(Pageable pageable) {
		  return convertDtoService.convertOutputAnounce(anounceService.findAllInternshipsStatusVerifiyng(pageable).getContent());
	 }
	 @Override
	 public List<DtoOutputAnounce> findAllInternshipsStatusExpired(Pageable pageable) {
		  return convertDtoService.convertOutputAnounce(anounceService.findAllInternshipsStatusExpired(pageable).getContent());
	 }
	 @Override
	 public List<DtoOutputAnounce> findAllInternshipsStatusIqnoring(Pageable pageable) {
		  return convertDtoService.convertOutputAnounce(anounceService.findAllInternshipsStatusIqnoring(pageable).getContent());
	 }

	 @Override
	 public List<DtoOutputAnounce> findAllJobsStatusActive(Pageable pageable) {
		  return convertDtoService.convertOutputAnounce(anounceService.findAllJobsStatusActive(pageable).getContent());
	 }
	 @Override
	 public List<DtoOutputAnounce> findAllJobsStatusVerifiyng(Pageable pageable) {
		  return convertDtoService.convertOutputAnounce(anounceService.findAllJobsStatusVerifiyng(pageable).getContent());
	 }
	 @Override
	 public List<DtoOutputAnounce> findAllJobsStatusExpired(Pageable pageable) {
		  return convertDtoService.convertOutputAnounce(anounceService.findAllJobsStatusExpired(pageable).getContent());
	 }
	 @Override
	 public List<DtoOutputAnounce> findAllJobsStatusIqnoring(Pageable pageable) {
		  return convertDtoService.convertOutputAnounce(anounceService.findAllJobsStatusIqnoring(pageable).getContent());

	 }

	 @Override
	 public List<DtoOutputAnounce> findAllCoursesStatusActive(Pageable pageable) {
		  return convertDtoService.convertOutputAnounce(anounceService.findAllCoursesStatusActive(pageable).getContent());
	 }
	 @Override
	 public List<DtoOutputAnounce> findAllCoursesStatusVerifiyng(Pageable pageable) {
		  return convertDtoService.convertOutputAnounce(anounceService.findAllCoursesStatusVerifiyng(pageable).getContent());

	 }
	 @Override
	 public List<DtoOutputAnounce> findAllCoursesStatusExpired(Pageable pageable) {
		  return convertDtoService.convertOutputAnounce(anounceService.findAllCoursesStatusExpired(pageable).getContent());

	 }
	 @Override
	 public List<DtoOutputAnounce> findAllCoursesStatusIqnoring(Pageable pageable) {
		  return convertDtoService.convertOutputAnounce(anounceService.findAllCoursesStatusIqnoring(pageable).getContent());

	 }

	 @Override
	 public List<DtoOutputAnounce> findByUserIdAllInternshipsStatusActive(Long userId, Pageable pageable) {
		  return convertDtoService.convertOutputAnounce(anounceService.findByUserIdAllInternshipsStatusActive(userId, pageable).getContent());

	 }
	 @Override
	 public List<DtoOutputAnounce> findByUserIdAllInternshipsStatusVerifiyng(Long userId, Pageable pageable) {
		  return convertDtoService.convertOutputAnounce(anounceService.findByUserIdAllInternshipsStatusVerifiyng(userId, pageable).getContent());

	 }
	 @Override
	 public List<DtoOutputAnounce> findByUserIdAllInternshipsStatusExpired(Long userId, Pageable pageable) {
		  return convertDtoService.convertOutputAnounce(anounceService.findByUserIdAllInternshipsStatusExpired(userId, pageable).getContent());

	 }
	 @Override
	 public List<DtoOutputAnounce> findByUserIdAllInternshipsStatusIqnoring(Long userId, Pageable pageable) {
		  return convertDtoService.convertOutputAnounce(anounceService.findByUserIdAllInternshipsStatusIqnoring(userId, pageable).getContent());

	 }

	 @Override
	 public List<DtoOutputAnounce> findByUserIdAllJobsStatusActive(Long userId, Pageable pageable) {
		  return convertDtoService.convertOutputAnounce(anounceService.findByUserIdAllJobsStatusActive(userId, pageable).getContent());

	 }
	 @Override
	 public List<DtoOutputAnounce> findByUserIdAllJobsStatusVerifiyng(Long userId, Pageable pageable) {
		  return convertDtoService.convertOutputAnounce(anounceService.findByUserIdAllJobsStatusVerifiyng(userId, pageable).getContent());

	 }
	 @Override
	 public List<DtoOutputAnounce> findByUserIdAllJobsStatusExpired(Long userId, Pageable pageable) {
		  return convertDtoService.convertOutputAnounce(anounceService.findByUserIdAllJobsStatusExpired(userId, pageable).getContent());

	 }
	 @Override
	 public List<DtoOutputAnounce> findByUserIdAllJobsStatusIqnoring(Long userId, Pageable pageable) {
		  return convertDtoService.convertOutputAnounce(anounceService.findByUserIdAllJobsStatusIqnoring(userId, pageable).getContent());

	 }

	 @Override
	 public List<DtoOutputAnounce> findByUserIdAllCoursesStatusActive(Long userId, Pageable pageable) {
		  return convertDtoService.convertOutputAnounce(anounceService.findByUserIdAllCoursesStatusActive(userId, pageable).getContent());

	 }
	 @Override
	 public List<DtoOutputAnounce> findByUserIdAllCoursesStatusVerifiyng(Long userId, Pageable pageable) {
		  return convertDtoService.convertOutputAnounce(anounceService.findByUserIdAllCoursesStatusVerifiyng(userId, pageable).getContent());

	 }
	 @Override
	 public List<DtoOutputAnounce> findByUserIdAllCoursesStatusExpired(Long userId, Pageable pageable) {
		  return convertDtoService.convertOutputAnounce(anounceService.findByUserIdAllCoursesStatusExpired(userId, pageable).getContent());

	 }
	 @Override
	 public List<DtoOutputAnounce> findByUserIdAllCoursesStatusIqnoring(Long userId, Pageable pageable) {
		  return convertDtoService.convertOutputAnounce(anounceService.findByUserIdAllCoursesStatusIqnoring(userId, pageable).getContent());

	 }
}
