package com.example.demo.Services.impl;

import com.example.demo.Dtos.OutputDto.DtoOutputCity;
import com.example.demo.Dtos.OutputDto.DtoOutputCityAndUniCount;
import com.example.demo.Dtos.OutputDto.DtoOutputUniCity;
import com.example.demo.Entities.UniCity;
import com.example.demo.Repositories.IUniCityRepo;
import com.example.demo.Services.Interfaces.IUniCityService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class UniCityService implements IUniCityService {

private final IUniCityRepo uniCityRepo;


@Override
public UniCity save(UniCity newUniCity) {


		  if(!uniCityRepo.existsUniCitiesByCity_IdAndAndUniversity_Id(newUniCity.getUniversity().getId(),
					 newUniCity.getCity().getId()))
		  {
				System.out.println("1");

				return uniCityRepo.save(newUniCity);
		  }
		  System.out.println("2");
		  return findByCity_IdAndUniversity_Id(newUniCity.getUniversity().getId(),newUniCity.getCity().getId());


}

@Override
public void deletedById(Long id) {
	 uniCityRepo.deleteById(id);
}

@Override
public Optional<UniCity> findById(Long id) {
	 return uniCityRepo.findById(id);
}

@Override
public List<UniCity> findAllByUniId(Long id) {
	 return uniCityRepo.findAllByUniversity_Id(id);
}

@Override
public List<DtoOutputUniCity> getUniCityByCityIds(List<Long> ids) {
	 return uniCityRepo.getUniCitiesByCityId(ids);
}

@Override
public List<UniCity> findAllByCityId(Long id) {
	 return uniCityRepo.findAllByCityId(id);
}

@Override
public List<UniCity> findAll() {
	 return uniCityRepo.findAll();
}

@Override
public boolean existsByCity_IdAndAndUniversity_Id(Long uniId,Long cityId) {
	 return uniCityRepo.existsUniCitiesByCity_IdAndAndUniversity_Id(uniId,cityId);
}

@Override
public UniCity findByCity_IdAndUniversity_Id(Long uniId,Long cityId) {
	 return uniCityRepo.findByCityIdAndUniversityId(uniId,cityId);
}

@Override
public List<DtoOutputCityAndUniCount> getCitiesAndUniCounts() {
	 return uniCityRepo.getCitiesAndUniCount();
}
}
