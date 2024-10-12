package com.zelyy.BootApp.services;

import com.zelyy.BootApp.pojo.User;
import com.zelyy.BootApp.repositiry.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void add(User user) {
        userRepo.save(user);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public void delete(Long id) {
        userRepo.delete(userRepo.findById(id).get());
    }

    public User findById(Long id) {
        return userRepo.findById(id).get();
    }
}
