package com.forum.discussionforum.service;

import com.forum.discussionforum.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAllUser();

    User findById(Long id);

    List<User> getUserByName(String name);

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);
}
