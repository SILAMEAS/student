package com.dailycode.test.service;

import com.dailycode.test.exception.StudentAlreadyExitException;
import com.dailycode.test.exception.StudentNotFoundException;
import com.dailycode.test.model.Student;
import com.dailycode.test.reposity.StudentRepo;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService{
  private final StudentRepo studentRepo;

  @Override
  public Student addStudent(Student student) {
    if(StudentAlreadyExit(student.getEmail())){
      throw new StudentAlreadyExitException(student.getEmail()+" already exited");
    }
    return studentRepo.save(student);
  }
  @Override
  public Student updateStudent(Student student,Long studentId) {
    return studentRepo.findById(studentId).map(stu->{
      stu.setEmail(student.getEmail());
      stu.setFirstName(student.getFirstName());
      stu.setLastName(student.getLastName());
      stu.setDepartment(student.getDepartment());
      return  studentRepo.save(stu);
    }).orElseThrow(()-> new StudentNotFoundException("Sorry, this student not found "));
  }


  @Override
  public Student getStudentById(Long studentId) {
    return studentRepo.findById(studentId).orElseThrow(()-> new StudentNotFoundException("Sorry, this student id "+studentId+" not found "));
  }

  @Override
  public List<Student> getStudents() {
    return studentRepo.findAll();
  }


  @Override
  public void deleteStudentById(Long studentId) {
    if(!studentRepo.existsById(studentId)){
     throw  new StudentNotFoundException("Sorry, can't delete student not found");
    }

  }
//  Method
private boolean StudentAlreadyExit(String email) {
    return studentRepo.findByEmail(email).isPresent();
}

}
