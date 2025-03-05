package com.example.demo.Dtos.SSelection.OutputDto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DtoOutputUniversity {

    Long uniId;

    String uniName;

    public DtoOutputUniversity(Long id, String name) {
        uniId = id;
        uniName = name;
    }
}
