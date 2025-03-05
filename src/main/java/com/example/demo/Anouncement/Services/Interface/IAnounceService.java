package com.example.demo.Anouncement.Services.Interface;

import com.example.demo.Anouncement.Entities.Anounce;
import com.example.demo.Anouncement.Enums.AnounceType;
import com.example.demo.Dtos.Announcment.InputDto.DtoInputAnounceMergeSubAnounce;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IAnounceService {

	 Optional<Anounce> findByIdAnounce(Long anounceId);
	 Anounce saveAnounce(Anounce newAnounce);
	 void deletedAnounceById(Long anounceId);
	 boolean existingByuserIdAndAnounceId(Long anounceId,Long userId);
	 Anounce updateAnounce(DtoInputAnounceMergeSubAnounce newAnounce);
	 void automaticDeactivated(Long day);
	 boolean existingAnounceById(Long anounceId);
	 Long getSubAnounceId(Long anounceId);
	 AnounceType getType(Long anounceId);

// Butun elanlari Statusa ve Tipe gore getiren ayri ayri metodlar

	 void changeByIdStatusActive(Long anounceId);
	 void changeByIdStatusExpaired(Long anounceId);
	 void changeByIdStatusVerifiying(Long anounceId);
	 void changeByIdStatusIqnoring(Long anounceId);

    Page<Anounce> findAllInternshipsStatusActive(Pageable pageable);
	 Page<Anounce> findAllInternshipsStatusVerifiyng(Pageable pageable);
	 Page<Anounce> findAllInternshipsStatusExpired(Pageable pageable);
	 Page<Anounce> findAllInternshipsStatusIqnoring(Pageable pageable);

	 Page<Anounce> findAllJobsStatusActive(Pageable pageable);
	 Page<Anounce> findAllJobsStatusVerifiyng(Pageable pageable);
	 Page<Anounce> findAllJobsStatusExpired(Pageable pageable);
	 Page<Anounce> findAllJobsStatusIqnoring(Pageable pageable);

	 Page<Anounce> findAllCoursesStatusActive(Pageable pageable);
	 Page<Anounce> findAllCoursesStatusVerifiyng(Pageable pageable);
	 Page<Anounce> findAllCoursesStatusExpired(Pageable pageable);
	 Page<Anounce> findAllCoursesStatusIqnoring(Pageable pageable);


	 //Userin Idi ile Butun elanlari status ve tipe gore getiren ayri-ayri metodlar

	 Page<Anounce>  findByUserIdAllInternshipsStatusActive(Long userId,Pageable pageable);
	 Page<Anounce>  findByUserIdAllInternshipsStatusVerifiyng(Long userId,Pageable pageable);
	 Page<Anounce>  findByUserIdAllInternshipsStatusExpired(Long userId,Pageable pageable);
	 Page<Anounce>  findByUserIdAllInternshipsStatusIqnoring(Long userId,Pageable pageable);

	 Page<Anounce>  findByUserIdAllJobsStatusActive(Long userId,Pageable pageable);
	 Page<Anounce>  findByUserIdAllJobsStatusVerifiyng(Long userId,Pageable pageable);
	 Page<Anounce>  findByUserIdAllJobsStatusExpired(Long userId,Pageable pageable);
	 Page<Anounce>  findByUserIdAllJobsStatusIqnoring(Long userId,Pageable pageable);

	 Page<Anounce>  findByUserIdAllCoursesStatusActive(Long userId,Pageable pageable);
	 Page<Anounce>  findByUserIdAllCoursesStatusVerifiyng(Long userId,Pageable pageable);
	 Page<Anounce>  findByUserIdAllCoursesStatusExpired(Long userId,Pageable pageable);
	 Page<Anounce>  findByUserIdAllCoursesStatusIqnoring(Long userId,Pageable pageable);







}
