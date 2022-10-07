package com.fareye.training.controller;

import java.util.ArrayList;
import java.util.List;

import com.fareye.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.fareye.training.model.User;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    //get all the users
    @GetMapping("/user")
    private List<User> listUsers(){
        return userService.getAllUsers();
    }

    //get a single user by ID
    @GetMapping("/user/{id}")
    private User getUser(@PathVariable int id){
        return userService.getUserById(id);
    }

    //delete a user by ID
    @DeleteMapping("/delete/{id}")
    private void deleteUser(@PathVariable int id){
        userService.delete(id);
    }

    //add a user
    @PostMapping("/addUser")
    public int createUser(@RequestBody @Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new IllegalArgumentException("User date is not acceptable");
        }
        userService.save(user);
        return user.getId();
    }

    @PutMapping("/update")
    public int updateUser(@RequestBody @Valid User user, BindingResult bindingResult){
        if((userService.getUserById(user.getId())).getId()>1) {
            throw new IllegalArgumentException("User does not exist for the id: " + user.getId());
        } else if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("User data is not acceptable");
        }
        userService.update(user);
        return user.getId();
    }
}
