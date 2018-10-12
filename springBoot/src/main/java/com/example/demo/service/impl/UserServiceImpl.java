package com.example.demo.service.impl;

import com.example.demo.mapper.UsersMapper;
import com.example.demo.model.Users;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    @CacheEvict(value = "users",allEntries = true)
    public void insterUser(Users users) {
        usersMapper.insertUser(users);
    }

    @Override
    @Cacheable(value = "users")
    public List<Users> findAll() {
        return usersMapper.findAll();
    }

    @Override
    @Cacheable(value = "users",key = "#id")  //把方法的返回值放入ehcahe中  value 指定缓存策略 如果没有使用默认缓存策略 key 默认去取惨数 如果缓存中有就不去数据库查询  # 可以指定对象那
    public Users findById(Integer id) {
        return usersMapper.findById(id);
    }

    @Override
    public void updateUser(Users users) {
        usersMapper.updateUser(users);
    }

    @Override
    public void deleteById(Integer id) {
        usersMapper.deleteById(id);
    }
}
