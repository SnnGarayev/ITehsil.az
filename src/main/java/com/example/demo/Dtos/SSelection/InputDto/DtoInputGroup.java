package com.example.demo.Dtos.SSelection.InputDto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DtoInputGroup {

    public DtoInputGroup(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    Long id;

    String name;
}
