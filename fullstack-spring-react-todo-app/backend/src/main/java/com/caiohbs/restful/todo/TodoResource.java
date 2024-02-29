package com.caiohbs.restful.todo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoResource {

    private final TodoService todoService;

    public TodoResource(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(path="/users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable String username) {
        return todoService.findByUsername(username);
    }

    @GetMapping(path="/users/{username}/todos/{id}")
    public Todo retrieveSingleTodo(
            @PathVariable String username,
            @PathVariable int id
    ) {
        return todoService.findById(id);
    }

    @DeleteMapping(path="/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(
            @PathVariable String username,
            @PathVariable int id
    ) {
        todoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
