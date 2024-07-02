package com.forum.discussionforum.repository;

import com.forum.discussionforum.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query(
        value = "select * from user",
        nativeQuery = true
    )
    List<User> findAllUser();

    @Query(
            value = "select * from user where id = :id",
            nativeQuery = true
    )
    User getById(Long id);

    @Query(
            value = "select * from user where name = :name",
            nativeQuery = true
    )
    List<User> getByUserName(String name);
}
