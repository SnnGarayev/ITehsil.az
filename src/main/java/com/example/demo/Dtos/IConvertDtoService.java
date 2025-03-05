package com.example.demo.Dtos;

import com.example.demo.Anouncement.Entities.*;
import com.example.demo.Dtos.Announcment.InputDto.*;
import com.example.demo.Dtos.Announcment.OutputDto.*;
import com.example.demo.Dtos.SSelection.InputDto.*;
import com.example.demo.Dtos.SSelection.OutputDto.*;
import com.example.demo.MergeInterfaces.IAnouncesSubClasses;
import com.example.demo.SpecialitySelection.Entities.*;

import java.util.List;

public interface IConvertDtoService {

 DtoOutputCity convertOutputCity(City city);
 List<DtoOutputCity> convertOutputCity(List<City> city);
 City convertEntityCity(DtoInputCity dtoInputCity);

 DtoOutputDegree convertOutputDegree(Degree degree);
 List<DtoOutputDegree> convertOutputDegree(List<Degree> degrees);
 Degree convertEntityDegree(DtoInputDegree dtoInputDegree);

 DtoOutputGroup convertOutputGroup(Group group);
 List<DtoOutputGroup> convertOutputGroup(List<Group> group);
 Group convertEntityGroup(DtoInputGroup dtoInputGroup);

 DtoOutputUniversity convertOutputUniversity(University university);
 List<DtoOutputUniversity> convertOutputUniversity(List<University> universities);
 University convertEntityUniversity(DtoInputUniversity dtoInputUniversity);

 DtoOutputProfession convertOutputProfession(Profession profession);
 List<DtoOutputProfession> convertOutputProfession(List<Profession> professions);
 University convertEntityProfession(DtoInputProfession dtoInputProfession);

 DtoOutputUniProfession convertOutputUniProfession(UniProffession uniProffession);
 List<DtoOutputUniProfession> convertOutputUniProfession(List<UniProffession> uniProffessions);
 University convertEntityUniProfession(DtoInputUniProfession dtoInputUniProfession);



 DtoOutputAnounce convertOutputAnounce(Anounce anounce);
 List<DtoOutputAnounce> convertOutputAnounce(List<Anounce> anounces);
 Anounce convertEntityAnounce(DtoInputAnounce dtoInputAnounce);

 DtoOutputJobAnounce convertOutputJobAnounce(JobAnounce jobAnounce);
 List<DtoOutputJobAnounce> convertOutputJobAnounce(List<JobAnounce> jobAnounces);
 JobAnounce convertEntityJobAnounce(DtoInputJobAnounce dtoInputJobAnounce);

DtoOutputAnounce convertOutputAnounceCategory(AnounceCategory anounceCategory);
List<DtoOutputAnounceCategory> convertOutputAnounceCategory(List<AnounceCategory> anounceCategories);
Anounce convertEntityAnounceCategory(DtoInputAnounceCategory dtoInputAnounceCategoryAnounce);


DtoOutputInternshipAnounce convertOutputInternshipAnounce(InternshipAnounce internshipAnounce);
List<DtoOutputInternshipAnounce> convertOutputInternshipAnounce(List<InternshipAnounce> internshipAnounces);
InternshipAnounce convertEntityInternshipAnounce(DtoInputInternshipAnounce dtoInputInternshipAnounce);

DtoOutputCourseAnounce convertOutputCourseAnounce(CourseAnounce courseAnounce);
List<DtoOutputCourseAnounce> convertOutputCourseAnounce(List<CourseAnounce> courseAnounces);
CourseAnounce convertEntityCourseAnounce(DtoInputCourseAnounce dtoInputCourseAnounce);

DtoOutputAnounceMergeSubAnounce convertOutputAnounceMergeSubAnounce(Anounce anounce, IAnouncesSubClasses subAnounce);
Anounce convertEntityAnounce(DtoInputAnounceMergeSubAnounce dtoInputAnounceMergeSubAnounceunce);



}
