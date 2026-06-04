package com.hostel.service;

import com.hostel.entity.Student;
import com.hostel.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student saveStudent(Student student) {

        return repository.save(student);
    }

    public List<Student> getAllStudents() {

        return repository.findAll();
    }

    public void deleteStudent(Long id) {

        repository.deleteById(id);
    }

    public Student updateStudent(
            Long id,
            Student student) {

        Student existingStudent =
                repository.findById(id)
                        .orElseThrow();

        existingStudent.setName(
                student.getName());

        existingStudent.setCourse(
                student.getCourse());

        existingStudent.setYear(
                student.getYear());

        existingStudent.setPhone(
                student.getPhone());

        existingStudent.setEmail(
                student.getEmail());

        existingStudent.setGender(
                student.getGender());

        existingStudent.setParentPhone(
                student.getParentPhone());

        existingStudent.setHostelRequired(
                student.getHostelRequired());

        return repository.save(
                existingStudent);
    }
}