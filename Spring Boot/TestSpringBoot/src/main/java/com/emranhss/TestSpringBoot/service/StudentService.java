package com.emranhss.TestSpringBoot.service;

import com.emranhss.TestSpringBoot.entity.Student;
import com.emranhss.TestSpringBoot.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private IStudentRepo iStudentRepo;


    public void save(Student student) {

        iStudentRepo.save(student);
    }


    public List<Student> findAll() {

      return   iStudentRepo.findAll();
    }



}
