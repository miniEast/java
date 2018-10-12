package com.springdata.jpa.dao;

import com.springdata.jpa.pojo.Users;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UsersRepositoryByName extends Repository<Users, Integer> {
    /**
     * 方法名称遵循驼峰命名法，
     * 1.关键字 findBy （关键字）
     * 2.属性名称  首字母大写
     * 3.查询条件 首字母大写
     * <p>
     * <p>
     * 默认使用相等连接
     *
     * @return
     */
    List<Users> findByName(String name);

    List<Users> findByNameLike(String name);


    List<Users> findByNameAndAge(String name,Integer age);
}
