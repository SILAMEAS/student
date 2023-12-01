package com.dailycode.test.reposity;

import com.dailycode.test.model.Student;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {


  Optional<Student> findByEmail(String email);
}
