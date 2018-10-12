package com.example.demo2.service.impl;

import com.example.demo2.mapper.UsersMapper;
import com.example.demo2.pojo.Users;
import com.example.demo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public void insterUser(Users users) {
        usersMapper.insertUser(users);
    }
}
