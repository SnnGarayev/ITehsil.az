package com.example.demo.Dtos.SSelection.OutputDto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DtoOutputGroup {

    public DtoOutputGroup(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    Long id;

    String name;
}
