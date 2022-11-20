package com.academia.app.rest.model.mappers;

import com.academia.app.rest.model.domain.StudentDTO;
import com.academia.app.rest.model.entities.StudentEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StudentMapper {
    public StudentEntity studentDTOToStudentEntity(StudentDTO studentDTO){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(studentDTO.getName());
        studentEntity.setSurname(studentDTO.getSurname());
        studentEntity.setId(studentDTO.getId());
        return studentEntity;
    }
    public StudentDTO studentEntityToStudentDTO(StudentEntity studentEntity){
        return Optional
                .ofNullable(studentEntity)
                .map(entity -> new StudentDTO(entity.getId(),entity.getName(),entity.getSurname()))
                .orElse(new StudentDTO());
    }
}
