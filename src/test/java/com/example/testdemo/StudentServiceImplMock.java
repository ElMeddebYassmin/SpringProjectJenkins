package com.example.testdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class StudentServiceImplMock {

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    IStudentRepository studentRepository1 = Mockito.mock(IStudentRepository.class);

    Student student = new Student(1, "Ali");

    List<Student> studentList = new ArrayList<Student>(){
        {
            add(new Student(2L, "Salah"));
            add(new Student(3L, "Mohsen"));
        }
    };

    @Test
    public void testRetreiveStudents(){
        Mockito.when(studentRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(student));
        Student student1 = studentService.retreiveStudent(2L);
        Assertions.assertNotNull(student1);
    }


}
