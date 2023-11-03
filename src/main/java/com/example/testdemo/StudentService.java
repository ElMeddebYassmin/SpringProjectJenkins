package com.example.testdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    IStudentRepository studentRepository;

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public Student retreiveStudent(Long id) {
        return studentRepository.findById(id).get();
    }
}
