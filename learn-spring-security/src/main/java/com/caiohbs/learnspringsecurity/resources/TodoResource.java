package com.caiohbs.learnspringsecurity.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final List<Todo> TODOS_LIST = List.of(
            new Todo("Caio-HBS", "Learn Java"),
            new Todo("Other-user", "Learn more Java")
    );

    @GetMapping(path="/todos")
    public List<Todo> retrieveAllTodos() {
        return TODOS_LIST;
    }

    @GetMapping(path="/users/{username}/todos")
    @PreAuthorize("hasRole('USER') and #username == authentication.name")
    @PostAuthorize("returnObject.username == 'Caio-HBS'")
    public Todo retrieveTodosForSingleUser(@PathVariable String username) {
        return TODOS_LIST.get(0);
    }

    @PostMapping(path="/users/{username}/todos")
    public void createTodoForSingleUser(
            @PathVariable String username, @RequestBody Todo todo
    ) {
        logger.info("Creating {} for {}", todo, username);
    }

}

record Todo(String username, String description) {
}
