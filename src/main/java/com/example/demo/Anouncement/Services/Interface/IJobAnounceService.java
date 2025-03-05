package com.example.demo.Anouncement.Services.Interface;

import com.example.demo.Anouncement.Entities.JobAnounce;
import com.example.demo.Dtos.Announcment.InputDto.DtoInputJobAnounce;

import java.util.Optional;

public interface IJobAnounceService {

	 Optional<JobAnounce> findById(Long id);
	 JobAnounce save(JobAnounce newJobAnounce);
	 void deleteByid(Long id);
	 JobAnounce update(DtoInputJobAnounce newJobAnounce);
}
