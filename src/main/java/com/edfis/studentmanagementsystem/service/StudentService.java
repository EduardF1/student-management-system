package com.edfis.studentmanagementsystem.service;

import com.edfis.studentmanagementsystem.model.Student;

import java.util.List;


public interface StudentService {
    Student save(Student student);
    List<Student> getAll();
    void deleteAll();
    Student getStudentById(Integer id);
    void deleteStudentById(Integer id);
}
