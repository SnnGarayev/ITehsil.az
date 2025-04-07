package com.example.demo.Dtos.OutputDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoOutputProfession {
	 public DtoOutputProfession(Long id, String name) {
		  this.id = id;
		  this.name = name;
	 }

	 Long id;
	 String name;
}
