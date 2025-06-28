package com.example.todo.controller;

import com.timgroup.statsd.NonBlockingStatsDClient;
import com.timgroup.statsd.StatsDClient;
import com.example.todo.model.Todo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private List<Todo> todoList = new ArrayList<>();

    // Initialize StatsD client
    private final StatsDClient statsd = new NonBlockingStatsDClient(
        "todo-app",      // Metric prefix
        "localhost",     // Graphite/StatsD host (or use "graphite" if in Docker)
        8125             // StatsD UDP port
    );

    @GetMapping
    public List<Todo> getTodos() {
        // Optional: Track GET requests too
        statsd.incrementCounter("todos.get_requests");
        return todoList;
    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {
        todoList.add(todo);
        statsd.incrementCounter("todos.created");  // 🔥 This line sends the metric
        return todo;
    }

}
