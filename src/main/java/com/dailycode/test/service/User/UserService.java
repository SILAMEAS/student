package com.dailycode.test.service.User;

import com.dailycode.test.exception.StudentAlreadyExitException;
import com.dailycode.test.exception.StudentNotFoundException;
import com.dailycode.test.model.User;
import com.dailycode.test.reposity.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserService implements IUserService{
    private  final UserRepo userRepo;
    @Override
    public User createUser(User user) {
        if(UserAlreadyExit(user.getEmail())){
            throw  new StudentAlreadyExitException("email already used");
        }
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        log.
//        if(!UserAlreadyExit(email)){
//            throw  new StudentNotFoundException("Email not found");
//        }
        if(!UserAlreadyExit(email)){
            throw  new StudentNotFoundException("Email not found");
        }
//        return userRepo.save(user);
        return userRepo.findByEmail(email);
    }

    @Override
    public User updateUserById(Long Id, User user) {
        return  userRepo.findById(Id).map(s->{
            s.setPassword(user.getPassword());
            return  userRepo.save(s);
        }).orElseThrow(()->new StudentNotFoundException("User not found"));
    }

    @Override
    public void deleteUser(Long Id) {
       if( !UserAlreadyExitById(Id)){
        throw  new StudentNotFoundException("User id "+Id+" not found");
       }
        userRepo.deleteById(Id);

    }
    private boolean UserAlreadyExit(String email) {
        return userRepo.findByEmail(email).isPresent();
    }
    private boolean UserAlreadyExitById(Long id) {
        return userRepo.findById(id).isPresent();
    }

}
