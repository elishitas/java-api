package com.academia.app.rest.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class studentDTO {
    private Integer id;
    private String name;
    private String surname;
}
