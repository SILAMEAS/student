package com.dailycode.test.controller;

import com.dailycode.test.model.Student;
import com.dailycode.test.service.StudentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v2")
public class StudentController {
  private final StudentService studentService;
  @GetMapping
  ResponseEntity<List<Student>> getStudent() {
    return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
  }
  @PostMapping()
  ResponseEntity<Student> createStudent(@RequestBody Student student) {
    return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.OK);
  }
  @DeleteMapping("{id}")
  ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) {
    studentService.deleteStudentById(id);
    return new ResponseEntity<String>("Student id "+id+" was deleted successfully", HttpStatus.OK);
  }
  @PutMapping("{id}")
  ResponseEntity<Student> updateStudent(@PathVariable("id") Student student,Long id) {
    return new ResponseEntity<>(   studentService.updateStudent(student,id), HttpStatus.OK);
  }

}
