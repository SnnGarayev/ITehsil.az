package com.example.demo.Dtos.SSelection.OutputDto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DtoOutputDegree {
    public DtoOutputDegree(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    Long id;

    String name;
}
