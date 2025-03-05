package com.example.demo.SpecialitySelection.Repositories;

import com.example.demo.SpecialitySelection.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUniCityRepo extends JpaRepository<UniCity,Long> {

	List<UniCity> findAllByCityId(Long id);

		List<UniCity> findAllByUniversity_Id(Long id);
@Query("SELECT COUNT(uc) > 0 FROM UniCity uc WHERE uc.university.id = :universityId AND uc.city.id = :cityId")
boolean existsUniCitiesByCity_IdAndAndUniversity_Id(@Param("universityId")Long uniId,@Param("cityId") Long cityId);

@Query("SELECT uc FROM UniCity uc WHERE uc.university.id = :universityId AND uc.city.id = :cityId")
UniCity findByCityIdAndUniversityId(@Param("universityId")Long uniId,@Param("cityId") Long cityId);

    @Query("SELECT u FROM UniCity u JOIN u.city c WHERE :cityNames IS NULL OR c.name IN :cityNames AND :universityNames IS NULL OR u.university.name IN :universityNames")
    List<University> findByCitiesAndUniversities(
            @Param("cityNames") List<String> cityNames,
            @Param("universityNames") List<String> universityNames);

}
