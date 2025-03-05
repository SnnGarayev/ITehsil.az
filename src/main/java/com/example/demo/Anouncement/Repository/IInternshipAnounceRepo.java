package com.example.demo.Anouncement.Repository;

import com.example.demo.Anouncement.Entities.InternshipAnounce;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IInternshipAnounceRepo extends JpaRepository<InternshipAnounce, Long> {

	 Optional<InternshipAnounce> findById(Long internshipId);

	 InternshipAnounce save(InternshipAnounce internshipAnounce);

	 void deleteById(Long internshipId);

}
