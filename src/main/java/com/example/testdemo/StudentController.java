package com.example.testdemo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/student")
public class StudentController {
    @Autowired
    IStudentRepository studentRepository;

    @PostMapping("/add")
    @ResponseBody
    public Student addContrat(@RequestBody Student c) {
        return studentRepository.save(c);
    }
}
