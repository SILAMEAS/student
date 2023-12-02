package com.dailycode.test.service.User;

import com.dailycode.test.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User createUser(User user);
    Optional<User> getUserByEmail(String email);
    List<User> getUsers();
    User updateUserById(Long Id,User user);
    void deleteUser(Long Id);

}
