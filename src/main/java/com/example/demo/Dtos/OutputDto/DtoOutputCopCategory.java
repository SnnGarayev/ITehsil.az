package com.example.demo.Dtos.OutputDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DtoOutputCopCategory {
    public DtoOutputCopCategory(String type, Long count) {
        this.type = type;
        this.count = count;
    }

    private String type;
    private Long count;
}
