package com.dailycode.test.service.Student;

import com.dailycode.test.model.Student;
import java.util.List;

public interface IStudentService {
  Student addStudent(Student student);
  Student getStudentById(Long studentId);
  List<Student> getStudents();
  Student updateStudent(Student student,Long studentId);
  void deleteStudentById(Long studentId);


}
