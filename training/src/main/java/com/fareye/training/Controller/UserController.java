package com.fareye.training.Controller;

import com.fareye.training.Model.User;
import com.fareye.training.Util.DataFromApi;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class UserController {

    HashMap<Integer, User> users = new HashMap<>();
    int count=0;

    @GetMapping("/user")
    public HashMap<Integer, User> getusers(){
        return users;
    }

    @GetMapping("/user/{id}")
    public User getuserbyid(@PathVariable("id") int id){
        return users.get(id);
    }

    @PostMapping("/adduser")
    public HashMap<Integer, User> CreateUser(@RequestBody User user){
        int key = ++count;
        user.setUser_id(key);
        user.setAvatarUrl(DataFromApi.call(user.getFirstName()));
        users.put(key,user);
        TodoController.Todos.put(key, new ArrayList<>());
        return users;
    }
    @PutMapping("/user/{id}")
    public HashMap<Integer, User> updateUser(@PathVariable("id") int id, @RequestBody User user){
        //id not found exception
        user.setUser_id(id);
        users.put(id, user);
        return users;
    }
    @DeleteMapping(value = "/user/{id}")
    public HashMap<Integer, User> deleteUser(@PathVariable int id) {
        users.remove(id);
//        Todos.remove(id);
        TodoController.Todos.remove(id);
        return users;
    }
}
