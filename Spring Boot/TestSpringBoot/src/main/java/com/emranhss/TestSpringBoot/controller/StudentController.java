package com.emranhss.TestSpringBoot.controller;


import com.emranhss.TestSpringBoot.entity.Student;
import com.emranhss.TestSpringBoot.entity.User;
import com.emranhss.TestSpringBoot.service.AuthService;
import com.emranhss.TestSpringBoot.service.StudentService;
import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @Autowired
    private AuthService authService;


    @PostMapping("/save")
    public void saveStudent(@RequestPart Student student, @RequestPart User user, @RequestParam MultipartFile photo) {


        authService.registerStudent(user, student,  photo);

    }





    @GetMapping("/all")
    public List<Student> getAllStudent(){
        return  studentService.findAll();
    }



}
