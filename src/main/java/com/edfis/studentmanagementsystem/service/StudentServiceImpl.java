package com.edfis.studentmanagementsystem.service;

import com.edfis.studentmanagementsystem.model.Student;
import com.edfis.studentmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteAll() {
        studentRepository.deleteAll();
    }

    @Override
    public Student getStudentById(Integer id){
        return studentRepository.getById(id);
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
    }
}
