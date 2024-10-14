package com.zelyy.BootApp.services;

import com.zelyy.BootApp.pojo.User;

import java.util.List;

public interface UserService {

    public void add(User user);
    public List<User> findAll();

    public void delete(Long id);

    public User findById(Long id);
}
