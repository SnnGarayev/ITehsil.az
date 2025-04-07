package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ServletComponentScan
@EntityScan(basePackages = {"com.example.demo"})
@EnableJpaRepositories(basePackages = {"com.example.demo"})
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

// Hər bir hissəni işləyən metod
//public static void processChunk(String chunk) {
//	 System.out.println("İşlənən hissə: " + chunk);
//	 List<String> obyekt = List.of(chunk.split("_"));
//
//	 UniProffession newUniProf = new UniProffession();
//	 Profession newProfession =new Profession();
//	 Degree newDegree =  new Degree();
//	 Group newGroup= new Group();
//	 UniCity newUniCity = new UniCity();
//	 University newUniversity =new University();
//	 City newCity	= new City();
//	 newCity.setName(obyekt.get(6));
//	 newDegree.setName("Bakalavr");
//	 newGroup.setName(obyekt.get(5));
//	 newGroup.setSubGroup(false);
//	 newGroup.setDegree(newDegree);
//	 newUniversity.setName(obyekt.get(0));
//	 newUniCity.setCity(newCity);
//	 newUniCity.setUniversity(newUniversity);
//	 newProfession.setProfessionName(obyekt.get(1));
//	 newProfession.setGroup(newGroup);
//	 newUniProf.setUniversity(newUniCity);
//	 newUniProf.setProfession(newProfession);
//	 newUniProf.setPossibility(Integer.parseInt(obyekt.get(8)));
//	 newUniProf.setPointFree(obyekt.get(4));
//	 newUniProf.setPointPaid(obyekt.get(3));
//	 newUniProf.setStudyLanguage(obyekt.get(7));
//	 newUniProf.setStudyType(obyekt.get(2));

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

//}

}




