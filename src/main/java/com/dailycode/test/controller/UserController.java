package com.dailycode.test.controller;

import com.dailycode.test.model.Student;
import com.dailycode.test.model.User;
import com.dailycode.test.service.Student.StudentService;
import com.dailycode.test.service.User.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http//:localhost:3000")
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v2")
public class UserController {
  private final UserService userService;
  @PostMapping("/user")
  ResponseEntity<User> createStudent(@Valid @RequestBody User user) {
    return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
  }

  @GetMapping("/user")
  ResponseEntity<Optional<User>> getStudent(@RequestBody String email) {
    return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
  }
  @DeleteMapping("/user/{id}")
  ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) {
    userService.deleteUser(id);
    return new ResponseEntity<String>("Student id "+id+" was deleted successfully", HttpStatus.OK);
  }
  @PutMapping("/user/{id}")
  ResponseEntity<User> updateStudent(@PathVariable("id") User user,Long id) {
    return new ResponseEntity<>( userService.updateUserById(id,user), HttpStatus.OK);
  }

}
