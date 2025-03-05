package com.example.demo.Dtos.SSelection.InputDto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DtoInputUniversity {

    Long uniId;

    String uniName;

    public DtoInputUniversity(Long id, String name) {
        uniId = id;
        uniName = name;
    }
}
