package com.example.demo.SpecialitySelection.Controller;

import com.example.demo.Dtos.ConvertDtoService;
import com.example.demo.Dtos.SSelection.OutputDto.DtoOutputCity;
import com.example.demo.Dtos.SSelection.OutputDto.DtoOutputDegree;
import com.example.demo.Dtos.SSelection.OutputDto.DtoOutputGroup;
import com.example.demo.Dtos.SSelection.OutputDto.DtoOutputUniversity;
import com.example.demo.SpecialitySelection.Entities.*;
import com.example.demo.SpecialitySelection.Services.Interfaces.*;
import com.example.demo.SpecialitySelection.Services.impl.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@RestController
@RequestMapping("/ss")
@RequiredArgsConstructor
public class SpecialitySelectionController {


private final IDegreeService degreeService;

private final IGroupService gorupService;

private final ICityService cityService;

private final IUniversityService universityService;

private final ConvertDtoService converterDto;

private final IUniProfessionService uniProfessionService;

private final IUniCityService uniCityService;

private final ProfessionService professionService;

@GetMapping("/getDgrees")
public List<DtoOutputDegree> findAllDegree() {
    return converterDto.convertOutputDegree(degreeService.findAll());
}

@GetMapping("/getGroupsByDgree/{degreeId}")
public List<DtoOutputGroup> getAllUpGroups(@PathVariable Long degreeId) {
    return converterDto.convertOutputGroup(gorupService.findAllByDegree(degreeId));
}

@GetMapping("/getSubGroups/{upGroupId}")
public List<DtoOutputGroup> getAllSubGroups(@PathVariable Long upGroupId) {
    return converterDto.convertOutputGroup(gorupService.findAllByUpGroupId(upGroupId));
}

@GetMapping("/getCities")
public List<DtoOutputCity> getAllCities() {
    return converterDto.convertOutputCity(cityService.findAll());
}

@GetMapping("/getUniversities")
public List<DtoOutputUniversity> getAllUniversities() {
    return converterDto.convertOutputUniversity(universityService.findAll());
}

@GetMapping("/test")
public void test() {
    //region
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
        // Konsoldan böyük həcmli string oxuyuruq
        String input =reader.readLine();;
        while(input!=null)
        {


            processChunk(input.split("/")[0]);
            input = reader.readLine();


        // Daxil edilən stringi "/" işarəsinə görə ayırırıq
//        String[] parts = input.split("/");
         }
        // Hər bir hissəni emal edirik
//        System.out.println("String hissələrə ayrıldı:");
//        for (int i=0 ; i< parts.length; i++) {
//            processChunk(parts[i]);
//        }

    } catch (IOException e) {
        System.err.println("Xəta baş verdi: " + e.getMessage());
    }



    //endregion

    //region test
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder chunkBuffer = new StringBuilder(); // Hər hissəni toplamaq üçün buffer
//        int currentChar = -1; // Hər bir simvolu oxumaq üçün
//
//        while (true) {
//            try {
//                if (!((currentChar = reader.read()) != -1)) break;
//            } catch (IOException e) {
//                System.out.println("Error oldu ------------------------------");
//            }
//            char character = (char) currentChar;
//
//            // "END" ilə girişin sonlandırılması
//            if (chunkBuffer.toString().endsWith("END")) {
//                break;
//            }
//
//            if (character == '/') {
//                // / işarəsinə çatdıqda hissəni işləyir
//                processChunk(chunkBuffer.toString());
//                chunkBuffer.setLength(0); // Bufferi sıfırlayır
//            } else {
//                // Simvolu bufferə əlavə edir
//                chunkBuffer.append(character);
//            }
//        }
//
//        // Əgər son hissə varsa, onu da işləyir
//        if (chunkBuffer.length() > 0) {
//            processChunk(chunkBuffer.toString());
//        }
    //endRegion
}

int j=0;


// Hər bir hissəni işləyən metod
public void processChunk(String chunk) {
    System.err.println(++j +" ///////////////////////////////////////////////////////////////////////////////");
    System.out.println("İşlənən hissə: " + chunk);
    List<String> obyekt = List.of(chunk.split("_"));
    UniProffession newUniProf = new UniProffession();
    Profession newProfession = new Profession();
    Degree newDegree = new Degree();
    Group newGroup = new Group();
    UniCity newUniCity = new UniCity();
    University newUniversity = new University();
    City newCity = new City();

    newCity.setName(obyekt.get(6));
    System.out.println("CityService--------------------------" + newCity.toString());
    newCity = cityService.saveCity(newCity);
    System.out.println("CityService--------------------------" + newCity.toString());
    newDegree.setName("Bakalavr");
    newDegree = degreeService.save(newDegree);
    System.out.println("degService--------------------------" + newDegree.toString());
    newGroup.setName(obyekt.get(5));
    newGroup.setSubGroup(false);
    newGroup.setDegree(newDegree);
    newGroup = gorupService.save(newGroup);
    System.out.println("grService--------------------------" + newGroup.toString());
    newUniversity.setName(obyekt.get(0));
    System.out.println("uniService--------------------------" + newUniversity.toString());
    newUniversity = universityService.save(newUniversity);
    System.out.println("uniService--------------------------" + newUniversity.toString());
    newUniCity.setCity(newCity);
    newUniCity.setUniversity(newUniversity);
    System.out.println("usService--------------------------" + newUniCity.toString());
    newUniCity = uniCityService.save(newUniCity);
    System.out.println("usService--------------------------" + newUniCity.toString());
    newProfession.setProfessionName(obyekt.get(1));
    newProfession.setGroup(newGroup);
    System.out.println("profService--------------------------" + newProfession.toString());
    newProfession = professionService.save(newProfession);
    System.out.println("profService--------------------------" + newProfession.toString());
    newUniProf.setUniCity(newUniCity);
    newUniProf.setProfession(newProfession);
    newUniProf.setPossibility(Integer.parseInt(obyekt.get(8)));
    newUniProf.setPointFree(obyekt.get(4));
    newUniProf.setPointPaid(obyekt.get(3));
    newUniProf.setStudyLanguage(obyekt.get(7));
    newUniProf.setStudyType(obyekt.get(2));
    System.out.println("UNIprofService--------------------------" + newUniProf.toString());
    uniProfessionService.save(newUniProf);
    System.out.println("UNIprofService--------------------------" + newUniProf.toString());


    // Məlumatı parçalayır və obyekt yaradır (məsələn, User obyekti)
//	 List<String> obyekt = List.of(chunk.split("_"));
// 0.Bakı Dövlət Universiteti_
// 1.Riyaziyyat_
// 2.Ə_
// 3.320.2_
// 4.320.2_
// 5.1_
// 6.Bakı_
// 7.Azərbaycanca_
// 8.1800/

//	 for(int i=0;i<obyekt)

}

}












