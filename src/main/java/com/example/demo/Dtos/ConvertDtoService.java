package com.example.demo.Dtos;


import com.example.demo.Anouncement.Entities.*;
import com.example.demo.Dtos.Announcment.InputDto.*;
import com.example.demo.Dtos.Announcment.OutputDto.*;
import com.example.demo.Dtos.SSelection.InputDto.*;
import com.example.demo.Dtos.SSelection.OutputDto.*;
import com.example.demo.MergeInterfaces.IAnouncesSubClasses;
import com.example.demo.SpecialitySelection.Entities.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConvertDtoService implements IConvertDtoService {


@Override
public DtoOutputCity convertOutputCity(City city)
{
	 return new DtoOutputCity(city.getId(),city.getName());
}
@Override
public List<DtoOutputCity> convertOutputCity(List<City> city) {
	 List<DtoOutputCity> returnData = new ArrayList<>();
	 for (City value : city) {
		  returnData.add(convertOutputCity(value));
	 }
	 return returnData;
}
@Override
public City convertEntityCity(DtoInputCity dtoInputCity)
{
	 return null;
}

@Override
public DtoOutputDegree convertOutputDegree(Degree degree) {
	 return new DtoOutputDegree(degree.getId(),degree.getName());
}
@Override
public List<DtoOutputDegree> convertOutputDegree(List<Degree> degrees) {
	 List<DtoOutputDegree> returnData = new ArrayList<>();
	 for (Degree degree : degrees) {
		  returnData.add(convertOutputDegree(degree));
	 }
	 return returnData;
}
@Override
public Degree convertEntityDegree(DtoInputDegree dtoInputDegree)
{
return null;
}

@Override
public DtoOutputGroup convertOutputGroup(Group group)
{
	 return new DtoOutputGroup(group.getId(),group.getName());
}
@Override
public List<DtoOutputGroup> convertOutputGroup(List<Group> group) {
	 List<DtoOutputGroup> returnData = new ArrayList<>();
	 for (Group value : group) {
		  returnData.add(convertOutputGroup(value));
	 }
	 return returnData;
}
@Override
public Group convertEntityGroup(DtoInputGroup dtoInputGroup)
{
return null;
}

@Override
public DtoOutputUniversity convertOutputUniversity(University university) {
	 return new DtoOutputUniversity(university.getId(),university.getName());
}
@Override
public List<DtoOutputUniversity> convertOutputUniversity(List<University> universities) {
	 List<DtoOutputUniversity> returnData = new ArrayList<>();
	 for (University university : universities) {
		  returnData.add(convertOutputUniversity(university));
	 }
	 return returnData;
}
@Override
public University convertEntityUniversity(DtoInputUniversity dtoInputUniversity)
{
return null;
}

@Override
public DtoOutputProfession convertOutputProfession(Profession profession) {
	 return null;
}
@Override
public List<DtoOutputProfession> convertOutputProfession(List<Profession> professions) {
	 return null;
}
@Override
public University convertEntityProfession(DtoInputProfession dtoInputProfession)
{
	 return null;
}

@Override
public DtoOutputUniProfession convertOutputUniProfession(UniProffession uniProffession) {
	 return null;
}
@Override
public List<DtoOutputUniProfession> convertOutputUniProfession(List<UniProffession> uniProffessions) {
	 return null;
}
@Override
public University convertEntityUniProfession(DtoInputUniProfession dtoInputUniProfession)
{
	 return null;
}

@Override
public DtoOutputAnounce convertOutputAnounce(Anounce anounce) {
	 return null;
}
@Override
public List<DtoOutputAnounce> convertOutputAnounce(List<Anounce> anounces) {
	 return List.of();
}
@Override
public Anounce convertEntityAnounce(DtoInputAnounce dtoInputAnounce) {
	 return null;
}

@Override
public DtoOutputJobAnounce convertOutputJobAnounce(JobAnounce jobAnounce) {
	 return null;
}
@Override
public List<DtoOutputJobAnounce> convertOutputJobAnounce(List<JobAnounce> jobAnounces) {
	 return List.of();
}
@Override
public JobAnounce convertEntityJobAnounce(DtoInputJobAnounce dtoInputJobAnounce) {
	 return null;
}

@Override
public DtoOutputAnounce convertOutputAnounceCategory(AnounceCategory anounceCategory) {
	 return null;
}
@Override
public List<DtoOutputAnounceCategory> convertOutputAnounceCategory(List<AnounceCategory> anounceCategories) {
	 return List.of();
}
@Override
public Anounce convertEntityAnounceCategory(DtoInputAnounceCategory dtoInputAnounceCategoryAnounce) {
	 return null;
}

@Override
public DtoOutputInternshipAnounce convertOutputInternshipAnounce(InternshipAnounce internshipAnounce) {
	 return null;
}
@Override
public List<DtoOutputInternshipAnounce> convertOutputInternshipAnounce(List<InternshipAnounce> internshipAnounces) {
	 return List.of();
}
@Override
public InternshipAnounce convertEntityInternshipAnounce(DtoInputInternshipAnounce dtoInputInternshipAnounce) {
	 return null;
}

@Override
public DtoOutputCourseAnounce convertOutputCourseAnounce(CourseAnounce courseAnounce) {
	 return null;
}
@Override
public List<DtoOutputCourseAnounce> convertOutputCourseAnounce(List<CourseAnounce> courseAnounces) {
	 return List.of();
}
@Override
public CourseAnounce convertEntityCourseAnounce(DtoInputCourseAnounce dtoInputCourseAnounce) {
	 return null;
}

@Override
public DtoOutputAnounceMergeSubAnounce convertOutputAnounceMergeSubAnounce(Anounce anounce, IAnouncesSubClasses subAnounce) {
	 return null;
}
@Override
public Anounce convertEntityAnounce(DtoInputAnounceMergeSubAnounce dtoInputAnounceMergeSubAnounceunce) {
	 return null;
}



}
