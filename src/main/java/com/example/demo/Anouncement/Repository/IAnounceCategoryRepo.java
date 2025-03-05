package com.example.demo.Anouncement.Repository;
import com.example.demo.Anouncement.Entities.AnounceCategory;
import com.example.demo.Anouncement.Enums.AnounceType;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface IAnounceCategoryRepo extends JpaRepository<AnounceCategory, Long> {


	 Optional<AnounceCategory> findById(@NonNull Long id);

	 AnounceCategory save(@NonNull AnounceCategory anounceCategory);

	 void deleteById(Long id);

	 List<AnounceCategory> findByAnounceTypeAndIsUpIsTrueOrderByCategoryName(AnounceType anounceType);
	 List<AnounceCategory> findByUpCategoryIdOrderByCategoryName(Long upCategoryId);

}
