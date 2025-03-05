package com.example.demo.Anouncement.Repository;
import com.example.demo.Anouncement.Entities.Anounce;
import com.example.demo.Anouncement.Enums.AnounceStatus;
import com.example.demo.Anouncement.Enums.AnounceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IAnounceRepo extends JpaRepository<Anounce,Long> {

	 Optional<Anounce> findById(Long anounceId);
	 Anounce save(Anounce newAnounce);
	 void deleteById(Long anounceId);
	 boolean existsByIdAndUserId(Long anounceId,Long userId);
	 boolean existsById(Long anounceId);

	 @Query("select a.subAnounceId from Anounce a where a.id = :anounceId")
	 Long getSubAnounceIdByAnounceId(@Param("anounceId")Long anounceId);

	 @Query("select a.anounceType from Anounce a where a.id = :anounceId")
	 AnounceType getTypeByAnounceId(@Param("anounceId")Long anounceId);


	 @Modifying
	 @Query("update Anounce a set a.status=:changeStatus where a.id=:id")
	 void findByIdAndChangeStatus(@Param("id") Long anounceId,@Param("changeStatus") AnounceStatus changeStatus);

	 @Modifying
	 @Query("update Anounce a set a.status='Expired' where a.status='Active' and a.sharingDate<= CURRENT_TIMESTAMP - :day DAY ")
	 void deactivatedAllOldAnounces(Long day);

	 Page<Anounce> findAllByUserIdAndStatusAndAnounceTypeOrderBySharingDateDesc(Long userId, AnounceStatus status, AnounceType type, Pageable pageable);
	 Page<Anounce> findAllByStatusAndAnounceTypeOrderBySharingDateDesc(AnounceStatus anounceStatus, AnounceType anounceType,Pageable pageable);

	 Page<Anounce> findAllByUserIdAndStatusOrderBySharingDateDesc(Long userId, AnounceStatus anounceStatus,Pageable pageable);
	 Page<Anounce> findAllByStatusOrderBySharingDateDesc(AnounceStatus anounceStatusatus,Pageable pageable);

	 Page<Anounce> findAllByAnounceTypeOrderBySharingDateDesc(AnounceType anounceType,Pageable pageable);
	 Page<Anounce> findAllByUserIdOrderBySharingDateDesc(Long useriId, Pageable pageable);
}
