package com.example.demo.Anouncement.Services.Impl;

import com.example.demo.Anouncement.Entities.Anounce;
import com.example.demo.Anouncement.Enums.AnounceStatus;
import com.example.demo.Anouncement.Enums.AnounceType;
import com.example.demo.Anouncement.Repository.IAnounceRepo;
import com.example.demo.Anouncement.Services.Interface.IAnounceService;
import com.example.demo.Dtos.Announcment.InputDto.DtoInputAnounceMergeSubAnounce;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnounceService implements IAnounceService {

private final IAnounceRepo anounceRepo;


@Override
public Optional<Anounce> findByIdAnounce(Long anounceId) {
	 return anounceRepo.findById(anounceId);
}
@Override
public Anounce saveAnounce(Anounce newAnounce) {
	 return anounceRepo.save(newAnounce);
}
@Override
public void deletedAnounceById(Long anounceId) {
	 anounceRepo.deleteById(anounceId);
}
@Override
public boolean existingByuserIdAndAnounceId(Long anounceId, Long userId) {
	 return anounceRepo.existsByIdAndUserId(anounceId,userId);
}
@Override
public Anounce updateAnounce(DtoInputAnounceMergeSubAnounce updatedAnounce) {
		return null;
}
@Override
public void automaticDeactivated(Long day) {
	anounceRepo.deactivatedAllOldAnounces(day);
}
@Override
public boolean existingAnounceById(Long anounceId) {
	 return anounceRepo.existsById(anounceId);
}
@Override
public Long getSubAnounceId(Long anounceId) {
	 return anounceRepo.getSubAnounceIdByAnounceId(anounceId);
}
@Override
public AnounceType getType(Long anounceId) {
	 return anounceRepo.getTypeByAnounceId(anounceId);
}


@Override
public void changeByIdStatusActive(Long anounceId) {
	 anounceRepo.findByIdAndChangeStatus(anounceId,AnounceStatus.Active);
}
@Override
public void changeByIdStatusExpaired(Long anounceId) {
	 anounceRepo.findByIdAndChangeStatus(anounceId,AnounceStatus.Expired);
}
@Override
public void changeByIdStatusVerifiying(Long anounceId) {
	 anounceRepo.findByIdAndChangeStatus(anounceId,AnounceStatus.Verifiyng);
}
@Override
public void changeByIdStatusIqnoring(Long anounceId) {
	 anounceRepo.findByIdAndChangeStatus(anounceId,AnounceStatus.Iqnoring);
}


@Override
public Page<Anounce> findAllInternshipsStatusActive(Pageable pageable) {
	 return anounceRepo.findAllByStatusAndAnounceTypeOrderBySharingDateDesc
				(AnounceStatus.Active,AnounceType.InternshipAnouncement,pageable);
}
@Override
public Page<Anounce>  findAllInternshipsStatusVerifiyng(Pageable pageable) {
	 return anounceRepo.findAllByStatusAndAnounceTypeOrderBySharingDateDesc
				(AnounceStatus.Verifiyng,AnounceType.InternshipAnouncement,pageable);
}
@Override
public Page<Anounce>  findAllInternshipsStatusExpired(Pageable pageable) {
	 return anounceRepo.findAllByStatusAndAnounceTypeOrderBySharingDateDesc(AnounceStatus.Expired,AnounceType.InternshipAnouncement,pageable);
}
@Override
public Page<Anounce>  findAllInternshipsStatusIqnoring(Pageable pageable) {
	 return anounceRepo.findAllByStatusAndAnounceTypeOrderBySharingDateDesc(AnounceStatus.Iqnoring,AnounceType.InternshipAnouncement,pageable);

}
@Override
public Page<Anounce>  findByUserIdAllInternshipsStatusActive(Long userId,Pageable pageable) {
	 return anounceRepo.findAllByUserIdAndStatusAndAnounceTypeOrderBySharingDateDesc(userId,AnounceStatus.Active,AnounceType.InternshipAnouncement,pageable);
}
@Override
public Page<Anounce>  findByUserIdAllInternshipsStatusVerifiyng(Long userId,Pageable pageable) {
	 return anounceRepo.findAllByUserIdAndStatusAndAnounceTypeOrderBySharingDateDesc(userId,AnounceStatus.Verifiyng,AnounceType.InternshipAnouncement,pageable);
}
@Override
public Page<Anounce>  findByUserIdAllInternshipsStatusExpired(Long userId,Pageable pageable) {
	 return anounceRepo.findAllByUserIdAndStatusAndAnounceTypeOrderBySharingDateDesc(userId,AnounceStatus.Expired,AnounceType.InternshipAnouncement,pageable);

}
@Override
public Page<Anounce>  findByUserIdAllInternshipsStatusIqnoring(Long userId,Pageable pageable) {
	 return anounceRepo.findAllByUserIdAndStatusAndAnounceTypeOrderBySharingDateDesc(userId,AnounceStatus.Iqnoring,AnounceType.InternshipAnouncement,pageable);
}


@Override
public Page<Anounce>  findAllJobsStatusActive(Pageable pageable) {
	 return anounceRepo.findAllByStatusAndAnounceTypeOrderBySharingDateDesc(AnounceStatus.Active,AnounceType.JobAnouncement,pageable);
}
@Override
public Page<Anounce>  findAllJobsStatusVerifiyng(Pageable pageable) {
	 return anounceRepo.findAllByStatusAndAnounceTypeOrderBySharingDateDesc(AnounceStatus.Verifiyng,AnounceType.JobAnouncement,pageable);
}
@Override
public Page<Anounce>  findAllJobsStatusExpired(Pageable pageable) {
	 return anounceRepo.findAllByStatusAndAnounceTypeOrderBySharingDateDesc(AnounceStatus.Expired,AnounceType.JobAnouncement,pageable);
}
@Override
public Page<Anounce>  findAllJobsStatusIqnoring(Pageable pageable) {
	 return anounceRepo.findAllByStatusAndAnounceTypeOrderBySharingDateDesc(AnounceStatus.Iqnoring,AnounceType.JobAnouncement,pageable);

}
@Override
public Page<Anounce>  findByUserIdAllJobsStatusActive(Long userId,Pageable pageable) {
	 return anounceRepo.findAllByUserIdAndStatusAndAnounceTypeOrderBySharingDateDesc(userId,AnounceStatus.Active,AnounceType.JobAnouncement,pageable);
}
@Override
public Page<Anounce>  findByUserIdAllJobsStatusVerifiyng(Long userId,Pageable pageable) {
	 return anounceRepo.findAllByUserIdAndStatusAndAnounceTypeOrderBySharingDateDesc(userId,AnounceStatus.Verifiyng,AnounceType.JobAnouncement,pageable);
}
@Override
public Page<Anounce>  findByUserIdAllJobsStatusExpired(Long userId,Pageable pageable) {
	 return anounceRepo.findAllByUserIdAndStatusAndAnounceTypeOrderBySharingDateDesc(userId,AnounceStatus.Expired,AnounceType.JobAnouncement,pageable);

}
@Override
public Page<Anounce>  findByUserIdAllJobsStatusIqnoring(Long userId,Pageable pageable) {
	 return anounceRepo.findAllByUserIdAndStatusAndAnounceTypeOrderBySharingDateDesc(userId,AnounceStatus.Iqnoring,AnounceType.JobAnouncement,pageable);
}


@Override
public Page<Anounce>  findAllCoursesStatusActive(Pageable pageable) {
	 return anounceRepo.findAllByStatusAndAnounceTypeOrderBySharingDateDesc(AnounceStatus.Active,AnounceType.CourseAnouncement,pageable);
}
@Override
public Page<Anounce>  findAllCoursesStatusVerifiyng(Pageable pageable) {
	 return anounceRepo.findAllByStatusAndAnounceTypeOrderBySharingDateDesc(AnounceStatus.Verifiyng,AnounceType.CourseAnouncement,pageable);

}
@Override
public Page<Anounce>  findAllCoursesStatusExpired(Pageable pageable) {
	 return anounceRepo.findAllByStatusAndAnounceTypeOrderBySharingDateDesc(AnounceStatus.Expired,AnounceType.CourseAnouncement,pageable);
}
@Override
public Page<Anounce>  findAllCoursesStatusIqnoring(Pageable pageable) {
	 return anounceRepo.findAllByStatusAndAnounceTypeOrderBySharingDateDesc(AnounceStatus.Iqnoring,AnounceType.CourseAnouncement,pageable);

}
@Override
public Page<Anounce>  findByUserIdAllCoursesStatusActive(Long userId,Pageable pageable) {
	 return anounceRepo.findAllByUserIdAndStatusAndAnounceTypeOrderBySharingDateDesc(userId,AnounceStatus.Active,AnounceType.CourseAnouncement,pageable);

}
@Override
public Page<Anounce>  findByUserIdAllCoursesStatusVerifiyng(Long userId,Pageable pageable) {
	 return anounceRepo.findAllByUserIdAndStatusAndAnounceTypeOrderBySharingDateDesc(userId,AnounceStatus.Verifiyng,AnounceType.CourseAnouncement,pageable);
}
@Override
public Page<Anounce> findByUserIdAllCoursesStatusExpired(Long userId,Pageable pageable) {
	 return anounceRepo.findAllByUserIdAndStatusAndAnounceTypeOrderBySharingDateDesc(userId,AnounceStatus.Expired,AnounceType.CourseAnouncement,pageable);

}
@Override
public Page<Anounce> findByUserIdAllCoursesStatusIqnoring(Long userId,Pageable pageable) {
	 return anounceRepo.findAllByUserIdAndStatusAndAnounceTypeOrderBySharingDateDesc(userId,AnounceStatus.Iqnoring,AnounceType.CourseAnouncement,pageable);
}


}
