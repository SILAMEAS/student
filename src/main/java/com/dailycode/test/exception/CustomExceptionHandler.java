package com.dailycode.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleException(MethodArgumentNotValidException ex){
    Map<String,String > errors=new HashMap<>();
    ex.getBindingResult().getFieldErrors().forEach(error->errors.put(error.getField(),error.getDefaultMessage()));
    return  errors;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(StudentAlreadyExitException.class)
    public Map<String,String> handlerStudentAlreadyExitException(StudentAlreadyExitException ex){
     Map<String,String> errorsStudentAlreadyExitException=new HashMap<>();
     errorsStudentAlreadyExitException.put("error : ",ex.getMessage());
     return  errorsStudentAlreadyExitException;
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(StudentNotFoundException.class)
    public Map<String,String> handlerStudentNotFoundException(StudentNotFoundException ex){
     Map<String,String> errorsStudentNotFoundException=new HashMap<>();
     errorsStudentNotFoundException.put("error : ",ex.getMessage());
     return  errorsStudentNotFoundException;
    }
}
