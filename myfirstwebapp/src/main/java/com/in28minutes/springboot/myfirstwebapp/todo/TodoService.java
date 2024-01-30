package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(
                new Todo(1, "CaioHBS", "Learn Java",
                LocalDate.now().plusYears(1), false)
        );
        todos.add(
                new Todo(2, "CaioHBS", "Learn AWS",
                LocalDate.now().plusYears(1), false)
        );
        todos.add(
                new Todo(3, "CaioHBS", "Learn React",
                LocalDate.now().plusYears(1), false)
        );
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }
}
