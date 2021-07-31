package com.edfis.studentmanagementsystem.controller;

import com.edfis.studentmanagementsystem.model.Student;
import com.edfis.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String add(@RequestBody Student student) {
        studentService.save(student);
        return "New Student entry added successfully";
    }

    @GetMapping("/getAll")
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        studentService.deleteAll();
        return "Successfully deleted all student entries";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Integer id) {
        try {
            Student student = studentService.getStudentById(id);
            return new ResponseEntity<>(student, HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Integer id) {
        studentService.deleteStudentById(id);
        return "Deleted student with id " + id;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable Integer id) {
        try {
            Student existingStudent = studentService.getStudentById(id);
            studentService.save(student);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
