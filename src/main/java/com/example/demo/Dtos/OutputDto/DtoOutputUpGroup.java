package com.example.demo.Dtos.OutputDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DtoOutputUpGroup {

    public DtoOutputUpGroup(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    Long id;

    String name;
}
