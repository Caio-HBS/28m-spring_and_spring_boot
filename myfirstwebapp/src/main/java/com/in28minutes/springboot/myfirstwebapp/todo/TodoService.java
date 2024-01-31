package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static final List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;

    static {
        todos.add(
                new Todo(todosCount++, "CaioHBS", "Learn Java",
                        LocalDate.now().plusYears(1), false)
        );
        todos.add(
                new Todo(todosCount++, "CaioHBS", "Learn AWS",
                        LocalDate.now().plusYears(1), false)
        );
        todos.add(
                new Todo(todosCount++, "CaioHBS", "Learn React",
                        LocalDate.now().plusYears(1), false)
        );
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }

    public void addNewTodo(
            String username, String description, LocalDate targetDate, boolean done
    ) {
        Todo todo = new Todo(todosCount++, username, description, targetDate, done);
        todos.add(todo);
    }

    public void deleteById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo getById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        return todos.stream().filter(predicate).findFirst().get();
    }

    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
