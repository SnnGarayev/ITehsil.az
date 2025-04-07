package com.example.demo.Dtos.OutputDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DtoOutputUniCity {

    Long Id;

    String uniName;

    String cityName;

    public DtoOutputUniCity(Long id, String name, String cityName) {
        Id = id;
        uniName = name;
        this.cityName = cityName;
    }
}
