package com.example.demo.SpecialitySelection.Services.Interfaces;

import com.example.demo.SpecialitySelection.Entities.*;
import java.util.List;
import java.util.Optional;

public interface IUniCityService {

UniCity save(UniCity newUniCity);

void deletedById(Long id);

Optional<UniCity> findById(Long id);

List<UniCity> findAllByUniId(Long id);

List<UniCity> findAllByCityId(Long id);


List<UniCity> findAll();


boolean existsByCity_IdAndAndUniversity_Id(Long cityId,Long uniId);

UniCity findByCity_IdAndUniversity_Id(Long cityId, Long uniId);

}
