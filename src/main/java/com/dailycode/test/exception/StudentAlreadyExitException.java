package com.dailycode.test.exception;

public class StudentAlreadyExitException extends RuntimeException {

  public StudentAlreadyExitException(String message) {
    super(message);
  }
}
