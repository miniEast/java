package com.springdata.jpa.dao;

import com.springdata.jpa.pojo.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;


/**
 * @Query 查询
 */
public interface UsersrRepositoryQueryAnnotation extends Repository<Users, Integer> {


    @Query("from Users where name = ?")
    List<Users> queryByNameUseHql(String name);

    @Query(value = "select * from t_users where name = ? ", nativeQuery = true)
    List<Users> queryByNameUseSql(String name);

    @Query(value = "update Users set name = ? where id = ?")
    @Modifying
        //修改时需要加入这个注解
    void updateUserNameByUserId(String name, Integer id);


}
