package com.springdata.jpa.dao;

import com.springdata.jpa.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository 泛型
 * 中参数一 需要映射的实体类
 * 参数二 主键类型
 */
public interface UsersRepostory extends JpaRepository<Users, Integer> {

}
