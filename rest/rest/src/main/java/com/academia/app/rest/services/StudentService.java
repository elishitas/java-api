package com.academia.app.rest.services;

import com.academia.app.rest.model.domain.StudentDTO;
import com.academia.app.rest.model.entities.StudentEntity;
import com.academia.app.rest.model.mappers.StudentMapper;
import com.academia.app.rest.model.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    public StudentService(StudentRepository studentRepository,
                          StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }
    public List<StudentDTO> findAll(){
        return studentRepository
                .findAll()
                .stream()
                .map(studentEntity -> studentMapper.studentEntityToStudentDTO(studentEntity))
                .collect(Collectors.toList());
    }
    public StudentDTO add(StudentDTO studentDTO){
        return Optional
                .ofNullable(studentDTO)
                .map(dto->studentMapper.studentDTOToStudentEntity(dto))
                .map(entity->studentRepository.save(entity))
                .map(entity->studentMapper.studentEntityToStudentDTO(entity))
                .orElse(new StudentDTO());
    }

    public StudentDTO findById(Integer studentId){
        return studentRepository
                .findById(studentId)
                .map(studentMapper::studentEntityToStudentDTO)
                .orElse(new StudentEntity());
    }
}
