package com.example.demo.Anouncement.Services.Interface;

import com.example.demo.Anouncement.Entities.InternshipAnounce;
import com.example.demo.Dtos.Announcment.InputDto.DtoInputInternshipAnounce;

import java.util.Optional;

public interface IInternshipAnounceService {

Optional<InternshipAnounce> findById(Long internshipId);
InternshipAnounce save(InternshipAnounce newInternshipAnounce);
void deleteByid(Long internshipId);
InternshipAnounce update(DtoInputInternshipAnounce newInternshipAnounce);
}
