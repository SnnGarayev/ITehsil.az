package com.example.demo.Dtos.SSelection.InputDto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DtoInputDegree {
    public DtoInputDegree(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    Long id;

    String name;
}
