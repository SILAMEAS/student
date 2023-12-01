package com.dailycode.test.controller;

import com.dailycode.test.model.Student;
import com.dailycode.test.service.Student.StudentService;
import java.util.List;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http//:localhost:3000")
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v2")
public class StudentController {
  private final StudentService studentService;
  @PostMapping("/student")
  ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
    return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.OK);
  }
  @GetMapping("/students")
  ResponseEntity<List<Student>> getStudent() {
    return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
  }
  @GetMapping("/student/{id}")
  ResponseEntity<Student> getStudent(@PathVariable("id") Long id) {
    return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
  }
  @DeleteMapping("/student/{id}")
  ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) {
    studentService.deleteStudentById(id);
    return new ResponseEntity<String>("Student id "+id+" was deleted successfully", HttpStatus.OK);
  }
  @PutMapping("/student/{id}")
  ResponseEntity<Student> updateStudent(@PathVariable("id") Student student,Long id) {
    return new ResponseEntity<>( studentService.updateStudent(student,id), HttpStatus.OK);
  }

}
