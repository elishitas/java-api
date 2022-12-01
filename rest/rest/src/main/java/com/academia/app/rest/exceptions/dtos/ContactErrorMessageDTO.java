package com.academia.app.rest.exceptions.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactErrorMessageDTO {
    private String message;
    private String path;
    private String code;
}
