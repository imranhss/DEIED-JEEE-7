package com.emranhss.TestSpringBoot.controller;


import com.emranhss.TestSpringBoot.entity.Student;
import com.emranhss.TestSpringBoot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping
    public void saveStudent(@RequestBody Student student) {

          studentService.save(student);

    }

    @GetMapping
    public List<Student> getAllStudent(){
        return  studentService.findAll();
    }



}
