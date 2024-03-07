package com.caiohbs.restful.todo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TodoJpaResource {

    private final TodoRepository todoRepository;

    public TodoJpaResource(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping(path="/users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable String username) {
        return todoRepository.findByUsername(username);
    }

    @GetMapping(path="/users/{username}/todos/{id}")
    public Optional<Todo> retrieveSingleTodo(
            @PathVariable String username,
            @PathVariable int id
    ) {
        return todoRepository.findById(id);
    }

    @DeleteMapping(path="/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(
            @PathVariable String username,
            @PathVariable int id
    ) {
        todoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path="/users/{username}/todos/{id}")
    public Todo updateTodo(
            @PathVariable String username,
            @PathVariable int id,
            @RequestBody Todo todo
    ) {
        todoRepository.save(todo);
        return todo;
    }

    @PostMapping(path="/users/{username}/todos")
    public Todo createNewTodo(
            @PathVariable String username, @RequestBody Todo todo
    ) {
        todo.setUsername(username);
        todo.setId(null);
        return todoRepository.save(todo);
    }

}
