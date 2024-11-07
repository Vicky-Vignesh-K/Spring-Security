package com.security.SpringToken.controller;

import com.security.SpringToken.VO.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class StudentController {

    List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Arun", 9988776655l),
            new Student(2, "Tharun", 8877997766l)
    ));

    @GetMapping("getStudents")
    public List<Student> getAllStudents() {
        return students;
    }

    @PostMapping("addStudent")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

}
