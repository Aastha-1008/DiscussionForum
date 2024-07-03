package com.forum.discussionforum.controller;

import com.forum.discussionforum.entity.Login;
import com.forum.discussionforum.entity.User;
import com.forum.discussionforum.response.GenericResponse;
import com.forum.discussionforum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public GenericResponse getAllUser(){
        List<User> listOfUser = userService.findAllUser();
        return GenericResponse.builder().statusCode(HttpStatus.OK).msg("Successfully fetched list of user").body(listOfUser).build();
    }

    @GetMapping("/{id}")
    public GenericResponse getUserById(@PathVariable Long id ){
        User user = userService.findById(id);
        if(user == null)
            return GenericResponse.builder().statusCode(HttpStatus.OK).msg("No user exist with this id ").build();
        return GenericResponse.builder().statusCode(HttpStatus.OK).msg("Successfully fetch user by using id").body(user).build();
    }

    @GetMapping("/name/{name}")
    public GenericResponse getUserByName(@PathVariable String name){
        List<User> listOfUser = userService.getUserByName(name);
        return GenericResponse.builder().statusCode(HttpStatus.OK).msg("Successfully fetch user by using name").body(listOfUser).build();
    }

    @GetMapping("/login/")
    public GenericResponse checkUserCredentials(@RequestBody Login login){
        User user = userService.checkUserCredentials(login);
        if(user == null)
            return GenericResponse.builder().statusCode(HttpStatus.OK).msg("No user exist").build();
        return GenericResponse.builder().statusCode(HttpStatus.OK).msg("User exist").body(user).build();
    }

    @PostMapping("/")
    public GenericResponse createUser(@RequestBody User user){
        if(user == null)
            return GenericResponse.builder().statusCode(HttpStatus.BAD_REQUEST).build();

        userService.createUser(user);
        return GenericResponse.builder().statusCode(HttpStatus.OK).msg("Successfully user created").build();
    }

    @PutMapping("/")
    public GenericResponse updateUser(@RequestBody User user){
        if(user == null)
            return GenericResponse.builder().statusCode(HttpStatus.BAD_GATEWAY).build();

        userService.updateUser( user);
        return GenericResponse.builder().statusCode(HttpStatus.OK).msg("Successfully update user").build();
    }

    @DeleteMapping("/{id}")
    public GenericResponse deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return GenericResponse.builder().statusCode(HttpStatus.OK).msg("Successfully deleted the user ").build();
    }
}
