package com.fareye.training.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fareye.training.model.User;
import com.fareye.training.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    //returns a list of all the users
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(u->users.add(u));
        return users;
    }

    //searching a user by ID
    public User getUserById(int id){
        return userRepository.findById(id).get();
    }

    //saving a new user
    public void save(User user){
        userRepository.save(user);
    }

    //updating an user
    public void update(User user){
        userRepository.save(user);
    }

    //delete an user
    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
