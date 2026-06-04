package com.hostel.controller;

import com.hostel.entity.Student;
import com.hostel.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PreAuthorize("hasRole('WARDEN')")
    @PostMapping
    public Student saveStudent(
            @RequestBody Student student){

        return service.saveStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents(){

        return service.getAllStudents();
    }

    @PreAuthorize("hasRole('WARDEN')")
    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @RequestBody Student student){

        return service.updateStudent(
                id,
                student);
    }

    @PreAuthorize("hasRole('WARDEN')")
    @DeleteMapping("/{id}")
    public String deleteStudent(
            @PathVariable Long id){

        service.deleteStudent(id);

        return "Student Deleted Successfully";
    }
}