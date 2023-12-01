package com.dailycode.test.reposity;

import com.dailycode.test.model.Student;
import com.dailycode.test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
