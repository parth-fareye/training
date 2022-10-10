package com.fareye.training.Controller;


import com.fareye.training.Model.Todo;
import com.fareye.training.Model.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class TodoController {

    //    List<Todo> Todos = new ArrayList<>();
    static HashMap<Integer, List<Todo>> Todos = new HashMap<>();

    @GetMapping("/todo")
    public HashMap<Integer, List<Todo>> get_todo(){
        return Todos;
    }

    @PostMapping("/addtodo")
    public HashMap<Integer, List<Todo>> createUser(@RequestBody Todo todo){
        //user not found
        //same title found

        Todos.get(todo.getAuthor().getUser_id()).add(todo);
        return Todos;
    }

    @PutMapping("/todo")
    public HashMap<Integer, List<Todo>> updateUser(@RequestBody Todo todo){
        //user not found
        //same title found
        Todos.get(todo.getAuthor().getUser_id()).add(todo);
        return Todos;
    }

    @DeleteMapping(value = "/todo/{id}/{title}")
    public HashMap<Integer, List<Todo>> deleteUser(@PathVariable int id, @PathVariable String title) {
        List<Todo> userTodo = Todos.get(id);
//        Todos.get(id).remove(title);
        for(int i=0; i<userTodo.size(); i++){
            if(title == userTodo.get(i).getTaskTitle()){
                Todos.get(id).remove(i);
            }
        }
        return Todos;
    }
}