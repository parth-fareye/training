package com.fareye.training.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import com.fareye.training.model.Todo;

@RestController
public class TodoController {
    List<Todo> todos = new ArrayList<>();

    @GetMapping("/get-todo")
    public String getTodo(@RequestParam String name){
        return "TODO List of name: "+todos;
    }

    //TODO create API to save todo
    @PostMapping("todo")
    public List<Todo> createTodo(@RequestBody Todo todo){
        todos.add(todo);
        return todos;
    }


}
