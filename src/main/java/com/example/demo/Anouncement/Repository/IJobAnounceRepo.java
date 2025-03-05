package com.example.demo.Anouncement.Repository;

import com.example.demo.Anouncement.Entities.JobAnounce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IJobAnounceRepo extends JpaRepository<JobAnounce,Long>{


Optional<JobAnounce> findById(Long jobId);

JobAnounce save(JobAnounce newJobAnounce);

void deleteById(Long jobId);


}
