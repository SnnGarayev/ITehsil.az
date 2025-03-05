package com.example.demo.Anouncement.Services.Impl;


import com.example.demo.Anouncement.Entities.JobAnounce;
import com.example.demo.Anouncement.Repository.IJobAnounceRepo;
import com.example.demo.Anouncement.Services.Interface.IJobAnounceService;
import com.example.demo.Dtos.Announcment.InputDto.DtoInputJobAnounce;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobAnounceService implements IJobAnounceService {

private final  IJobAnounceRepo jobAnounceRepo;

@Override
public Optional<JobAnounce> findById(Long id) {
	 return jobAnounceRepo.findById(id);
}
@Override
public JobAnounce save(JobAnounce newJobAnounce) {
	 return jobAnounceRepo.save(newJobAnounce);
}
@Override
public void deleteByid(Long id) { jobAnounceRepo.deleteById(id);}

@Override
public JobAnounce update(DtoInputJobAnounce newJobAnounce) {
	 return null;
}


}
