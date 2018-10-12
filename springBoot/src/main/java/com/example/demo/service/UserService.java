package com.example.demo.service;

import com.example.demo.model.Users;

import java.util.List;

public interface UserService {
    void insterUser(Users users);

    List<Users> findAll();

    Users findById(Integer id);

    void updateUser(Users users);

    void deleteById(Integer id);
}
