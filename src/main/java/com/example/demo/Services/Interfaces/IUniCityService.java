package com.example.demo.Services.Interfaces;

import com.example.demo.Dtos.OutputDto.DtoOutputCity;
import com.example.demo.Dtos.OutputDto.DtoOutputCityAndUniCount;
import com.example.demo.Dtos.OutputDto.DtoOutputUniCity;
import com.example.demo.Entities.UniCity;
import java.util.List;
import java.util.Optional;

public interface IUniCityService {

UniCity save(UniCity newUniCity);

void deletedById(Long id);

Optional<UniCity> findById(Long id);

List<UniCity> findAllByUniId(Long id);
List<DtoOutputUniCity> getUniCityByCityIds(List<Long> ids);
List<UniCity> findAllByCityId(Long id);

List<UniCity> findAll();


boolean existsByCity_IdAndAndUniversity_Id(Long cityId,Long uniId);

UniCity findByCity_IdAndUniversity_Id(Long cityId, Long uniId);
List<DtoOutputCityAndUniCount> getCitiesAndUniCounts();

}
