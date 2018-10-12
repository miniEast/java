package com.example.demo.mapper;

import com.example.demo.model.Users;

import java.util.List;

public interface UsersMapper {
    void insertUser(Users users);

    List<Users> findAll();

    Users findById(Integer id);

    void updateUser(Users users);

    void deleteById(Integer id);
}
