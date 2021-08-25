package com.eight.spring.dao;

import com.eight.spring.util.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Long> {
    @Query(value = "select new com.eight.spring.util.User(id, name, password) \n" +
            "from User where id = :id")
    User findUserById(@Param("id") Long id);
}
