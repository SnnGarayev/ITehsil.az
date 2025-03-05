package com.example.demo.Anouncement.Services.Impl;

import com.example.demo.Anouncement.Entities.InternshipAnounce;
import com.example.demo.Anouncement.Services.Interface.IInternshipAnounceService;
import com.example.demo.Dtos.Announcment.InputDto.DtoInputInternshipAnounce;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InternshipAnounceService  implements IInternshipAnounceService {
@Override
public Optional<InternshipAnounce> findById(Long internshipId) {
	 return Optional.empty();
}

@Override
public InternshipAnounce save(InternshipAnounce newInternshipAnounce) {
	 return null;
}

@Override
public void deleteByid(Long internshipId) {

}

@Override
public InternshipAnounce update(DtoInputInternshipAnounce newInternshipAnounce) {
	 return null;
}

}
