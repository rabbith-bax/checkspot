package com.checkspot.checkspot.service;

import com.checkspot.checkspot.model.User;
import com.checkspot.checkspot.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepo userRepo;

    public User addUser(User user){
        return userRepo.save(user);
    }

    public void deleteUserById(Long id){
        userRepo.deleteById(id);
    }
}
