package com.dailycode.test.exception;

public class StudentNotFoundException extends RuntimeException{

  public StudentNotFoundException(String message) {
    super(message);
  }
}
