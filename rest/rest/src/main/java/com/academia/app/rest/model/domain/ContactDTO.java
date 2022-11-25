package com.academia.app.rest.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {
    private Integer id;
    private String nombre;
    private Integer celular;
}
