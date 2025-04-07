package com.example.demo.Repositories;

import com.example.demo.Dtos.OutputDto.DtoOutputCity;
import com.example.demo.Dtos.OutputDto.DtoOutputCityAndUniCount;
import com.example.demo.Dtos.OutputDto.DtoOutputUniCity;
import com.example.demo.Entities.UniCity;
import com.example.demo.Entities.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUniCityRepo extends JpaRepository<UniCity,Long> {

	List<UniCity> findAllByCityId(Long id);

		List<UniCity> findAllByUniversity_Id(Long id);
	@Query("SELECT COUNT(uc) > 0 FROM UniCity uc " +
		  "WHERE uc.university.id = :universityId " +
		  "AND uc.city.id = :cityId")
	boolean existsUniCitiesByCity_IdAndAndUniversity_Id(
		  @Param("universityId")Long uniId,@Param("cityId") Long cityId);

	@Query("SELECT uc FROM UniCity uc " +
		  "WHERE uc.university.id = :universityId " +
		  "AND uc.city.id = :cityId")
	UniCity findByCityIdAndUniversityId(@Param("universityId")Long uniId,@Param("cityId") Long cityId);

	 @Query("SELECT new com.example.demo.Dtos.OutputDto.DtoOutputCityAndUniCount(u.city.id, u.city.name, COUNT(u.university)) FROM UniCity u GROUP BY u.city.id order by u.city.name")
	 List<DtoOutputCityAndUniCount> getCitiesAndUniCount();


    @Query("SELECT u FROM UniCity u JOIN u.city c " +
				"WHERE :cityNames IS NULL OR c.name IN :cityNames " +
				"AND :universityNames IS NULL OR u.university.name IN :universityNames")
    List<University> findByCitiesAndUniversities(
            @Param("cityNames") List<String> cityNames,
            @Param("universityNames") List<String> universityNames);

	 @Query("SELECT new com.example.demo.Dtos.OutputDto.DtoOutputUniCity(u.id,u.university.name,c.name) " +
				"FROM UniCity u JOIN u.city c WHERE :cityIds IS NULL OR c.id IN :cityIds " +
				"order by u.university.name asc")
		List<DtoOutputUniCity> getUniCitiesByCityId(@Param("cityIds") List<Long> cityNames);

}
