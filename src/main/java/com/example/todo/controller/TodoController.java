package com.example.todo.controller;

import com.example.todo.model.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private List<Todo> todoList = new ArrayList<>();

    @GetMapping
    public List<Todo> getTodos() {
        return todoList;
    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {
        todoList.add(todo);
        return todo;
    }
}
