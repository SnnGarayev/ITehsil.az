package com.example.demo.Anouncement.Services.Interface;

import com.example.demo.Dtos.Announcment.InputDto.DtoInputAnounceMergeSubAnounce;
import com.example.demo.Dtos.Announcment.OutputDto.DtoOutputAnounce;
import com.example.demo.Dtos.Announcment.OutputDto.DtoOutputAnounceMergeSubAnounce;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IAnouncmentService {


	 Optional<DtoOutputAnounce> findByIdAnounce(Long anounceId);
	 Optional<DtoOutputAnounceMergeSubAnounce> findByIdMergingAnounce(Long anounceId);
	 DtoOutputAnounceMergeSubAnounce saveAnounce(DtoInputAnounceMergeSubAnounce newAnounce);
	 void deletedAnounceById(Long anounceId);
	 boolean existingByuserIdAndAnounceId(Long anounceId,Long userId);
	 void editingOrSaving(Long anounceId);

DtoOutputAnounceMergeSubAnounce updateAnounce(DtoInputAnounceMergeSubAnounce newAnounce, Long userId);

void automaticDeactivated();

	 // Butun elanlari Statusa ve Tipe gore getiren ayri ayri metodlar

	 void changeByIdStatusActive(Long anounceId);
	 void changeByIdStatusExpaired(Long anounceId);
	 void changeByIdStatusVerifiying(Long anounceId);
	 void changeByIdStatusIqnoring(Long anounceId);


List<DtoOutputAnounce> findAllInternshipsStatusActive(Pageable pageable, int page, int size);

List<DtoOutputAnounce> findAllInternshipsStatusVerifiyng(Pageable pageable);
	 List<DtoOutputAnounce> findAllInternshipsStatusExpired(Pageable pageable);
	 List<DtoOutputAnounce> findAllInternshipsStatusIqnoring(Pageable pageable);

	 List<DtoOutputAnounce> findAllJobsStatusActive(Pageable pageable);
	 List<DtoOutputAnounce> findAllJobsStatusVerifiyng(Pageable pageable);
	 List<DtoOutputAnounce> findAllJobsStatusExpired(Pageable pageable);
	 List<DtoOutputAnounce> findAllJobsStatusIqnoring(Pageable pageable);

	 List<DtoOutputAnounce> findAllCoursesStatusActive(Pageable pageable);
	 List<DtoOutputAnounce> findAllCoursesStatusVerifiyng(Pageable pageable);
	 List<DtoOutputAnounce> findAllCoursesStatusExpired(Pageable pageable);
	 List<DtoOutputAnounce> findAllCoursesStatusIqnoring(Pageable pageable);


	 //Userin Idi ile Butun elanlari status ve tipe gore getiren ayri-ayri metodlar

	 List<DtoOutputAnounce> findByUserIdAllInternshipsStatusActive(Long userId, Pageable pageable);
	 List<DtoOutputAnounce> findByUserIdAllInternshipsStatusVerifiyng(Long userId, Pageable pageable);
	 List<DtoOutputAnounce> findByUserIdAllInternshipsStatusExpired(Long userId, Pageable pageable);
	 List<DtoOutputAnounce> findByUserIdAllInternshipsStatusIqnoring(Long userId, Pageable pageable);

	 List<DtoOutputAnounce> findByUserIdAllJobsStatusActive(Long userId, Pageable pageable);
	 List<DtoOutputAnounce> findByUserIdAllJobsStatusVerifiyng(Long userId, Pageable pageable);
	 List<DtoOutputAnounce> findByUserIdAllJobsStatusExpired(Long userId, Pageable pageable);
	 List<DtoOutputAnounce> findByUserIdAllJobsStatusIqnoring(Long userId, Pageable pageable);

	 List<DtoOutputAnounce> findByUserIdAllCoursesStatusActive(Long userId, Pageable pageable);
	 List<DtoOutputAnounce> findByUserIdAllCoursesStatusVerifiyng(Long userId, Pageable pageable);
	 List<DtoOutputAnounce> findByUserIdAllCoursesStatusExpired(Long userId, Pageable pageable);
	 List<DtoOutputAnounce> findByUserIdAllCoursesStatusIqnoring(Long userId, Pageable pageable);



}
