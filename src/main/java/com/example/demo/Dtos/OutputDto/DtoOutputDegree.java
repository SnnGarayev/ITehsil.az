package com.example.demo.Dtos.OutputDto;

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
