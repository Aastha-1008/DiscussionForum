package com.forum.discussionforum.service.Impl;

import com.forum.discussionforum.entity.Login;
import com.forum.discussionforum.entity.User;
import com.forum.discussionforum.repository.UserRepository;
import com.forum.discussionforum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User>findAllUser(){
        return userRepository.findAllUser();
    }

    public User findById(Long id){
        return userRepository.getById(id);
    }

    public List<User> getUserByName(String name){
        return userRepository.getByUserName(name);
    }

    public User checkUserCredentials(Login login){
        return userRepository.checkUserCredentials(login.getUsername() , login.getPassword());
    }

    public void setUser(User currUser , User newUser){
        currUser.setName(newUser.getName());
        currUser.setEmail(newUser.getEmail());
        currUser.setMobileNumber(newUser.getMobileNumber());
        currUser.setUsername(newUser.getUsername());
        currUser.setPassword(newUser.getPassword());

        userRepository.save(currUser);
    }

    public void createUser(User user){
        User u = new User();
        setUser(u,user);
    }

    public void updateUser(User user){
        User currUser = userRepository.getById(user.getId());
        if (currUser == null)return;
        setUser(currUser,user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
