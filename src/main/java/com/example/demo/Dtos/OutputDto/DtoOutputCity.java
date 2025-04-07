package com.example.demo.Dtos.OutputDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoOutputCity {

public DtoOutputCity(Long id, String name) {
    this.id = id;
    this.name = name;

}

Long id;
    String name;
}
